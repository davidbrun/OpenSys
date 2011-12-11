package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.IProcessor;

public interface ICommand {
	public void execute(IProcessor processor);
}