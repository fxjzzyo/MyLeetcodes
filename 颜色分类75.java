package leetcode;


/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @author Administrator
 *
 */
public class 颜色分类75 {

	public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
	/**
	 * 法一，一次遍历
	 * @param nums
	 */
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int i = 0;//始终指向值为0的位置
        int j = len-1;//始终指向值为2的位置
        for(int k = 0;k<len;k++){
            if(k>j) break;//j后面全是2，所以如果超过了j，就不用再比了
            if(nums[k]==0 && k!=i){
                swap(nums,k,i);//将值为0的数交换到i的位置
                k--;//交换回来的值还需要比较，所以保持当前遍历位置k不变
                i++;//值为0的指针向右移动一下
                
            }else if(nums[k]==2 && k!=j){
                swap(nums,k,j);//将值为2的数交换到j的位置
                k--;//交换回来的值还需要比较，所以保持当前遍历位置k不变
                j--;//值为2的指针向左移动一下
            }
            
        }
    }
	
    /**
     * 法二，两次遍历
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        //统计0 1 2 的次数
        int[] recs = new int[3];
        for(int i = 0;i<len;i++){
        	recs[nums[i]]++;
        }
        
        //为数组按顺序复值
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
