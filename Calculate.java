package Calulation;

import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("��ѡ���������������:(����ѡ1������ѡ2)");
		int choice = scanner.nextInt();
		System.out.println("�����뱾��:");
		double money = scanner.nextDouble(); // ����
		System.out.println("������������:");
		int years = scanner.nextInt(); // ��Ǯ����
		double sum = 0;// ����ܶ�
		System.out.println("������������:");
		double rate = scanner.nextDouble(); // ����
		switch(choice)
		{
			case 1:
				CompoundingCalculation(money, years, rate);
				break;
			case 2:
				SimpleInterestCalculation(money, years, rate);
				break;
			default:
				System.out.println("�������!");
				main(null);
				break;
		}

	}

		public static void CompoundingCalculation(double money, int years, double rate) 
		{
			double sum = 0 ;
			for (int i = 1; i <= years; i++) 
			{
				sum = money*Math.pow(1.0 + rate, years);	
			}
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum);
			main(null);
		}
		
		public static void SimpleInterestCalculation(double money, int years, double rate)
		{
			double sum;
			double interest;
			interest = money*rate*years;
			sum = money+interest;
			System.out.println("�����" + years + "���Ĵ���ܶ�Ϊ��" + sum);
			main(null);
		}
		
		
}
