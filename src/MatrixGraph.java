import java.util.ArrayList;


/**
 * @author karroje
 *
 */
public class MatrixGraph extends Graph {
	
	public Double[][] graph = new Double[num_nodes][num_nodes];
	
	public MatrixGraph(int n) {
		super(n);
	}

	/* (non-Javadoc)
	 * @see Graph#weight(int, int)
	 */
	@Override
	Double getWeight(int i, int j) {
		if(j>num_nodes || i>num_nodes){
			throw new IndexOutOfBoundsException();
		}
		return graph[i][j];
	}

	/* (non-Javadoc)
	 * @see Graph#setWeight(int, int, java.lang.Double)
	 */
	@Override
	void setWeight(int i, int j, Double weight) {
		if(j>num_nodes || i>num_nodes){
			throw new IndexOutOfBoundsException();
		}
		graph[i][j]= weight;
		graph[j][i]=weight;
	}

	/* (non-Javadoc)
	 * @see Graph#adjacentNodes(int)
	 */
	@Override
	ArrayList<Pair<Integer, Double>> adjacentNodes(int i) {
		if(i>num_nodes){
			throw new IndexOutOfBoundsException();
		}
		ArrayList<Pair<Integer, Double>> a = new ArrayList<Pair<Integer, Double>>();
		for(int j =0;j<graph.length;j++){
			if(graph[i][j]!=null){
				Pair<Integer,Double> b = new Pair<Integer,Double>(j,graph[i][j]);
				a.add(b);
			}
		}
		return a;
	}

	/* (non-Javadoc)
	 * @see Graph#degree(int)
	 */
	@Override
	int degree(int i) {
		if(i>num_nodes){
			throw new IndexOutOfBoundsException();
		}
		int p = 0;
		for(int j =0 ; j<graph.length;j++){
			if(graph[i][j]!=null){
				p++;
			}
		}
		return p;
	}

}
