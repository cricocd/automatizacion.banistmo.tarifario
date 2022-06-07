package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.tools.ant.taskdefs.Tar;
import userinterfaces.BanistmoHomePage;
import userinterfaces.TariffsSection;

import static net.serenitybdd.screenplay.actions.Click.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.waits.WaitUntil.*;
import static userinterfaces.BanistmoHomePage.*;
import static userinterfaces.TariffsSection.*;

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
