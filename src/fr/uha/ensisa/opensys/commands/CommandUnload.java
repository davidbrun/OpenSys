package fr.uha.ensisa.opensys.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class CommandUnload implements ICommand {
	
	@Override
	public String getName() {
		return "Unload";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return System.class;
	}
	
	@Override
	public void execute(Processor processor) {
		// TODO Auto-generated method stub
		
	}
}