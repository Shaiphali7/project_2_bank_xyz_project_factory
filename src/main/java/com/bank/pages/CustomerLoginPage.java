package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")

    WebElement yourName;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement login;

    public void selectYourName(String option)
    {
        selectByVisibleTextFromDropDown(yourName,option);
        CustomListeners.test.log(Status.PASS, "Select from dropdown");
    }
    public void clickOnLogin()
    {
        clickOnElement(login);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }


}
