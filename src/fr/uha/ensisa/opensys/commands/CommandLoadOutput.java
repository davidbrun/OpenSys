package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoadOutput implements ICommand {

	@Override
	public void execute(Processor processor) {
		OpenSys sys = processor.getOpenSys();
		processor.getOutput().printLine("Nom de l'output ?");
		String name = processor.getInput().getLine();
		fr.uha.ensisa.opensys.core.Output s = sys.newOutput(name);
		if(s == null)
			processor.getOutput().printLine("Raté !");
		else
			sys.setOutput(s);
	}

	@Override
	public String getName() {
		return "LoadOutput";
	}

}
