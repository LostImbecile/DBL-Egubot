package com.github.egubot.commands;

import org.javacord.api.entity.message.Message;

import com.github.egubot.interfaces.Command;

public class ToggleBotReadModeCommand implements Command {

	@Override
	public String getName() {
		return "toggle bot read mode";
	}

	@Override
	public boolean execute(Message msg, String arguments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStartsWithPrefix() {
		return false;
	}

}
