package com.leanplum.sdt_impl;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;

public class SdtInit {

	public static Desktop sDesktop = new Desktop();
	public static BrowserWindow getDesktop() {
		return sDesktop.<BrowserWindow>find("/BrowserApplication//BrowserWindow");
	}

}
