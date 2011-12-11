package fr.uha.ensisa.opensys.commands;

import java.util.List;

import fr.uha.ensisa.opensys.classloader.CommandFactory;
import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoadJar implements ICommand {
	@Override
	public String getName() {
		return "LoadJar";
	}

	@Override
	public void execute(Processor processor) {
		String line = processor.getInput().getLine();
		List<ICommand> commands = CommandFactory.getCommandsFromJarFile(line);
		for (ICommand c : commands)
			processor.addCommand(c);
	}
}