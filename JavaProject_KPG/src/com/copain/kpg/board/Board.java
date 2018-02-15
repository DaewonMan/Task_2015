package com.copain.kpg.board;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.copain.kpg.source.Card;
import com.copain.kpg.source.GameSource;

public class Board implements ActionListener {

	JFrame jf;
	public JButton jb, exit;
	public JPanel my_money, bet, back_ground, you_card1, you_card2, my_card1, my_card2;
	public JLabel my_label, bet_label, yCard_label1, yCard_label2, mCard_label1, mCard_label2;

	JPanel currentDP, meDP;
	JLabel currentDL, meDL;

	public JTextArea ta;

	public int basic_money1, basic_money2;
	public int bet_amount1, bet_amount2;
	public int receiveCnt, otherCnt;
	public int bet_sum;
	public int bet_result;

	public String[] bet_buttons;
	public String[] bet_button0;
	public String[] bet_button1;
	public String[] bet_button2;

	public boolean whoFirst;
	public boolean letYouGo;

	// ���� Ŭ���� ���� �� �Ӽ�
	GameSource gs;

	public int card[];
	public int myCard[];
	public int yourCard[];
	public int win;
	public int draw;
	public int lose;
	public int batting;
	public int mbm;
	public int ybm;
	
	public Card ci; // �� �̹��� ��ü
	
	public int card1, card2;
	
	Socket s;
	OutputStream os;
	OutputStreamWriter osw;
	BufferedWriter bw;

	public Board() {
		basic_money1 = 10000; // ó�� ����� ������ �ݾ�
		basic_money2 = 10000; // ������� ó�� ����� ������ �ݾ�
		bet_amount1 = 0; // ���ñݾ�
		bet_amount2 = 0; // ����� ���ñݾ�
		receiveCnt = 0; // �� ���� Ƚ��
		otherCnt = 0;
		bet_sum = 0; // �� ���� �ݾ�

		bet_buttons = new String[] { "����(3��)", "��(2��)", "üũ(1��)", "����" }; // ���ÿɼ�
		bet_button0 = new String[] { "����(3��)", "����" }; // ���ÿɼ�
		bet_button1 = new String[] { "��(2��)", "����" }; // ���ÿɼ�
		bet_button2 = new String[] { "üũ(1��)", "����" }; // ���ÿɼ�

		whoFirst = false; // ���� ���� �������� �˾Ƴ��� ����
		letYouGo = false; // ���� ���� ��밡 �����ߴٴ� ��ȣ�� �˸��� ����
		bet_result = 0;
		
		gs = GameSource.getGS(); // ���� Ŭ���� �̱���
		
		card = new int[20];
		myCard = new int[2];
		yourCard = new int[2];
		win = 0;
		draw = 0;
		lose = 0;
		batting = 0;
		mbm = 0;
		ybm = 0;
		
		ci = new Card();
		card1 = 0;
		card2 = 0;
		
	}

