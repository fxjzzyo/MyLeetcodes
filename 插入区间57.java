package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.合并区间56.Interval;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * @author Administrator
 *
 */
public class 插入区间57 {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "Interval [" + start + ", " + end + "]";
		}
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null && newInterval!=null){
            result.add(newInterval);
            return result;
        }
        
         if(intervals != null && newInterval==null){
            return intervals;
        }
        //插入
        int pos = 0;
        for(Interval inte:intervals)
        {
            if(inte.start>=newInterval.start){
                break;
            }
            pos++;
        }
        
        intervals.add(pos,newInterval);
        //区间合并
        
        result.add(intervals.get(0));
        for(int i = 1;i<intervals.size();i++){
            Interval inta = intervals.get(i);
            Interval intb = result.get(result.size()-1);
            if(inta.start<=intb.end){
                intb.end = inta.end>intb.end?inta.end:intb.end;
            }else{
                result.add(inta);
            }
        }
        return result;
        
    }
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(6, 9));
		
		Interval inte = new Interval(2, 5);
		
		List<Interval> resu = insert(intervals,inte);
		System.out.println(resu);

	}

}
