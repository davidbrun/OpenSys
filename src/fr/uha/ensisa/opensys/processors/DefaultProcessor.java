package fr.uha.ensisa.opensys.processors;

import fr.uha.ensisa.opensys.commands.*;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class DefaultProcessor extends Processor {
	
	static {
		OpenSys.addProcessor(DefaultProcessor.class.getSimpleName().toLowerCase(), DefaultProcessor.class);
	}
	
	public DefaultProcessor(OpenSys openSys) {
		super(openSys);
		this.initDefaultProcessor();
	}

	private void initDefaultProcessor() {
		this.addCommand(new CommandLoad());
		this.addCommand(new CommandUnload());
		this.addCommand(new CommandHelp());
		this.addCommand(new CommandAbout());
	}
	

}