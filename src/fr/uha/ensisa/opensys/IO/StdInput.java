package fr.uha.ensisa.opensys.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.uha.ensisa.opensys.core.Input;

public class StdInput extends Input {

	private BufferedReader in;

	public StdInput() {
		in = new BufferedReader(new InputStreamReader(System.in));
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
