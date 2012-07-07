package edu.indiana.d2i.netkarma.xsp.adapter;

public class Triplets<E1, E2, E3> extends Pair<E1, E2>{
	private E3 e3;
	
	public Triplets(){
		super();
	}
	
	public Triplets(E1 e1){
		super(e1);
		this.e3 = null;
	}
	
	public Triplets(E1 e1, E2 e2){
		super(e1,e2);
		this.e3 = null;
	}
	
	public Triplets(E1 e1, E2 e2, E3 e3){
		super(e1,e2);
		this.e3 = e3;
	}
	
	public void add(E1 e1, E2 e2, E3 e3){
		super.add(e1,e2);
		this.e3 = e3;
	}	

	public void setElementThree(E3 e3) {
		this.e3 = e3;
	}
	
	public E3 getElementThree(){
		return e3;
	}
}
