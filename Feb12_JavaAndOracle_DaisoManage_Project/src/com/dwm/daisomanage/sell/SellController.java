package com.dwm.daisomanage.sell;

import java.util.ArrayList;

import com.dwm.daisomanage.main.MainController;

public class SellController {

	public static void goToMenu() {
		SellMenu.showMenu();
	}

	public static void goToSubMenu(int num) {
		if(num == 1) {
			// ������ �Ǹ�
			SellMenu.showSell();
		} else if (num == 2) {
			// ���û�ǰ �Ǹ���Ȳ
			SellMenu.showItemInfo();
		} else if (num == 3) {
			// �� ����� �� ������
			SellMenu.showSalesAndProfit();
		} else if(num == 4) {
			// ���θ޴���
			MainController.main(null);
		} else {
			// �ٽ�
			goToMenu();
		}
		
	}

	public static void goToDBWork(String what, SellItem item) {
		if(what.equals("�Ǹ�")) {
			SellDAO.sell(item);
		} else if(what.equals("��ȸ")) {
			SellDAO.info();
		} else if(what.equals("�Ż�")) {
			SellDAO.sales();
		} else {
			System.out.println("�ٽü���");
			goToMenu();
		}
		
	}

	public static void goToSellResult(String what) {
		SellView.showSellResult(what);
	}

	public static void goToInfoResult(String what, ArrayList<SellItem> items) {
		SellView.showInfoResult(what, items);
	}

	public static void goToSalesResult(String what, int tempSale) {
		SellView.showSalesResult(what, tempSale);
	}

}
