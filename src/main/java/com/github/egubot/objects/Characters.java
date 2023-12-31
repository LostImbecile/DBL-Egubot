package com.github.egubot.objects;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.javacord.api.entity.message.Messageable;

public class Characters {
	private String characterName;
	private String rarity;
	private String colour;
	private String gameID;
	private String imageLink;
	private int siteID;
	private boolean isZenkai;
	private boolean isLF;

	public Characters(String characterName, String rarity, String colour, String gameID, String imageLink, int siteID,
			boolean isZenkai, boolean isLF) {
		super();
		this.characterName = characterName;
		this.rarity = rarity;
		this.colour = colour;
		this.gameID = gameID;
		this.imageLink = imageLink;
		this.siteID = siteID;
		this.isZenkai = isZenkai;
		this.isLF = isLF;
	}

	public Characters() {

	}

	public boolean isLF() {
		return isLF;
	}

	public void setLF(boolean isLF) {
		this.isLF = isLF;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}

	public void setZenkai(boolean isZenkai) {
		this.isZenkai = isZenkai;
	}

	public String getCharacterName() {
		return characterName;
	}

	public String getRarity() {
		return rarity;
	}

	public Color getColour() {
		Color colour = Color.black;
		if (this.colour.equalsIgnoreCase("red"))
			colour = Color.red;
		else if (this.colour.equalsIgnoreCase("yel"))
			colour = Color.yellow;
		else if (this.colour.equalsIgnoreCase("grn"))
			colour = Color.green;
		else if (this.colour.equalsIgnoreCase("blu"))
			colour = Color.blue;
		else if (this.colour.equalsIgnoreCase("pur"))
			colour = Color.magenta;
		else if (this.colour.equalsIgnoreCase("lgt"))
			colour = Color.white;

		return colour;
	}

	public String getGameID() {
		return gameID;
	}

	public String getImageLink() {
		return "https://dblegends.net/" + imageLink.strip();
	}

	public String getPageLink() {
		return "https://dblegends.net/character.php?id=" + siteID;
	}

	public int getSiteID() {
		if (siteID == 19800) {
			return 355;
		}
		if (siteID == 9000) {
			return 356;
		}
		return siteID;
	}

	public boolean isZenkai() {
		return isZenkai;
	}

	public static void sendCharacters(Messageable e, List<Characters> characters) {
		try {
			File tempFile = new File("Characters.txt");

			try (FileWriter file = new FileWriter(tempFile)) {
				String gameID;
				String name;
				for (int i = 0; i < characters.size(); i++) {
					gameID = "[" + characters.get(i).getGameID();
					name = characters.get(i).getCharacterName();
					file.write(String.format("%-12s] - %s%n", gameID, name));
				}
			}
			InputStream stream = new FileInputStream("Characters.txt");
			e.sendMessage(stream, "Characters.txt").join();

			stream.close();
			tempFile.delete();
		} catch (IOException e1) {
			e.sendMessage("Failed to send");
		}
	}
}
