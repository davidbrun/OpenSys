package fr.uha.ensisa.opensys.sample.emptysys;

import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.processors.RestrictedProcessor;

public class EmptySysRestrictedProcessorLauncher {
	
	public static void main(String args[])
	{
		OpenSys openSys = new OpenSys();
		openSys.setProcessor(new RestrictedProcessor(openSys));
		openSys.run();
	}
}