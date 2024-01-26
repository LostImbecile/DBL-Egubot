package com.github.egubot.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.github.egubot.interfaces.Shutdownable;

public class ShutdownManager {
	private List<Shutdownable> shutdownables;

	public ShutdownManager() {
		this.shutdownables = new ArrayList<>();
	}

	public void registerShutdownable(Shutdownable shutdownable) {
		shutdownables.add(shutdownable);
	}

	public void initiateShutdown(int exitCode) {
		// Some classes need to shutdown last to avoid trouble
		Collections.sort(shutdownables, Comparator.comparingInt(Shutdownable::getShutdownPriority));
		
		// Uses its own thread to avoid being run by a thread it's terminating
		CompletableFuture.runAsync(() -> {
			for (Shutdownable shutdownable : shutdownables) {
				shutdownable.shutdown();
			}
			
			System.exit(exitCode);
		});
		
	}
	
}