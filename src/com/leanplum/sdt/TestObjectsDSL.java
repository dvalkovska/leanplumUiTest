
package com.leanplum.sdt;

import com.leanplum.sdt_impl.*;

public class TestObjectsDSL {
	public static SdtInit sSdtInit = new SdtInit();
	
	public static Start sStart = new StartImpl();
    	
	public static Login sLogin = new LoginImpl(); 

	public static SideNavigationBar sSideNavigationBar = new SideNavigationBarImpl(); 

	public static CampaignsTab sCampaignsTab = new CampaignsTabImpl(); 

	public static CampaignSettingsDialog sCampaignSettingsDialog = new CampaignSettingsDialogImpl(); 

	public static NewCampaignDialog sNewCampaignDialog = new NewCampaignDialogImpl(); 

}
