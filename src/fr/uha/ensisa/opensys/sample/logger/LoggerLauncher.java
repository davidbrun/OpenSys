package fr.uha.ensisa.opensys.sample.logger;

import java.io.IOException;

import fr.uha.ensisa.opensys.IO.LoggerInput;
import fr.uha.ensisa.opensys.IO.LoggerOutput;
import fr.uha.ensisa.opensys.IO.StdInput;
import fr.uha.ensisa.opensys.IO.StdOutput;
import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Output;
import fr.uha.ensisa.opensys.core.Processor;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;

public class LoggerLauncher {
	public static void main(String args[]) {
		Input i = null;
		try {
			i = new LoggerInput("/tmp/input");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(i != null)
			i.addBack(new StdInput());
		else
			i = new StdInput();
		
		Output o = null;

		try {
			o = new LoggerOutput("/tmp/output");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(o != null)
			o.addBack(new StdOutput());
		else
			o = new StdOutput();
		
		OpenSys openSys = new OpenSys();
		
		Processor p = new DefaultProcessor(openSys);
		openSys.setInput(i);
		openSys.setOutput(o);
		openSys.setProcessor(p);
		
		openSys.run();
	}
}
