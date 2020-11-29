
package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;


public interface CampaignSettingsDialog  {
    	
	
	@Params({"name="})    
	
	public void setName(String name);

	@RestoreAppState
	    
	
	public void clickSave( );

	@RestoreAppState
	    
	
	public void clickCancel( );

	@RestoreAppState
	    
	
	public void clickClose( );

}
