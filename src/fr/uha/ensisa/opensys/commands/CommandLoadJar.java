package fr.uha.ensisa.opensys.commands;

import java.util.List;

import fr.uha.ensisa.opensys.IO.JLineInput;
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
		processor.getOutput().printLine("Chemin du jar : ");
		String line = processor.getInput().getLine();
		List<ICommand> commands = CommandFactory.getCommandsFromJarFile(line);
		for (ICommand c : commands)
			processor.addCommand(c);
		
		if (processor.getInput().getClass().equals(JLineInput.class))
			((JLineInput)processor.getInput()).setCommands(processor.getCommands());
	}
}