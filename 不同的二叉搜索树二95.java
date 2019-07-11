package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ n������������ 1 ... n Ϊ�ڵ�����ɵĶ�����������

ʾ��:

����: 3
���:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
����:
���ϵ������Ӧ���� 5 �ֲ�ͬ�ṹ�Ķ�����������

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   ˼·��
   ���ݷ�
 * @author Administrator
 *
 */
public class ��ͬ�Ķ�����������95 {

	  public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
		
	      
	  }
	 
	
	 public static List<TreeNode> generateTrees(int n) {
	        if(n == 0) return new ArrayList<>();
	        return generateTree(1,n);
	    }
	    
	    public static List<TreeNode> generateTree(int start,int end){
	        List<TreeNode> resu = new ArrayList<>();
	        if(start>end){
	            resu.add(null);
	            return resu;
	        }
	        for(int i = start;i<=end;i++){
	            List<TreeNode> leftsub = generateTree(start,i-1);
	            List<TreeNode> rightsub = generateTree(i+1,end);
	            for(TreeNode l:leftsub){
	                for(TreeNode r:rightsub){
	                    TreeNode node = new TreeNode(i);
	                    node.left = l;
	                    node.right = r;
	                    resu.add(node);
	                }
	            }
	        }
	        return resu;
	        
	    }
	
	public static void main(String[] args) {
		int n = 5;
		List<TreeNode> generateTrees = generateTrees(n);
		
		

	}

}
