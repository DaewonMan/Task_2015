package com.dwm.daisomanage.first;

import java.util.ArrayList;

public class SuppliesView {

	public static void showInfoResult(String what, ArrayList<Supplies> supplies) {
		if(what.equals("����")) {
			for (Supplies tempS : supplies) {
				tempS.printInfo();
				System.out.println("-----------------");
			}
			System.out.println("��ǰ ��ȸ ����!!");
		} else {
			System.out.println("��ǰ ��ȸ ����!!");			
		}
		SuppliesController.goToMenu();
	}

	public static void showDelResult(String what) {
		if(what.equals("����")) {
			System.out.println("��ǰ ���� ����!!");
		} else {
			System.out.println("��ǰ ���� ����..");
		}
		SuppliesController.goToMenu();
		
	}
}
