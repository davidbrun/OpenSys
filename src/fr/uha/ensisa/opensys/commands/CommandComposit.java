package fr.uha.ensisa.opensys.commands;

import java.util.ArrayList;
import java.util.List;
import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public abstract class CommandComposit implements ICommand {
	
	private List<ICommand> listCommands;
	
	public CommandComposit() {
		this.listCommands = new ArrayList<ICommand>();
	}
	
	@Override
	public Class<? extends System> getTarget() {
		if (listCommands != null && listCommands.size() > 0)
			return listCommands.get(0).getTarget();
		else
			return null;
	}
	
	@Override
	public void execute(Processor processor) {
		for (ICommand c : listCommands)
			c.execute(processor);
	}
	
	public void addCommand(ICommand command) {
		this.listCommands.add(command);
	}
	
	public void removeCommand(ICommand command) {
		this.listCommands.remove(command);
	}
	
	public List<ICommand> getCommands() {
		return this.listCommands;
	}
	
	public List<String> getCommandNames() {
		List<String> result = new ArrayList<String>();
		for (ICommand c : listCommands)
			result.add(c.getName().toLowerCase());
		
		return result;
	}
}