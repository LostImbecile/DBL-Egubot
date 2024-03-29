package com.github.egubot.commands;

import org.javacord.api.entity.message.Message;

import com.github.egubot.info.ServerInfoUtilities;
import com.github.egubot.interfaces.Command;
import com.github.lavaplayer.TrackScheduler;

public class MusicCancelCommand implements Command {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "cancel";
	}

	@Override
	public boolean execute(Message msg, String arguments) {
		TrackScheduler.destroy(ServerInfoUtilities.getServerID(msg));
		return true;
	}

	@Override
	public boolean isStartsWithPrefix() {
		return true;
	}

}
