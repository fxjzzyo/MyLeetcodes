package leetcode;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * ����������һ�־�������������ǰ����Ϊ : 
 * 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 
 * 742900, 2674440, 9694845, 35357670, 129644790, 477638700, 1767263190, 
 * 6564120420, 24466267020, 91482563640, 343059613650, 1289904147324, 
 * 4861946401452, ...
 * 
 *  ���ƹ�ʽ�� h(n) = h(n-1)*(4*n-2)/(n+1)
 * @author Administrator
 *
 */
public class �������� {
	
	public static void main(String[] args){ 
		int n = 10;//ǰ10��
		
		BigInteger x,y;
		BigInteger []a=new BigInteger[n+1];
		//ǰ����
		a[0]=BigInteger.valueOf(1);
		a[1]=BigInteger.valueOf(1);
		int i;
		for(i=2;i<n+1;i++) {
			x=a[i-1];
			x=x.multiply(BigInteger.valueOf(4*i-2));
			y=x.divide(BigInteger.valueOf(i+1));
			a[i]=y;
		}
		//���
		for(int k = 0;k<a.length;k++){
			System.out.println(a[k]);
		}

	}
}


