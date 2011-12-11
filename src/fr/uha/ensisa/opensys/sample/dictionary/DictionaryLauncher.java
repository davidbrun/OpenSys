package fr.uha.ensisa.opensys.sample.dictionary;

import fr.uha.ensisa.opensys.IO.JLineInput;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.sample.dictionary.commands.*;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class DictionaryLauncher {
	public static void main(String args[])
	{
		OpenSys openSys = new OpenSys();
		JLineInput jlineInput = new JLineInput();
		openSys.setInput(jlineInput);
		Dictionary dico = new Dictionary();
		openSys.getProcessor().setSystem(dico);
		openSys.getProcessor().addCommand(new CommandTranslate());
		openSys.getProcessor().addCommand(new CommandInsert());
		openSys.getProcessor().addCommand(new CommandRemove());
		openSys.getProcessor().addCommand(new CommandPrint());
		jlineInput.setCommands(openSys.getProcessor().getCommands());
		openSys.run();
	}
}