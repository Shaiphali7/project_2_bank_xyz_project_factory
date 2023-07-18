package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")

    WebElement customerName;
    By customerName1=By.xpath("//option[@ng-repeat='cust in Customers']");
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameClick;
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    By processButton=By.xpath("//button[contains(text(),'Process')]");
    public void selectFromCustomerDropDwn(String option) {
        clickOnElement(customerNameClick);
        try {
            List<WebElement> userManagementList = driver.findElements(customerName1);
            for (WebElement element :userManagementList ) {
                if (element.getText().equals(option)) {
                    element.click();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectCustomerName(String option)
    {
        selectByVisibleTextFromDropDown(customerName,option);
        CustomListeners.test.log(Status.PASS, "Select from dropdown");
    }

    public void selectCurrency(String option)
    {
        selectByVisibleTextFromDropDown(currency,option);
    }
    public void clickOnProcessButton()
    {
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS, "Click on processButton");
    }

}
