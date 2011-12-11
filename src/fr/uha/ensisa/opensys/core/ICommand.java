package fr.uha.ensisa.opensys.core;

public interface ICommand {
	public String getName();
	public Class<? extends fr.uha.ensisa.opensys.core.System> getTarget();
	public void execute(Processor processor);
}