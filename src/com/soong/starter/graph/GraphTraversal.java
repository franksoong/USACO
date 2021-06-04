package com.soong.starter.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/** DFS��BFS���ӶȾ�ΪO(n)�� */

public class GraphTraversal {
	ListGraph graph;
	boolean[] visited;// ��¼�����ʹ��Ķ���

	public GraphTraversal(ListGraph listGraph) {
		this.graph = listGraph;
		visited = new boolean[listGraph.graphs.size()];// visited����Ŀ�Ͷ������Ŀһ��
	}

	public void DFS() {// ����ÿһ�����㣬�������û�б����ʹ�������������DFSTraversal������
		for (int i = 0; i < graph.graphs.size(); i++) {
			if (!visited[i]) {
				DFSTraversal(i);
			}
		}
	}

	public void BFS() {// ����ÿһ�����㣬�������û�б����ʹ�������������BFSTraversal������
		for (int i = 0; i < graph.graphs.size(); i++) {
			if (!visited[i]) {
				BFSTraversal(i);
			}
		}
	}

	public void DFSTraversal(int v) {// DFS���Ĵ���
		if (visited[v])
			return;// ������������ʹ��ˣ�ֱ��return
		visited[v] = true;// ����˱��������󣬽��˶�������Ϊ���ѷ��ʡ�
		System.out.print(v + " -> ");// ��ӡ���ǰ�벿�֣������㣩
		Iterator<Integer> neighbors = graph.graphs.get(v).listIterator();
		// get()�����õ�����һ������v����ӱ��б���Ҫ����֮ǰдListGraph���ʱ��ʹ�õ���˫��ArrayList�ģ���
		// Ȼ��ʹ����java.util.ArrayList.listIterator()���������صõ����б��е��б����������
		while (neighbors.hasNext()) {// �Զ������ӱ��б��������������ֱ�������ꡣ
			int nextNode = neighbors.next();// ��ȡ������ڽӵ�
			if (!visited[nextNode]) {
				DFSTraversal(nextNode);// �ݹ飬��ÿ���ڽӵ���з��ʲ�������ʱ����һ��ArrayList��
			}
		}
	}

	// ��ʵ���У�������Ҫʹ��queue�����������Ҫ�����Ķ��㣨ÿ����ڽӵ㣩����Java������ͨ��Deque��ʵ��Queue
	public void BFSTraversal(int v) {// BFS���Ĵ���
		Deque<Integer> queue = new ArrayDeque<>();// ����һ��˫���������
		visited[v] = true;
		queue.offerFirst(v);// ���ö������˫�˶��е�ͷ��
		while (queue.size() != 0) {// ���ʸõ�������ڽӵ�
			Integer cur = queue.pollFirst();// ��ȡ���Ƴ��Ƚ�����е��ڽӵ㣬��һ����ӡ����
			System.out.print(cur + " -> ");
			Iterator<Integer> neighbors = graph.graphs.get(cur).listIterator();// ��ȡ���ڽӵ���ڽӵ�
			while (neighbors.hasNext()) {
				int nextNode = neighbors.next();
				if (!visited[nextNode]) {
					visited[nextNode] = true;
					queue.offerLast(nextNode);// ����ڽӵ���ڽӵ�û�б����ʹ����ǾͰ��ڽӵ���ڽӵ�������ĩβ
				}
			}
		}
	}

}