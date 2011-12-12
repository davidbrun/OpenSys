package fr.uha.ensisa.opensys.core;

import java.util.HashMap;
import java.util.Map;

import fr.uha.ensisa.opensys.IO.JLineInput;
import fr.uha.ensisa.opensys.IO.StdInput;
import fr.uha.ensisa.opensys.IO.StdOutput;
import fr.uha.ensisa.opensys.processors.DefaultProcessor;
import fr.uha.ensisa.opensys.sample.dictionary.core.Dictionary;

@SuppressWarnings("rawtypes")
public class OpenSys {	
	public static final String PACKAGE_IO = "fr.uha.ensisa.opensys.IO";
	public static final String PACKAGE_PROCESSORS = "fr.uha.ensisa.opensys.processors";
	public static final String PACKAGE_COMMANDS_CORE = "fr.uha.ensisa.opensys.commands";
	public static final String PACKAGE_COMMANDS_DICTIONARY = "fr.uha.ensisa.opensys.sample.dictionary.commands";
	
	private static Map<String, Class<? extends Input>> inputs;
	private static Map<String, Class<? extends Output>> outputs;
	private static Map<String, Class<? extends Processor>> processors;
	private static Map<String, Class<? extends System>> systems;
	
	static {
		inputs = new HashMap<String, Class<? extends Input>>();
		outputs = new HashMap<String, Class<? extends Output>>();
		processors = new HashMap<String, Class<? extends Processor>>();
		systems = new HashMap<String, Class<? extends System>>();
		
		initOpenSys();
	}

	public static <T> void addInput(String name, Class<? extends Input> input) {
		if (!inputs.containsKey(name))
			inputs.put(name, input);
	}
	
	public static <T> void addOutput(String name, Class<? extends Output> output) {
		if (!outputs.containsKey(name))
			outputs.put(name, output);
	}
	
	public static <T> void addProcessor(String name, Class<? extends Processor> processor) {
		if (!processors.containsKey(name))
			processors.put(name, processor);
	}
	
	public static <T> void addSystem(String name, Class<? extends System> system) {
		if (!systems.containsKey(name))
			systems.put(name, system);
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
		
		if (input instanceof JLineInput)
			((JLineInput)input).setCommands(processor.getCommands());
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
			Object parameter = null;
			if (c.getDeclaredConstructors()[0].getParameterTypes().length != 0)
			{
				getOutput().printLine("Entrez le nom du fichier : ");
				parameter = getInput().getLine().toLowerCase();
				input = c.getConstructor(parameter.getClass()).newInstance(parameter.toString());
			}
			else
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
			Object parameter = null;
			if (c.getDeclaredConstructors()[0].getParameterTypes().length != 0)
			{
				getOutput().printLine("Entrez le nom du fichier : ");
				parameter = getInput().getLine().toLowerCase();
				output = c.getConstructor(parameter.getClass()).newInstance(parameter.toString());
			}
			else
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
			processor = c.getConstructor(OpenSys.class).newInstance(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return processor;
	}
	
	public Processor getProcessor() {
		return processor;
	}
	
	public void setProcessor(Processor processor) {
		if (this.processor != null)
			this.processor.stop();
		this.processor = processor;
		this.processor.run();
	}
	
	public void run() {
		this.processor.run();
	}
	
	@SuppressWarnings("unchecked")
	private static void initOpenSys() {
		// Referencing all the known objects
		// IO
		try
		{
			for (Class clazz : fr.uha.ensisa.opensys.utils.PackageExplorer.getClasses(PACKAGE_IO))
				try {
					if (clazz.getSuperclass().equals(Input.class))
						addInput(clazz.getSimpleName().toLowerCase(), clazz);
					if (clazz.getSuperclass().equals(Output.class))
						addOutput(clazz.getSimpleName().toLowerCase(), clazz);	
				}
				catch (Exception e) { }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// Processors
		try
		{
			for (Class clazz : fr.uha.ensisa.opensys.utils.PackageExplorer.getClasses(PACKAGE_PROCESSORS))
				try {
					if (clazz.getSuperclass().equals(Processor.class))
						addProcessor(clazz.getSimpleName().toLowerCase(), clazz);
				}
				catch (Exception e) { }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		// Systems
		addSystem(Dictionary.class.getSimpleName().toLowerCase(), Dictionary.class);
	}
}