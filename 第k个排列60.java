package leetcode;

/**
 * �������� [1,2,3,��,n]��������Ԫ�ع��� n! �����С�

����С˳���г����������������һһ��ǣ��� n = 3 ʱ, �����������£�

"123"
"132"
"213"
"231"
"312"
"321"
���� n �� k�����ص� k �����С�

˵����

���� n �ķ�Χ�� [1, 9]��
���� k �ķ�Χ��[1,  n!]��
ʾ�� 1:

����: n = 3, k = 3
���: "213"
ʾ�� 2:

����: n = 4, k = 9
���: "2314"

˼·������չ�� https://blog.csdn.net/lttree/article/details/24798653

 * @author Administrator
 *
 */
public class ��k������60 {

	public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] fac = {1,1,2,6,24,120,720,5040,40320};
        int i,j,t;
        boolean[] mark = new boolean[10];
        k--;
        for(i = 0;i<n;i++){
            t = k/fac[n-1-i];
            for(j = 1;j<=n;j++){
                if(!mark[j]){
                    if(t == 0) break;
                    t--;
                }
            }
            sb.append(""+j);
            mark[j] = true;
            k%=fac[n-i-1];
        }
        
        return sb.toString();
    }
    
	
	public static void main(String[] args) {
		String permutation = getPermutation(3,3);
		System.out.println(permutation);
		
		

	}

}
