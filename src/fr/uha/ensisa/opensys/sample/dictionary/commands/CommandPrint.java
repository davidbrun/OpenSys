package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandPrint implements ICommand {

	@Override
	public String getName() {
		return "Print";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return Dictionary.class;
	}
	
	@Override
	public void execute(Processor processor) {
		Dictionary dictionary = (Dictionary) processor.getSystem(getTarget().getSimpleName());
		if (dictionary != null)
			processor.getOutput().printLine(dictionary.toString());
		else
			processor.getOutput().printLine("Dictionary systeme null !");
	}
}