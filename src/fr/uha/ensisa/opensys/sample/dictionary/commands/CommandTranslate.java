package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.core.System;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandTranslate implements ICommand {
	
	@Override
	public String getName() {
		return "Translate";
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
			processor.getOutput().printLine("Entrez le texte a traduire : ");
			processor.getOutput().printLine("Traduction : " + dictionary.translate(processor.getInput().getLine()));
		}
		else
			processor.getOutput().printLine("Dictionary systeme null !");
	}
}