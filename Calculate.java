import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("�����뱾��:");
		double money = scanner.nextDouble(); // ����
		System.out.println("������������:");
		int years = scanner.nextInt(); // ��Ǯ����
		double sum = 0;// ����ܶ�
		System.out.println("������������:");
		double rate = scanner.nextDouble(); // ����

		for (int i = 1; i <= years; i++) {
			sum = (1 + rate) * i * money;
			System.out.println("�����" + i + "���Ĵ���ܶ�Ϊ��" + sum);
		}
	}
}
