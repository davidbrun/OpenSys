package fr.uha.ensisa.opensys.core;

import java.util.HashMap;
import java.util.Map;

import fr.uha.ensisa.opensys.IO.StdInput;
import fr.uha.ensisa.opensys.IO.StdOutput;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;

public class OpenSys {	
	private static Map<String, Class<? extends Input>> inputs;
	private static Map<String, Class<? extends Output>> outputs;
	private static Map<String, Class<? extends Processor>> processors;
	private static Map<String, Class<? extends System>> systems;
	
	static {
		inputs = new HashMap<String, Class<? extends Input>>();
		outputs = new HashMap<String, Class<? extends Output>>();
		processors = new HashMap<String, Class<? extends Processor>>();
		systems = new HashMap<String, Class<? extends System>>();
	}

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
	
	public Input newInput(String name) {
		Input input = null;
		Class<? extends Input> c = inputs.get(name);
		try {
			input = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public Output newOutput(String name) {
		Output output = null;
		Class<? extends Output> c = outputs.get(name);
		try {
			output = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public System newSystem(String name) {
		System system = null;
		Class<? extends System> c = systems.get(name);
		try {
			system = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return system;
	}
	
	public Processor newProcessor(String name) {
		Processor processor = null;
		Class<? extends Processor> c = processors.get(name);
		try {
			processor = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processor;
	}
	
	public Processor getProcessor() {
		return processor;
	}
	
	public void setProcessor(Processor processor) {
		this.processor = processor;
		this.processor.run();
	}
	
	public void run() {
		this.processor.run();
	}
}