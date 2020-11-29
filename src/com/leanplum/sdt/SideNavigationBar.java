
package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;


public interface SideNavigationBar  {
    	
	@AddAppState({CampaignsTab.class})
	    
	
	public CampaignsTab selectCampaignsTab( );

}
