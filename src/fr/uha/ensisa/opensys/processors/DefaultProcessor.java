package fr.uha.ensisa.opensys.processors;

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
	private fr.uha.ensisa.opensys.core.System system;
	
	public DefaultProcessor(OpenSys openSys) {
		super(openSys);
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