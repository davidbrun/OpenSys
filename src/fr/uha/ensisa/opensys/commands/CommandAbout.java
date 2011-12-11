package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandAbout implements ICommand {

	@Override
	public void execute(Processor processor) {
		processor.getOutput().printLine("Projet Systèmes ouverts\nDavid Brun - Michael Muré");
	}

	@Override
	public String getName() {
		return "About";
	}

}
