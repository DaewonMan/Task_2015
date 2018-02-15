package com.dwm.daisomanage.sell;

import java.util.Scanner;

public class SellMenu {

	public static void showMenu() {
		Scanner sc = null;
		
		int num = 0;
		try {
			sc = new Scanner(System.in);
			System.out.println("-------------------");
			System.out.println("1. ������ �Ǹ�");
			System.out.println("2. �� �Ǹ���Ȳ");
			System.out.println("3. �� ����� �� ������");
			System.out.println("4. ���θ޴���");
			System.out.println("-------------------");
			System.out.print(">> ���� : ");
			num = sc.nextInt();
			
			SellController.goToSubMenu(num);
			
		} catch (Exception e) {
			e.printStackTrace();
			showMenu();
		}
		
	}

	public static void showSell() {
		Scanner sc = null;
		String name = null;
		int sold = 0;
		try {
			sc = new Scanner(System.in);
			System.out.print("���� �� ��ǰ�� : ");
			name = sc.next();
			
			System.out.print("�Ǹ� ���� : ");
			sold = sc.nextInt();
			
			SellItem item = new SellItem(0, name, sold, 0);
			
			SellController.goToDBWork("�Ǹ�", item);
		
		} catch (Exception e) {
			e.printStackTrace();
			SellController.goToMenu();
		}
		
	}

	public static void showItemInfo() {
		SellController.goToDBWork("��ȸ", null);
	}

	public static void showSalesAndProfit() {
		SellController.goToDBWork("�Ż�", null);
	}
}
