package org.bunny.skyfire.resource;

public final class DataStorage {

	private static final String APIKEY = "";
	private static final String APISECRET = "";
	private static final String PASSPHRASE = "";
	private static final String PROXY_HOST = "";
	private static final String PROXY_PORT = "";
	private static final String PROXY_USERNAME = "";
	private static final String PROXY_PASSWORD = "";

	public static String getApikey() {
		return APIKEY;
	}
	
	public static String getApisecret() {
		return APISECRET;
	}
	
	public static String getPassphrase() {
		return PASSPHRASE;
	}
	
	public static String getProxyHost() {
		return PROXY_HOST;
	}

	public static String getProxyPort() {
		return PROXY_PORT;
	}

	public static String getProxyUsername() {
		return PROXY_USERNAME;
	}

	public static String getProxyPassword() {
		return PROXY_PASSWORD;
	}

}
