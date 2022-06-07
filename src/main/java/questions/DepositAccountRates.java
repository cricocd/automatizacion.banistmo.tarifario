package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DepositAccountRates implements Question <Boolean> {

    private String pdfText;
    private String title = "Tarifas de cuentas de Dep\u00f3sitos";

    public DepositAccountRates (String pdfText) {
        this.pdfText = pdfText;
    }

    public static DepositAccountRates isCorrect(String pdfText) {

        return new DepositAccountRates(pdfText);
    }

    @Override
    public Boolean answeredBy(Actor actor){
        boolean result;
        result = pdfText.contains(title);
        return result;

    }
}
