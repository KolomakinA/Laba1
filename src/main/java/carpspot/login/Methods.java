package carpspot.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by user on 04.03.2017.
 */
public class Methods {
    WebDriver driver;
    public Methods (WebDriver driver){this.driver=driver;}

    public WebElement findElement(String s){return  driver.findElement(By.xpath(s));}

    public void provideLogin(String mail, String selecor){
        WebElement e = driver.findElement(By.xpath(selecor));
        e.sendKeys(mail);
    }

    public void providePass(String pass, String selecor){
        WebElement e = driver.findElement(By.xpath(selecor));
        e.sendKeys(pass);
    }

    public void submitForm (String selecor){
        WebElement e = driver.findElement(By.xpath(selecor));
        e.submit();
    }
}
