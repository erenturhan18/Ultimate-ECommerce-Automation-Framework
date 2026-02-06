package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_LoginTesti {


    @Test
    public void testBasariliLogin(){
        AutomationExercisePage aePage = new AutomationExercisePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        aePage.signupLoginButonu.click();
        aePage.loginEmailKutusu.sendKeys(ConfigurationReader.getProperty("gecerliEmail"));
        aePage.loginPasswordKutusu.sendKeys(ConfigurationReader.getProperty("gecerliSifre"));
        aePage.loginButonu.click();
        Assert.assertTrue(aePage.loggedInAsYazisi.isDisplayed());


    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void testNegatifLogin(){
        AutomationExercisePage aePage = new AutomationExercisePage();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        aePage.signupLoginButonu.click();
        aePage.loginEmailKutusu.sendKeys(ConfigurationReader.getProperty("gecerliEmail"));
        aePage.loginPasswordKutusu.sendKeys("yanlisSifre123");
        aePage.loginButonu.click();
        Assert.assertTrue(aePage.loginHataMesaji.isDisplayed());

    }
    @AfterMethod
    public void tearDown1() {
        Driver.closeDriver();
    }











}
