package fr.uha.ensisa.opensys.core;

public class Element<T> {
	private String name = null;
	private Element<T> next;

	public Element() {
		next = null;
	}
	
	public Element(T next) {
		next = null;
	}
	
	public void addBack(Element<T> element) {
		if(next != null)
			next.addBack(element);
		next = element;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
