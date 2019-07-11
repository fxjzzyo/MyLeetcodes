package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * �����������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���

ÿ��ת��ֻ�ܸı�һ����ĸ��
ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
˵��:

���������������ת�����У����� 0��
���е��ʾ�����ͬ�ĳ��ȡ�
���е���ֻ��Сд��ĸ��ɡ�
�ֵ��в������ظ��ĵ��ʡ�
����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
ʾ�� 1:

����:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

���: 5

����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     �������ĳ��� 5��
ʾ�� 2:

����:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

���: 0

����: endWord "cog" �����ֵ��У������޷�����ת����
 * @author Administrator
 *
 */
public class ���ʽ���127 {

	/**
     * 127. ���ʽ���
     * Word Ladder
     * BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        int count = 1;
        while (!queue.isEmpty()) {//̽������Ƿ�Ϊ�գ���Ϊ�յĻ�����ִ��������߼�
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                //����һ���ںУ���ǰ��word����������Щ�ṩ��words�е�word���ҳ���
                List<String> candidates = transform(words, word);
                for (String candidate : candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);//���ҵ���candidate���뵽queue��
                }
            }
        }
        return 0;
    }

    /**
     * ���ɵ�ǰword������candidates
     *
     * @param words �������ֵ�
     * @param word  ��Ҫ�Աȵ�word
     * @return
     */
    private static List<String> transform(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);//��¼�µ�ǰword�ĵ�һ����ĸ����hit�����h��һ������¼��temp��
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {//��hit�ĵ�һλh��a-z����ĸһ��һ���滻�����жԱȣ���������Լ������ʱʱ��continue��
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = new String(sb);
                if (words.remove(newWord)) {//���words ������newWord���Ƴ�������newWord���뵽��ѡ�ߵ�list��
                    candidates.add(newWord);
                }

            }
            sb.setCharAt(i, temp);//�統ǰ�Ѿ�������z����hit����h�õ�zit����zit������ʼ��״̬��temp��¼���ǳ�ʼ״̬�ǵ�ʱ��ĸ
        }
        return candidates;
    }
	
	public static void main(String[] args) {
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList  = Arrays.asList(words);
		String endWord = "cog";
		String beginWord = "hit";
		int ladderLength = ladderLength(beginWord,endWord,wordList);
		System.out.println(ladderLength);

	}

}
