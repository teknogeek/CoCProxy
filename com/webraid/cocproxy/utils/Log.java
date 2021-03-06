package com.webraid.cocproxy.utils;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JOptionPane;

import com.webraid.cocproxy.Proxy;
import com.webraid.cocproxy.gui.InterceptGUI;

public class Log {
	private static Logger log = Logger.getLogger("CocProxy");
	private static FileHandler fh;

	public static void init() {
		try {
			fh = new FileHandler("CoCproxy.log");
			log.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void logPacket(Packet currentPacket) {
		if (Proxy.canDebug()) {
			if (currentPacket.toString() != null) {
				log.info(currentPacket.toString() + "-----------------");
			}
		}
	}

	public static void logInfo(String info) {
		log.info(info);
	}

	public static void logImportantInfo(String info) {
		JOptionPane.showMessageDialog(null, info);
		log.info(info);
	}
}
