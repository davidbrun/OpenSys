package fr.uha.ensisa.opensys.core;

public abstract class Output extends Element<Input> {

	public abstract void printLine(String s);

	public abstract void printChar(char c);
}