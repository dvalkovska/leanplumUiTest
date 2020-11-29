package com.leanplum.sdt_impl;

import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.leanplum.sdt.CampaignsTab;
import com.leanplum.sdt.SideNavigationBar;

public class SideNavigationBarImpl implements SideNavigationBar {

	private Desktop desktop = SdtInit.sDesktop;
	
	
	@Override
	@Implemented
	public CampaignsTab selectCampaignsTab() {
		DomElement navBar = desktop.<DomElement> find("//DIV[@class='side-nav-view']");		//webdriver locator: "By.className("side-nav-view")"
		DomLink campaigns = desktop.<DomLink> find(navBar.getLocator()+"//A[@Text='Campaigns']");		//webdriver locator: "By.xpath("//DIV[@class='side-nav-view']//a[@class='link']")"
		navBar.domMouseMove();				
		campaigns.click();
		//move mouse away
		desktop.<DomElement>find("//DIV[@class='frames']").domMouseMove();
		return null;
	}

}
