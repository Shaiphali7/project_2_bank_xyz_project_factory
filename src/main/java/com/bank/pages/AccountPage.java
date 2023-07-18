package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawlButton;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountToBeDeposit;
    @CacheLookup
    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositButtonAfterDeposit;
    @CacheLookup
    @FindBy(xpath ="//button[text()='Withdraw']")
    WebElement withdrawalButtonAfterWithdrawal;
    @CacheLookup
    @FindBy(xpath ="//span[contains(text(),'Deposit Successful')]")
    WebElement successMessageAfterDeposit;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")

    WebElement successMessageAfterWithdrawal;


    public void clickOnDepositButton() {
        clickOnElement(depositButton);
        CustomListeners.test.log(Status.PASS, "Click on depositButton");
    }

    public void clickOnWithdrawalButton() {
        clickOnElement(withdrawlButton);
        CustomListeners.test.log(Status.PASS, "Click on withdrawlButton");
    }

    public void clickOnDepositButtonAfterDeposit() {
        clickOnElement(depositButtonAfterDeposit);
        CustomListeners.test.log(Status.PASS, "Click on deposit Button After Deposit");
    }

    public void sendAmountToDeposit(String amount) {
        sendTextToElement(amountToBeDeposit, amount);
        CustomListeners.test.log(Status.PASS, "Send amount");

    }

    public String getSuccessMessageAfterDeposit() {
        return getTextFromElement(successMessageAfterDeposit);
    }

    public void clickOnWithdrawalButtonAfterWithdrawal() {
        clickOnElement(withdrawalButtonAfterWithdrawal);
        CustomListeners.test.log(Status.PASS, "Click on withdrawal Button After Withdrawal");
    }

    public String getSuccessMessageAfterWithdrawal() {
        return getTextFromElement(successMessageAfterWithdrawal);
    }

}
