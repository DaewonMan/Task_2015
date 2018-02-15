package com.dwm.daisomanage.factoryItem;

import java.util.Scanner;

public class FactoryItemMenu {

	public static void showMainMenu() {
		Scanner sc = null;

		int num = 0;
		try {
			sc = new Scanner(System.in);

			System.out.println("-----���� ����-----");
			System.out.println("1. ����ǰ ���"); // ���̼ҿ��� ��ǰ��� �ǰ� �Ѵ�.
			System.out.println("2. ���� ��ǰ ����");
			System.out.println("3. ���̼ҿ� �Ǹ�"); // ���̼ҿ� ��ǰ ������ �߰��Ѵ�.
			System.out.println("4. ��ǰ ��Ȳ");
			System.out.println("5. ��ǰ ���");
			System.out.println("6. ���θ޴���");
			System.out.println("-------------------");
			System.out.print(">> ���� : ");
			num = sc.nextInt();

			FactoryItemController.goToSubMenu(num);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			showMainMenu();
		}

	}

	public static void showReg() {
		Scanner sc = null;

		String name = null;
		int amount = 0, cost = 0;
		try {
			sc = new Scanner(System.in);

			System.out.print("����ǰ�� : ");
			name = sc.next();

			System.out.print("���귮 : ");
			amount = sc.nextInt();

			System.out.print("���� : ");
			cost = sc.nextInt();

			FactoryItem item = new FactoryItem(0, name, amount, cost);

			FactoryItemController.goToDBWork("���", item);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			showReg();
		}
	}

	public static void showUpdate() {
		Scanner sc = null;
		
		String name = null;
		int amount = 0;
		try {
			sc = new Scanner(System.in);

			System.out.print("��ǰ�� : ");
			name = sc.next();

			System.out.print("���귮 : ");
			amount = sc.nextInt();

			FactoryItem item = new FactoryItem(0, name, amount, 0);

			FactoryItemController.goToDBWork("����", item);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			showUpdate();
		}

	}

	public static void showInfo() {
		FactoryItemController.goToDBWork("��Ȳ", null);
	}

	public static void showDel() {
		Scanner sc = null;
		
		String name = null;
		int no = 0;
		try {
			sc = new Scanner(System.in);

			System.out.print("��ǰ�� : ");
			name = sc.next();

			FactoryItem item = new FactoryItem(0, name, 0, 0);

			FactoryItemController.goToDBWork("���", item);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			showDel();
		}
		
	}

	public static void showDeal() {
		Scanner sc = null;
		
		String name = null;
		int amount = 0;
		try {
			sc = new Scanner(System.in);

			System.out.print("�ŷ��� ��ǰ�� : ");
			name = sc.next();
			
			System.out.print("�ŷ��� ��ǰ ���� : ");
			amount = sc.nextInt();

			FactoryItem item = new FactoryItem(0, name, amount, 0);

			FactoryItemController.goToDBWork("�ŷ�", item);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�ٽ�");
			showDeal();
		}
		
	}
}
