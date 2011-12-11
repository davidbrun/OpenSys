package fr.uha.ensisa.opensys.sample.dictionary;

import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;
import fr.uha.ensisa.opensys.sample.dictionary.commands.CommandInsert;
import fr.uha.ensisa.opensys.sample.dictionary.commands.CommandTranslate;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class DictionaryLauncher {
	public static void main(String args[])
	{
		OpenSys openSys = new OpenSys();
		Dictionary dico = new Dictionary();
		openSys.getProcessor().setSystem(dico);
		((DefaultProcessor)openSys.getProcessor()).addICommand(new CommandTranslate());
		((DefaultProcessor)openSys.getProcessor()).addICommand(new CommandInsert());
		openSys.run();
	}
}