package fr.uha.ensisa.opensys.sample.dictionary;

import fr.uha.ensisa.opensys.IO.JLineInput;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.sample.dictionary.commands.*;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class DictionaryLauncher {
	
	public static void main(String args[])
	{
		JLineInput jlineInput = new JLineInput();
		OpenSys openSys = new OpenSys();
		
		openSys.getProcessor().addSystem(new Dictionary());
		openSys.getProcessor().addCommand(new CommandTranslate());
		openSys.getProcessor().addCommand(new CommandInsert());
		openSys.getProcessor().addCommand(new CommandRemove());
		openSys.getProcessor().addCommand(new CommandPrint());
		
		openSys.setInput(jlineInput);
		jlineInput.setCommands(openSys.getProcessor().getCommands());
		
		openSys.run();
	}
}