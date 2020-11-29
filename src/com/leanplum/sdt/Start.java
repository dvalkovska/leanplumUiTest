

package com.leanplum.sdt;

import com.borland.silk.sdt.appstates.*;

@StartObject

public interface Start  {
    	
	@NewAppState({Login.class})
	    
	
	public void start( );

}
	