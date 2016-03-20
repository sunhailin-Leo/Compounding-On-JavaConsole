package Calulation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	//�����ж��Ƿ�Ϊ����ѡ��
	public static boolean isNumeric(String str)
	{ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
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
			double money,rate=0;
			double sum1=0;
			int years;
			System.out.println("�����뱾��:");
			money = scanner.nextDouble(); // ����
			System.out.println("������������:");
			years = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			rate = scanner.nextDouble(); // ����
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			double money,rate,interest;
			double sum1=0;
			int years;
			System.out.println("�����뱾��:");
			money = scanner.nextDouble(); // ����
			System.out.println("������������:");
			years = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			rate = scanner.nextDouble(); // ����
			interest = money*rate*years;
			sum1 = money+interest;
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			double money = 0;
			double ExpectedPrincipal,rate;
			int years;
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("������������:");
			years = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			rate = scanner.nextDouble(); // ����
			money = ExpectedPrincipal/Math.pow(1.0 + rate, years);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			money = ExpectedPrincipal/(1+rate*years);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			main(null);
		}
		
		public static void CalculateRewardTime()
		{
			double ExpectedPrincipal,rate,money,year;
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("������������:");
			rate = scanner.nextDouble(); // ����
			System.out.println("����");
			money = scanner.nextDouble();
			year =  log((ExpectedPrincipal/money),1+rate);
			System.out.println("���" + Math.ceil(year));
			main(null);
		}
		
		public static double log(double value,double base)
		{
			return Math.log(value)/Math.log(base);
		}

		public static void CalculateInterest()
		{
			double ExpectedPrincipal,rate,money,year;
			System.out.println("Ԥ�ڽ��");
			ExpectedPrincipal = scanner.nextDouble();
			System.out.println("���������:");
			year = scanner.nextDouble(); // ����
			System.out.println("����");
			money = scanner.nextDouble();
			rate = Math.pow((ExpectedPrincipal/money), 1/year)-1;
			System.out.println("����" + rate);
			main(null);
		}
		
		public static void IncreasingInterestInvestmentQuota()
		{
			System.out.println("ÿ�궨��ѡ1��ÿ�¶���ѡ2");
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
			System.out.println("ÿ�궨���ʱ�");
			EachYearQuotaMoney = scanner.nextDouble();
			System.out.println("������������:");
			years = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			rate = scanner.nextDouble(); // ����
			for (int i = 1; i <= years; i++) 
			{
				sum1 = (sum1+EachYearQuotaMoney)*Math.pow((1.0 + rate), i);
			}
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum1);
			System.out.println(EachYearQuotaMoney);
			main(null);	
		}

		public static void EachMonth() 
		{
			double EachMonthQuotaMoney,MonthRate;
			int Months;
			double sum1 = 0 ;
			System.out.println("ÿ�¶����ʱ�");
			EachMonthQuotaMoney = scanner.nextDouble();
			System.out.println("������������:");
			Months = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			MonthRate = scanner.nextDouble(); // ����
			sum1 = 0 ;
			for (int i = 1; i <= Months; i++) 
			{
				sum1 = (sum1+EachMonthQuotaMoney)*Math.pow((1.0 + MonthRate), Months);
			}
			System.out.println("�����" + Months + "�º�Ĵ���ܶ�Ϊ��" + sum1+EachMonthQuotaMoney);
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
			System.out.println("�������������");
			money = scanner.nextDouble();
			System.out.println("�������������");
			years = scanner.nextInt();
			System.out.println("���������������");
			rate = scanner.nextDouble();
			//����
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			Repayment = sum1/(years*12);
			
			interest = money*rate*years;
			sum = money+interest;
			Repayment1 = sum/(years*12);
			System.out.println("ÿ����Ҫ����(����)" + Repayment1);
			System.out.println("ÿ����Ҫ����(����)" + Repayment);
		}
}
