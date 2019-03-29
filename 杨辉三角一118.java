package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Ñî»ÔÈı½ÇÒ»118 {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lss = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
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
        return lss;
    }
	public static void main(String[] args) {
		List<List<Integer>> lss = generate(5);
		System.out.println(lss);
	}

}
