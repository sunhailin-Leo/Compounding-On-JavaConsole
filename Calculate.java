package Calulation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	//正则判断是否为数字选项
	public static boolean isNumeric(String str)
	{ 
		   Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   }
		   return true; 
	}
	
	//字符型转整型
	public static int StringToInt(String intstr)
	{
		Integer integer;
		integer = Integer.valueOf(intstr);
		return integer.intValue();
	}
	
	//字符型转double型(该功能尚未使用)
	public static double StringToDouble(String str)
	{
		Double data;
		data = Double.valueOf(str);
		return data.doubleValue();
	}
	
	//double型转字符型(该功能尚未使用)
	public static String DoubleToString(double value)
	{
		double dd = value;
		String str = String.valueOf(dd);
		return str;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("请选择单利计算或复利计算:(复利选1，单利选2,本金计算选3,投资预期年份计算选4,投资预期利率计算选5,定额复利投资递增性选6,贷款月还款金额计算选7)");
		String choice = scanner.next();
		if(isNumeric(choice))
		{
			switch(StringToInt(choice))
			{
			case 1:
				CompoundingCalculation();
				break;
			case 2:
				SimpleInterestCalculation();
				break;
			case 3:
				PrincipalCalculation();
				break;
			case 4:
				CalculateRewardTime();
				break;
			case 5:
				CalculateInterest();
				break;
			case 6:
				IncreasingInterestInvestmentQuota();
				break;
			case 7:
				MatchingInterestRepaymentCalculator();
				break;
			}
		}
		else
		{
			System.out.println("输入错误!,请重新输入!");
			main(null);
		}
	}
		
		public static void CompoundingCalculation() 
		{
			String money,rate,years;
			int Year=0;
			double Rate=0,Money=0,sum1=0;
			System.out.println("请输入本金:");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CompoundingCalculation(); 
			}
			System.out.println("请输入存款年数:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CompoundingCalculation();
			}
			System.out.println("请输入年利率:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CompoundingCalculation();
			}
			for (int i = 1; i <= Year; i++) 
			{
				sum1 = Money*Math.pow(1.0 + Rate, Year);	
			}
			System.out.println("存入第" + Year + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			String money,rate,years;
			double Money=0,sum1=0,Rate=0,interest=0;
			int Year=0;
			System.out.println("请输入本金:");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				SimpleInterestCalculation(); 
			}
			System.out.println("请输入存款年数:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				SimpleInterestCalculation(); 
			}
			System.out.println("请输入年利率:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				SimpleInterestCalculation(); 
			}
			interest = Money*Rate*Year;
			sum1 = Money+interest;
			System.out.println("存入第" + Year + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			String ExpectedPrincipal,rate,years;
			double Rate=0,ExpectedPrincipalMoney=0,money = 0;
			int Year = 0;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				PrincipalCalculation(); 
			}
			System.out.println("请输入存款年数:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				PrincipalCalculation(); 
			}
			System.out.println("请输入年利率:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				PrincipalCalculation(); 
			}
			money = ExpectedPrincipalMoney/Math.pow(1.0 + Rate, Year);
			System.out.println("初始本金为(复利算法)" + money);
			money = ExpectedPrincipalMoney/(1+Rate*Year);
			System.out.println("初始本金为(单利算法)" + money);
			main(null);
		}
		
		public static void CalculateRewardTime()
		{
			double year = 0,ExpectedPrincipalMoney = 0,Rate = 0,Money = 0;
			String ExpectedPrincipal,rate,money;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateRewardTime(); 
			}
			System.out.println("请输入年利率:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateRewardTime(); 
			}
			System.out.println("本金");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateRewardTime(); 
			}
			year =  log((ExpectedPrincipalMoney/Money),1+Rate);
			System.out.println("年份" + Math.ceil(year));
			main(null);
		}
		
		public static double log(double value,double base)
		{
			return Math.log(value)/Math.log(base);
		}

		public static void CalculateInterest()
		{
			double ExpectedPrincipalMoney = 0,Money = 0;
			int Year = 0;
			String ExpectedPrincipal,years,money;
			double rate = 0;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateInterest(); 
			}
			System.out.println("请输入年份:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateInterest(); 
			}
			System.out.println("本金");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				CalculateInterest(); 
			}
			rate = Math.pow((ExpectedPrincipalMoney/Money), 1/Year)-1;
			System.out.println("利率" + rate);
			main(null);
		}
		
		public static void IncreasingInterestInvestmentQuota()
		{
			System.out.println("每年定额选1，每月定额选2");
			String choice = scanner.next();
			if(isNumeric(choice))
			{
				switch(StringToInt(choice))
				{
				case 1:
					EachYear();
					break;
				case 2:
					EachMonth();
					break;
				}
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				IncreasingInterestInvestmentQuota();
			}	
		}

		public static void EachYear() 
		{
			double EachYearQuotaMoney = 0,Rate = 0,sum1 = 0;
			int Year = 0;
			String years,EachYearQuotaMoney1,rate;
			System.out.println("每年定额资本");
			EachYearQuotaMoney1 = scanner.next();
			if(isNumeric(EachYearQuotaMoney1))
			{
				EachYearQuotaMoney = StringToDouble(EachYearQuotaMoney1);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachYear();  
			}
			System.out.println("请输入存款年数:");
			years = scanner.next(); // 存钱年数
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachYear(); 
			}
			System.out.println("请输入年利率:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachYear(); 
			}	
			sum1 = EachYearQuotaMoney*(1+Rate)*(-1+Math.pow(1+Rate, Year))/Rate;
			System.out.println("存入第" + Year + "年后的存款总额为：" + sum1);
			main(null);	
		}

		public static void EachMonth() 
		{
			double EachMonthQuotaMoney1 = 0,MonthRate1 = 0,sum1 = 0;
			int Months1 = 0;
			String EachMonthQuotaMoney,MonthRate,Months;
			System.out.println("每月定额资本");
			EachMonthQuotaMoney = scanner.next();
			if(isNumeric(EachMonthQuotaMoney))
			{
				EachMonthQuotaMoney1 = StringToDouble(EachMonthQuotaMoney);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachMonth(); 
			}
			System.out.println("请输入存款月数:");
			Months = scanner.next();
			if(isNumeric(Months))
			{
				Months1 = StringToInt(Months);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachMonth(); 
			}
			System.out.println("请输入月利率:");
			MonthRate = scanner.next();
			if(isNumeric(MonthRate))
			{
				MonthRate1 = StringToDouble(MonthRate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				EachMonth(); 
			}
			sum1 = EachMonthQuotaMoney1*(1+MonthRate1)*(-1+Math.pow(1+MonthRate1, Months1))/MonthRate1;
			System.out.println("存入第" + Months1 + "月后的存款总额为：" + sum1);
			main(null);	
		}
		
		public static void MatchingInterestRepaymentCalculator()
		{
			String money,rate,years;
			double Money = 0,Rate = 0,interest,Repayment = 0,Repayment1 = 0,sum1 = 0,sum = 0;
			int Year = 0;
			System.out.println("请输入贷款金额数");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				MatchingInterestRepaymentCalculator();
			}
			System.out.println("请输入贷款年限");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				MatchingInterestRepaymentCalculator();
			}
			System.out.println("请输入贷款年利率");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("输入错误!,请重新输入!");
				MatchingInterestRepaymentCalculator();
			}
			//复利
			for (int i = 1; i <= Year; i++) 
			{
				sum1 = Money*Math.pow(1.0 + Rate, Year);	
			}
			Repayment = sum1/(Year*12);
			interest = Money*Rate*Year;
			sum = Money+interest;
			Repayment1 = sum/(Year*12);
			System.out.println("每月需要还款(单利)" + Repayment1);
			System.out.println("每月需要还款(复利)" + Repayment);
		}
}
