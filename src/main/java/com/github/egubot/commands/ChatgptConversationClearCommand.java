package com.github.egubot.commands;

import org.javacord.api.entity.message.Message;

import com.github.egubot.facades.ChatGPTContext;
import com.github.egubot.interfaces.Command;

public class ChatgptConversationClearCommand implements Command {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "gpt clear";
	}

	@Override
	public boolean execute(Message msg, String arguments) {
		if(!ChatGPTContext.isChatGPTOn())
			return false;
		
		ChatGPTContext.getChatgptConversation().clear();
		msg.getChannel().sendMessage("Conversation cleared :thumbsup:");
		return true;
	}

	@Override
	public boolean isStartsWithPrefix() {
		return false;
	}

}
