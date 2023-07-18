package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage home;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage customerPage;
    OpenAccountPage accountPage;
    CustomerLoginPage login;
    CustomerPage customer;
    AccountPage depositAndWithdrawal;
    @BeforeMethod(groups = {"sanity","smoke","regression","regression1"})
    public void inIt()
    {
        home = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        customerPage = new AddCustomerPage();
        accountPage=new OpenAccountPage();
        login=new CustomerLoginPage();
        customer=new CustomerPage();
        depositAndWithdrawal=new AccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException{
//        click On "Bank Manager Login" Tab
        home.clickOnBankManagerLogin();
//        click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomer();
//        enter FirstName
        customerPage.setFirstName("Sonia");
//        enter LastName
        customerPage.setLastName("Jojo");
//        enter PostCode
        customerPage.setPostCode("DE735XS");
//        click On "Add Customer" Button
        Thread.sleep(5000);
        customerPage.clickOnAddCustomerButton();
//        popup display
//        verify message "Customer added successfully"
        String actualMessage = customerPage.getTextFromAlert();
        String exceptedMessage = "Customer added successfully with customer id :6";
        Assert.assertEquals(actualMessage, exceptedMessage, "account is not added");

//        click on "ok" button on popup.
        customerPage.dismissAlert();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException{
//        click On "Bank Manager Login" Tab
           home.clickOnBankManagerLogin();
//        click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccount();

        Thread.sleep(1000);
        //accountPage.refreshMethod();
//        Search customer that created in first test

        accountPage.selectCustomerName("Harry Potter");

//        Select currency "Pound"
        accountPage.selectCurrency("Pound");
//        click on "process" button
        accountPage.clickOnProcessButton();
//        popup displayed
//        verify message "Account created successfully"
        String actualMessage=accountPage.getTextFromAlert();
        String expectedMessage="Account created successfully with account Number :1016";
        Assert.assertEquals(actualMessage,expectedMessage);
//        click on "ok" button on popup.
        accountPage.acceptAlert();
    }
    @Test(groups = {"regression1","regression"})
    public void customerShouldLoginAndLogoutSuccessfully()
    throws InterruptedException{
//        click on "Customer Login" Tab
        home.clickOnCustomerLogin();
//        search customer that you created.
        login.selectYourName("Harry Potter");

//            click on "Login" Button
        login.clickOnLogin();
        Thread.sleep(2000);
//        verify "Logout" Tab displayed.
        String actualLogout=customer.getTextFromLogoutButton();
        Assert.assertEquals(actualLogout,"Logout","Logout button not displayed");
//        click on "Logout"
        customer.clickOnLogout();
//        verify "Your Name" text displayed.
        String actualYourNameText=customer.getTextFromLogOutDropDown();
        String expectedText="---Your Name---";
        Assert.assertEquals(actualYourNameText,expectedText,"You haven't logout");
    }

    @Test(groups = {"regression1","regression"})
    public void  customerShouldDepositMoneySuccessfully() {
//        click on "Customer Login" Tab
        home.clickOnCustomerLogin();
//        search customer that you created.
        login.selectYourName("Harry Potter");
//                click on "Login" Button
        login.clickOnLogin();
//        click on "Deposit" Tab
        depositAndWithdrawal.clickOnDepositButton();
//        Enter amount 100
        depositAndWithdrawal.sendAmountToDeposit("100");
//        click on "Deposit" Button
        depositAndWithdrawal.clickOnDepositButtonAfterDeposit();
//        verify message "Deposit Successful"
        String actualMessage=depositAndWithdrawal.getSuccessMessageAfterDeposit();
        Assert.assertEquals(actualMessage,"Deposit Successful","Deposit is not successful");
    }
    @Test(groups = {"regression1","regression"})
    public void customerShouldWithdrawMoneySuccessfully() {
//        click on "Customer Login" Tab
        login.clickOnLogin();
//        search customer that you created.
        login.selectYourName("Hermoine Granger");
//         click on "Login" Button
        login.clickOnLogin();
//        click on "Withdrawl" Tab
        depositAndWithdrawal.clickOnWithdrawalButton();
//        Enter amount 50
        depositAndWithdrawal.sendAmountToDeposit("50");
//        click on "Deposit" Button
        depositAndWithdrawal.clickOnWithdrawalButtonAfterWithdrawal();
//        verify message "Transaction Successful"
        String actualMessage=depositAndWithdrawal.getSuccessMessageAfterWithdrawal();
        String expectedMessage="Transaction successful";
        Assert.assertEquals(actualMessage,expectedMessage,"Withdrawal failed");
    }



}
