package com.leanplum.utils;

public class TestParameters {
	private static String IEXPLORE = "iexplore";
	private static final String FIREFOX_BROWSER = "firefox";
	private static final String CHROME_BROWSER = "chrome";

	/**
	 * @return URL to run the tests against as specified by the <i>url</i>
	 *         property. Defaults to https://www.leanplum.com.
	 */
	public static String getTestURL() {
		return System.getProperty("url", "https://www.leanplum.com");
	}

	/**
	 * @return The path to the executable for the browser that the test should use
	 *         as specified by the <i>browser_app</i> property.
	 */
	public static String getBrowserApp() {
		return System.getProperty("browser_app");
	}

	/**
	 * @return true if the browser application we are testing with is Internet
	 *         Explorer
	 */
	public static boolean isInternetExplorer() {
		return getBrowserApp().contains(IEXPLORE);
	}

	/**
	 * @return true if the browser application we are testing with is Internet
	 *         Explorer
	 */
	public static boolean isChrome() {
		return getBrowserApp().contains(CHROME_BROWSER);
	}

	/**
	 * @return true if the browser application we are testing with is Firefox
	 */
	public static boolean isFirefox() {
		return getBrowserApp().contains(FIREFOX_BROWSER);
	}

}
