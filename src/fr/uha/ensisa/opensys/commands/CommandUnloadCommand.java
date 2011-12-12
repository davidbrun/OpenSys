package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class CommandUnloadCommand implements ICommand {
	
	@Override
	public String getName() {
		return "UnloadCommand";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@Override
	public void execute(Processor processor) {
		processor.getOutput().printLine("Entrez le nom de la commande a decharger : ");
		String command = processor.getInput().getLine();
		if (processor.removeCommand(command))
			processor.getOutput().printLine("Commande OK");
		else
			processor.getOutput().printLine("Commande non dechargee");
	}
}