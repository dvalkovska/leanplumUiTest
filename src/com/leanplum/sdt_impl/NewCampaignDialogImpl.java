package com.leanplum.sdt_impl;

import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.leanplum.sdt.CampaignSettingsDialog;
import com.leanplum.sdt.CampaignsTab;
import com.leanplum.sdt.NewCampaignDialog;
import org.junit.Assert;


public class NewCampaignDialogImpl implements NewCampaignDialog {
	
	private Desktop desktop = SdtInit.sDesktop;
	
	private String campaignNameBox = "//DIV[@class='campaign-name-box']";					//webdriver locator: "By.className("campaign-name-box")"
	private String goalCategory = "//DIV[@class='choices content']"; 						//webdriver locator: "By.className("choices")"
	
	@Override
	@Implemented
	public CampaignsTab goToCampaigns() {
		desktop.<DomLink>find("//A[@class='back-link' and @Text='Back to Campaigns']").click();	//webdriver locator: "By.linkText("Back to Campaigns")"
		return null;
	}

	@Override
	@Implemented
	public CampaignSettingsDialog renameCampaign() {
		desktop.<DomElement>find(campaignNameBox + "//DIV[@class='name']").click();
		return null;
	}

	@Override
	@Implemented
	public void setNotificationMessage(String message) {
		DomTextField messageField = desktop.<DomTextField>find("//INPUT[@name='Message' and @placeholder='Push*']");
		messageField.click();
		messageField.clearText();
		messageField.setText(message);
	}
	
	@Override
	@Implemented
	public void verifyCampaignName(String name) {
		String displayedName = desktop.<DomElement>find(campaignNameBox + "//DIV[@class='name']/SPAN").getText();
		Assert.assertEquals(name, displayedName);
	}
	
	@Override
	@Implemented
	public void selectGoal(String goal) {
		desktop.<DomElement>find(goalCategory + "//DIV[@Text='"+goal+"']").click();
	}
	
	@Override
	@Implemented
	public void verifyGoalIsSelected(String goal, Boolean isSelected) {
		if(isSelected) {
			Assert.assertTrue(desktop.exists(goalCategory + "//DIV[@class='option selected' and @Text='"+goal+"']"));
		}else{
			Assert.assertFalse(desktop.exists(goalCategory + "//DIV[@class='option selected' and @Text='"+goal+"']"));
		}
		
	}
	
	@Override
	@Implemented
	public void selectNext() {
		DomLink nextButton = desktop.<DomLink>find("//A[@textContents='Next']");									//webdriver locator: "By.linkText("Next")"
		nextButton.click();
	}

	@Override
	@Implemented
	public void verifySelectedStep(String stepName) {
		switch(stepName) {
		case "Goal":
			Assert.assertTrue("You are not in Goal setting dialog", desktop.exists("//P[@textContents='Goal Category']"));
			break;
		case "Audience":
			Assert.assertTrue("You are not in Select Audience dialog", desktop.exists("//H2[@textContents='Select Audience']"));
			break;
		case "Delivery":
			Assert.assertTrue("You are not in Delivery Method setting dialog", desktop.exists("//P[@textContents='Campaign Delivery an*']"));
			break;
		case "Actions":
			Assert.assertTrue("You are not in Actions setting dialog", desktop.exists("//A[@textContents='Channel']"));
			break;
		}
		
	}

	@Override
	@Implemented
	public void setDeliveryMethodScheduled(String date) {
		desktop.<DomElement>find("//DIV[@class='option scheduled*']").click(); 			//webdriver locator: "By.xpath("//div[@class='option scheduled*']")"
		DomTextField dateField = desktop.<DomTextField>find("//INPUT[@placeholder='MM/dd/yyyy']");
		dateField.click();
		dateField.clearText();
		dateField.typeKeys(date);
		//click enter
		dateField.typeKeys("<Enter>");
	}

	@Override
	@Implemented
	public void setActionPushNotification() {
		desktop.<DomElement>find("//DIV[@class='composer-actions-kin*']//SPAN[@textContents='Push Notification']").click();
	}

	@Override
	@Implemented
	public void startCampaign() {
		desktop.<DomButton>find("//BUTTON[@Text='Start Campaign']").click();						//webdriver locator: "By.xpath("//button//span[text()=\"Start Campaign\"]")"
		desktop.<DomButton>find("//P[@textContents='Start Campaign?']/../..//BUTTON[@Text='Start campaign']").click();
		//close pendo-gide-container if shows up
		if(desktop.exists("//DIV[@id='pendo-guide-containe*']")) {
			desktop.<DomButton>find("//BUTTON[@id='pendo-close-guide*']").click();
		}
	}

	@Override
	@Implemented
	public void verifyStartCampaignButtonIsEnabled(Boolean isEnabled) {
		if(isEnabled) {
			Assert.assertTrue(desktop.exists("//BUTTON[@Text='Start Campaign' and @class='*enabled*']"));
		}else {
			Assert.assertFalse(desktop.exists("//BUTTON[@Text='Start Campaign' and @class='*enabled*']"));
		}
		
		
	}

	@Override
	@Implemented
	public void verifyScheduledDate(String date) {
		String dateText = desktop.<DomElement>find("//A[@class='*delivery*']//DIV/DIV/SPAN").getText();
		Assert.assertTrue("Expected delivery is "+date+" but was: "+dateText, dateText.contains(date));
		
	}

	@Override
	@Implemented
	public void endCampaign() {
		desktop.<DomElement>find("//SPAN[@textContents='End Campaign']").click();
		desktop.<DomElement>find("//P[@textContents='End the Campaign?']/../..//SPAN[@textContents='End']").click();
	}

	@Override
	@Implemented
	public void verifyCampaignFinished() {
		Assert.assertTrue(desktop.exists("//SPAN[@textContents='Finished']"));
		
	}

}
