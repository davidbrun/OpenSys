package fr.uha.ensisa.opensys.processors;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import fr.uha.ensisa.opensys.commands.CommandLoad;
import fr.uha.ensisa.opensys.commands.CommandUnload;
import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Output;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;

public class DefaultProcessor extends Processor {
	private OpenSys openSys;
	private Map<String, ICommand> mapCommands;
	private fr.uha.ensisa.opensys.core.System system;
	
	public DefaultProcessor(OpenSys openSys) {
		this.openSys = openSys;
		this.mapCommands = new HashMap<String, ICommand>();
		this.initDefaultProcessor();
	}

	private void initDefaultProcessor() {
		ICommand commandLoad = new CommandLoad();
		this.mapCommands.put(commandLoad.getName().toLowerCase(), commandLoad);
		
		ICommand commandUnload = new CommandUnload();
		this.mapCommands.put(commandUnload.getName().toLowerCase(), commandUnload);
	}
	
	@Override
	public fr.uha.ensisa.opensys.core.System getSystem() {
		return this.system;
	}
	
	@Override
	public Input getInput() {
		return this.openSys.getInput();
	}
	
	@Override
	public Output getOutput() {
		return this.openSys.getOutput();
	}
	
	@Override
	public void run() {
		String EXIT_COMMAND = "quit";
		String line = "";
		while (!line.equals(EXIT_COMMAND))
		{
			line = getInput().getLine().toLowerCase();
			if (this.mapCommands.containsKey(line))
				this.mapCommands.get(line).execute(this);
			else
				if (!line.equals(EXIT_COMMAND))
					getOutput().printLine("Unknown command: " + line);
		}
		getOutput().printLine("Bye bye!");
	}

	@Override
	public void setSystem(System system) {
		this.system = system;
	}
	
	public void addICommand(ICommand command) {
		this.mapCommands.put(command.getName().toLowerCase(), command);
	}
	
	public Set<String> getCommands() {
		return this.mapCommands.keySet();
	}
}