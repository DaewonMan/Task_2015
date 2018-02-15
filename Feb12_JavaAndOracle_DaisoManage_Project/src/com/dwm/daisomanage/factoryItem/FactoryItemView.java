package com.dwm.daisomanage.factoryItem;

import java.util.ArrayList;

public class FactoryItemView {

	public static void showRegResult(String what) {
		if(what.equals("����")) {
			System.out.println("�Ż�ǰ ��� ����!!");
		} else {
			System.out.println("�Ż�ǰ ��� ����!!");			
		}
		FactoryItemController.goToMenu();
	}

	public static void showUpdateResult(String what) {
		if(what.equals("����")) {
			System.out.println("���� ��ǰ ����� ����!!");
		} else {
			System.out.println("���� ��ǰ ����� ����!!");			
		}
		FactoryItemController.goToMenu();
	}

	public static void showDelResult(String what) {
		if(what.equals("����")) {
			System.out.println("�ش� ��ǰ ��� ����!!");
		} else {
			System.out.println("�ش� ��ǰ ��� ����!!");			
		}
		FactoryItemController.goToMenu();
	}

	public static void showInfoResult(String what, ArrayList<FactoryItem> items) {
		if(what.equals("����")) {
			for (FactoryItem factoryItem : items) {
				factoryItem.printInfo();
				System.out.println("--------------");
			}
			System.out.println("��� ��ǰ ��ȸ ����!!");
		} else {
			System.out.println("��� ��ǰ ��ȸ ����!!");			
		}
		FactoryItemController.goToMenu();
	}

	public static void showDealResult(String what) {
		if(what.equals("����")) {
			System.out.println("�ŷ� ����!!");
		} else {
			System.out.println("�ŷ� ����!!");			
		}
		FactoryItemController.goToMenu();
	}
}
