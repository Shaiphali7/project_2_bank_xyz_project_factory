package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOut;
    @CacheLookup
    @FindBy(xpath = "//option[contains(text(),'---Your Name---')]")
    WebElement logOutDropDown;
    public String getTextFromLogoutButton()
    {
        return getTextFromElement(logOut);
    }
    public void clickOnLogout()
    {
        clickOnElement(logOut);
        CustomListeners.test.log(Status.PASS, "Click on logoutButton");
    }
    public String getTextFromLogOutDropDown()
    {
        return getTextFromElement(logOutDropDown);
    }


}
