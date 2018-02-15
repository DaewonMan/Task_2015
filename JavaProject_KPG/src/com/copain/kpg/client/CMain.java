package com.copain.kpg.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.copain.kpg.board.Board;
import com.copain.kpg.source.GameSource;

public class CMain {
	public static void main(String[] args) {
		Socket s = null;
		
		try {
			s = new Socket("172.30.1.51", 1111); // ���ӵ� ������ ���

			System.out.println("���ӵ�");

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			Board b = new Board();
			b.mainDisplay();
			b.setSocket(s);
			//JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ ����");
			//GameSource gs = GameSource.getGS(); // �̱���
			
			new Thread() {
				public void run() {
					String str1 = null;
					while (true) {
						try {
							str1 = br.readLine();
							if (str1.equals("Ready...") && b.jb.getText().equals("Ready...")) {
								// �Ѵ� ���� ������ ���ӽ���
								b.startGame();
								b.otherCnt++;

							} else if(str1.equals("���ñ��Է�")) {
								int you_money = Integer.parseInt(br.readLine());
								b.ta.setText("������ " + you_money +"�� �Է��Ͽ����ϴ�.");
								b.bet_amount1 = you_money;
								b.yourCard[0] = Integer.parseInt(br.readLine());
								b.myCard[0] = Integer.parseInt(br.readLine());
								
								b.updateMoney(b.bet_amount1);
								b.mCard_label1.setIcon(b.ci.il[b.myCard[0]]); // �� �̹��� ����
								b.yCard_label1.setIcon(b.ci.il[b.yourCard[0]]);
								
								b.secondBetting();
							} else if(str1.equals("���������Է�")) {
								int bet_result = Integer.parseInt(br.readLine());
								
								if (bet_result == 0) {
									b.ta.setText("��밡 ������ �����Ͽ����ϴ�.");

									b.bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, b.bet_button0, "����");

									if (bet_result != 0)
										b.ta.setText("���̸� �����Ͽ����ϴ�.");
									else
										b.bet_amount1 *= 3;

								} else if (bet_result == 1) {
									b.ta.setText("��밡 ���� �����Ͽ����ϴ�.");

									b.bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, b.bet_button1, "����");

									if (bet_result != 0)
										b.ta.setText("���̸� �����Ͽ����ϴ�.");
									else
										b.bet_amount1 *= 2;

								} else if (bet_result == 2) {
									b.ta.setText("��밡 üũ�� �����Ͽ����ϴ�.");
									b.bet_result = JOptionPane.showOptionDialog(null, "���ÿɼ��� �����ϼ���!", "���ÿɼǼ���",
											JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, b.bet_button2, "����");

									if (bet_result != 0)
										b.ta.setText("���̸� �����Ͽ����ϴ�.");

								} else {
									// ��밡 ������ ���
									b.ta.setText("��밡 ���̸� �����Ͽ����ϴ�.!!!?");
									System.out.println(bet_result);
								}
								// ����, ��, üũ�� ��� ���� ����
								if (bet_result == 0) {
									//System.out.println(bet_amount1); // 0
									b.updateMoney(b.bet_amount1);
								}

								b.yourCard[1] = Integer.parseInt(br.readLine());
								b.yCard_label2.setIcon(b.ci.il[b.yourCard[1]]); // �� �̹��� ����
								
								b.myCard[1] = Integer.parseInt(br.readLine());
								b.mCard_label2.setIcon(b.ci.il[b.myCard[1]]); // �� �̹��� ����
								
								b.judgeResult();
							} /*else {
								JOptionPane.showMessageDialog(null, "������ �������� �ʾҽ��ϴ�.");
								return; // �Լ�������
							}*/
							
							
							/*else if (str1.equals("2") && b.receiveCnt == 1) {
								// ������ ��밡 ���� ���ô����� ���� ���� �ȴ�������
								b.letYouGo = true;
								//b.card1 = gs.yourCard[0];
								str1 = br.readLine(); // ������ ���� ���ñݾ� �Ҵ�
								b.bet_amount1 = Integer.parseInt(str1);
								b.otherCnt++;
								
								b.yourCard[0] = Integer.parseInt(br.readLine());
								b.myCard[0] = Integer.parseInt(br.readLine());
								

							} else if (str1.equals("3") && b.receiveCnt == 2) {
								// ������ ��밡 2�� ���ô����� ���� ���� �ȴ�������
								b.letYouGo = true;
								str1 = br.readLine(); // ������ ���� ���ñݾ� �Ҵ�
								b.bet_result = Integer.parseInt(str1);
								b.otherCnt++;
								//b.card1 = gs.yourCard[1];
								b.yourCard[1] = Integer.parseInt(br.readLine());
								b.myCard[1] = Integer.parseInt(br.readLine());
							}*/
							
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

				};
			}.start();
			String str2 = null;
			while (true) {
				if (b.receiveCnt <= 1) {
					str2 = b.jb.getText();
					bw.write(str2 + "\r\n");
					bw.flush();

				} /*else if (b.receiveCnt == 2) {
					//str2 = b.ta.getText();
				}
				*/
				
				/*else if (b.receiveCnt == 2 ) {
					bw.write(b.receiveCnt + "\r\n"); // ������� �����Ѱ��� �˸������� ��ư���� Ƚ�� ����
					bw.flush();
					bw.write(b.bet_amount1 + "\r\n"); // ������� ���� �ݾ��� �˸��� ����
					bw.flush();
					//bw.write(GameSource.myCard[0]);
					//bw.flush();
					//bw.write(GameSource.yourCard[0]);
					//bw.flush();
				} else if (b.receiveCnt == 3 ) {
					bw.write(b.receiveCnt + "\r\n"); // ������� �����Ѱ��� �˸������� ��ư���� Ƚ�� ����
					bw.flush();
					bw.write(b.bet_result + "\r\n"); // ������� 2�� ���� �������������
					bw.flush();
					//bw.write(GameSource.myCard[1]);
					//bw.flush();
					//bw.write(GameSource.yourCard[1]);
					//bw.flush();
				}*/

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
