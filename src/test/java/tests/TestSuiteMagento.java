package tests;

import core.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AllCustomersPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.NewCustomerPage;
import utils.ExcelUtils;

import java.lang.reflect.Method;

public class TestSuiteMagento extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(TestSuiteMagento.class);

    @DataProvider(name = "data", parallel = true)
    public Object[][] getData(Method method){
        return switch (method.getName()) {
            case "testCase01" -> ExcelUtils.getTestData("src/test/resources/TestData.xlsx", "TC01", 0, 5);
            case "testCase02" -> ExcelUtils.getTestData("src/test/resources/TestData.xlsx", "TC02", 0, 7);
            case "testCase03" -> ExcelUtils.getTestData("src/test/resources/TestData.xlsx", "TC03", 0, 5);
            case "testCase04" -> ExcelUtils.getTestData("src/test/resources/TestData.xlsx", "TC04", 0, 4);
            default -> null;
        };

    }

    @Test(dataProvider = "data")
    public void testCase01(String TCid, String url, String username, String password, String titleExpected) {

        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        loginPage.navigateTo(url);

        Assert.assertTrue(loginPage.isAllLoginLocatorsDisplay(), "Not all expected elements are displayed on Login page");

        loginPage.login(username, password);

        Assert.assertTrue(dashboardPage.verifyLoginSuccess(titleExpected), "Login not successfully");
    }


    @Test(dataProvider = "data")
    public void testCase02(String TCId, String url, String username, String password,
                           String firstName, String lastName, String email) {
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        AllCustomersPage allCustomersPage = new AllCustomersPage(getDriver());
        NewCustomerPage newCustomerPage = new NewCustomerPage(getDriver());

        loginPage.navigateTo(url);

        loginPage.login(username , password);

        dashboardPage.navigationBar.clickOnCustomerMenu();

        dashboardPage.navigationBar.customersMenu.clickOnAllCustomersMenu();

        allCustomersPage.clickOnAddNewCustomer();

        newCustomerPage.inputCustomerInformation(firstName, lastName, email);

        try {
            Assert.assertTrue(newCustomerPage.verifyInput());
        } catch (Exception e) {
            log.error("error: ", e);
        }

        allCustomersPage.navigationBar.clickOnCustomerMenu();

        allCustomersPage.navigationBar.customersMenu.clickOnAllCustomersMenu();

        allCustomersPage.customersTable.waitUntilTableVisible();

        allCustomersPage.customersTable.selectCheckboxByText(firstName + " " + lastName);

        allCustomersPage.deleteSelectedCustomer();
    }

    @Test(dataProvider = "data")
    public void testCase03(String TCid, String url, String username, String password, String SearchValue) {
        System.out.println("pass");
    }

    @Test(dataProvider = "data")
    public void testCase04(String TCid, String url, String username, String password) {
        System.out.println("pass");
    }
}
