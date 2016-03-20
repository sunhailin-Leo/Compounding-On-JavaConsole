package Calulation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	//正则判断是否为数字选项
	public static boolean isNumeric(String str)
	{ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
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
			double money,rate=0;
			double sum1=0;
			int years;
			System.out.println("请输入本金:");
			money = scanner.nextDouble(); // 本金
			System.out.println("请输入存款年数:");
			years = scanner.nextInt(); // 存钱年数
			System.out.println("请输入年利率:");
			rate = scanner.nextDouble(); // 利率
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			System.out.println("存入第" + years + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			double money,rate,interest;
			double sum1=0;
			int years;
			System.out.println("请输入本金:");
			money = scanner.nextDouble(); // 本金
			System.out.println("请输入存款年数:");
			years = scanner.nextInt(); // 存钱年数
			System.out.println("请输入年利率:");
			rate = scanner.nextDouble(); // 利率
			interest = money*rate*years;
			sum1 = money+interest;
			System.out.println("存入第" + years + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			double money = 0;
			double ExpectedPrincipal,rate;
			int years;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入存款年数:");
			years = scanner.nextInt(); // 存钱年数
			System.out.println("请输入年利率:");
			rate = scanner.nextDouble(); // 利率
			money = ExpectedPrincipal/Math.pow(1.0 + rate, years);
			System.out.println("初始本金为(复利算法)" + money);
			money = ExpectedPrincipal/(1+rate*years);
			System.out.println("初始本金为(单利算法)" + money);
			main(null);
		}
		
		public static void CalculateRewardTime()
		{
			double ExpectedPrincipal,rate,money,year;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入年利率:");
			rate = scanner.nextDouble(); // 利率
			System.out.println("本金");
			money = scanner.nextDouble();
			year =  log((ExpectedPrincipal/money),1+rate);
			System.out.println("年份" + Math.ceil(year));
			main(null);
		}
		
		public static double log(double value,double base)
		{
			return Math.log(value)/Math.log(base);
		}

		public static void CalculateInterest()
		{
			double ExpectedPrincipal,rate,money,year;
			System.out.println("预期金额");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入年份:");
			year = scanner.nextDouble(); // 利率
			System.out.println("本金");
			money = scanner.nextDouble();
			rate = Math.pow((ExpectedPrincipal/money), 1/year)-1;
			System.out.println("利率" + rate);
			main(null);
		}
		
		public static void IncreasingInterestInvestmentQuota()
		{
			System.out.println("每年定额选1，每月定额选2");
			int choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				EachYear();
				break;
			case 2:
				EachMonth();
				break;
			}
		}

		public static void EachYear() 
		{
			double EachYearQuotaMoney,rate;
			int years;
			double sum1 = 0 ;
			System.out.println("每年定额资本");
			EachYearQuotaMoney = scanner.nextDouble();
			System.out.println("请输入存款年数:");
			years = scanner.nextInt(); // 存钱年数
			System.out.println("请输入年利率:");
			rate = scanner.nextDouble(); // 利率
			for (int i = 1; i <= years; i++) 
			{
				sum1 = (sum1+EachYearQuotaMoney)*Math.pow((1.0 + rate), i);
			}
			System.out.println("存入第" + years + "年后的存款总额为：" + sum1);
			System.out.println(EachYearQuotaMoney);
			main(null);	
		}

		public static void EachMonth() 
		{
			double EachMonthQuotaMoney,MonthRate;
			int Months;
			double sum1 = 0 ;
			System.out.println("每月定额资本");
			EachMonthQuotaMoney = scanner.nextDouble();
			System.out.println("请输入存款月数:");
			Months = scanner.nextInt(); // 存钱年数
			System.out.println("请输入月利率:");
			MonthRate = scanner.nextDouble(); // 利率
			sum1 = 0 ;
			for (int i = 1; i <= Months; i++) 
			{
				sum1 = (sum1+EachMonthQuotaMoney)*Math.pow((1.0 + MonthRate), Months);
			}
			System.out.println("存入第" + Months + "月后的存款总额为：" + sum1+EachMonthQuotaMoney);
			main(null);	
		}
		
		public static void MatchingInterestRepaymentCalculator()
		{
			double money,rate,interest;
			double Repayment = 0;
			double Repayment1 = 0;
			double sum1 = 0;
			double sum = 0;
			int years;
			System.out.println("请输入贷款金额数");
			money = scanner.nextDouble();
			System.out.println("请输入贷款年限");
			years = scanner.nextInt();
			System.out.println("请输入贷款年利率");
			rate = scanner.nextDouble();
			//复利
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			Repayment = sum1/(years*12);
			
			interest = money*rate*years;
			sum = money+interest;
			Repayment1 = sum/(years*12);
			System.out.println("每月需要还款(单利)" + Repayment1);
			System.out.println("每月需要还款(复利)" + Repayment);
		}
}
