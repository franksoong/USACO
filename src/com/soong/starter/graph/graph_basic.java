/**
 * 
 */
package com.soong.starter.graph;

/**
 * @author Administrator
 *
 */
public class graph_basic {

	public static void main(String[] args) {
		// System.out.println(graph.length);
		dfs(0, graph);
	}

	//	@formatter:off    									
	static int[][] graph = new int[][]{
		//A, B, C, D, E, F
		{0, 1, 1},
		{1, 0, 1},
		{1, 1, 0}
		
		//A, B, C, D, E, F
//		{0, 0, 1, 1, 0, 0},
//		{0, 0, 1, 0, 0, 0},
//		{1, 1, 0, 0, 0, 0},
//		{0, 0, 1, 0, 1, 0},
//		{0, 0, 0, 1, 0, 1},
//		{0, 0, 0, 0, 1, 0}
	};
	//	@formatter:on

	static int[] visited = new int[graph.length];// ������¼�Ѿ���������Ԫ��

	// DFS(������ȱ���)ͬ������������ͼ A->C->B->D->E->F �� 0->2->1->3->4->5
	public static void dfs(int node, int[][] graph) {
		visited[node] = 1;
		System.out.println(node);
		for (int i = 0; i < graph[node].length; ++i) {
			if (visited[i] == 0 && i != node && graph[node][i] == 1) {
				dfs(i, graph);
			}
		}
	}

	// BFS(������ȱ���)ͬ������������ͼ A->C->D->B->E->F ��0->2->3->1->4->5
	public static void bfs(int[][] graph) {
		int[] queue = new int[graph.length];

		int count = 1;
		queue[0] = 0;// ��A��Ϊ��ʼ����������
		visited[0] = 1;

		System.out.println(0);
		for (int i = 0; i < count; ++i) {
			for (int j = 0; j < graph[queue[i]].length; ++j) {
				if (queue[i] != j && graph[queue[i]][j] == 1 && visited[j] == 0) {
					visited[queue[i]] = 1;
					queue[count++] = j;
					System.out.println(j);
				}
			}
		}
	}
}