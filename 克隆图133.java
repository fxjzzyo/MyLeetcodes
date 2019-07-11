package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * ����������ͨͼ��һ���ڵ�����ã����ظ�ͼ���������¡���� ͼ�е�ÿ���ڵ㶼��������ֵ val��Int�� �����ھӵ��б�list[Node]����
 * 
 * ʾ����
 * 
 * 
 * ���룺 {"$id":"1","neighbors":[ {"$id":"2","neighbors":[{"$ref":"1"},
 * {"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],
 * "val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * 
 * ���ͣ� �ڵ� 1 ��ֵ�� 1�����������ھӣ��ڵ� 2 �� 4 �� �ڵ� 2 ��ֵ�� 2�����������ھӣ��ڵ� 1 �� 3 �� �ڵ� 3 ��ֵ��
 * 3�����������ھӣ��ڵ� 2 �� 4 �� �ڵ� 4 ��ֵ�� 4�����������ھӣ��ڵ� 1 �� 3 ��
 * 
 * 
 * ��ʾ��
 * 
 * �ڵ������� 1 �� 100 ֮�䡣 ����ͼ��һ����ͼ������ζ��ͼ��û���ظ��ıߣ�Ҳû���Ի��� ����ͼ������ģ�����ڵ� p �ǽڵ� q ���ھӣ���ô�ڵ�
 * q Ҳ�����ǽڵ� p ���ھӡ� ���뽫�����ڵ�Ŀ�����Ϊ�Կ�¡ͼ�����÷��ء�
 * 
 * 
 * @author Administrator
 *
 */
public class ��¡ͼ133 {

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
		}

		public Node(int _val, List<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public static Node cloneGraph(Node node) {
		if (node == null)
			return node;

		Map<Node, Node> map = new HashMap<>();
		return dfs(node, map);

	}

	public static Node dfs(Node node, Map<Node, Node> map) {
		if (node == null)
			return node;
		Node cloneNode = new Node(node.val, new ArrayList<Node>());
		map.put(node, cloneNode);
		for (Node neigh : node.neighbors) {
			if (map.containsKey(neigh)) {
				Node n = map.get(neigh);
				cloneNode.neighbors.add(n);
			} else {
				Node n = dfs(neigh, map);
				cloneNode.neighbors.add(n);
			}
		}
		return cloneNode;
	}

	/**
	 * ����
	 * BFS
	 * @param node
	 * @return
	 */
	public static Node cloneGraph2(Node node) {
		if (node == null)
			return node;
		Node cloneNode = new Node(node.val,new ArrayList<Node>());
		Map<Node, Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		map.put(node, cloneNode);
		while(!q.isEmpty()){
			Node curNode = q.poll();
			for(Node neigh:curNode.neighbors){
				if(!map.containsKey(neigh)){
					map.put(neigh, new Node(neigh.val,new ArrayList<Node>()));
					q.offer(neigh);
				}
				map.get(curNode).neighbors.add(map.get(neigh));
			}
		}
		
		return cloneNode;

	}

	public static void main(String[] args) {

	}

}
