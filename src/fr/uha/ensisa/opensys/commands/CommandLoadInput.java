package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoadInput implements ICommand {

	@Override
	public void execute(Processor processor) {
		OpenSys sys = processor.getOpenSys();
		processor.getOutput().printLine("Nom de l'Input ?");
		String name = processor.getInput().getLine();
		fr.uha.ensisa.opensys.core.Input s = sys.newInput(name);
		if(s == null)
			processor.getOutput().printLine("Input inconnu !");
		else
			sys.setInput(s);
	}

	@Override
	public String getName() {
		return "LoadInput";
	}

}
