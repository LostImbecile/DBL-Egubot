package com.github.egubot.shared;

import java.util.Scanner;

import com.github.egubot.main.ShutdownManager;
import com.github.egubot.main.StatusManager;

public class Shared {
	private static ShutdownManager shutdown = new ShutdownManager();
	private static StatusManager status;
	private static Scanner input = new Scanner(System.in);
	private static boolean testMode = false;

	public static ShutdownManager getShutdown() {
		return shutdown;
	}

	public static void setShutdown(ShutdownManager shutdown) {
		Shared.shutdown = shutdown;
	}

	public static StatusManager getStatus() {
		return status;
	}

	public static void setStatus(StatusManager status) {
		Shared.status = status;
	}

	public static Scanner getSystemInput() {
		return input;
	}

	public static void setInput(Scanner input) {
		Shared.input = input;
	}

	public static boolean isTestMode() {
		return testMode;
	}

	public static void setTestMode(boolean testMode) {
		Shared.testMode = testMode;
	}

}
