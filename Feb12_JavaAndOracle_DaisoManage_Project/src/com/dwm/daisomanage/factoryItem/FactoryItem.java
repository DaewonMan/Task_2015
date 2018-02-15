package com.dwm.daisomanage.factoryItem;

public class FactoryItem {
	private int no;
	private String name;
	private int amount;
	private int cost; // ����
	
	public FactoryItem() {
		// TODO Auto-generated constructor stub
	}

	public FactoryItem(int no, String name, int amount, int cost) {
		super();
		this.no = no;
		this.name = name;
		this.amount = amount;
		this.cost = cost;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	public void printInfo() {
		System.out.println("��ǰ��ȣ : " + no);
		System.out.println("��ǰ�� : " + name);
		System.out.println("���귮 : " + amount);
		System.out.println("���� : " + cost);
	}
}
