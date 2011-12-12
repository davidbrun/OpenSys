package fr.uha.ensisa.opensys.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class Processor extends Element<Processor> {
	private static final String EXIT_COMMAND = "quit";
	private Map<String,fr.uha.ensisa.opensys.core.System> mapSystems;
	protected Map<String, ICommand> mapCommands;
	protected OpenSys openSys;
	private boolean mustStop = false;
	
	public Processor(OpenSys openSys) {
		this.openSys = openSys;
		this.mapCommands = new HashMap<String, ICommand>();
		this.mapSystems = new HashMap<String, System>();
	}

	public fr.uha.ensisa.opensys.core.System getSystem(String systemName) {
		if (mapSystems.containsKey(systemName))
			return mapSystems.get(systemName);
		else
			return null;
	}

	public Input getInput() {
		return this.openSys.getInput();
	}

	public Output getOutput() {
		return this.openSys.getOutput();
	}

	public void addSystem(System system) {
		if (!this.mapSystems.containsKey(system.getClass().getSimpleName().toLowerCase()))
			this.mapSystems.put(system.getClass().getSimpleName().toLowerCase(), system);
	}
	
	public OpenSys getOpenSys() {
		return openSys;
	}

	public void addCommand(ICommand command) {
		if (!this.mapCommands.containsKey(command.getName().toLowerCase()))
			this.mapCommands.put(command.getName().toLowerCase(), command);
	}
	
	public boolean removeCommand(String commandName) {
		boolean result = this.mapCommands.containsKey(commandName);
		this.mapCommands.remove(commandName);
		return result;
	}

	public Set<String> getCommands() {
		Set<String> result = new TreeSet<String>();
		result.addAll(this.mapCommands.keySet());
		result.add(EXIT_COMMAND);
		return result;
	}

	public void run() {
		String line = "";
		mustStop = false;
		while (line != null && !line.equals(EXIT_COMMAND) && !mustStop)
		{
			line = getInput().getLine();
			if (line != null)
			{
				line = line.toLowerCase().trim();
				if (this.mapCommands.containsKey(line))
					this.mapCommands.get(line).execute(this);
				else
					if (!line.equals(EXIT_COMMAND))
						getOutput().printLine("Unknown command: " + line);
			}
		}
		if (!mustStop)
			getOutput().printLine("Bye bye!");
	}

	public synchronized void stop() {
		this.mustStop = true;
	}
}