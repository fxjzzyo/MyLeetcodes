package leetcode;

/**
 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
 * 
 * 1. 1 
 * 2. 11 
 * 3. 21 
 * 4. 1211 
 * 5. 111221 
 * 1 ������ "one 1" ("һ��һ") , �� 11�� 
 * 11 ������"two 1s" ("����һ"��, �� 21��
 * 21 ������ "one 2", "one 1" ��"һ����" , "һ��һ") , �� 1211��
 * 
 * ����һ�������� n��1 �� n �� 30��������������еĵ� n �
 * 
 * ע�⣺����˳�򽫱�ʾΪһ���ַ�����
 * 
 * 
 * 
 * ʾ�� 1:
 * 
 * ����: 1 ���: "1" ʾ�� 2:
 * 
 * ����: 4 ���: "1211"
 * 
 * 
 * ˼·��
 * ����n��ȡ����n-1�Ľ��
 * �磬2��ȡ����1�Ľ����1������һ��һ��11
 * ���磬3��ȡ����2�Ľ����11����������һ��21
 * 
 * @author Administrator
 *
 */
public class ����38 {

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		String s = "1";// ��һ�ζ�1
		// ��2��ʼ��
		for (int i = 2; i <= n; i++) {
			// ��¼���ζ�ȡ�Ľ��
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				// ͳ���ظ��ֵĴ���
				int times = 1;
				while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
					times++;
					j++;
				}
				// ��¼�м�����������
				sb.append(times);
				// ��������
				sb.append(s.charAt(j));

			}
			// ���ν����Ϊ���´α�����ȡ��
			s = sb.toString();
		}
		return s;
	}

	public static void main(String[] args) {
		String s = countAndSay(5);
		System.out.println(s);
	}

}
