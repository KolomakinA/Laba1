package carpspot.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by user on 04.03.2017.
 */
public class Methods {
    WebDriver driver;
    public Methods (WebDriver driver){this.driver=driver;}

    //-------------
    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}

    public void checkCart(String openBracketButton){
        WebElement ob = driver.findElement(By.xpath(openBracketButton));
        ob.click();
    }
}
