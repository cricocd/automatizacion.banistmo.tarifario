package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.the;
import static userinterfaces.BanistmoHomePage.TARIFFS_BUTTOM;
import static userinterfaces.TariffsSection.DEPOSIT_ACCOUNT_RATES_BUTTOM;

public class SelectTariffs implements Task {

    public static SelectTariffs andDownload(){
        return Tasks.instrumented(SelectTariffs.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                on(TARIFFS_BUTTOM),
                on(DEPOSIT_ACCOUNT_RATES_BUTTOM),
                the(DEPOSIT_ACCOUNT_RATES_BUTTOM, isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
