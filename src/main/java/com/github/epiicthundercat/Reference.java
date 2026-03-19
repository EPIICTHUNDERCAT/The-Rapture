package com.github.epiicthundercat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {
	public static final String ID = "therapture";
	public static final String VER = "0.0.0";
	public static final String NAME = "TheRapture";

	public static final String CLIENT_PROXY = "com.github.epiicthundercat.proxy.ClientProxy";
	public static final String SERVER_PROXY = "com.github.epiicthundercat.proxy.CommonProxy";
	private static final Logger log = LogManager.getLogger(ID);

	public static Logger getLogger() {
		return log;
	}
}
