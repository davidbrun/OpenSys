package fr.uha.ensisa.opensys.core;

public class Element<T> {
	protected Element<T> next;
	
	public Element() {
		next = null;
	}
	
	public Element(Element<T> next) {
		this.next = next;
	}
	
	public void addBack(Element<T> element) {
		if(next != null)
			next.addBack(element);
		next = element;
	}

}
