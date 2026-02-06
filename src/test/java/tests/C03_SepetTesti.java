package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.AutomationExercisePage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class C03_SepetTesti {
    protected ExtentReports extentReports;
    protected ExtentSparkReporter extentSparkReporter;
    protected ExtentTest extentTest;

    @BeforeClass
    public void raporuBaslat(){
        extentReports = new ExtentReports();
        java.util.Locale.setDefault(java.util.Locale.ENGLISH);
        String filePath = System.getProperty("user.dir") + "/test-output/Rapor.html";

        File klasor = new File(System.getProperty("user.dir") + "/test-output");
        if (!klasor.exists()) { klasor.mkdirs(); }

        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Otomasyon Test Raporu");
        extentSparkReporter.config().setReportName("Sepet Testi Sonuçları");
    }







    @Test
    public void testSepeteUrunEkleme() {

        extentTest = extentReports.createTest("Sepet Testi", "Ürün arama ve sepete ekleme testi");
        AutomationExercisePage aePage = new AutomationExercisePage();

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        extentTest.info("Ana sayfaya gidildi");

        aePage.productsButonu.click();
        extentTest.info("Products butonuna tıklandı");

        ReusableMethods.reklamGecerseKapat();
        if (!Driver.getDriver().getCurrentUrl().contains("products")) {
            aePage.productsButonu.click();
        }

        aePage.aramaKutusu.sendKeys("Blue Top");
        aePage.aramaButonu.click();
        extentTest.info("Ürün araması yapıldı: Blue Top");

        ReusableMethods.jsClick(aePage.ilkUrunAddToCart);
        ReusableMethods.jsClick(aePage.ilkUrunAddToCart);
        aePage.viewCartLinki.click();
        extentTest.info("Ürün sepete eklendi ve sepete gidildi");

        String actualUrunIsmi = aePage.sepettekiUrunIsmi.getText();
        Assert.assertEquals(actualUrunIsmi, "Blue Top");

        extentTest.pass("Sepetteki ürün isminin 'Blue Top' olduğu doğrulandı.");
        extentReports.flush();


    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotPath);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.skip("Test skipped: " + result.getName());
        }
    }




   @AfterClass
   public void sonlandir() {
       extentReports.flush();
       Driver.closeDriver();
       System.out.println("İŞLEM TAMAM: Rapor diske yazıldı.");
   }


}
