package fr.uha.ensisa.opensys.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;

public class LoggerInput extends Input {

	static {
		OpenSys.addInput(LoggerInput.class.getSimpleName().toLowerCase(), LoggerInput.class);
	}
	
	private PrintWriter out;

	public LoggerInput(String filename) throws IOException {
		out = new PrintWriter(new FileWriter(filename));
	}
	
	public void filnalize() {
		out.close();
	}
	
	@Override
	public int getChar() {
		int i = ((Input)next).getChar();
		out.print(i);
		return i;
	}

	@Override
	public String getLine() {
		String s = ((Input)next).getLine();
		out.println(s);
		return s;
	}

}
