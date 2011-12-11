package fr.uha.ensisa.opensys.sample.emptysys;

import fr.uha.ensisa.opensys.IO.JLineInput;
import fr.uha.ensisa.opensys.core.OpenSys;

public class EmptySysWithJLineLauncher {
	public static void main(String args[])
	{
		OpenSys openSys = new OpenSys();
		JLineInput jlineInput = new JLineInput();
		openSys.setInput(jlineInput);
		jlineInput.setCommands(openSys.getProcessor().getCommands());
		openSys.run();
	}
}