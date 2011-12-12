package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class CommandLoadProcessor implements ICommand {
	
	@Override
	public String getName() {
		return "LoadProcessor";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@Override
	public void execute(Processor processor) {
		OpenSys sys = processor.getOpenSys();
		processor.getOutput().printLine("Nom du processor ?");
		String name = processor.getInput().getLine().toLowerCase().trim();
		fr.uha.ensisa.opensys.core.Processor s = sys.newProcessor(name);
		if(s == null)
			processor.getOutput().printLine("Processeur non chargé !");
		else
		{
			sys.getProcessor().stop();
			processor.getOutput().printLine("Processeur OK");
			sys.setProcessor(s);
		}
	}
}