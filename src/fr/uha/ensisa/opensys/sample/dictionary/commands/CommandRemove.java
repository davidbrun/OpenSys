package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandRemove implements ICommand {

	@Override
	public String getName() {
		return "Remove";
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
			processor.getOutput().printLine("Entrez le mot a retirer :");
			String word = processor.getInput().getLine();
			if (dictionary.contains(word))
			{
				dictionary.remove(word);
				processor.getOutput().printLine("Retrait OK");
			}
			else
				processor.getOutput().printLine("Le mot " + word + " n'est pas dans le dictionnaire.");
		}
		else
			processor.getOutput().printLine("Dictionary systeme null !");
	}
}