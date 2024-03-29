package com.github.egubot.commands;

import org.javacord.api.entity.message.Message;

import com.github.egubot.facades.AutoRespondContext;
import com.github.egubot.info.UserInfoUtilities;
import com.github.egubot.interfaces.Command;

public class ResponseEditCommand implements Command{

	@Override
	public String getName() {
		return "response edit";
	}

	@Override
	public boolean execute(Message msg, String arguments) {
		AutoRespondContext.getAutoRespond().updateResponse(arguments, msg.getChannel(), UserInfoUtilities.isOwner(msg));
		return true;
	}

	@Override
	public boolean isStartsWithPrefix() {
		return true;
	}

}
