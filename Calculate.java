import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入本金:");
		double money = scanner.nextDouble(); // 本金
		System.out.println("请输入存款年数:");
		int years = scanner.nextInt(); // 存钱年数
		double sum = 0;// 存款总额
		System.out.println("请输入年利率:");
		double rate = scanner.nextDouble(); // 利率

		for (int i = 1; i <= years; i++) {
			sum = (1 + rate) * i * money;
			System.out.println("存入第" + i + "年后的存款总额为：" + sum);
		}
	}
}
