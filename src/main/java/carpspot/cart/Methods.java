package carpspot.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by andrii kolomakin on 04.03.2017.
 */
public class Methods{
    private WebDriver driver;
    public Methods (WebDriver driver){this.driver=driver;}

    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}

    public void checkCart(String openBracketButton){
        WebElement ob = driver.findElement(By.xpath(openBracketButton));
        ob.click();
    }

    public void checkOut(String checkOut){
        WebElement chk = driver.findElement(By.xpath(checkOut));
        chk.click();
    }
}
