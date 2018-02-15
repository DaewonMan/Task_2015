package com.copain.kpg.source;

public class GameSource {
	public static int card[];
	public static int myCard[];
	public static int yourCard[];
	public int win;
	public int draw;
	public int lose;
	public int batting;
	public int mbm;
	public int ybm;

	private static final GameSource GS = new GameSource();

	public GameSource() {
		card = new int[20];
		myCard = new int[2];
		yourCard = new int[2];
		win = 0;
		draw = 0;
		lose = 0;
		batting = 0;
		mbm = 0;
		ybm = 0;
	}

	// ĸ��ȭ!!!
	public static GameSource getGS() {
		return GS;
	}

	// ������ �޾� ���п��θ� result������ �����Ѵ�.
	public int sorceCheck(int myScore, int yourScore) {
		if (myScore > yourScore) {
			System.out.println(" �¸�! ");
			return 1;
		} else if (myScore == yourScore) {
			System.out.println(" �����ϴ� ");
			return 2;
		} else {
			System.out.println(" �й�! ");
			return 3;
		}
	}

	// �÷��̾��� ī�忡 ���� ���� �ο�
	public static int getScore(int[] playerCard) {

		int player = 0;
		// score check
		if ((playerCard[0] == 3 && playerCard[1] == 8) || (playerCard[0] == 8 && playerCard[1] == 3)) {
			player = 200; // 38����
		}
		if (playerCard[0] == 1 && (playerCard[1] == 3 || playerCard[1] == 8)) {
			player = 90; // ���� 90��

		}
		if ((playerCard[0] == 8) && (playerCard[1] == 1)) {
			player = 90;
		}
		if ((playerCard[0] == 3) && (playerCard[1] == 1)) {
			player = 90;

		}
		if (playerCard[0] % 10 == playerCard[1] % 10) {
			player = 80; // ��
		}

		if (playerCard[0] == 1 || playerCard[0] == 11) {
			if (playerCard[1] == 2 || playerCard[1] == 12) {
				player = 70; // �˸� (1��, 2��)
			} else if (playerCard[1] == 4 || playerCard[1] == 14) {
				player = 65; // ���� (1��, 4��)
			} else if (playerCard[1] == 9 || playerCard[1] == 19) {
				player = 60; // ���� (1��, 9��)
			} else if (playerCard[1] == 10 || playerCard[1] == 20) {
				player = 55; // ��� (1��, 10��)
			}
		}
		if (playerCard[0] == 2 || playerCard[0] == 12) {
			if (playerCard[1] == 1 || playerCard[1] == 11)
				player = 70;
		}
		if (playerCard[0] == 4 || playerCard[0] == 14) {
			if (playerCard[1] == 1 || playerCard[1] == 11) {
				player = 65;
			} else if (playerCard[1] == 10 || playerCard[1] == 20) {
				player = 50; // ��� (4��,10��)
			} else if (playerCard[1] == 6 || playerCard[1] == 16) {
				player = 45; // ���� (4��,6��)
			}
		}
		if (playerCard[0] == 9 || playerCard[0] == 19) {
			if (playerCard[1] == 1 || playerCard[1] == 11)
				player = 60;
		}
		if (playerCard[0] == 10 || playerCard[0] == 20) {
			if (playerCard[1] == 1 || playerCard[1] == 11) {
				player = 55;
			} else if (playerCard[1] == 4 || playerCard[1] == 14) {
				player = 50;
			}
		}
		if (playerCard[0] == 6 || playerCard[0] == 16) {
			if (playerCard[1] == 4 || playerCard[1] == 14)
				player = 45;
		} else {
			player = (playerCard[0] + playerCard[1]) % 10;

		}
		return player;
	}

	// ������ ��ǻ�Ϳ��� ī�带 �й��Ѵ�.
	public static void getCard(int[] myCard, int[] yourCard, int[] card) {
		int temp;
		// card�迭�� �̹� shuffle�Ǿ� �־ ������� �־
		// ������ ī�带 ����
		myCard[0] = card[0];
		yourCard[0] = card[1];
		myCard[1] = card[2];
		yourCard[1] = card[3];
	}

	public void batting(int mbm, int batting) {

		int b = 0;
		int bb = 0;
		int bbb = 0;
		int bbbb = 0;
		if (batting == 1) {
			b = 3 * mbm;
			System.out.printf("����!!  %d ��\n", b);
		} else if (batting == 2) {
			bb = 2 * mbm;
			System.out.printf("��!!  %d ��\n", bb);
		} else if (batting == 3) {
			bbb = 1 * mbm;
			System.out.printf("üũ!!  %d ��\n", bbb);
			System.out.println(bbb);
		} else if (batting == 4) {
			bbbb = mbm;
			System.out.printf("%d �� �Ҿ����ϴ�\n", mbm);

		} else {
			System.out.println("�Է¿���");
			return;
		}
	}

	public void cardSwap(int[] playerCard) {
		int temp;

		temp = playerCard[0];
		playerCard[0] = playerCard[1];
		playerCard[1] = temp;
	}

