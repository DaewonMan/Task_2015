package com.dwm.daisomanage.main;

import com.dwm.daisomanage.factoryItem.FactoryItemController;
import com.dwm.daisomanage.first.SuppliesController;
import com.dwm.daisomanage.sell.SellController;

public class MainController {
	public static void mainController(int num) {
		if(num == 1) {
			// �ŷ�ó ���� ����
			FactoryItemController.goToMenu();
		} else if(num == 2) {
			// ��� ���� ����
			SuppliesController.goToMenu();
		} else if(num == 3) {
			// �Ǹ� ���� ����
			SellController.goToMenu();
		} else if(num == 4) {
			// ������
			
		} else {
			// �̿��� ��
			main(null);
		}
		
	}
	public static void main(String[] args) {
		MainMenu.mainMenuShow(); // �޴����
	}
}
