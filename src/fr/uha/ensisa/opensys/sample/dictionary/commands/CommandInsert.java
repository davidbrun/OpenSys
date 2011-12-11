package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandInsert implements ICommand {
	@Override
	public String getName() {
		return "Insert";
	}

	@Override
	public void execute(Processor processor) {
		Dictionary dictionary = (Dictionary) processor.getSystem();
		if (dictionary != null)
		{
			processor.getOutput().printLine("Entrez les 2 mots à insérer, séparés par un \"entré\" : ");
			String word1 = processor.getInput().getLine();
			String word2 = processor.getInput().getLine();
			dictionary.insert(word1, word2);
			processor.getOutput().printLine("Ajout OK");
		}	
	}
}