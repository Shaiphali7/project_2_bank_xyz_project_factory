package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='addCust()']")

    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='showCust()']")

    WebElement customers;

    public void clickOnAddCustomer() {
        clickOnElement(addCustomer);
        CustomListeners.test.log(Status.PASS, "Click on addCustomerButton");

    }

    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS, "Click on openAccount");

    }

    public void clickOnCustomers() {
        clickOnElement(customers);
        CustomListeners.test.log(Status.PASS, "Click on customers");
    }

}
