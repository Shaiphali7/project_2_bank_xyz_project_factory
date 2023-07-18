package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")

    WebElement homeButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    public void clickOnHomeButton()
    {
        clickOnElement(homeButton);
        CustomListeners.test.log(Status.PASS, "Click on homeButton");
    }
    public void clickOnCustomerLogin()
    {
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS, "Click on customer login Button");
    }
    public void clickOnBankManagerLogin()
    {
        clickOnElement(bankManagerLogin);
        CustomListeners.test.log(Status.PASS, "Click on bank manager login Button");
    }

}
