package fr.uha.ensisa.opensys.IO;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import fr.uha.ensisa.opensys.core.OpenSys;
import fr.uha.ensisa.opensys.core.Output;

public class FileOutput extends Output {

	static {
		OpenSys.addOutput(FileOutput.class.getSimpleName().toLowerCase(), FileOutput.class);
	}
	
	private PrintWriter out;
	
	public FileOutput(String filename) throws IOException {
		out = new PrintWriter(new FileWriter(filename));
	}
	
	public void finalize() {
		out.flush();
		out.close();
	}
	
	@Override
	public void printChar(char c) {
		out.print(c);
		out.flush();
	}

	@Override
	public void printLine(String s) {
		out.println(s);
		out.flush();
	}

}
