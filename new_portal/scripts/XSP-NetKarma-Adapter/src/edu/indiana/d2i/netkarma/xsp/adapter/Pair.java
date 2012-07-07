package edu.indiana.d2i.netkarma.xsp.adapter;

public class Pair<E1,E2> {
	private E1 e1;
	private E2 e2;
	
	public Pair(){
		super();
	}
	
	public Pair(E1 e1){
		this.e1 = e1;
		this.e2 = null;
	}
	
	public Pair(E1 e1, E2 e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public void add(E1 e1, E2 e2){
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public void setElementOne(E1 e1) {		
		this.e1 = e1;
	}

	public void setElementTwo(E2 e2) {
		this.e2 = e2;
	}
	
	public E1 getElementOne(){
		return e1;
	}
	
	public E2 getElementTwo(){
		return e2;
	}
	
}
