package carpspot.cart;

/**
 * Created by andrii kolomakin on 04.03.2017.
 */
public class Locators {
    public String openCart = "//div[@class='div_button_a']/a[text()='Открыть корзину']";
    public String price = "//table/tbody/tr[2]/td[5]";
    public String cartContent = "//h1[text()='Содержимое корзины']";
    public String checkOut = "//a[@class='button cart_btn_2'][text()='Оформить заказ']";
    public String submit = "//button[@name='submit'][@value='Заказать']";
}
