package fr.uha.ensisa.opensys.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class Processor extends Element<Processor> {
	private static final String EXIT_COMMAND = "quit";
	private fr.uha.ensisa.opensys.core.System system;
	protected Map<String, ICommand> mapCommands;
	protected OpenSys openSys;
	
	public Processor(OpenSys openSys) {
		this.openSys = openSys;
		this.mapCommands = new HashMap<String, ICommand>();
	}

	public fr.uha.ensisa.opensys.core.System getSystem() {
		return this.system;
	}

	public Input getInput() {
		return this.openSys.getInput();
	}

	public Output getOutput() {
		return this.openSys.getOutput();
	}

	public void setSystem(System system) {
		this.system = system;
	}

	public void addCommand(ICommand command) {
		this.mapCommands.put(command.getName().toLowerCase(), command);
	}

	public Set<String> getCommands() {
		Set<String> result = new TreeSet<String>();
		result.addAll(this.mapCommands.keySet());
		result.add(EXIT_COMMAND);
		return result;
	}

	public void run() {
		String line = "";
		while (!line.equals(EXIT_COMMAND))
		{
			line = getInput().getLine().toLowerCase().trim();
			if (this.mapCommands.containsKey(line))
				this.mapCommands.get(line).execute(this);
			else
				if (!line.equals(EXIT_COMMAND))
					getOutput().printLine("Unknown command: " + line);
		}
		getOutput().printLine("Bye bye!");
	}
}