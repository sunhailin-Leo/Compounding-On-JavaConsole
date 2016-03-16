package Calulation;

import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Calculate {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		
		System.out.println("请选择单利计算或复利计算:(复利选1，单利选2,本金计算选3,投资预期年份计算选4,投资预期利率计算选5,定额复利投资递增性选6)");
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
				System.out.println("输入错误!");
				main(null);
				break;
		}
	}

		public static void CompoundingCalculation() 
		{
			System.out.println("请输入本金:");
			double money = scanner.nextDouble(); // 本金
			System.out.println("请输入存款年数:");
			int years = scanner.nextInt(); // 存钱年数
			double sum = 0;// 存款总额
			System.out.println("请输入年利率:");
			double rate = scanner.nextDouble(); // 利率
			double sum1 = 0 ;
			for (int i = 1; i <= years; i++) 
			{
				sum1 = money*Math.pow(1.0 + rate, years);	
			}
			System.out.println("存入第" + years + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void SimpleInterestCalculation()
		{
			System.out.println("请输入本金:");
			double money = scanner.nextDouble(); // 本金
			System.out.println("请输入存款年数:");
			int years = scanner.nextInt(); // 存钱年数
			double sum = 0;// 存款总额
			System.out.println("请输入年利率:");
			double rate = scanner.nextDouble(); // 利率
			double sum1;
			double interest;
			interest = money*rate*years;
			sum1 = money+interest;
			System.out.println("存入第" + years + "年后的存款总额为：" + sum1);
			main(null);
		}
		
		public static void PrincipalCalculation()
		{	
			double money = 0;
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
		
		public static void CalculateRewardTime()
		{
			System.out.println("预期金额");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入年利率:");
			double rate = scanner.nextDouble(); // 利率
			System.out.println("本金");
			double money = scanner.nextDouble();
			double year =  log((ExpectedPrincipal/money),1+rate);
			System.out.println("年份" + Math.ceil(year));
			main(null);
		
		}
		
		public static double log(double value,double base)
		{
			return Math.log(value)/Math.log(base);
		}

		public static void CalculateInterest()
		{
			System.out.println("预期金额");
			double ExpectedPrincipal = scanner.nextDouble();
			System.out.println("请输入年份:");
			double year = scanner.nextDouble(); // 利率
			System.out.println("本金");
			double money = scanner.nextDouble();
			double rate = Math.pow((ExpectedPrincipal/money), 1/year)-1;
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
			
			System.out.println("每年定额资本");
			double EachYearQuotaMoney = scanner.nextDouble();
			System.out.println("请输入存款年数:");
			int years = scanner.nextInt(); // 存钱年数
			System.out.println("请输入年利率:");
			double rate = scanner.nextDouble(); // 利率
			double sum1 = 0 ;
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
			System.out.println("每月定额资本");
			double EachMonthQuotaMoney = scanner.nextDouble();
			System.out.println("请输入存款月数:");
			int Months = scanner.nextInt(); // 存钱年数
			System.out.println("请输入月利率:");
			double MonthRate = scanner.nextDouble(); // 利率
			double sum1 = 0 ;
			for (int i = 1; i <= Months; i++) 
			{
				sum1 = (sum1+EachMonthQuotaMoney)*Math.pow((1.0 + MonthRate), Months);
			}
			System.out.println("存入第" + Months + "月后的存款总额为：" + sum1+EachMonthQuotaMoney);
			main(null);	
		}
}
