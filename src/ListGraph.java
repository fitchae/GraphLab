import java.util.ArrayList;

/**
 * @author karroje
 *
 */
public class ListGraph extends Graph {
	Object [] a = new Object[10];
	
	public ListGraph(int n) {
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
		ArrayList<Pair<Integer,Double>> z = (ArrayList<Pair<Integer,Double>>) a[i];
		for(int x = 0;x<z.size();x++){
			if(z.get(x).first.equals(j)){
				return z.get(x).second;
			}
		}
		return null;
	}



	/* (non-Javadoc)
	 * @see Graph#addEdge(int, int)
	 */
	@Override
	void setWeight(int i, int j, Double weight) {
		if(j>num_nodes || i>num_nodes){
			throw new IndexOutOfBoundsException();
		}
		Pair<Integer,Double> p1 = new Pair<Integer,Double>(j,weight);
		Pair<Integer,Double> p2 = new Pair<Integer,Double>(i,weight);
		if(a[i]==null){
			a[i] = new ArrayList<Pair<Integer,Double>>();
		}
		if(a[j]==null){
			a[j] = new ArrayList<Pair<Integer,Double>>();
		}
		
		
		((ArrayList<Pair<Integer,Double>>) a[i]).add(p1);
		((ArrayList<Pair<Integer,Double>>) a[j]).add(p2);
		
	}
		
	/* (non-javadoc)
	 * @see Graph#AdjacentNodes
	 */
	ArrayList<Pair<Integer,Double>> adjacentNodes(int i) {
		if(a[i]==null){
			throw new IndexOutOfBoundsException();
		}
		return (ArrayList<Pair<Integer, Double>>) a[i];
	}
	 
	/* (non-javadoc)
	 * @see Graph#degree
	 */
	int degree(int i) {
		if(a[i]==null ){
			throw new IndexOutOfBoundsException();
		}
		ArrayList<Pair<Integer,Double>> z = (ArrayList<Pair<Integer,Double>>) a[i];
		return z.size();
	}

}
