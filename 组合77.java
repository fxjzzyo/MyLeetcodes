package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ������������ n �� k������ 1 ... n �����п��ܵ� k ��������ϡ�

ʾ��:

����: n = 4, k = 2
���:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

˼·�����ݷ�
 * @author Administrator
 *
 */
public class ���77 {

	 public static List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> results = new ArrayList<>();
	        if(k<1||n<1||n<k) return results;
	        List<Integer> temp = new ArrayList<>();
	        huisu(results,temp,n,k,1);
	        return results;
	        
	    }
	    
	    public static void huisu(List<List<Integer>> resu,List<Integer> temp,int n,int k,int start){
	        if(temp.size() == k){
	            resu.add(new ArrayList<Integer>(temp));
	            return;
	        }
	        
	       for(int i = start;i<=n;i++){
	           temp.add(i);
	           huisu(resu,temp,n,k,i+1);
	           temp.remove(temp.size()-1);
	       }
	    }
	
	public static void main(String[] args) {
		List<List<Integer>> combine = combine(4,2);
		System.out.println(combine);

	}

}
