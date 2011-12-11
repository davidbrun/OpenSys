package fr.uha.ensisa.opensys.core;

public interface ICommand {
	public String getName();
	public void execute(IProcessor processor);
}