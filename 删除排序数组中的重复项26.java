package leetcode;

/**
 * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�

��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�

ʾ�� 1:

�������� nums = [1,1,2], 

����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2�� 

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
ʾ�� 2:

���� nums = [0,0,1,1,1,2,2,3,3,4],

����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��

�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
˵��:

Ϊʲô������ֵ��������������Ĵ���������?

��ע�⣬�����������ԡ����á���ʽ���ݵģ�����ζ���ں������޸�����������ڵ������ǿɼ��ġ�

����������ڲ���������:

// nums ���ԡ����á���ʽ���ݵġ�Ҳ����˵������ʵ�����κο���
int len = removeDuplicates(nums);

// �ں������޸�����������ڵ������ǿɼ��ġ�
// ������ĺ������صĳ���, �����ӡ�������иó��ȷ�Χ�ڵ�����Ԫ�ء�
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 * @author Administrator
 *
 */
public class ɾ�����������е��ظ���26 {

	 public static int removeDuplicates(int[] nums) {
	        if(nums == null || nums.length ==0) return 0;
	        int res = 0;
	        int len = nums.length;
	        for(int i = 0,j=0;i<len;){
	            res++;
	            nums[j++] = nums[i];
	            while(++i<len&&nums[i] == nums[i-1]);
	        }
	        return res;
	        
	    }
	
	public static void main(String[] args) {
		int[] nums={0,0,1,1,1,2,2,3,3,4};
		
		int res = removeDuplicates(nums);

		for(int i = 0;i<res;i++){
			System.out.println(nums[i]+" ");
		}
	}

}
