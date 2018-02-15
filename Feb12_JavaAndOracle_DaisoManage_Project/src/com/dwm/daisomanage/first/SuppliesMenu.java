package com.dwm.daisomanage.first;

import java.util.Scanner;

public class SuppliesMenu {
	/* �繫��ǰ ���� �޴� */
	public static void showMenu() {
		Scanner sc = null;
		int num = 0;
		try {
			sc = new Scanner(System.in);

			System.out.println("==========================");
			System.out.println("1. ��ǰ ��ȸ");
			System.out.println("2. ��ǰ ���");
			System.out.println("3. ���θ޴���");
			System.out.println("==========================");
			System.out.print("���� : ");
			num = sc.nextInt();

			SuppliesController.goToSubMenu(num);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ��Է�");
			showMenu();
		}
	}

	/* ���� ���� �޴��� ǥ���ϴ� �޼ҵ�� */
	public static void showInfoMenu() {
			SuppliesController.goToDBWork("��ȸ", null);
	}

	public static void showDelMenu() {
		Scanner sc = null;
		
		int no = 0;
		try {
			System.out.print("����� ��ǰ ��ȣ : ");
			no = sc.nextInt();
			
			Supplies supplies = new Supplies(no, null, 0, 0, 0);
			
			SuppliesController.goToDBWork("���", supplies);
		} catch (Exception e) {
			e.printStackTrace();
			SuppliesController.goToMenu();
		}
		
	}

}
