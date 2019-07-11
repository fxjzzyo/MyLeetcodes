package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ������ candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�

candidates �е�ÿ��������ÿ�������ֻ��ʹ��һ�Ρ�

˵����

�������֣�����Ŀ������������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:

����: candidates = [10,1,2,7,6,1,5], target = 8,
����⼯Ϊ:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
ʾ�� 2:

����: candidates = [2,5,2,1,2], target = 5,
����⼯Ϊ:
[
  [1,2,2],
  [5]
]
 * @author Administrator
 *
 */
public class ����ۺ϶�40 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		// ����
		Arrays.sort(candidates);

		find(results, temp, candidates, target, 0);
		return results;
	}

	public static void find(List<List<Integer>> ress, List<Integer> temp, int[] cands, int target, int num) {
		if (target == 0) {
			ress.add(new ArrayList<>(temp));// ���
			return;
		}

		if (cands[0] > target)
			return;
		for (int i = num; i < cands.length && cands[i] <= target; i++) {
			temp.add(cands[i]);
			// �ݹ� ע��˴���i+1�������ⲻͬ
			find(ress, temp, cands, target - cands[i], i + 1);
			temp.remove(temp.size()-1);
			// �����ظ�
			while (i < cands.length - 1 && cands[i] == cands[i + 1])
				i++;

		}

	}

	/**
	 * �ڶ���д��
	 * @param ress
	 * @param temp
	 * @param cands
	 * @param target
	 * @param num
	 */
	 public void find2(List<List<Integer>> ress,List<Integer> temp,int[]  cands,int target,int num){
	        if(target == 0){
	            ress.add(temp);
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            //���
	            List<Integer> ls = new ArrayList<>(temp);
             int n = cands[i];
	            ls.add(n);
	            //�ݹ� ע��˴���i+1�������ⲻͬ
	            find(ress,ls,cands,target-n,i+1);
             //�����ظ�
             while(i<cands.length-1&&cands[i] == cands[i+1]) i++;
             
	        }
	        
	    }
	
	public static void main(String[] args) {
		int[] candidates = {10,1,2,7,6,1,5};
		int target = 8;
		List<List<Integer>> combinationSum = combinationSum2(candidates,target);
		
		System.out.println(combinationSum);

	}

}
