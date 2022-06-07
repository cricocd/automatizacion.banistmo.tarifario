package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import interactions.ReadPdf;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;
import questions.DepositAccountRates;
import tasks.Open;
import tasks.SelectTariffs;

import java.io.IOException;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TariffsStepDefinitons {

    private EnvironmentVariables environmentVariables;
    String downloadFolder;
    String fileName;

    @Before
    public void setStage(){
        setTheStage(new OnlineCast());
        theActorCalled("Chris");
    }

    @Given("^Chris entered in the banistmo page$")
    public void chrisEnteredInTheBanistmoPage() {
        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);

        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);
        theActorInTheSpotlight().wasAbleTo(Open.banistmoHomePage());
    }


    @When("^he download the Deposit Account Rates$")
    public void heDownloadTheDepositAccountRates() {
        theActorInTheSpotlight().attemptsTo(SelectTariffs.andDownload());

    }

    @Then("^he should read the Deposit Account Rates corectly$")
    public void heShouldReadTheDepositAccountRatesCorectly() throws IOException {
        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);
        theActorInTheSpotlight().whoCan(ReadPdf.downloadedInPath(statementFilePath));
        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();
        theActorInTheSpotlight().should(seeThat(DepositAccountRates.isCorrect(pdfText)));
    }

}
