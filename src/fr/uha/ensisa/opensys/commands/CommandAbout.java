package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class CommandAbout implements ICommand {
	
	@Override
	public String getName() {
		return "About";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@Override
	public void execute(Processor processor) {
		processor.getOutput().printLine("Projet Systèmes ouverts\nDavid Brun - Michael Muré");
	}
}