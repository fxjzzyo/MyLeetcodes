package leetcode;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
示例 1:

输入: 1
输出: "A"
示例 2:

输入: 28
输出: "AB"
示例 3:

输入: 701
输出: "ZY"

思路：就是看成10进制转换成26进制的问题
 * @author Administrator
 *
 */
public class Excel列表名称168 {

	public static String convertToTitle(int n) {
        char[] words = {'A','B','C','D','E',
                       'F','G','H','I','J',
                       'K','L','M','N','O',
                       'P','Q','R','S','T',
                        'U','V','W','X','Y','Z',
                        };
        StringBuilder sb = new StringBuilder();
       
        while(n!=0){
            n--;//数组从0计数开始！！！！26对应'Z',数组里的words[25],所以要先26--
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
