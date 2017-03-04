package carpspot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by andrii kolomakin on 04.03.2017.
 * address: http://carpspot.ua/shop/carp/user/login/
 * login: kolomakin@gmail.com
 * pass: 123456qwe
 */
public class Tests {
    private final WebDriver driver = new ChromeDriver();
    private String price;

    @BeforeSuite
    public void setUp(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        synchronized (driver){
            driver.wait(10000);
        }
        System.out.println("Testing complete. Seems that everything went fine.");
        System.out.println("Item's price is " + price);
        driver.quit();
    }

    @Test(priority = 1)
    public void testLogIn(){
        carpspot.login.Methods loginM = new carpspot.login.Methods(driver);
        carpspot.login.Locators loginL = new carpspot.login.Locators();

        driver.get("http://carpspot.ua/shop/carp/user/login/");

        Assert.assertTrue(loginM.findElement(loginL.mailLoginField).isDisplayed(),
                "Error: The e-mail field is not displayed!");
        Assert.assertTrue(loginM.findElement(loginL.passLoginField).isDisplayed(),
                "Error: The password field is not displayed!");
        Assert.assertTrue(loginM.findElement(loginL.submitButton).isDisplayed(),
                "Error: The \"Вход\" button is not displayed!");

        loginM.provideLogin("kolomakin@gmail.com", loginL.mailLoginField);
        loginM.providePass("123456qwe", loginL.passLoginField);
        loginM.submitForm(loginL.submitButton);

        Assert.assertTrue(loginM.findElement(loginL.myAccount).getText().
                equalsIgnoreCase("Моя учётная запись"),
                "Error: cannot find \"Моя учётная запись\" text");
    }

    @Test(priority = 2)
    public void testCatalog(){
        carpspot.catalog.Methods catalogM = new carpspot.catalog.Methods(driver);
        carpspot.catalog.Locators catalogL = new carpspot.catalog.Locators();

        Assert.assertTrue(catalogM.findElement(catalogL.snastiSection).isDisplayed());

        catalogM.selectSnastiSection(catalogL.snastiSection,catalogL.udilischaSection);
        catalogM.selectAparticularRod(catalogL.rod);
        price=catalogM.savePrice(catalogL.price);
        catalogM.toCart(catalogL.toCart);
        Assert.assertTrue(catalogM.findElement(catalogL.cart).isDisplayed(),
                "Error: The cart is not displayed");
        Assert.assertTrue(catalogM.findElement(catalogL.rodInCart).getText().
                equalsIgnoreCase("Rod Hutchinson Enduro Spod 12\""),
                "Error: required rod is not in the cart");
    }

    @Test(priority = 3)
    public void testCart(){
        carpspot.cart.Methods cartM = new carpspot.cart.Methods(driver);
        carpspot.cart.Locators cartL = new carpspot.cart.Locators();

        Assert.assertTrue(cartM.findElement(cartL.openCart).isDisplayed(),
                "Error: Open cart button is not displayed");
        cartM.checkCart(cartL.openCart);
        Assert.assertTrue(cartM.findElement(cartL.cartContent).isDisplayed(),
                "Error: the cart has not been displayed");
        Assert.assertTrue(cartM.findElement(cartL.price).getText().equalsIgnoreCase(price),
                "Error: individual item's price in the cart does not match the price in the catalog");
        cartM.checkOut(cartL.checkOut);
        Assert.assertTrue(cartM.findElement(cartL.submit).isDisplayed(),
                "Error: something went wrong and submit button is not displayed");

    }
}
