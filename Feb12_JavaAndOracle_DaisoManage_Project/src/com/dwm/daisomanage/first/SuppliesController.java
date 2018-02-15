package com.dwm.daisomanage.first;

import java.util.ArrayList;

import com.dwm.daisomanage.main.MainController;
import com.dwm.daisomanage.main.MainMenu;

public class SuppliesController {
	
	/*�����޴��� �����ϰ� �ϴ� �޼ҵ�*/
	public static void goToSubMenu(int num) {
		if(num == 1) {
			// ��ȸ
			SuppliesMenu.showInfoMenu();
		} else if(num == 2) {
			// ���
			SuppliesMenu.showDelMenu();
		} else if(num == 3) {
			// ���θ޴���
			MainController.main(null);
		} else {
			// �ٽ�
			goToMenu();
		}
		
	}
	
	/*DB ó���� �ϰ� �ϴ� �޼ҵ�*/
	public static void goToDBWork(String what, Supplies s) {
		if(what.equals("��ȸ")) {
			SuppliesDAO.info(s);
		} else if(what.equals("���")) {
			SuppliesDAO.del(s);
		} else {
			// ���θ޴���
			MainMenu.mainMenuShow();
		} 
	}
	
	/*�޴�ȭ������ �����ϴ� �޼ҵ��*/
	public static void goToMenu() {
		SuppliesMenu.showMenu();
	}
	
	/*��� ��� View�� �����ϴ� �޼ҵ��*/
	public static void goToDelResult(String what) {
		SuppliesView.showDelResult(what);
		
	}

	public static void goToInfoResult(String what, ArrayList<Supplies> supplies) {
		SuppliesView.showInfoResult(what, supplies);
	}
}
