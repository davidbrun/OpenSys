package fr.uha.ensisa.opensys.core;

public abstract class Processor extends Element<Processor> {
	
	public abstract fr.uha.ensisa.opensys.core.System getSystem();
	public abstract Input getInput();
	public abstract Output getOutput();
	
	public abstract void run();
}