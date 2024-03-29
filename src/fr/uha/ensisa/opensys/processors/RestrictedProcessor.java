package fr.uha.ensisa.opensys.processors;

import fr.uha.ensisa.opensys.commands.CommandAbout;
import fr.uha.ensisa.opensys.commands.CommandHelp;
import fr.uha.ensisa.opensys.commands.CommandLoadCommand;
import fr.uha.ensisa.opensys.commands.CommandLoadJar;
import fr.uha.ensisa.opensys.commands.CommandUnloadCommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;

public class RestrictedProcessor extends Processor {
	
	static {
		OpenSys.addProcessor(RestrictedProcessor.class.getSimpleName().toLowerCase(), RestrictedProcessor.class);
	}
	
	public RestrictedProcessor(OpenSys openSys) {
		super(openSys);
		this.initRestrictedProcessor();
	}

	private void initRestrictedProcessor() {
		this.addCommand(new CommandLoadCommand());
		this.addCommand(new CommandUnloadCommand());
		this.addCommand(new CommandHelp());
		this.addCommand(new CommandAbout());
		this.addCommand(new CommandLoadJar());
	}
}