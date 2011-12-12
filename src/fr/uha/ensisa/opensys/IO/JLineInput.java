package fr.uha.ensisa.opensys.IO;

import java.io.IOException;
import java.util.Set;

import jline.Completor;
import jline.ConsoleReader;
import jline.SimpleCompletor;
import fr.uha.ensisa.opensys.core.Input;
import fr.uha.ensisa.opensys.core.OpenSys;

public class JLineInput extends Input {
	private static final String PROMPT = "-->";
	private static final String[] EMPTY_STRING_ARRAY = new String[0];
	private ConsoleReader in;
	
	static {
		OpenSys.addInput(JLineInput.class.getSimpleName().toLowerCase(), JLineInput.class);
	}
	
	public JLineInput() {
		try {
			this.in = new ConsoleReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getLine() {
		String line = null;
		try {
			line = in.readLine(PROMPT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	@Override
	public int getChar() {
		int readChar = -1;
		try {
			readChar = in.readCharacter(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readChar;
	}
	
	@SuppressWarnings("unchecked")
	public void setCommands(Set<String> commands) {
		Completor[] listCompletor;
		listCompletor = (Completor[]) this.in.getCompletors().toArray(new Completor[0]);
		for (int i = 0; i < listCompletor.length; i++)
			if (this.in.removeCompletor(listCompletor[i]))
				i--;
		in.addCompletor(new SimpleCompletor(commands.toArray(EMPTY_STRING_ARRAY)));
	}
}