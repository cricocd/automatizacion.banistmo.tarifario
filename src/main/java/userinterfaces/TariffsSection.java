package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.targets.Target.*;
import static org.openqa.selenium.By.*;

public class TariffsSection extends PageObject {
    public static final Target DEPOSIT_ACCOUNT_RATES_BUTTOM = the("deposit account rates buttom")
            .located(xpath("//div[@id=\"layoutContainers\"]/div/div[1]/section/div[2]/div[2]/div/div/table/tbody/tr[3]/td[2]/span/a/img"));

}
