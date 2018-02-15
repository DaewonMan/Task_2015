package com.dwm.daisomanage.factoryItem;

import java.util.ArrayList;

import com.dwm.daisomanage.main.MainController;

public class FactoryItemController {

	public static void goToMenu() {
		FactoryItemMenu.showMainMenu();
	}

	public static void goToSubMenu(int num) {
		if(num == 1) {
			// ����ǰ ���
			FactoryItemMenu.showReg();
		} else if (num == 2) {
			// ���� ��ǰ ����
			FactoryItemMenu.showUpdate();
		} else if (num == 3) {
			// ���̼� �Ǹ�
			FactoryItemMenu.showDeal();
		} else if (num == 4) {
			// ��ǰ ��Ȳ
			FactoryItemMenu.showInfo();
		} else if (num == 5) {
			// ��ǰ ���
			FactoryItemMenu.showDel();
		} else if (num == 6) {
			// ���� �޴���
			MainController.main(null);
		} else {
			// �ٽ�
			FactoryItemController.goToMenu();
		}
		
	}

	public static void goToDBWork(String what, FactoryItem item) {
		if(what.equals("���")) {
			FactoryItemDAO.reg(item);
		} else if(what.equals("����")) {
			FactoryItemDAO.update(item);
		} else if(what.equals("��Ȳ")) {
			FactoryItemDAO.info();
		} else if(what.equals("���")) {
			FactoryItemDAO.del(item);
		} else if(what.equals("�ŷ�")) {
			FactoryItemDAO.deal(item);
		} else {
			System.out.println("�ٽ� ����");
			FactoryItemController.goToMenu();
		}
		
	}

	public static void goToRegResult(String what) {
		FactoryItemView.showRegResult(what);
	}

	public static void goToUpdateResult(String what) {
		FactoryItemView.showUpdateResult(what);
	}

	public static void goToDelResult(String what) {
		FactoryItemView.showDelResult(what);
	}

	public static void goToInfoResult(String what, ArrayList<FactoryItem> items) {
		FactoryItemView.showInfoResult(what, items);
	}

	public static void goToDealResult(String what) {
		FactoryItemView.showDealResult(what);
	}

}
