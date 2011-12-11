package fr.uha.ensisa.opensys.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;

public class StdInput extends Input {

	static {
		OpenSys.addInput(StdInput.class.getSimpleName().toLowerCase(), StdInput.class);
	}
	
	private BufferedReader in;

	public StdInput() {
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	public void finalize() {
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getChar() {
		int i = -1;

		try {
			i =  in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public String getLine() {
		String s = null;

		try {
			s =  in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return s;
	}

}
