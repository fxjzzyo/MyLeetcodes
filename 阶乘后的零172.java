package leetcode;

/**
 * ����һ������ n������ n! ���β�������������
 * 
 * ʾ�� 1:
 * 
 * ����: 3 ���: 0 ����: 3! = 6, β����û���㡣 ʾ�� 2:
 * 
 * ����: 5 ���: 1 ����: 5! = 120, β������ 1 ����. ˵��: ���㷨��ʱ�临�Ӷ�ӦΪ O(log n) ��
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class �׳˺����172 {

	
	public static int trailingZeroes(int n) {
		//ֻ��Ҫ��5�ĸ����ͺ���
		int result = 0;
        while(n>0){
            n /= 5;
            result+=n;
        }
		return result;
		
	}

	public static void main(String[] args) {
		int trailingZeroes = trailingZeroes(13);
		System.out.println(trailingZeroes);

	}

}
