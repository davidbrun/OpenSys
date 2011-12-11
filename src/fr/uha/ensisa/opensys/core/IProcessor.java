package fr.uha.ensisa.opensys.core;

public interface IProcessor {
	public fr.uha.ensisa.opensys.core.System getSystem();
	public Input getInput();
	public Output getOutput();
	
	public void run();
}