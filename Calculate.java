package Calulation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	//�����ж��Ƿ�Ϊ����ѡ��
	public static boolean isNumeric(String str)
	{ 
		   Pattern pattern = Pattern.compile("^\\d+(\\.\\d+)?$"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   }
		   return true; 
	}
	
	//�ַ���ת����
	public static int StringToInt(String intstr)
	{
		Integer integer;
		integer = Integer.valueOf(intstr);
		return integer.intValue();
	}
	
	//�ַ���תdouble��(�ù�����δʹ��)
	public static double StringToDouble(String str)
	{
		Double data;
		data = Double.valueOf(str);
		return data.doubleValue();
	}
	
	//double��ת�ַ���(�ù�����δʹ��)
	public static String DoubleToString(double value)
	{
		double dd = value;
		String str = String.valueOf(dd);
		return str;
	}
	
	public static void main(String[] args) 
	{
		System.out.println("��ѡ���������������:(����ѡ1������ѡ2,�������ѡ3,Ͷ��Ԥ����ݼ���ѡ4,Ͷ��Ԥ�����ʼ���ѡ5,�����Ͷ�ʵ�����ѡ6,�����»��������ѡ7)");
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
			System.out.println("�������!,����������!");
			main(null);
		}
	}
		
		public static void CompoundingCalculation() 
		{
			String money,rate,years;
			int Year=0;
			double Rate=0,Money=0,sum1=0;
			System.out.println("�����뱾��:");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("�������!,����������!");
				CompoundingCalculation(); 
			}
			System.out.println("������������:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				CompoundingCalculation();
			}
			System.out.println("������������:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				CompoundingCalculation();
			}
			for (int i = 1; i <= Year; i++) 
			{
				sum1 = Money*Math.pow(1.0 + Rate, Year);	
			}
			System.out.println("�����" + Year + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			String money,rate,years;
			double Money=0,sum1=0,Rate=0,interest=0;
			int Year=0;
			System.out.println("�����뱾��:");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("�������!,����������!");
				SimpleInterestCalculation(); 
			}
			System.out.println("������������:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				SimpleInterestCalculation(); 
			}
			System.out.println("������������:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				SimpleInterestCalculation(); 
			}
			interest = Money*Rate*Year;
			sum1 = Money+interest;
			System.out.println("�����" + Year + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			String ExpectedPrincipal,rate,years;
			double Rate=0,ExpectedPrincipalMoney=0,money = 0;
			int Year = 0;
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("�������!,����������!");
				PrincipalCalculation(); 
			}
			System.out.println("������������:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				PrincipalCalculation(); 
			}
			System.out.println("������������:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				PrincipalCalculation(); 
			}
			money = ExpectedPrincipalMoney/Math.pow(1.0 + Rate, Year);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			money = ExpectedPrincipalMoney/(1+Rate*Year);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			main(null);
		}
		
		public static void CalculateRewardTime()
		{
			double year = 0,ExpectedPrincipalMoney = 0,Rate = 0,Money = 0;
			String ExpectedPrincipal,rate,money;
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateRewardTime(); 
			}
			System.out.println("������������:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateRewardTime(); 
			}
			System.out.println("����");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateRewardTime(); 
			}
			year =  log((ExpectedPrincipalMoney/Money),1+Rate);
			System.out.println("���" + Math.ceil(year));
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
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.next();
			if(isNumeric(ExpectedPrincipal))
			{
				ExpectedPrincipalMoney = StringToDouble(ExpectedPrincipal);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateInterest(); 
			}
			System.out.println("���������:");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateInterest(); 
			}
			System.out.println("����");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("�������!,����������!");
				CalculateInterest(); 
			}
			rate = Math.pow((ExpectedPrincipalMoney/Money), 1/Year)-1;
			System.out.println("����" + rate);
			main(null);
		}
		
		public static void IncreasingInterestInvestmentQuota()
		{
			System.out.println("ÿ�궨��ѡ1��ÿ�¶���ѡ2");
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
				System.out.println("�������!,����������!");
				IncreasingInterestInvestmentQuota();
			}	
		}

		public static void EachYear() 
		{
			double EachYearQuotaMoney = 0,Rate = 0,sum1 = 0;
			int Year = 0;
			String years,EachYearQuotaMoney1,rate;
			System.out.println("ÿ�궨���ʱ�");
			EachYearQuotaMoney1 = scanner.next();
			if(isNumeric(EachYearQuotaMoney1))
			{
				EachYearQuotaMoney = StringToDouble(EachYearQuotaMoney1);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachYear();  
			}
			System.out.println("������������:");
			years = scanner.next(); // ��Ǯ����
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachYear(); 
			}
			System.out.println("������������:");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachYear(); 
			}	
			sum1 = EachYearQuotaMoney*(1+Rate)*(-1+Math.pow(1+Rate, Year))/Rate;
			System.out.println("�����" + Year + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);	
		}

		public static void EachMonth() 
		{
			double EachMonthQuotaMoney1 = 0,MonthRate1 = 0,sum1 = 0;
			int Months1 = 0;
			String EachMonthQuotaMoney,MonthRate,Months;
			System.out.println("ÿ�¶����ʱ�");
			EachMonthQuotaMoney = scanner.next();
			if(isNumeric(EachMonthQuotaMoney))
			{
				EachMonthQuotaMoney1 = StringToDouble(EachMonthQuotaMoney);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachMonth(); 
			}
			System.out.println("������������:");
			Months = scanner.next();
			if(isNumeric(Months))
			{
				Months1 = StringToInt(Months);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachMonth(); 
			}
			System.out.println("������������:");
			MonthRate = scanner.next();
			if(isNumeric(MonthRate))
			{
				MonthRate1 = StringToDouble(MonthRate);
			}
			else
			{
				System.out.println("�������!,����������!");
				EachMonth(); 
			}
			sum1 = EachMonthQuotaMoney1*(1+MonthRate1)*(-1+Math.pow(1+MonthRate1, Months1))/MonthRate1;
			System.out.println("�����" + Months1 + "�º�Ĵ���ܶ�Ϊ��" + sum1);
			main(null);	
		}
		
		public static void MatchingInterestRepaymentCalculator()
		{
			String money,rate,years;
			double Money = 0,Rate = 0,interest,Repayment = 0,Repayment1 = 0,sum1 = 0,sum = 0;
			int Year = 0;
			System.out.println("�������������");
			money = scanner.next();
			if(isNumeric(money))
			{
				Money = StringToDouble(money);
			}
			else
			{
				System.out.println("�������!,����������!");
				MatchingInterestRepaymentCalculator();
			}
			System.out.println("�������������");
			years = scanner.next();
			if(isNumeric(years))
			{
				Year = StringToInt(years);
			}
			else
			{
				System.out.println("�������!,����������!");
				MatchingInterestRepaymentCalculator();
			}
			System.out.println("���������������");
			rate = scanner.next();
			if(isNumeric(rate))
			{
				Rate = StringToDouble(rate);
			}
			else
			{
				System.out.println("�������!,����������!");
				MatchingInterestRepaymentCalculator();
			}
			//����
			for (int i = 1; i <= Year; i++) 
			{
				sum1 = Money*Math.pow(1.0 + Rate, Year);	
			}
			Repayment = sum1/(Year*12);
			interest = Money*Rate*Year;
			sum = Money+interest;
			Repayment1 = sum/(Year*12);
			System.out.println("ÿ����Ҫ����(����)" + Repayment1);
			System.out.println("ÿ����Ҫ����(����)" + Repayment);
		}
}
