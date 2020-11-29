package com.leanplum.testscripts;

import org.junit.Test;

import com.leanplum.sdt.TestObjectsDSL;

public class CampaignTests {

	@Test
	public void loginDialogTest() throws Exception {
		/* SDT::Line */ 
		TestObjectsDSL.sStart.start(); 
		/* SDT::Line */ 
		TestObjectsDSL.sLogin.verifyLoginFailure("Administrator", "IllegalPassword", "Please enter a valid email"); 
		/* SDT::Line */ 
		TestObjectsDSL.sLogin.verifyLoginFailure("abc@abc.com", "123", "The password must be at least 8 characters"); 
	}

	@Test
	public void renameCampaignTest() throws Exception {
		/* SDT::Line */ 
		TestObjectsDSL.sStart.start(); 
		/* SDT::Line */ 
		TestObjectsDSL.sLogin.login("dimitrinav@yahoo.com", "Adf1nbar"); 
		/* SDT::Line */ 
		TestObjectsDSL.sSideNavigationBar.selectCampaignsTab(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.newCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.renameCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.setName("My First Campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.clickSave(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyCampaignName("My First Campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.renameCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.setName("My Second Campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.clickCancel(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyCampaignName("My First Campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.goToCampaigns(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignInList("My First Campaign", true); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignInList("My Second Campaign", false); 
	}

	@Test
	public void createCampaign() throws Exception {
		/* SDT::Line */ 
		TestObjectsDSL.sStart.start(); 
		/* SDT::Line */ 
		TestObjectsDSL.sLogin.login("dimitrinav@yahoo.com", "Adf1nbar"); 
		/* SDT::Line */ 
		TestObjectsDSL.sSideNavigationBar.selectCampaignsTab(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.newCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.renameCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.setName("My campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignSettingsDialog.clickSave(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyCampaignName("My campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.selectGoal("Notify"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyGoalIsSelected("Notify", true); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.selectNext(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifySelectedStep("Audience"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.selectNext(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifySelectedStep("Delivery"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.setDeliveryMethodScheduled("01/02/2021"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyScheduledDate("2 Jan 2021"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.selectNext(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifySelectedStep("Actions"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.setActionPushNotification(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.setNotificationMessage("My notification"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyStartCampaignButtonIsEnabled(true); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.goToCampaigns(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignInList("My campaign", true); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignCreatedBy("My campaign", "Dimitrina Valkovska"); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignChannel("My campaign", "Push Notification"); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.openCampaign("My campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyCampaignName("My campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.startCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.goToCampaigns(); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.verifyCampaignIsActive("My campaign", true); 
		/* SDT::Line */ 
		TestObjectsDSL.sCampaignsTab.openCampaign("My campaign"); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.endCampaign(); 
		/* SDT::Line */ 
		TestObjectsDSL.sNewCampaignDialog.verifyCampaignFinished(); 
	}
}
