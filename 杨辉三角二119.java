package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ñî»ÔÈý½Ç¶þ119 {
	public static List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<List<Integer>> lss = new ArrayList<>();
        for(int i = 0;i<rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j == 0|| j == i){
                    row.add(1);
                }else{
                    row.add(lss.get(i-1).get(j-1)+lss.get(i-1).get(j));
                }
            }
            lss.add(row);
        }
        return lss.get(rowIndex-1);
    }
	public static void main(String[] args) {
		List<Integer> lss = getRow(3);
		System.out.println(lss);
	}

}
