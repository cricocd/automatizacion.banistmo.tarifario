package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import userinterfaces.BanistmoHomePage;

import static net.serenitybdd.screenplay.actions.Click.on;
import static net.serenitybdd.screenplay.actions.Open.browserOn;

public class Open implements Task {

    private BanistmoHomePage banistmoHomePage;

    public static Open banistmoHomePage() {

        return Tasks.instrumented(Open.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                browserOn(banistmoHomePage)
        );
    }
}
