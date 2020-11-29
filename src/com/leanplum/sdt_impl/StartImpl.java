package com.leanplum.sdt_impl;

import com.leanplum.sdt.Start;
import java.util.List;
import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.BrowserBaseState;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.BrowserType;
import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.leanplum.utils.TestParameters;

public class StartImpl implements Start {

			private Desktop desktop = SdtInit.sDesktop;

			@Implemented
			@Override
			public void start() {
				String browserApp = System.getProperty("browser_app");

				try {
					/*
					 * Close the previous instance in case of any browser popup messages
					 * that might be blocking us.
					 */
					List<BrowserApplication> browsers = desktop
							.<BrowserApplication> findAll("/BrowserApplication");
					for (BrowserApplication browser : browsers) {

						browser.setActive();
						browser.closeOtherTabs();
						browser.closeSynchron(true);

					}
				} catch (Exception ex) {
					System.out.println("Browser close failed: " + ex.getMessage());
				}

				String loginUrl = TestParameters.getTestURL()+"/dashboard/access?continue=%2Fdashboard#login";
				
				BrowserApplication browser = openBrowser(browserApp);

				browser.navigate(loginUrl);
				browser.maximize();

				desktop.setOption("OPT_MOUSE_INPUT_DELAY", 5000);
				desktop.setOption("OPT_WAIT_RESOLVE_OBJDEF", 25000);
				desktop.setOption("OPT_OBJECT_ENABLED_TIMEOUT", 10000);
			}

			private BrowserApplication openBrowser(String browserApp) {
				if (TestParameters.isInternetExplorer()) {
					BrowserBaseState baseState = new BrowserBaseState(
							BrowserType.InternetExplorer, "about:blank");
					return baseState.<BrowserApplication> execute(desktop);
				} else {
					BrowserBaseState baseState = new BrowserBaseState(browserApp, null);
					return baseState.<BrowserApplication> execute(desktop);
				}
			}
}
