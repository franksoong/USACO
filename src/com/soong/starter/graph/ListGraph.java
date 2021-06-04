/**
 * 
 */
package com.soong.starter.graph;

import java.util.ArrayList;

public class ListGraph {
	ArrayList<ArrayList<Integer>> graphs;// 定义一个邻接表数组graphs
	// ArrayList（此处是顶点）<ArrayList<Integer>（此处是顶点连接的链表）>

	public ListGraph(int v) {// 有参构造方法 ，v是顶点的数量
		graphs = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			graphs.add(new ArrayList<>());// 给每个顶点连接一个链表，构成邻接表这一数据结构。
		}
	}

	public void addEdge(int start, int end) {// 添加一条从start到end的边
		graphs.get(start).add(end);//
	}

	public void removeEdge(int start, int end) {// 删除一条从start到end的边
		graphs.get(start).remove((Integer) end);
	}
}