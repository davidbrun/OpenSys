package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandLoad implements ICommand {
	@Override
	public String getName() {
		return "Load";
	}
	
	@Override
	public void execute(Processor processor) {
//		processor.addCommand();
	}
}