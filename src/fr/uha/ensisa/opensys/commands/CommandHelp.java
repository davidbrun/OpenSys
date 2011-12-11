package fr.uha.ensisa.opensys.commands;

import java.util.Iterator;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;

public class CommandHelp implements ICommand {

	@Override
	public void execute(Processor processor) {
		String s = "Commandes disponibles:\n";
		int x = 0;
		Iterator<String> it = processor.getCommands().iterator();
		while(it.hasNext()) {
			s += it.next() + " ";
			x++;
			if(x % 5 == 0)
				s += "\n";
		}
		processor.getOutput().printLine(s);
	}

	@Override
	public String getName() {
		return "Help";
	}

}
