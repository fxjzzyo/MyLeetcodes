package leetcode;

/**
 * ����һ������������������ Excel �������Ӧ�������ơ�

���磬

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
ʾ�� 1:

����: 1
���: "A"
ʾ�� 2:

����: 28
���: "AB"
ʾ�� 3:

����: 701
���: "ZY"

˼·�����ǿ���10����ת����26���Ƶ�����
 * @author Administrator
 *
 */
public class Excel�б�����168 {

	public static String convertToTitle(int n) {
        char[] words = {'A','B','C','D','E',
                       'F','G','H','I','J',
                       'K','L','M','N','O',
                       'P','Q','R','S','T',
                        'U','V','W','X','Y','Z',
                        };
        StringBuilder sb = new StringBuilder();
       
        while(n!=0){
            n--;//�����0������ʼ��������26��Ӧ'Z',�������words[25],����Ҫ��26--
            int index = n%26;
            sb.append(words[index]);
            n = n/26;
        }
        return sb.reverse().toString();
        
    }
	
	public static void main(String[] args) {
		String convertToTitle = convertToTitle(28);
		System.out.println(convertToTitle);

	}

}
