package fr.uha.ensisa.opensys.core;

import fr.uha.ensisa.opensys.IO.StdInput;
import fr.uha.ensisa.opensys.IO.StdOutput;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;

public class OpenSys {
	private Input input;
	private Output output;
	private Processor processor;
	
	public OpenSys() {
		this.input = new StdInput();
		this.output = new StdOutput();
		this.processor = new DefaultProcessor(this);
	}
	
	public OpenSys(Input input, Output output, Processor processor) {
		this.input = input;
		this.output = output;
		this.processor = processor;
	}

	public Input getInput() {
		return input;
	}
	
	public void setInput(Input input) {
		this.input = input;
	}
	
	public Output getOutput() {
		return output;
	}
	
	public void setOutput(Output output) {
		this.output = output;
	}
	
	public Processor getProcessor() {
		return processor;
	}
	
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	
	public void run() {
		this.processor.run();
	}
	
	public static void main(String args[])
	{
		OpenSys openSys = new OpenSys();
		openSys.run();
	}
}