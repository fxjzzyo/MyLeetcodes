package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tst2 {

	public static String xiufuStr(String str){
		
		System.out.println("-------"+str);
		char[] cs = str.toCharArray();
		int len = cs.length;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0;i<len;i++){
			int index = i+1;
			char c = cs[i];
			//下一个不同
			if(index<len&&cs[index] != c){
				sb.append(c);
				continue;
			}
			//下一个相同
			else if(index<len&&cs[index] == c){
				//找到第一个不同的数
				while(index<len&& cs[index]==c){
					index++;
				}
				if(index==len){
					sb.append(c);
					sb.append(cs[index]);
					break;
				}
				char second = cs[index];
				//找到不同与second的第一个数
				while(index<len&& cs[index]==second){
					index++;
				}
				if(index==len){
					sb.append(c);
					sb.append(c);
					sb.append(second);
					break;
				}
				
				sb.append(c);
				sb.append(c);
				sb.append(second);
				
				i = index;continue;
			
			}else{
				sb.append(c);
			}
			
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> ss = new ArrayList<>();
        for(int i = 0;i<n;i++){
        	String str = in.nextLine();
        	ss.add(str);
        }
        in.close();
        for(int i = 0;i<n;i++){
        	System.out.println(xiufuStr(ss.get(i)));
        }
        
        
	}
	
	public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        int last = 1024 - n;
        int result = 0;
        int[] chus = {64,16,4,1};
        int i = 0;
        while(last!=0){
        	result+=last/chus[i];
        	last = last%chus[i];
        	i++;
        }
        System.out.println(result);
        

	}

	
	public static int minGift(int[] nums){
		
		int len = nums.length;
		int[] gifts = new int[len];
		gifts[0] = 1;
		int result = gifts[0];
		for(int i = 1;i<len;i++){
			
			if(nums[i]>nums[i-1]){
				gifts[i] = gifts[i-1]+1;
			}else if(nums[i]<nums[i-1]){
				gifts[i] = gifts[i-1]-1;
			}else{
				gifts[i] = gifts[i-1];
			}
			result+=gifts[i];
			
		}
		if(nums[len-1]>nums[0]){
			
		}else if(nums[len-1]<nums[0]){
			gifts[len-1] = gifts[0]-1;
		}	
		
		
		return result;
		
	}
	
	public static void main3(String[] args) {
		 Scanner in = new Scanner(System.in);
	        
	        int n = Integer.parseInt(in.nextLine());
	        int cases[][] = new int[n][];
	        for(int i = 0;i<n;i++){
	            int m = in.nextInt();
	            cases[i] = new int[m];
	            for(int j = 0;j<m;j++){
	                cases[i][j] = in.nextInt();
	            }
	        }
	        
	        
	        
	        
	        
	        for(int i = 0;i<n;i++){
	        	
	        	System.out.println(minGift(cases[i]));
//	            for(int j = 0;j<cases[i].length;j++){
//	            	
//	            	
//	                System.out.println(cases[i][j]);
//	                System.out.println(cases[i][j]);
//	            }
	        }
	        
	        in.close();
	        
	}
}
