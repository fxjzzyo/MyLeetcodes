package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
 * @author Administrator
 *
 */
public class 单词接龙127 {

	/**
     * 127. 单词接龙
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
        while (!queue.isEmpty()) {//探测队列是否为空，不为空的话继续执行下面的逻辑
            int size = queue.size();
            count++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                //当做一个黑盒，当前的word可以生成哪些提供的words中的word，找出来
                List<String> candidates = transform(words, word);
                for (String candidate : candidates) {
                    if (endWord.equals(candidate)) {
                        return count;
                    }
                    queue.offer(candidate);//将找到的candidate加入到queue中
                }
            }
        }
        return 0;
    }

    /**
     * 生成当前word后续的candidates
     *
     * @param words 所给的字典
     * @param word  需要对比的word
     * @return
     */
    private static List<String> transform(Set<String> words, String word) {
        List<String> candidates = new ArrayList<>();
        StringBuffer sb = new StringBuffer(word);
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);//记录下当前word的第一个字母，如hit这个的h第一个，记录到temp中
            for (char c = 'a'; c <= 'z'; c++) {
                if (temp == c) {//当hit的第一位h被a-z的字母一个一个替换掉进行对比，当其等于自己本身的时时候，continue掉
                    continue;
                }
                sb.setCharAt(i, c);
                String newWord = new String(sb);
                if (words.remove(newWord)) {//如果words 中有新newWord，移除掉并将newWord加入到候选者的list中
                    candidates.add(newWord);
                }

            }
            sb.setCharAt(i, temp);//如当前已经遍历到z后，如hit换掉h得到zit，将zit换到初始的状态，temp记录的是初始状态是的时字母
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
