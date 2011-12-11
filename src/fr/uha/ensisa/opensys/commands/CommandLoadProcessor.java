package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoadProcessor implements ICommand {

	@Override
	public void execute(Processor processor) {
		OpenSys sys = processor.getOpenSys();
		processor.getOutput().printLine("Nom du processor ?");
		String name = processor.getInput().getLine();
		fr.uha.ensisa.opensys.core.Processor s = sys.newProcessor(name);
		if(s == null)
			processor.getOutput().printLine("Raté !");
		else
			sys.setProcessor(s);
	}

	@Override
	public String getName() {
		return "LoadProcessor";
	}

}
