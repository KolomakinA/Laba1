package carpspot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04.03.2017.
 * address: http://carpspot.ua/shop/carp/user/login/
 * login: kolomakin@gmail.com
 * pass: 123456qwe
 */
public class Tests {
    WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        synchronized (driver){
            driver.wait(5000);
        }
        //driver.quit();
    }

    @Test(priority = 1)
    public void logInTest(){
        carpspot.login.Methods loginM = new carpspot.login.Methods(driver);
        carpspot.login.Locators loginL = new carpspot.login.Locators();

        driver.get("http://carpspot.ua/shop/carp/user/login/");

        Assert.assertTrue(loginM.findElement(loginL.mailLoginField).isDisplayed(), "Error: The e-mail field is not displayed!");
        Assert.assertTrue(loginM.findElement(loginL.passLoginField).isDisplayed(), "Error: The password field is not displayed!");
        Assert.assertTrue(loginM.findElement(loginL.submitButton).isDisplayed(), "Error: The \"Вход\" button is not displayed!");

        loginM.provideLogin("kolomakin@gmail.com", loginL.mailLoginField);
        loginM.providePass("123456qwe", loginL.passLoginField);
        loginM.submitForm(loginL.submitButton);

        Assert.assertTrue(loginM.findElement(loginL.myAccount).getText().equalsIgnoreCase("Моя учётная запись"), "Error: cannot find \"Моя учётная запись\" text");
    }

    @Test(priority = 2)
    public void findAGood(){
        carpspot.catalog.Methods catalogM = new carpspot.catalog.Methods(driver);
        carpspot.catalog.Locators catalogL = new carpspot.catalog.Locators();

        Assert.assertTrue(catalogM.findElement(catalogL.snastiSection).isDisplayed());

        catalogM.selectSnastiSection("Удилища и аксессуары",catalogL.snastiSection,catalogL.udilischaSection);

    }

    //@Test(priority = 3)



}
