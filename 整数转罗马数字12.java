package leetcode;

public class 整数转罗马数字12 {
	public static String intToRoman(int num) {
		String result = "";
		/**
		 * 1000 M 900 CM 500 D 400 CD 100 C 90 XC 50 L 40 XL 10 X 9 IX 5 V 4 IV
		 * 1 I
		 */
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			if (num >= 1000) {
				// [1000,)
				int m = num / 1000;
				for (int i = 0; i < m; i++)
					sb.append("M");
				num = num % 1000;

			} else if (num >= 500) {
				// [900,1000)
				if (num >= 900) {
					sb.append("CM");
					num = num - 900;
				} else {// [500,900)
					sb.append("D");
					num = num - 500;
				}

			} else if (num >= 100) {
				// [400,500)
				if (num >= 400) {
					sb.append("CD");
					num = num - 400;
				} else {// [100,400)
					int c = num / 100;
					for (int i = 0; i < c; i++)
						sb.append("C");
					num = num % 100;
				}

			} else if (num >= 50) {
				// [90,100)
				if (num >= 90) {
					sb.append("XC");
					num = num - 90;
				} else {
					// [50,90)
					sb.append("L");
					num = num - 50;
				}

			} else if (num >= 10) {
				// [40,50)
				if (num >= 40) {
					sb.append("XL");
					num = num - 40;
				} else {
					// [10,40)
					int x = num / 10;
					for (int i = 0; i < x; i++)
						sb.append("X");
					num = num % 10;
				}

			} else {
				// [9,10)
				if (num >= 9) {
					sb.append("IX");
					num = num - 9;
				} else if (num >= 5) {
					// [5,9)
					sb.append("V");
					num = num - 5;
				} else if (num >= 4) {
					// [4,5)
					sb.append("IV");
					num = num - 4;
				} else {
					// [0,4)
					for (int i = 0; i < num; i++) {
						sb.append("I");
					}
					num = 0;
				}
			}

		}

		return sb.toString();

	}

	public static void main(String[] args) {
		String res  = intToRoman(1994);
		System.out.println(res);
	}

}
