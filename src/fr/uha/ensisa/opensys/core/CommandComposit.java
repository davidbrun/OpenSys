package fr.uha.ensisa.opensys.core;

import java.util.ArrayList;
import java.util.List;

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
	
	public void removeCommand(String command) {
		for (int i = listCommands.size() - 1; i >= 0; i--)
			if (listCommands.get(i).getName().toLowerCase().equals(command.toLowerCase()))
			{
				listCommands.remove(listCommands.get(i));
				break;
			}
	}
	
	public void removeAllCommands() {
		this.listCommands.clear();
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