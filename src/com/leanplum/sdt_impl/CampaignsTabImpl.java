package com.leanplum.sdt_impl;

import java.util.List;

import org.junit.Assert;

import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.leanplum.sdt.CampaignsTab;
import com.leanplum.sdt.NewCampaignDialog;

public class CampaignsTabImpl implements CampaignsTab {
	private Desktop desktop = SdtInit.sDesktop;
	
	@Override
	@Implemented
	public NewCampaignDialog newCampaign() {
		desktop.<DomLink> find("//A[@textContents='New Campaign']").click();		//webdriver locator: "By.linkText("New Campaign")"
		return null;
	}

	@Override
	@Implemented
	public NewCampaignDialog openCampaign(String campaignName) {
		desktop.<DomElement>find("//TABLE//TD[@textContents='"+campaignName+"']").click();
		return null;
	}

	@Override
	@Implemented
	public void verifyCampaignInList(String campaignName, Boolean isInList) {
		if(isInList) {
			Assert.assertTrue("Campaign "+ campaignName +" doesn't exist!", desktop.exists("//TD[@textContents='"+campaignName+"']"));						//webdriver locator: "By.xpath("//td[starts-with(text(),\"campane name\")]")"
		}else {
			Assert.assertFalse("Campaign "+ campaignName +" is in list but should not be!", desktop.exists("//TD[@textContents='"+campaignName+"']"));
		}
	}

	@Override
	@Implemented
	public void verifyCampaignChannel(String campaignName, String channel) {
		String chanelName = getCellText(campaignName, "Channel");
		Assert.assertEquals(channel, chanelName);
	}

	@Override
	@Implemented
	public void verifyCampaignCreatedBy(String campaignName, String name) {
		String userName = getCellText(campaignName, "Created By");
		Assert.assertEquals(name, userName);
	}

	@Override
	@Implemented
	public void verifyCampaignUsers(String campaignName, String number) {
		String numberOfUsers = getCellText(campaignName, "Users?");
		Assert.assertEquals(number, numberOfUsers);
	}

	@Override
	@Implemented
	public void verifyCampaignIsActive(String name, Boolean isActive) {
		int row = getRowByCampaignName(name);
		if(isActive) {
			Assert.assertTrue(desktop.exists("//TABLE//TR["+row+"]/TD//DIV[@class='*view acti*']"));
		}else {
			Assert.assertFalse(desktop.exists("//TABLE//TR["+row+"]/TD//DIV[@class='*view acti*']"));
		}
	}
	
	private int getColumnIndex(String columnName) {
		int index = -1;
		List<DomElement> columns = desktop.<DomElement>findAll("//TH[@class='column']");
		for (DomElement element : columns) {
			String name = element.getText();
			if(name.equalsIgnoreCase(columnName)){
				index = columns.indexOf(element) + 1;
			}
		}
		return index;	
	}
	
	private int getRowByCampaignName(String campaignName) {
		int nameIndex = getColumnIndex("Name");
		int index = -1;
		List<DomElement> columns = desktop.<DomElement>findAll("//TBODY//TR");
		for (DomElement element : columns) {
			String name = element.find("//TD["+nameIndex+"]").getText();
			if(name.equalsIgnoreCase(campaignName)){
				index = columns.indexOf(element) + 1;
			}
		}
		return index;	
		
	}
	
	private String getCellText(String campaignName, String columnName) {
		int column = getColumnIndex(columnName);
		int row = getRowByCampaignName(campaignName);
		String cellText = desktop.<DomElement>find("//TABLE//TR["+row+"]/TD["+column+"]").getText();
		return cellText;
	}


	
	
}
