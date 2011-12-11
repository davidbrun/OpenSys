package fr.uha.ensisa.opensys.core;

import java.util.HashMap;
import java.util.Map;

public abstract class Processor extends Element<Processor> {
	protected Map<String, ICommand> mapCommands;
	protected OpenSys openSys;
	
	public Processor(OpenSys openSys) {
		this.openSys = openSys;
		this.mapCommands = new HashMap<String, ICommand>();
	}
	
	public abstract void setSystem(fr.uha.ensisa.opensys.core.System system);
	public abstract fr.uha.ensisa.opensys.core.System getSystem();
	public abstract Input getInput();
	public abstract Output getOutput();
	
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
}