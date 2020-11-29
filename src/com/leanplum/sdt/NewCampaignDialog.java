
package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;


public interface NewCampaignDialog  {
    	
	@AddAppState({CampaignsTab.class})@RemoveAppState({NewCampaignDialog.class})
	    
	
	public CampaignsTab goToCampaigns( );

	
	@Params({"message="})    
	
	public void setNotificationMessage(String message);

	
	@Params({"name="})    
	
	public void verifyCampaignName(String name);

	
	@Params({"goal="})    
	
	public void selectGoal(String goal);

	
	@Params({"goal=", "isSelected="})    
	
	public void verifyGoalIsSelected(String goal, Boolean isSelected);

	
	    
	
	public void selectNext( );

	
	    
	
	public void verifySelectedStep(String stepName);
	
	
	public void verifyStartCampaignButtonIsEnabled(Boolean isEnabled);

	
	@Params({"date="})    
	
	public void setDeliveryMethodScheduled(String date);

	
	    
	
	public void setActionPushNotification( );

	
	    
	
	public void startCampaign( );

	
	@NewAppState({CampaignSettingsDialog.class})
	    
	
	public CampaignSettingsDialog renameCampaign( );
	
	
	public void verifyScheduledDate(String date);
	
	public void endCampaign();
	
	public void verifyCampaignFinished();

}
