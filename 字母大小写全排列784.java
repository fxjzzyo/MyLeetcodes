package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
注意：

S 的长度不超过12。
S 仅由数字和字母组成。
 * @author Administrator
 *
 */

public class 字母大小写全排列784 {

	public static List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		dfs(result,S.toCharArray(),0);
		return result;
	}

	private static void dfs(List<String> result, char[] charArray, int i) {
		int swap = 'a' - 'A';
		if(i==charArray.length){
			result.add(new String(charArray));
			return;
		}
		dfs(result,charArray,i+1);
		if(charArray[i]>='a' && charArray[i]<='z'){
			charArray[i]-=swap;
			dfs(result,charArray,i+1);
			charArray[i]+=swap;
		}else if(charArray[i]>='A' && charArray[i]<='Z'){
			charArray[i]+=swap;
			dfs(result,charArray,i+1);
			charArray[i]-=swap;
		}
	}

	public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> rsp = new ArrayList<>();
        if (nums == null) {
            return rsp;
        }
        rsp.add(new ArrayList<Integer>());
        for(int i: nums){
            int len=rsp.size();
            for(int j=0;j<len;j++){
                List<Integer> temp= new ArrayList<>(rsp.get(j));
                temp.add(i);
                rsp.add(temp);
            }
        }
        return rsp;
    }
	
	public static void main(String[] args) {
		String S = "a1b2";
		List<String> letterCasePermutation = letterCasePermutation(S);
		System.out.println(letterCasePermutation);
		
	}

}
