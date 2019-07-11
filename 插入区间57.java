package leetcode;

import java.util.ArrayList;
import java.util.List;

import leetcode.�ϲ�����56.Interval;

/**
 * ����һ�����ص��� ������������ʼ�˵�����������б�

���б��в���һ���µ����䣬����Ҫȷ���б��е�������Ȼ�����Ҳ��ص�������б�Ҫ�Ļ������Ժϲ����䣩��

ʾ�� 1:

����: intervals = [[1,3],[6,9]], newInterval = [2,5]
���: [[1,5],[6,9]]
ʾ�� 2:

����: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
���: [[1,2],[3,10],[12,16]]
����: ������Ϊ�µ����� [4,8] �� [3,5],[6,7],[8,10] �ص���
 * @author Administrator
 *
 */
public class ��������57 {

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
        //����
        int pos = 0;
        for(Interval inte:intervals)
        {
            if(inte.start>=newInterval.start){
                break;
            }
            pos++;
        }
        
        intervals.add(pos,newInterval);
        //����ϲ�
        
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
