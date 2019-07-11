package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * �� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����

�� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��

��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����

 

ʾ�� 1��

���룺"/home/"
�����"/home"
���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
ʾ�� 2��

���룺"/../"
�����"/"
���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
ʾ�� 3��

���룺"/home//foo/"
�����"/home/foo"
���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
ʾ�� 4��

���룺"/a/./b/../../c/"
�����"/c"
ʾ�� 5��

���룺"/a/../../b/../c//.//"
�����"/c"
ʾ�� 6��

���룺"/a//b////c/d//././/.."
�����"/a/b/c"
 * @author Administrator
 *
 */
public class ��·��71 {

	public static String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        int len = path.length();
        StringBuilder sb = new StringBuilder();
        //��ȥ��˫б��
        for(int i = 0;i<len;i++){
            char c = path.charAt(i);
            if(c == '/'){
                //�Ӻ����ҵ�һ������/��λ��
                while(i<len && path.charAt(i)=='/'){
                    i++;
                }
                i--;
            }
            sb.append(c);
        }
        String newStr = sb.toString();
        //�ٶ�ȥ����˫б�ܵ��ַ�������
        String[] ss = newStr.split("/");
        System.out.println("-----si len-----"+ss.length);
        Stack<String> s = new Stack<>();
        for(int i = 0;i<ss.length;i++){
            String si = ss[i];
            System.out.println("-----si-----"+si);
            if(si.equals(".")){
                continue;
            }else if(si.equals("..")){
                if(s.size() == 0){
                    s.push("/");
                }else if(s.size() == 1){
                    s.pop();
                    s.push("/");
                }else{
                    s.pop();
                }
            }else if(si.isEmpty()){
                
            }else{
            	if(s.isEmpty()||!s.peek().equals("/")){
            		s.push("/"+si);
            	}
            	else{//�Ѿ��С�/��
            		s.push(si);
            	}
                
            }
        }
        //������������Ϊ�գ�ֱ�ӷ��ء�/��
        if(s.isEmpty()) return "/";
        StringBuilder sru = new StringBuilder();
        List<String> resu = new ArrayList<>();
        while(!s.isEmpty()){
            String item = s.pop();
            System.out.println("-----item-----"+item);
            resu.add(0,item);
        }
        for(String srr:resu){
            sru.append(srr);
        }
        
        return sru.toString();
        
    }
	
	public static void main(String[] args) {
		String simplifyPath = simplifyPath("/..");
		System.out.println(simplifyPath);

	}

}
