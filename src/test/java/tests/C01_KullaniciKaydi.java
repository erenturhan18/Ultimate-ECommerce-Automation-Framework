package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_KullaniciKaydi {


    @Test
    public void test01() {
        AutomationExercisePage aePage = new AutomationExercisePage();
        Faker faker = new Faker();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        aePage.signupLoginButonu.click();
        Assert.assertTrue(aePage.newUserSignupYazisi.isDisplayed());
        aePage.signupNameKutusu.sendKeys(faker.name().fullName());
        aePage.signupEmailKutusu.sendKeys(faker.internet().emailAddress());
        aePage.signupButonu.click();
        aePage.genderMale.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.click(aePage.passwordKutusu)
                .sendKeys("Sifre123")
                .sendKeys(Keys.TAB)
                .sendKeys("10")
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys("Tech Academy")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Texas")
                .sendKeys(Keys.TAB)
                .sendKeys("Dallas")
                .sendKeys(Keys.TAB)
                .sendKeys("75001")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Assert.assertTrue(aePage.accountCreatedYazisi.isDisplayed());

    }
    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }


}
