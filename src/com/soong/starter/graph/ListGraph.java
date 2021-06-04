/**
 * 
 */
package com.soong.starter.graph;

import java.util.ArrayList;

public class ListGraph {
	ArrayList<ArrayList<Integer>> graphs;// ����һ���ڽӱ�����graphs
	// ArrayList���˴��Ƕ��㣩<ArrayList<Integer>���˴��Ƕ������ӵ�����>

	public ListGraph(int v) {// �вι��췽�� ��v�Ƕ��������
		graphs = new ArrayList<>(v);
		for (int i = 0; i < v; i++) {
			graphs.add(new ArrayList<>());// ��ÿ����������һ�����������ڽӱ���һ���ݽṹ��
		}
	}

	public void addEdge(int start, int end) {// ���һ����start��end�ı�
		graphs.get(start).add(end);//
	}

	public void removeEdge(int start, int end) {// ɾ��һ����start��end�ı�
		graphs.get(start).remove((Integer) end);
	}
}