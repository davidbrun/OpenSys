package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandInsert implements ICommand {
	
	@Override
	public String getName() {
		return "Insert";
	}
	
	@Override
	public Class<? extends System> getTarget() {
		return Dictionary.class;
	}

	@Override
	public void execute(Processor processor) {
		Dictionary dictionary = (Dictionary) processor.getSystem(getTarget().getSimpleName().toLowerCase());
		if (dictionary != null)
		{
			processor.getOutput().printLine("Entrez le mot a traduire : ");
			String word1 = processor.getInput().getLine();
			processor.getOutput().printLine("Entrez la traduction : ");
			String word2 = processor.getInput().getLine();
			dictionary.insert(word1, word2);
			processor.getOutput().printLine("Ajout OK");
		}
		else
			processor.getOutput().printLine("Dictionary systeme null !");
	}
}