package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。 图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * 
 * 示例：
 * 
 * 
 * 输入： {"$id":"1","neighbors":[ {"$id":"2","neighbors":[{"$ref":"1"},
 * {"$id":"3","neighbors":[{"$ref":"2"},
 * {"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],
 * "val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * 
 * 解释： 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。 节点 3 的值是
 * 3，它有两个邻居：节点 2 和 4 。 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * 
 * 
 * 提示：
 * 
 * 节点数介于 1 到 100 之间。 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点
 * q 也必须是节点 p 的邻居。 必须将给定节点的拷贝作为对克隆图的引用返回。
 * 
 * 
 * @author Administrator
 *
 */
public class 克隆图133 {

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
	 * 法二
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
