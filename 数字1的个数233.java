package leetcode;

/**
 * ����һ������ n����������С�ڵ��� n �ķǸ����������� 1 ���ֵĸ�����

ʾ��:

����: 13
���: 6 
����: ���� 1 ����������������: 1, 10, 11, 12, 13 ��
 * @author Administrator
 *
 */
public class ����1�ĸ���233 {
	
	
	public static int countDigitOne(int n) {
		int result = 0;
		int a = 1,b=1;
		while(n>0){
			result+= (n+8)/10 * a + (n%10 == 1?1:0) * b;
			b+=n%10*a;
			a*=10;
			n /= 10;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int countDigitOne = countDigitOne(13);
		System.out.println(countDigitOne);

	}

}
