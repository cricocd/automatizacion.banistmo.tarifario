package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

import static net.serenitybdd.screenplay.targets.Target.the;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://www.banistmo.com/wps/portal/banistmo/personas/")

public class BanistmoHomePage extends PageObject {

    public static final Target TARIFFS_BUTTOM = the("tariffs buttom")
            .located(xpath("//footer[@id=\"footer-content\"]/div[2]/div/div/div[2]/div/ul/li[5]/a"));

}