	public void mainDisplay() {
		// ȭ�� Ʋ
		JFrame jf = new JFrame("Korean Poker Game made by copain"); // ������ ����
		jf.setLayout(null);
		jf.setBounds(270, 130, 900, 600);
		jf.setResizable(false);
		jf.setVisible(true);

		// �е�
		// �����
		you_card1 = new JPanel();
		you_card1.setBounds(250, 70, 70, 105);
		you_card1.setBackground(Color.red);

		yCard_label1 = new JLabel();
		// yCard_label1.setBackground(Color.red);
		you_card1.add(yCard_label1);
		jf.add(you_card1);

		you_card2 = new JPanel();
		you_card2.setBounds(330, 70, 70, 105);
		you_card2.setBackground(Color.red);

		yCard_label2 = new JLabel();
		// yCard_label2.setBackground(Color.red);
		you_card2.add(yCard_label2);
		jf.add(you_card2);

		// ����
		my_card1 = new JPanel();
		my_card1.setBounds(250, 400, 70, 105);
		my_card1.setBackground(Color.red);

		mCard_label1 = new JLabel();
		//mCard_label1.setBackground(Color.red);
		my_card1.add(mCard_label1);
		jf.add(my_card1);

		my_card2 = new JPanel();
		my_card2.setBounds(330, 400, 70, 105);
		my_card2.setBackground(Color.red);

		mCard_label2 = new JLabel();
		// mCard_label2.setBackground(Color.red);
		my_card2.add(mCard_label2);
		jf.add(my_card2);

		// ���� �ݾ� - �̸� ǥ�� �г�
		currentDP = new JPanel();
		currentDP.setBounds(660, 80, 220, 30);
		currentDP.setBackground(Color.black);

		currentDL = new JLabel("����ݾ�");
		currentDL.setBounds(30, 30, 50, 40);
		currentDL.setForeground(Color.white);
		currentDL.setFont(new Font("����", Font.BOLD, 20));
		currentDP.add(currentDL);
		jf.add(currentDP);

		// **���� �ݾ� - ǥ�� �г�
		my_money = new JPanel();
		my_money.setBounds(660, 111, 220, 40);
		my_money.setBackground(Color.gray);
		// jf.add(jp);

		my_label = new JLabel();
		my_label.setBounds(30, 30, 50, 40);
		my_label.setForeground(Color.white);
		my_label.setFont(new Font("����", Font.BOLD, 20));
		my_money.add(my_label);
		jf.add(my_money);

		// ó�� ����� ���� �ݾ� �󺧿� ǥ��
		my_label.setText(basic_money1 + "");

		// �ǵ� - ǥ�ø� �г�
		meDP = new JPanel();
		meDP.setBounds(660, 200, 220, 30);
		meDP.setBackground(Color.black);

		meDL = new JLabel("�� ��");
		meDL.setForeground(Color.white);
		meDL.setFont(new Font("����", Font.BOLD, 20));
		meDP.add(meDL);
		jf.add(meDP);

		// ** �ǵ� - ǥ�� �г�
		bet = new JPanel();
		bet.setBounds(660, 231, 220, 40);
		bet.setBackground(Color.darkGray);

		bet_label = new JLabel();
		// bet_label.setBounds(0, 50, 30, 20);
		bet_label.setForeground(Color.white);
		bet_label.setFont(new Font("����", Font.BOLD, 20));
		bet.add(bet_label);
		jf.add(bet);

		// ���¸� ����ϴ� â
		ta = new JTextArea(); // �������� ĭ�ε� ���ڸ� ������ ��������
		ta.setBounds(660, 350, 220, 90);
		ta.setEditable(false);
		jf.add(ta);

		// ���� ��ư
		jb = new JButton("Start?");
		jb.setFont(new Font("����", Font.BOLD, 35));
		jb.setBounds(680, 450, 200, 70);
		jb.addActionListener(this);
		jf.add(jb);

		// �ӽ� ������ ��ư
		exit = new JButton("������");
		exit.setFont(new Font("����", Font.BOLD, 20));
		exit.setBounds(780, 20, 100, 50);
		exit.addActionListener(this);
		jf.add(exit);

		// �� ���� �ٴ�
		back_ground = new JPanel();
		back_ground.setBounds(20, 20, 620, 520);
		back_ground.setBackground(Color.green);
		jf.add(back_ground);

	}
	// ���� ����
	public void setSocket(Socket s) {
		try {
			this.s = s;
			os = s.getOutputStream();
			osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// ���ӽ����� �˸��� �Լ�
	public void startGame() {
		receiveCnt = 2; // 2
		JOptionPane.showMessageDialog(null, "������ ���۵Ǿ����ϴ�!!!");
		jb.setText("�� ��");
		ta.setText("Start Game!!!");
		
		if (whoFirst) {
			bet_amount2 = bet_amount1 = Integer.parseInt(JOptionPane.showInputDialog("���ñݾ��� �Է��Ͻÿ�"));
			updateMoney(bet_amount1);
			ta.setText(bet_amount1 + "���� �����߽��ϴ�.");
			
			mCard_label1.setIcon(ci.il[GameSource.myCard[0]]); // �� �̹��� ����
			yCard_label1.setIcon(ci.il[GameSource.yourCard[0]]);
			try {
				bw.write("���ñ��Է�\r\n");
				bw.flush();
				bw.write(bet_amount1 + "\r\n");
				bw.flush();
				bw.write(GameSource.myCard[0] + "\r\n");
				bw.flush();
				bw.write(GameSource.yourCard[0] + "\r\n");
				bw.flush();
				
				JOptionPane.showMessageDialog(null, ta.getText());
				secondBetting();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ta.setText("������ ���ñ� �Է���...");
		}
	}
	
	public void secondBetting() {
		if(whoFirst) {
			bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, bet_buttons, "��(2��)");
			if (bet_result == 0) {
				// ������ ���
				ta.setText("������ �����Ͽ����ϴ�.");
				bet_amount1 *= 3; // �⺻�ݿ� 3��
			} else if (bet_result == 1) {
				// ���� ���
				ta.setText("���� �����Ͽ����ϴ�.");
				bet_amount1 *= 2; // �⺻�ݿ� 2��
			} else if (bet_result == 2) {
				ta.setText("üũ�� �����Ͽ����ϴ�.");
			} else {
				ta.setText("���̸� �����Ͽ����ϴ�.");
			}

			// ����, ��, üũ�� ��� ���� ����
			if (bet_result <= 2) {
				updateMoney(bet_amount1);
			}
			mCard_label2.setIcon(ci.il[GameSource.myCard[1]]); // �� �̹��� ����
			yCard_label2.setIcon(ci.il[GameSource.yourCard[1]]); // �� �̹��� ����
			
			try {
				bw.write("���������Է�" + "\r\n");
				bw.flush();
				bw.write(bet_result + "\r\n");
				bw.flush();
				bw.write(GameSource.myCard[1] + "\r\n");
				bw.flush();
				bw.write(GameSource.yourCard[1] + "\r\n");
				bw.flush();
				
				JOptionPane.showMessageDialog(null, ta.getText());
				judgeResult();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ta.setText("������ ���ñ� �Է���...");
		}
	}
	
	public void judgeResult() {
		mbm = GameSource.getScore(myCard);
		ybm = GameSource.getScore(yourCard);
		
		if(mbm > ybm) {
			JOptionPane.showMessageDialog(null, "�̰���ϴ�!!");
			ta.setText("�̰���ϴ�!!");
			nowMoney(bet_sum);
			whoFirst = false;
		} else if(mbm < ybm) {
			JOptionPane.showMessageDialog(null, "�����ϴ�...");
			ta.setText("�����ϴ�...");
			nowMoney(-bet_sum);
			whoFirst = true;
		} else {
			JOptionPane.showMessageDialog(null, "�����ϴ�!");
			ta.setText("�����ϴ�!");
			if(whoFirst) {
				whoFirst = false;
			}
			else {
				whoFirst = true;
			}
		}
		
		refresh();
		
	}

	// ���ñݾ� ����
	public void updateMoney(int num) {
		// basic_money -= num;
		bet_sum += num;
		if(bet_sum <= 0) {
			JOptionPane.showMessageDialog(null, "�Ļ��Ͽ����ϴ�.");
		}
		
		bet_label.setText(bet_sum + ""); // ������ ���� �ݾ� ǥ��
		// my_label.setText(basic_money + ""); // �谨�� ���� �ݾ� �󺧿� ǥ��
	}
	// ���� �ݾ� ����
		public void nowMoney(int num) {
			basic_money1 += num;
			
			my_label.setText(basic_money1 + "");
			
			if(basic_money1 <= 0) {
				JOptionPane.showMessageDialog(null, "�Ļ��Ͽ����ϴ�.");
				System.exit(0);
			}
		}

	public void refresh() {
		//bet_sum = 0;
		//bet_label.setText(bet_sum + "");
		receiveCnt = 0;
		otherCnt = 0;
		jb.setText("Start?");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) { // �����ư Ŭ���� ������
			try {
				s.close();
				System.exit(0);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == jb) { // ��ŸƮ��ư Ŭ���� ����
			jb.setText("Ready...");
			ta.setText(jb.getText()); // ������ �����̸� ���ӽ��� => ��ư�� �������� ǥ�õǰ��Ѵ�.
			receiveCnt++; // �����ư ������ ���ӽ����غ�
			
			//gs.shuffle(card); // ī�� ����
			//
			if (whoFirst) {
				GameSource.shuffle(GameSource.card); // ī�弯�� (���� �����)
				GameSource.getCard(GameSource.myCard, GameSource.yourCard, GameSource.card); // ���� ī�� �й�
				
				card = GameSource.card;
				myCard = GameSource.myCard;
				yourCard = GameSource.yourCard;
			}
		
		} 
		
		/*else if (e.getSource() == jb && receiveCnt == 1) { // ���ù�ư Ŭ��
			if (whoFirst) {
				// �����϶�
				try {
					bet_amount2 = bet_amount1 = Integer.parseInt(JOptionPane.showInputDialog("���ñݾ��� �Է��Ͻÿ�"));
					updateMoney(bet_amount1);
					ta.append("\n" + bet_amount1 + "���� �����߽��ϴ�.");
					receiveCnt++; // �� �ѹ� ����
					mCard_label1.setIcon(ci.il[GameSource.myCard[0]]); // �� �̹��� ����
					yCard_label1.setIcon(ci.il[GameSource.yourCard[0]]);
					

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "���ñݾ� �Է��� ����Ͽ����ϴ�.");
				}

			} else if (letYouGo) {
				ta.append("\n��밡 " + bet_amount1 + "���� �����Ͽ����ϴ�.");

				// ������ ��밡 ���� �Ϸ��
				JOptionPane.showMessageDialog(null, "��밡 ���ñݾ��� " + bet_amount1 + "������ �����Ͽ����ϴ�.");
				updateMoney(bet_amount1);

				receiveCnt++;
				letYouGo = false; // �ٽ� ����� ������ ��ٸ��� ����
				mCard_label1.setIcon(ci.il[GameSource.myCard[0]]); // �� �̹��� ����
				yCard_label1.setIcon(ci.il[GameSource.yourCard[0]]);

			} else {
				JOptionPane.showMessageDialog(null, "������ �Է����� �ʾҽ��ϴ�.");
			}

		} else if (e.getSource() == jb && receiveCnt == 2) { // �� �ѹ� �̻� �ް� ���ù�ư Ŭ��

			if (whoFirst) {

				
				 * if(otherCnt < 2) { JOptionPane.showMessageDialog(null, "������ �Է����� �ʾҽ��ϴ�??.");
				 * return; }
				 
				bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, bet_buttons, "��(2��)");
				if (bet_result == 0) {
					// ������ ���
					ta.append("\n������ �����Ͽ����ϴ�.");
					bet_amount1 *= 3; // �⺻�ݿ� 3��
				} else if (bet_result == 1) {
					// ���� ���
					ta.append("\n���� �����Ͽ����ϴ�.");
					bet_amount1 *= 2; // �⺻�ݿ� 2��
				} else if (bet_result == 2) {
					ta.append("\nüũ�� �����Ͽ����ϴ�.");
				} else {
					ta.append("\n���̸� �����Ͽ����ϴ�.");
				}
				receiveCnt++;

				// ����, ��, üũ�� ��� ���� ����
				if (bet_result <= 2) {
					updateMoney(bet_amount1);
				}
				mCard_label2.setIcon(ci.il[GameSource.myCard[1]]); // �� �̹��� ����
				yCard_label2.setIcon(ci.il[GameSource.yourCard[1]]); // �� �̹��� ����
				
				
			} else if (letYouGo) {
				// ���� ���� �Ϸ��
				if (bet_result == 0) {
					ta.append("\n��밡 ������ �����Ͽ����ϴ�.");

					bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, bet_button0, "����");

					if (bet_result != 0)
						ta.append("\n���̸� �����Ͽ����ϴ�.");
					else
						bet_amount1 *= 3;

				} else if (bet_result == 1) {
					ta.append("\n��밡 ���� �����Ͽ����ϴ�.");

					bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, bet_button1, "����");

					if (bet_result != 0)
						ta.append("\n���̸� �����Ͽ����ϴ�.");
					else
						bet_amount1 *= 2;

				} else if (bet_result == 2) {
					ta.append("\n��밡 üũ�� �����Ͽ����ϴ�.");
					bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
							JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, bet_button2, "����");

					if (bet_result != 0)
						ta.append("\n���̸� �����Ͽ����ϴ�.");

				} else {
					// ��밡 ������ ���
					ta.append("\n��밡 ���̸� �����Ͽ����ϴ�.!!!?");
					System.out.println(bet_result);
				}
				// ����, ��, üũ�� ��� ���� ����
				if (bet_result == 0) {
					System.out.println(bet_amount1); // 0
					updateMoney(bet_amount1);
				}

				receiveCnt++;
				mCard_label2.setIcon(ci.il[GameSource.myCard[1]]); // �� �̹��� ����
				yCard_label2.setIcon(ci.il[GameSource.yourCard[1]]); // �� �̹��� ����
			} else {
				JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.");
				return; // �Լ�������
			}

		}*/

	}

	/*
	 * public static void main(String[] args) { Board b = new Board();
	 * b.mainDisplay(); }
	 */

}
