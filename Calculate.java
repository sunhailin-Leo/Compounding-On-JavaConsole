package Calulation;

import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("请选择单利计算或复利计算:(复利选1，单利选2,本金计算选3)");
		int choice = scanner.nextInt();
		if(choice==3)
		{
			PrincipalCalculation();
		}
		System.out.println("请输入本金:");
		double money = scanner.nextDouble(); // 本金
		System.out.println("请输入存款年数:");
		int years = scanner.nextInt(); // 存钱年数
		double sum = 0;// 存款总额
		System.out.println("请输入年利率:");
		double rate = scanner.nextDouble(); // 利率
		switch(choice)
		{
			case 1:
				CompoundingCalculation(money, years, rate);
				break;
			case 2:
				SimpleInterestCalculation(money, years, rate);
				break;
			default:
				System.out.println("输入错误!");
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
			System.out.println("存入第" + years + "年后的存款总额为：" + sum);
			main(null);
		}
		
		public static void SimpleInterestCalculation(double money, int years, double rate)
		{
			double sum;
			double interest;
			interest = money*rate*years;
			sum = money+interest;
			System.out.println("存入第" + years + "年后的存款总额为：" + sum);
			main(null);
		}
		public static void PrincipalCalculation()
		{	
			double money = 0;
			Scanner scanner = new Scanner(System.in);
			System.out.println("预期金额");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入存款年数:");
			int years = scanner.nextInt(); // 存钱年数
			double sum = 0;// 存款总额
			System.out.println("请输入年利率:");
			double rate = scanner.nextDouble(); // 利率
			
			money = ExpectedPrincipal/Math.pow(1.0 + rate, years);
			
			System.out.println("初始本金为(复利算法)" + money);
			money = ExpectedPrincipal/(1+rate*years);
			
			
			System.out.println("初始本金为(单利算法)" + money);
			main(null);
		}
		
}
