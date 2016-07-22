/*
 * Get java, Problem 7-1-2
 * Marbles
 */

class MarbleUser {
	int m_cnt;
	
	public MarbleUser(int m) { // ������
		m_cnt = m; // ó�� ������ ����
	}
	public void getMarbles(MarbleUser child, int m) { // ���� ���� ������ ��� �޼ҵ�
		m_cnt += m;
		child.lossMarbles(m);
	}
	public void lossMarbles(int m) { // ��뿡�� ������ �ִ� �޼ҵ�
		m_cnt -= m;
	}
	public void showMarbles() { // ���� ������ ������ �����ִ� �޼ҵ�
		System.out.println("���� ���� ������ ���� : " + m_cnt);
	}
}
public class P7_1_2 {

	public static void main(String[] args) {
		MarbleUser f_child = new MarbleUser(15); // ù��° ��� ���� 15��
		MarbleUser s_child = new MarbleUser(9); // �ι�° ��� ���� 9��
		
		f_child.getMarbles(s_child, 2); // ù ��° ��̰� �� ��° ����� ���� 2���� ȹ��
		System.out.print("ù ��° ����� ");
		f_child.showMarbles();
		System.out.print("�� ��° ����� ");
		s_child.showMarbles();
		
		s_child.getMarbles(f_child, 7);
		System.out.print("ù ��° ����� ");
		f_child.showMarbles();
		System.out.print("�� ��° ����� ");
		s_child.showMarbles();
	}

}
