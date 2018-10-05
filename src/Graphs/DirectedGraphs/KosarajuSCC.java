package Graphs.DirectedGraphs;

public class KosarajuSCC {
	private boolean[] marked; // �ѷ��ʹ��Ķ���
	private int[] id; // ǿ��ͨ�����ı�ʶ��
	private int count; // ǿ��ͨ����������
	
	public KosarajuSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reserve());// ʹ��ͼ�ķ���ͼ
		for(int s : order.reversePost()) { // ʹ�÷���ͼ�������
			if(! marked[s]) {
				dfs(G, s);
				count++; // ÿ����һ����������Ͷ�����ͬһ��ǿ��ͨ������
			}
		}
	}
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count; // ��¼ǿ��ͨ����
		for(int w : G.adj(v)) {
			if(! marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	public int id(int v) {
		return id[v];
	}
	public int count() { // �ж��ٸ�ǿ��ͨ����
		return count;
	}
}