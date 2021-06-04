package com.soong.starter.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/** DFS和BFS复杂度均为O(n)。 */

public class GraphTraversal {
	ListGraph graph;
	boolean[] visited;// 记录被访问过的顶点

	public GraphTraversal(ListGraph listGraph) {
		this.graph = listGraph;
		visited = new boolean[listGraph.graphs.size()];// visited的数目和顶点的数目一致
	}

	public void DFS() {// 遍历每一个顶点，如果顶点没有被访问过，则让它进入DFSTraversal方法。
		for (int i = 0; i < graph.graphs.size(); i++) {
			if (!visited[i]) {
				DFSTraversal(i);
			}
		}
	}

	public void BFS() {// 遍历每一个顶点，如果顶点没有被访问过，则让它进入BFSTraversal方法。
		for (int i = 0; i < graph.graphs.size(); i++) {
			if (!visited[i]) {
				BFSTraversal(i);
			}
		}
	}

	public void DFSTraversal(int v) {// DFS核心代码
		if (visited[v])
			return;// 如果这个顶点访问过了，直接return
		visited[v] = true;// 进入此遍历方法后，将此顶点设置为“已访问”
		System.out.print(v + " -> ");// 打印结点前半部分（即顶点）
		Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
		// get()方法得到的是一个顶点v的领接表列表（不要忘记之前写ListGraph类的时候使用的是双层ArrayList的），
		// 然后使用了java.util.ArrayList.listIterator()方法（返回得到的列表中的列表迭代器）。
		while (neighbors.hasNext()) {// 对顶点的领接表列表逐个遍历操作，直至遍历完。
			int nextNode = neighbors.next();// 获取顶点的邻接点
			if (!visited[nextNode]) {
				DFSTraversal(nextNode);// 递归，对每个邻接点进行访问操作（此时仅有一层ArrayList）
			}
		}
	}

	// 在实现中，我们需要使用queue来储存接下来要遍历的顶点（每层的邻接点），在Java中我们通过Deque来实现Queue
	public void BFSTraversal(int v) {// BFS核心代码
		Deque<Integer> queue = new ArrayDeque<>();// 创建一个双端数组队列
		visited[v] = true;
		queue.offerFirst(v);// 将该顶点插入双端队列的头部
		while (queue.size() != 0) {// 访问该点的所有邻接点
			Integer cur = queue.pollFirst();// 获取并移除先进入队列的邻接点，下一步打印出来
			System.out.print(cur + " -> ");
			Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();// 获取该邻接点的邻接点
			while (neighbors.hasNext()) {
				int nextNode = neighbors.next();
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					queue.offerLast(nextNode);// 如果邻接点的邻接点没有被访问过，那就把邻接点的邻接点加入队列末尾
				}
			}
		}
	}

}