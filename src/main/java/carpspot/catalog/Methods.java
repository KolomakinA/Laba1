package carpspot.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by user on 04.03.2017.
 */
public class Methods {
    WebDriver driver;
    public Methods (WebDriver driver){this.driver=driver;}

    //-------------
    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}

    public void selectSnastiSection(String category, String selecorSnasti, String selecorUdilischa){
        Actions action = new Actions(driver);
        WebElement snastiC = driver.findElement(By.xpath(selecorSnasti));
        WebElement udilischaC = driver.findElement(By.xpath(selecorUdilischa));
        action.moveToElement(snastiC).moveToElement(udilischaC).click().build().perform();
    }


}
