package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]

思路：

使用hashmap统计次数就没什么可说了，easy的一匹

这里考虑不使用map呢

摩尔投票法。该算法用于1/2情况，它说：“在任何数组中，出现次数大于该数组长度一半的值只能有一个。”

那么，改进一下用于1/3。可以着么说：“在任何数组中，出现次数大于该数组长度1/3的值最多只有两个。”

于是，需要定义两个变量。空间复杂度为O(1)。

摩尔投票法：https://mabusyao.iteye.com/blog/2223195

算法1/3改进：https://blog.csdn.net/weixin_42768679/article/details/81567231

设置两个标签与计数器，当遍历到的数与两个标签的值都不相等时使两个计数器减1.

 * @author Administrator
 *
 */
public class 求众数二229 {

	public List<Integer> majorityElement(int[] nums) {
        List<Integer> resu = new ArrayList<>();
        if(nums == null || nums.length == 0) return resu;
        
        //摩尔投票法，超过n/3的一定不会超过两个数
        int x = 0,y = 0;//两个数字
        int tx = 0,ty = 0;//对应两个标记次数
        //统计次数和数字
        for(int n:nums){
            if((tx == 0 || n == x) && n!=y){
                tx++;
                x = n;
            }else if(ty == 0 || n == y){
                ty++;
                y = n;
            }else{
                tx--;
                ty--;
            }
        }
        
        //找出这两个数
        
        //找出x
        int count = 0;
        for(int n:nums){
            if(n == x) count++;
        }
        if(count>nums.length/3) resu.add(x);
        
        //找出y
        count = 0;
        for(int n:nums){
            if(n == y) count++;
        }
        //因为一开始给y赋值为0所以这里要确定x y不相同
        if(count>nums.length/3 && y!=x) resu.add(y);
        
        return resu;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
