package fr.uha.ensisa.opensys.core;

import java.util.HashMap;

import fr.uha.ensisa.opensys.IO.StdInput;
import fr.uha.ensisa.opensys.IO.StdOutput;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;

public class OpenSys {	
	private static HashMap<String, Class<? extends Input>> inputs;
	private static HashMap<String, Class<? extends Output>> outputs;
	private static HashMap<String, Class<? extends Processor>> processors;
	private static HashMap<String, Class<? extends System>> systems;
	

	public static <T> void addInput(String name, Class<? extends Input> s) {
		inputs.put(name, s);
	}
	
	public static <T> void addOutput(String name, Class<? extends Output> s) {
		outputs.put(name, s);
	}
	
	public static <T> void addProcessor(String name, Class<? extends Processor> s) {
		processors.put(name, s);
	}
	
	public static <T> void addSystem(String name, Class<? extends System> s) {
		systems.put(name, s);
	}
	
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
}