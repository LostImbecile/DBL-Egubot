package com.github.egubot.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionException;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.Messageable;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import com.github.egubot.build.LegendsDatabase;
import com.github.egubot.objects.CharacterHash;
import com.github.egubot.objects.Characters;

public class LegendsRoll extends LegendsPool {
	
	private Random rng = new Random();

	public LegendsRoll(LegendsDatabase legendsWebsite, List<String> arrayList) {
		super(legendsWebsite, arrayList);
	}

	public void rollCharacters(String msgText, Messageable e, boolean isAnimated) {

		int size;
		int randomIndex;
		int rollAmount;
		boolean rerollOnDupe = true;
		Characters unit;
		ArrayList<Characters> pool;
		EmbedBuilder[] embeds = new EmbedBuilder[6];

		pool = (ArrayList<Characters>) getPool(msgText);

		if (pool == null || pool.isEmpty()) {
			e.sendMessage("No characters would match that <a:L:1155894861644435516>");
			return;
		}
		size = pool.size();
		// System.out.println(size);
		ArrayList<Characters> rolledCharacters = new ArrayList<>(0);
		try {
			rollAmount = Integer.parseInt(msgText.substring(6, 7));
			if (rollAmount > 6)
				rollAmount = 6;
		} catch (Exception e1) {
			rollAmount = 6;
		}

		if (rollAmount > pool.size())
			rerollOnDupe = false;

		for (int i = 0; i < rollAmount; i++) {
			randomIndex = rng.nextInt(size);

			if (!rolledCharacters.contains(pool.get(randomIndex)))
				rolledCharacters.add(pool.get(randomIndex));
			else if (rerollOnDupe)
				rollAmount++;
		}

		try {

			for (int i = 0; i < rolledCharacters.size(); i++) {
				unit = rolledCharacters.get(i);

				embeds[i] = MessageFormats.createCharacterEmbed(unit);

			}

			MessageBuilder msg = new MessageBuilder();

			if (isAnimated) {
				Message m = msg.setContent("`Rolling...‎‎‏‏‎`").send(e).join();

				MessageFormats.animateRolledCharacters(pool, m, embeds, rolledCharacters.size());
			} else {
				msg.setEmbeds(embeds).send(e);
			}

		} catch (CompletionException e1) {
			System.err.println("rip at legends reroll");
		}

	}

	protected List<Characters> getPool(String msgText) {
		String st = msgText.replace("b-roll", "");
		ArrayList<Characters> pool;

		// Remove number in b-rolln if present
		if (st.length() > 1 && st.substring(0,1).matches("[0-9]"))
			st = st.substring(1);
		else if (st.length() == 1)
			st = "";

		st = st.strip();
		// System.out.println(st);
		if (st.equals("")) {
			pool = (ArrayList<Characters>) getLegendsWebsite().getCharactersList();
		} else {
			pool = ((CharacterHash) analyseAndCreatePool(st)).toArrayList();
		}
		
		return pool;
	}

}
