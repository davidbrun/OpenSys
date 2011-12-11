package fr.uha.ensisa.opensys.sample.dictionary.commands;

import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.IProcessor;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

public class CommandTranslate implements ICommand {
	@Override
	public void execute(IProcessor processor) {
		Dictionary dictionary = (Dictionary) processor.getSystem();
		if (dictionary != null)
		{
			processor.getOutput().printLine(dictionary.translate(processor.getInput().getLine()));
		}
	}
}