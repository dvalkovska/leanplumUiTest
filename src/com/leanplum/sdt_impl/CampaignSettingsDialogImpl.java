package com.leanplum.sdt_impl;

import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.leanplum.sdt.CampaignSettingsDialog;

public class CampaignSettingsDialogImpl implements CampaignSettingsDialog {

	private Desktop desktop = SdtInit.sDesktop;

	private String campaignSettingsDialog = "//DIV[@Text='Campaign Settings']/../../div";	//webdriver locator: "By.xpath("//p[text()='Campaign Settings']/../../../div")"

	@Override
	@Implemented
	public void setName(String name) {
		DomTextField inputName = desktop.<DomTextField>find(campaignSettingsDialog+"//INPUT[@placeholder='Campaign Name']");
		inputName.click();
		inputName.clearText();
		inputName.typeKeys(name);
	}

	@Override
	@Implemented
	public void clickSave() {
		desktop.<DomElement>find(campaignSettingsDialog+"//SPAN[@textContents='Save']").click();
	}

	@Override
	@Implemented
	public void clickCancel() {
		desktop.<DomElement>find(campaignSettingsDialog+"//SPAN[@textContents='Cancel']").click();
	}

	@Override
	public void clickClose() {
		// TODO Auto-generated method stub

	}

}
