/*
 * Get java, Problem 7-1-1
 * define Triangle Class to save base and height 
 */
class Triangle {
	
	double base; // ��������
	double height;
	
	public Triangle() // ������
	{
		base = 1;
		height = 1;
	}
	
	public void changeValue(double b, double h) { // �غ��� ���̸� �����ϴ� �޼ҵ�
		base = b;
		height = h;
	}
	
	public double triArea() { // �ﰢ�� ���� ����ϴ� �޼ҵ�
		return ( base * height ) / 2;
	}
}
public class P7_1_1 {

	public static void main(String[] args) {
		Triangle t = new Triangle(); // �ν��Ͻ� ����
		double result = 0;
		
		t.changeValue(5, 7); // �ﰢ���� �غ��� ���� �Ҵ�
		result = t.triArea(); // �ﰢ�� ���� �Ҵ�
		
		System.out.println(result);
	}

}
