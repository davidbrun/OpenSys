package fr.uha.ensisa.opensys.IO;

import fr.uha.ensisa.opensys.core.Output;

public class StdOutput extends Output {

	@Override
	public void printChar(char c) {
		System.out.print(c);
	}

	@Override
	public void printLine(String s) {
		System.out.println(s);
	}

}
