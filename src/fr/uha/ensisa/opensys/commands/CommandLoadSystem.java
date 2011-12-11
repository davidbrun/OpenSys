package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoadSystem implements ICommand {

	@Override
	public void execute(Processor processor) {
		OpenSys sys = processor.getOpenSys();
		processor.getOutput().printLine("Nom du System ?");
		String name = processor.getInput().getLine();
		fr.uha.ensisa.opensys.core.System s = sys.newSystem(name);
		if(s == null)
			processor.getOutput().printLine("System inconnu !");
		else
			processor.setSystem(s);
	}

	@Override
	public String getName() {
		return "LoadSystem";
	}

}
