package fr.uha.ensisa.opensys.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.uha.ensisa.opensys.core.CommandComposit;
import fr.uha.ensisa.opensys.core.ICommand;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.utils.PackageExplorer;

public class CommandCompositImplementation extends CommandComposit {
	
	public CommandCompositImplementation() {
		super();
	}
	
	@Override
	public String getName() {
		return "Composit";
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Processor processor) {
		processor.getOutput().printLine("COMPOSIT --> add, remove, removeAll or execute");
		String line = processor.getInput().getLine().toLowerCase().trim();
		if (line.equals("add")) {
			List<Class> classes;
			try {
				classes = PackageExplorer.getClasses(OpenSys.PACKAGE_COMMANDS_CORE);
				List<Class> classes2 = PackageExplorer.getClasses(OpenSys.PACKAGE_COMMANDS_DICTIONARY);
				classes.addAll(classes2);
				
				Map<String, ICommand> localCommands = new HashMap<String, ICommand>();
				for (Class c : classes)
				{
					try {
						ICommand command = (ICommand)c.newInstance();
						localCommands.put(command.getName().toLowerCase(), command);
					}
					catch (Exception e)
					{ }
				}
				
				processor.getOutput().printLine("COMPOSIT --> Entrez le nom d'une commande interne a charger : ");
				String command = processor.getInput().getLine().toLowerCase().trim();
				this.addCommand(localCommands.get(command));
				processor.getOutput().printLine("COMPOSIT --> Commande OK");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (line.equals("remove")) {
			processor.getOutput().printLine("COMPOSIT --> Entrez le nom d'une commande interne a supprimer : ");
			String command = processor.getInput().getLine().toLowerCase().trim();
			this.removeCommand(command);
			processor.getOutput().printLine("COMPOSIT --> Commande OK");
		} else if (line.equals("removeall")) {
			this.removeAllCommands();
			processor.getOutput().printLine("COMPOSIT --> Commandes OK");
		} else if (line.equals("execute")) {
			super.execute(processor);
		} else {
			processor.getOutput().printLine("unknown command");
		}
	}
}