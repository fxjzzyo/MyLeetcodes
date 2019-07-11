package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]] 输出: [[1,6],[8,10],[15,18]] 解释: 区间 [1,3] 和
 * [2,6] 重叠, 将它们合并为 [1,6]. 示例 2:
 * 
 * 输入: [[1,4],[4,5]] 输出: [[1,5]] 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 * @author Administrator
 *
 */
public class 合并区间56 {
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

	/**
	 * 法一
	 * O(n^2)
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null || intervals.size() == 0)
			return result;
		int size = intervals.size();
		// 标记是否已合并
		boolean[] isMerged = new boolean[size];
		// 标记整个循环是否有合并过，
		// 如果没有则说明结果已经不能再合并了，可以返回了
		boolean hasMerge = false;
		for (int i = 0; i < size - 1; i++) {
			if (isMerged[i])
				continue;
			Interval inteI = intervals.get(i);
			for (int j = i + 1; j < size; j++) {
				if (isMerged[j])
					continue;
				Interval inteJ = intervals.get(j);
				if (inteI.start <= inteJ.start && inteI.end >= inteJ.end) {
					// i包含j
					result.add(inteI);
					isMerged[i] = true;
					isMerged[j] = true;
					hasMerge = true;
					break;
				} else if (inteI.start >= inteJ.start && inteI.end <= inteJ.end) {
					// j包含i
					result.add(inteJ);
					isMerged[i] = true;
					isMerged[j] = true;
					hasMerge = true;
					break;
				} else if (inteI.end >= inteJ.start && inteI.end <= inteJ.end && inteI.start <= inteJ.start) {
					// i j相交，且i左 j右
					Interval inter = new Interval(inteI.start, inteJ.end);
					result.add(inter);
					isMerged[i] = true;
					isMerged[j] = true;
					hasMerge = true;
					break;
				} else if (inteJ.end >= inteI.start && inteJ.end <= inteI.end && inteJ.start <= inteI.start) {
					// i j相交，且i右 j左
					Interval inter = new Interval(inteJ.start, inteI.end);
					result.add(inter);
					isMerged[i] = true;
					isMerged[j] = true;
					hasMerge = true;
					break;
				}

			}
			// 没有找到能合并的
			if (!isMerged[i]) {
				result.add(inteI);
				isMerged[i] = true;
			}

		}
		// 处理最后一个
		if (!isMerged[size - 1])
			result.add(intervals.get(size - 1));
		if (!hasMerge)
			return result;
		else
			return merge(result);
	}

	/**
	 * 法二
	 * O(nlogn)
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge2(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		if (intervals == null || intervals.size() == 0)
			return result;
		int size = intervals.size();
	
		//对Interval按start排序
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start-o2.start;
			}
		});
		result.add(intervals.get(0));
		for(int i = 1;i<size;i++){
			Interval a = intervals.get(i);
			Interval b = result.get(result.size()-1);
			if(a.start<=b.end){
				b.end = a.end>b.end?a.end:b.end;
			}else{
				result.add(a);
			}
		}
		return result;
		
		
	}
	
	public static void printInterval(List<Interval> intervals){
		for(Interval inte: intervals ){
			System.out.println(inte.toString());
		}
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		List<Interval> merge = merge2(intervals);
		System.out.println(merge);

		List<Interval> intervals2 = new ArrayList<Interval>();
		intervals2.add(new Interval(1, 4));
		intervals2.add(new Interval(0, 2));
		intervals2.add(new Interval(3, 5));
		List<Interval> merge2 = merge2(intervals2);
		System.out.println(merge2);

	}

}
