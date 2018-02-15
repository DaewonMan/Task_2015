package com.dwm.daisomanage.sell;

import java.util.ArrayList;

public class SellView {

	public static void showSellResult(String what) {
		if(what.equals("����")) {
			System.out.println("������ ��ǰ �Ǹ� ����!!");
		} else {
			System.out.println("������ ��ǰ �Ǹ� ����..");			
		}
		SellController.goToMenu();
	}

	public static void showInfoResult(String what, ArrayList<SellItem> items) {
		if(what.equals("����")) {
			for (SellItem sellItem : items) {
				sellItem.printInfo();
				System.out.println("-------------------");
			}
			System.out.println("��ǰ ��ȸ ����!!");
		} else {
			System.out.println("��ǰ ��ȸ ����..");			
		}
		SellController.goToMenu();
	}

	public static void showSalesResult(String what, int tempSale) {
		if(what.equals("����")) {
			System.out.println("�� �Ż� : " + tempSale);
			System.out.println("�� ���� : " + (double)(tempSale*2)/3);
			System.out.println("�� �Ż� �� �� ���� ���� ����!!");
		} else {
			System.out.println("�� �Ż� �� �� ���� ���� ����..");			
		}
		SellController.goToMenu();
	}

}
