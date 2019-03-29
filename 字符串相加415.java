package leetcode;

/**
 * ���������ַ�����ʽ�ķǸ����� num1 ��num2 ���������ǵĺ͡�
 * 
 * ע�⣺
 * 
 * num1 ��num2 �ĳ��ȶ�С�� 5100. num1 ��num2 ��ֻ�������� 0-9. num1 ��num2 ���������κ�ǰ���㡣
 * �㲻��ʹ���κ΃Ƚ� BigInteger �⣬ Ҳ����ֱ�ӽ�������ַ���ת��Ϊ������ʽ��
 * 153
 * 878
 * 
 * 1031
 * @author Administrator
 *
 */
public class �ַ������415 {
	public static String addStrings(String num1, String num2) {
		if(num1 == null || num1.length()<1) return num2;
		if(num2 == null || num2.length()<1) return num1;
		StringBuilder sb = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();
		int i = len1-1;
		int j = len2 - 1;
		int jin = 0;//��ʶ��λ
		while(i>=0&&j>=0){
			int n1 = num1.charAt(i)-'0';
			int n2 = num2.charAt(j)-'0';
			int sum = n1+n2+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			i--;
			j--;
		}
		while(i>=0){
			int n1 = num1.charAt(i)-'0';
			int sum = n1+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			i--;
		}
		while(j>=0){
			int n2 = num2.charAt(j)-'0';
			int sum = n2+jin;
			sb.append(sum%10);
			if(sum>9){
				jin = 1;
			}else{
				jin = 0;
			}
			j--;
		}
		if(jin!=0) sb.append(1);
		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		String res = addStrings("123","9988");
		System.out.println(res);
	}

}
