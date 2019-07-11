package leetcode;


/**
 * ����һ��������ɫ����ɫ����ɫ��һ�� n ��Ԫ�ص����飬ԭ�ض����ǽ�������ʹ����ͬ��ɫ��Ԫ�����ڣ������պ�ɫ����ɫ����ɫ˳�����С�

�����У�����ʹ������ 0�� 1 �� 2 �ֱ��ʾ��ɫ����ɫ����ɫ��

ע��:
����ʹ�ô�����е����������������⡣

ʾ��:

����: [2,0,2,1,1,0]
���: [0,0,1,1,2,2]
���ף�

һ��ֱ�۵Ľ��������ʹ�ü������������ɨ���㷨��
���ȣ����������0��1 �� 2 Ԫ�صĸ�����Ȼ����0��1��2��������д��ǰ���顣
�������һ����ʹ�ó����ռ��һ��ɨ���㷨��
 * @author Administrator
 *
 */
public class ��ɫ����75 {

	public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
	/**
	 * ��һ��һ�α���
	 * @param nums
	 */
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int i = 0;//ʼ��ָ��ֵΪ0��λ��
        int j = len-1;//ʼ��ָ��ֵΪ2��λ��
        for(int k = 0;k<len;k++){
            if(k>j) break;//j����ȫ��2���������������j���Ͳ����ٱ���
            if(nums[k]==0 && k!=i){
                swap(nums,k,i);//��ֵΪ0����������i��λ��
                k--;//����������ֵ����Ҫ�Ƚϣ����Ա��ֵ�ǰ����λ��k����
                i++;//ֵΪ0��ָ�������ƶ�һ��
                
            }else if(nums[k]==2 && k!=j){
                swap(nums,k,j);//��ֵΪ2����������j��λ��
                k--;//����������ֵ����Ҫ�Ƚϣ����Ա��ֵ�ǰ����λ��k����
                j--;//ֵΪ2��ָ�������ƶ�һ��
            }
            
        }
    }
	
    /**
     * ���������α���
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        //ͳ��0 1 2 �Ĵ���
        int[] recs = new int[3];
        for(int i = 0;i<len;i++){
        	recs[nums[i]]++;
        }
        
        //Ϊ���鰴˳��ֵ
        int k = 0;
        for(int i = 0;i<recs.length;i++){
        	int counts = recs[i];
        	counts+=k;
        	while(k<counts){
        		nums[k++] = i;
        	}
        }
        
    }
	
    
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,1,0};
		sortColors2(nums);
		for(int n:nums){
			System.out.println(n);
		}

	}

}
