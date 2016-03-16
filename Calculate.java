package Calulation;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		System.out.println("��ѡ���������������:(����ѡ1������ѡ2,�������ѡ3,Ͷ��Ԥ����ݼ���ѡ4,Ͷ��Ԥ�����ʼ���ѡ5,�����Ͷ�ʵ�����ѡ6)");
		int choice = scanner.nextInt();	
		switch(choice)
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
			default:
				System.out.println("�������!");
				main(null);
				break;
		}
	}

		public static void CompoundingCalculation() 
		{
			System.out.println("�����뱾��:");
			double money = scanner.nextDouble(); // ����
			System.out.println("������������:");
			int years = scanner.nextInt(); // ��Ǯ����
			double sum = 0;// ����ܶ�
			System.out.println("������������:");
			double rate = scanner.nextDouble(); // ����
			double sum1 = 0 ;
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			System.out.println("�����뱾��:");
			double money = scanner.nextDouble(); // ����
			System.out.println("������������:");
			int years = scanner.nextInt(); // ��Ǯ����
			double sum = 0;// ����ܶ�
			System.out.println("������������:");
			double rate = scanner.nextDouble(); // ����
			double sum1;
			double interest;
			interest = money*rate*years;
			sum1 = money+interest;
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			double money = 0;
			System.out.println("Ԥ�ڽ��");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("������������:");
			int years = scanner.nextInt(); // ��Ǯ����
			double sum = 0;// ����ܶ�
			System.out.println("������������:");
			double rate = scanner.nextDouble(); // ����
			money = ExpectedPrincipal/Math.pow(1.0 + rate, years);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			money = ExpectedPrincipal/(1+rate*years);
			System.out.println("��ʼ����Ϊ(�����㷨)" + money);
			main(null);
		}
		
		public static void CalculateRewardTime()
		{
			System.out.println("Ԥ�ڽ��");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("������������:");
			double rate = scanner.nextDouble(); // ����
			System.out.println("����");
			double money = scanner.nextDouble();
			double year =  log((ExpectedPrincipal/money),1+rate);
			System.out.println("���" + Math.ceil(year));
			main(null);
		
		}
		
		public static double log(double value,double base)
		{
			return Math.log(value)/Math.log(base);
		}

		public static void CalculateInterest()
		{
			System.out.println("Ԥ�ڽ��");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("���������:");
			double year = scanner.nextDouble(); // ����
			System.out.println("����");
			double money = scanner.nextDouble();
			double rate = Math.pow((ExpectedPrincipal/money), 1/year)-1;
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
			
			System.out.println("ÿ�궨���ʱ�");
			double EachYearQuotaMoney = scanner.nextDouble();
			System.out.println("������������:");
			int years = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			double rate = scanner.nextDouble(); // ����
			double sum1 = 0 ;
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
			System.out.println("ÿ�¶����ʱ�");
			double EachMonthQuotaMoney = scanner.nextDouble();
			System.out.println("������������:");
			int Months = scanner.nextInt(); // ��Ǯ����
			System.out.println("������������:");
			double MonthRate = scanner.nextDouble(); // ����
			double sum1 = 0 ;
			for (int i = 1; i <= Months; i++) 
			{
				sum1 = (sum1+EachMonthQuotaMoney)*Math.pow((1.0 + MonthRate), Months);
			}
			System.out.println("�����" + Months + "�º�Ĵ���ܶ�Ϊ��" + sum1+EachMonthQuotaMoney);
			main(null);	
		}
}
