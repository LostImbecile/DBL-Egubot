package com.github.egubot.commands;

import org.javacord.api.entity.message.Message;

import com.github.egubot.interfaces.Command;

public class GrabCommand implements Command {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "grab";
	}

	@Override
	public boolean execute(Message msg, String arguments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStartsWithPrefix() {
		// TODO Auto-generated method stub
		return true;
	}

}
