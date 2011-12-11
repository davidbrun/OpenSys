package fr.uha.ensisa.opensys.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;

public class FileInput extends Input {
	
	static {
		OpenSys.addInput(FileInput.class.getName().toLowerCase(), FileInput.class);
	}

	private BufferedReader in;
	
	public FileInput(String filename) throws FileNotFoundException {
		in = new BufferedReader(new FileReader(filename));
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
