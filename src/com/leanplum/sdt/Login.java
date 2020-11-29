
package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;


public interface Login  {
    	
	
	@Params({"username=Administrator", "password=IllegalPassword", "provider="})    
	
	public void verifyLoginFailure(String username, String password, String provider);

	@SetAppState({SideNavigationBar.class})
	@Params({"username=Administrator", "password=Administrator"})    
	
	public void login(String username, String password);

}
