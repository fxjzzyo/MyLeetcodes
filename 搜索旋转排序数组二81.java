package leetcode;

/**
 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��
 * 
 * ( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��
 * 
 * ��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��
 * 
 * ʾ�� 1:
 * 
 * ����: nums = [2,5,6,0,0,1,2], target = 0 ���: true ʾ�� 2:
 * 
 * ����: nums = [2,5,6,0,0,1,2], target = 3 ���: false ����:
 * 
 * ���� ������ת�������� ��������Ŀ�������е� nums ���ܰ����ظ�Ԫ�ء� ���Ӱ�쵽�����ʱ�临�Ӷ��𣿻���������Ӱ�죬Ϊʲô��
 * 
 * @author Administrator
 *
 */
public class ������ת���������81 {

	public static boolean search(int[] nums, int target) {
		return searchHelp(nums, 0, nums.length - 1, target);
	}

	public static boolean searchHelp(int[] nums, int l, int h, int target) {
		if (l > h) {
			return false;
		}
		int mid = (l+h)/2;
        if(nums[mid] == target) return true;
        else if(nums[mid]<nums[l]){
            if(target>nums[mid]&&target<=nums[h]){
                return searchHelp(nums,mid+1,h,target);
            }else{
                return searchHelp(nums,l,mid-1,target);
            }
        }else if(nums[l]<nums[mid]){
            if(target<nums[mid]&&target>=nums[l]){
                return searchHelp(nums,l,mid-1,target);
            }else{
                return searchHelp(nums,mid+1,h,target);
            }
        }else{
            return searchHelp(nums,l+1,h,target);
        }
	}

	public static void main(String[] args) {
		int[] nums= {1,1,3,1};
		int target = 3;
		boolean res = search(nums, target);
		System.out.println(res);

	}

}
