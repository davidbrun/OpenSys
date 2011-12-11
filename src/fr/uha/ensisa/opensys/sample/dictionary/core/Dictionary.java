package fr.uha.ensisa.opensys.sample.dictionary.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import fr.uha.ensisa.opensys.core.System;

public class Dictionary extends System {
	private Map<String, String> dico;

	public Dictionary() {
		this.dico = new HashMap<String, String>();
		this.initDico();
	}
	
	private void initDico() {
		dico.put("maison", "house");
		dico.put("arbre", "tree");
		dico.put("chat", "cat");
		dico.put("ordinateur", "computer");
		dico.put("texte", "text");
	}
	
	public String translate(String word) {
		if (dico.containsKey(word))
			return dico.get(word);
		else
			return "Le mot " + word + " n'est pas present dans le dictionnaire.";
	}
	
	public void insert(String wordLanguage1, String wordLanguage2) {
		dico.put(wordLanguage1, wordLanguage2);
	}
	
	public void remove(String word) {
		dico.remove(word);
	}
	
	public int getSize() {
		return dico.size();
	}
	
	public String toString() {
		String s = "Dictionnaire:\n";
		
		Iterator<Map.Entry<String, String>> it = dico.entrySet().iterator();
		while(it.hasNext()) {
			Entry<String, String> entry = it.next();
			s += entry.getKey() + " --> " + entry.getValue() + "\n";
		}
		return s;
	}
}