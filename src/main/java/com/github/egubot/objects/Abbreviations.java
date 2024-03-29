package com.github.egubot.objects;

import java.util.List;

public class Abbreviations {
	private String name, id;

	public Abbreviations(String name, String id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static String getReactionId(String id) {
		if (id.matches("<.*>"))
			return id.replaceAll("[<>]", "").replace("<a", "").replaceFirst(":", "");
		
		return id;
	}

	public static String replaceAbbreviations(String input, List<Abbreviations> abbreviations) {
		for (Abbreviations abbreviation : abbreviations) {
			input = input.replace(abbreviation.getName(), abbreviation.getId());
		}
		return input;

	}

}
