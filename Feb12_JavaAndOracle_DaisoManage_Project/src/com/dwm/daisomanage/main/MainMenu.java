package com.dwm.daisomanage.main;

import java.util.Scanner;

// V
public class MainMenu {
	public static void mainMenuShow() {
		Scanner sc = null;
		int num = 0;
		try {
			sc = new Scanner(System.in);
			
			System.out.println("========���̼�������������=========");
			System.out.println("1. �ŷ�ó ���� ����");
			System.out.println("2. ��� ���� ����");
			System.out.println("3. �Ǹ� ���� ����");
			System.out.println("4. ������");
			System.out.println("=======================================");
			System.out.print(">> �޴����� : ");
			
			num = sc.nextInt();
			
			MainController.mainController(num);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ��Է�");
			mainMenuShow();
		}
	}
}