	// ī�� ����
	public static void shuffle(int[] card) {
		boolean swit[] = new boolean[card.length];
		int w = 0;
		int r;

		// random
		while (w < card.length) {
			r = (int) (Math.random() * card.length);
			if (!swit[r]) {
				swit[r] = true;
				card[w] = r + 1; // 1~20 (r%10)
				w++;
			}

		}
	}

	public void confirmFirstCard(int[] myCard, int[] yourCard, int[] card) {
		if (myCard[0] == 1 || myCard[0] == 3 || myCard[0] == 8) {
			System.out.println("My card: " + myCard[0] + "��! "); // + myCard[1] + "��");
		} else if (card[0] > 10) {
			System.out.println("My card: " + (myCard[0] = card[0] - 10) + "�� "); // + myCard[1] + "��");
		} else {
			System.out.println("My card: " + myCard[0] + "�� "); // + myCard[1] + "��");
		}
		if (yourCard[0] == 1 || yourCard[0] == 3 || yourCard[0] == 8) {
			System.out.println("Your card: " + yourCard[0] + "��! ");// + yourCard[1] + "��");
		} else if (card[1] > 10) {
			System.out.println("Your card: " + (yourCard[0] = card[1] - 10) + "�� ");// + yourCard[1] + "��");
		} else {
			System.out.println("Your card: " + yourCard[0] + "�� ");// + yourCard[1] + "��");
		}
		System.out.println("=========================");
	}

	public void confirmSecondCard(int[] myCard, int[] yourCard, int[] card) {
		if (myCard[1] == 1 || myCard[1] == 3 || myCard[1] == 8) {
			System.out.println("My card: " + myCard[1] + "��! "); // + myCard[1] + "��");
		} else if (card[2] > 10) {
			System.out.println("My card: " + (myCard[1] = card[2] - 10) + "�� "); // + myCard[1] + "��");
		} else {
			System.out.println("My card: " + myCard[1] + "�� "); // + myCard[1] + "��");
		}
		if (yourCard[1] == 1 || yourCard[1] == 3 || yourCard[1] == 8) {
			System.out.println("Your card: " + yourCard[1] + "��! ");// + yourCard[1] + "��");
		} else if (card[3] > 10) {
			System.out.println("Your card: " + (yourCard[1] = card[3] - 10) + "�� ");// + yourCard[1] + "��");
		} else {
			System.out.println("Your card: " + yourCard[1] + "�� ");// + yourCard[1] + "��");
			System.out.println("=========================");
		}
	}

	/*
	 * public void main(String[] args) {
	 * 
	 * 
	 * 
	 * String again = "y"; Scanner keyboard = new Scanner(System.in);
	 * 
	 * while (again.equals("y") || again.equals("yes") || again.equals("Y") ||
	 * again.equals("Yes")) { try { System.out.println("���� �ϼ���");
	 * System.out.print("���ñ� : "); mbm = keyboard.nextInt();
	 * 
	 * System.out.printf("%d �� ����!\n", mbm); Thread.sleep(100);
	 * 
	 * System.out.println("Shuffling now..."); shuffle(card); // ī�� ����
	 * 
	 * // ī�� �й� // ���� ī�带 ������ ��ǻ�Ͱ� 1�徿 ���� ������. getCard(myCard, yourCard, card);
	 * 
	 * // ���� ī��, ��ǻ�� ī�� ��� System.out.println("Open Cards");
	 * 
	 * confirmFirstCard(myCard, yourCard, card); // ù�� ���
	 * 
	 * while(true) { System.out.println("1. ����"); System.out.println("2. ��");
	 * System.out.println("3. üũ"); System.out.println("4. ����");
	 * System.out.print("���� : "); batting = keyboard.nextInt();
	 * System.out.println("========================="); if(batting < 1 || batting >
	 * 4) { System.out.println("�ٽ� �Է��Ͻÿ�!!"); continue; } else { break; } } if
	 * (batting == 4) { lose++; //break; continue; }
	 * 
	 * batting(mbm, batting); System.out.println("=========================");
	 * getCard(myCard, yourCard, card); // ī�带 �� ���徿 �����´�
	 * 
	 * confirmSecondCard(myCard, yourCard, card); // �ι�° ī��
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } // ������ �����´�. // 38���� = 200, ����
	 * = 90, ... ��� int myScore = getScore(myCard); int yourScore =
	 * getScore(yourCard);
	 * 
	 * // ������ ������ ���ؼ� ���и� ������.
	 * 
	 * // result == 1�̸� �¸�, 2�̸� ���º�, 3�̸� �й� int result = sorceCheck(myScore,
	 * yourScore); if (result == 1) win++; else if (result == 2) draw++; else
	 * lose++;
	 * 
	 * System.out.println(win + "�� " + draw + "�� " + lose + "��");
	 * System.out.print("���� ��! :  ");
	 * 
	 * again = keyboard.next(); }
	 * 
	 * System.out.println("���� ����");
	 * 
	 * }
	 */
}