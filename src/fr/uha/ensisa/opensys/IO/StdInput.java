package fr.uha.ensisa.opensys.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import fr.uha.ensisa.opensys.core.Input;

public class StdInput extends Input {

	@Override
	public int getChar() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
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
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = null;

		try {
			s =  in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return s;
	}

}
