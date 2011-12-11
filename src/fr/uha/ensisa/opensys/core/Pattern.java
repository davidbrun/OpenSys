package fr.uha.ensisa.opensys.core;

public abstract class Pattern {
	private Pattern next = null;

	public Pattern getNext() {
		return next;
	}

	public void setNext(Pattern next) {
		this.next = next;
	}
	
	public abstract void execute(ICommand cmd);

}
