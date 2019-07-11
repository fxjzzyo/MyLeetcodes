package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ��

ʾ��:

����: "25525511135"
���: ["255.255.11.135", "255.255.111.35"]

˼·�����ݷ�

 * @author Administrator
 *
 */
public class ��ԭIP��ַ93 {

	static List<String> res = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
        
        if(s == null||s.length() == 0||s.length()>12) return res;
        List<String> resu = new ArrayList<>();
        huisu(resu,s,0);
        return res;
    }
    
    public static void huisu(List<String> resu,String s,int index){
        if(index == s.length() &&resu.size() == 4){
            handleListStr(resu);
            return;
        }
        //��֦
        if(resu.size() == 3){
            if(index<s.length()){
                String lastStr = s.substring(index,s.length());
                if(isValidIp(lastStr)){
                    resu.add(lastStr);
                    handleListStr(resu);
                    resu.remove(resu.size()-1);
                }
            }
        }
        //��֦
        if(resu.size() == 2){
            if(s.length() - index>6)
                return;
        }
        
        for(int i = index+1;i<index+4 && i<s.length();i++){
            String preStr = s.substring(index,i);
            if(isValidIp(preStr)){
                resu.add(preStr);
                huisu(resu,s,i);
                resu.remove(resu.size()-1);
            }else{
                return;
            }
        }
        
    }
    
    /**
     * ������б���֯�ɴ𰸵���ʽ
     * ["255","255","11","255"]-->["255.255.11.255"]
     * @param pre
     */
    private static void handleListStr(List<String> pre) {
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0;i < pre.size(); i++) {
			stringBuffer.append(pre.get(i));
			if (i != pre.size() - 1) {
				stringBuffer.append(".");
			}
		}
		res.add(stringBuffer.toString());
	}
    
    /**
     * �ж��Ƿ��ǺϷ���IP�ֶ�
     * @param s
     * @return
     */
    private static boolean isValidIp(String s){
        if (s.length() == 0 || s.length() > 3) {
			return false;
		}
		if (s.length() != 1) {
			char c = s.charAt(0);
			if (c == '0') {
				return false;
			}
		}
		if (Integer.valueOf(s) > 255) {
			return false;
		}
		return true;
    }
	
	public static void main(String[] args) {
		String s = "25525511135";
		List<String> restoreIpAddresses = restoreIpAddresses(s);
		System.out.println(restoreIpAddresses);

	}

}
