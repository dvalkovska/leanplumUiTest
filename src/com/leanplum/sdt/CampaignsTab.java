
package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;


public interface CampaignsTab  {
    	
	@AddAppState({NewCampaignDialog.class})@RemoveAppState({CampaignsTab.class})
	    
	
	public NewCampaignDialog newCampaign( );

	@AddAppState({NewCampaignDialog.class})@RemoveAppState({CampaignsTab.class})
	@Params({"campaignName="})    
	
	public NewCampaignDialog openCampaign(String campaignName);

	
	@Params({"campaignName=", "isInList="})    
	
	public void verifyCampaignInList(String campaignName, Boolean isInList);

	
	@Params({"campaignName=", "channel="})    
	
	public void verifyCampaignChannel(String campaignName, String channel);

	
	@Params({"campaignName=", "name="})    
	
	public void verifyCampaignCreatedBy(String campaignName, String name);

	
	@Params({"campaignName=", "number="})    
	
	public void verifyCampaignUsers(String campaignName, String number);
	
	
	public void verifyCampaignIsActive(String name, Boolean isActive);

}
