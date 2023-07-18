package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")

    WebElement firstName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;

    public void setFirstName(String option)
    {
       sendTextToElement(firstName,option);
        CustomListeners.test.log(Status.PASS, "Enter firstname " + firstName);
    }

    public void setLastName(String option)
    {
        sendTextToElement(lastName,option);
        CustomListeners.test.log(Status.PASS, "Enter lastName" + lastName);
    }
    public void setPostCode(String option)
    {
        sendTextToElement(postCode,option);
        CustomListeners.test.log(Status.PASS, "Enter postCode " + postCode);
    }
    public void clickOnAddCustomerButton()
    {
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

}
