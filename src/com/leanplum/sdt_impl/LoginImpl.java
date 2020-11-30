package com.leanplum.sdt_impl;

import org.junit.Assert;

import com.borland.silk.sdt.appstates.Implemented;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import com.leanplum.sdt.Login;




public class LoginImpl implements Login {

	private Desktop desktop = SdtInit.sDesktop;
	
	@Override
	@Implemented
	public void verifyLoginFailure(String username, String password,
			String message) {
		loginUser(username, password);
		Assert.assertTrue(desktop.exists("//form//DIV[@textContents='"+message+"*']"));		//webdriver locator: "By.xpath("(//form//div[starts-with(text(),\"+message)])")"
	}

	@Implemented
	@Override
	public void login(String username, String password) {
		loginUser(username, password);
		
		//verify successful login
		desktop.waitForObject("//DIV[@class='side-nav-view']", 5);
		DomElement navBar = desktop.<DomElement> find("//DIV[@class='side-nav-view']");		//webdriver locator: "By.className("side-nav-view")"
		Assert.assertTrue(desktop.exists(navBar.getLocator()));
	}

	private void loginUser(String username, String password) {
		DomTextField email = desktop.<DomTextField>find("//INPUT[@name='email']"); 		//webdriver locator: "By.xpath("(//input[@name=\"email\"])"
		DomTextField pass = desktop.<DomTextField>find("//INPUT[@name='password']");	//webdriver locator: "By.xpath("(//input[@name=\"password\"])")"
		DomButton login = desktop.<DomButton>find("//BUTTON[@textContents='Log in']");	//webdriver locator: "By.xpath("//button[text()=\"Log in\"]")"

		email.clearText();
		email.typeKeys(username);
		pass.clearText();
		pass.typeKeys(password);
		login.click();
	}
}
