package Graphs;

public class Text {
	public static void main(String[] args) {
		int p = 15, q = 6;
		if(p < q) {
			int temp = p;
			p = q;
			q = temp;
		}
		while(q != 0) {
			int r = p % q;
			p = q;
			q = r;
		}
		System.out.println(p);
	}

}
