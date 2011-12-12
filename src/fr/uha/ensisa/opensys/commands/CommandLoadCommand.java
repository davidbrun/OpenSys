package fr.uha.ensisa.opensys.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;
import fr.uha.ensisa.opensys.util.PackageExplorer;

public class CommandLoadCommand implements ICommand {
	
	@Override
	public String getName() {
		return "LoadCommand";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Processor processor) {
		try {
			List<Class> classes = PackageExplorer.getClasses(OpenSys.PACKAGE_COMMANDS);
			
			Map<String, ICommand> localCommands = new HashMap<String, ICommand>();
			for (Class c : classes)
			{
				try {
					ICommand command = (ICommand)c.newInstance();
					localCommands.put(command.getName().toLowerCase(), command);
				}
				catch (Exception e)
				{ }
			}
			
			processor.getOutput().printLine("Entrez le nom de la commande interne a charger : ");
			String command = processor.getInput().getLine();
			processor.addCommand(localCommands.get(command));
			processor.getOutput().printLine("Commande OK");
			
		} catch (Exception e) {
			processor.getOutput().printLine("Commande non chargee");
		}
	}
}