/*
 * Get java, Problem 6-2-2
 * To determine whether prime number, print out prime number from 1 to 100
 */
public class P6_2_2 {

	public static void main(String[] args) {
		int num = 1;
		int cnt = 0;
	
		while(num < 101){
			cnt = 0;
			for(int div = 1;div <= num;div++){
				if(num % div == 0) cnt++; // ������ �������� ī��Ʈ ����
				if (cnt > 2) break;
			}
			if(flag(cnt)) System.out.println(num); // �Ҽ��̸� ���
			num++;
		}
	}
	
	public static boolean flag(int cnt){
		if (cnt < 3) return true;
		return false;
	}
	
}
