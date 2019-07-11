package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ���S��ͨ�����ַ���S�е�ÿ����ĸת���Сд�����ǿ��Ի��һ���µ��ַ������������п��ܵõ����ַ������ϡ�

ʾ��:
����: S = "a1b2"
���: ["a1b2", "a1B2", "A1b2", "A1B2"]

����: S = "3z4"
���: ["3z4", "3Z4"]

����: S = "12345"
���: ["12345"]
ע�⣺

S �ĳ��Ȳ�����12��
S �������ֺ���ĸ��ɡ�
 * @author Administrator
 *
 */

public class ��ĸ��Сдȫ����784 {

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
