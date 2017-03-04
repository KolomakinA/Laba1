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

    public void selectSnastiSection(String selecorSnasti, String selecorUdilischa){
        Actions action = new Actions(driver);
        WebElement snastiC = driver.findElement(By.xpath(selecorSnasti));
        WebElement udilischaC = driver.findElement(By.xpath(selecorUdilischa));
        action.moveToElement(snastiC).moveToElement(udilischaC).click().build().perform();
    }

    public void selectAparticularRod(String rodSelector){
        WebElement rod = driver.findElement(By.xpath(rodSelector));
        rod.click();
    }

    public String savePrice(String pri){
        WebElement price = driver.findElement(By.xpath(pri));
        return price.getText();
    }

    public void toCart(String buttonSelector){
        WebElement toCartButton = driver.findElement(By.xpath(buttonSelector));
        toCartButton.click();
    }


}
