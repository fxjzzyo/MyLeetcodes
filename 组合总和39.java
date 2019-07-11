package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ظ�Ԫ�ص����� candidates ��һ��Ŀ���� target ���ҳ� candidates �����п���ʹ���ֺ�Ϊ target ����ϡ�

candidates �е����ֿ����������ظ���ѡȡ��

˵����

�������֣����� target��������������
�⼯���ܰ����ظ�����ϡ� 
ʾ�� 1:

����: candidates = [2,3,6,7], target = 7,
����⼯Ϊ:
[
  [7],
  [2,2,3]
]
ʾ�� 2:

����: candidates = [2,3,5], target = 8,
����⼯Ϊ:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 * @author Administrator
 *
 */
public class ����ܺ�39 {

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> results  = new ArrayList<>();
	        List<Integer> temp = new ArrayList<>();
	        //����
	        Arrays.sort(candidates);
	        find(results,temp,candidates,target,0);
	        return results;
	    }
	    
	    
	    public static void find(List<List<Integer>> ress,List<Integer> temp,int[] cands,int target,int num){
	        if(target == 0){
	            ress.add(new ArrayList<>(temp));//���
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            temp.add(cands[i]);
	            //�ݹ�
	            find(ress,temp,cands,target-cands[i],i);
	            temp.remove(temp.size()-1);//����
	        }
	        
	    }
	    
	    /**
	     * ���ݵĵڶ���д��
	     * @param ress
	     * @param temp
	     * @param cands
	     * @param target
	     * @param num
	     */
	    public void find2(List<List<Integer>> ress,List<Integer> temp,int[] cands,int target,int num){
	        if(target == 0){
	            ress.add(temp);
	            return;
	        }
	        
	        if(cands[0]>target) return;
	        for(int i=num;i<cands.length&&cands[i]<=target;i++){
	            //���
	            List<Integer> ls = new ArrayList<>(temp);
	            ls.add(cands[i]);
	            //�ݹ�
	            find(ress,ls,cands,target-cands[i],i);
	        }
	        
	    }
	
	public static void main(String[] args) {
		int[] candidates = {2,3,6,7};
		int target = 7;
		List<List<Integer>> combinationSum = combinationSum(candidates,target);
		
		System.out.println(combinationSum);
		
	}

}
