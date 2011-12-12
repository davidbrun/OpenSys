package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class CommandPrintOutput implements ICommand {
	
	private String text = null;
	
	@Override
	public String getName() {
		return "PrintOut";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@Override
	public void execute(Processor processor) {
		if (text == null)
		{
			processor.getOutput().printLine("Texte à afficher : ");
			text = processor.getInput().getLine();
		}
		
		processor.getOutput().printLine(text);
	}
}