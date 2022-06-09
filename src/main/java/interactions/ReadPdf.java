package interactions;

import com.itextpdf.text.pdf.PdfReader;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.itextpdf.text.pdf.parser.PdfTextExtractor.getTextFromPage;

public class ReadPdf implements Ability {

    private EnvironmentVariables environmentVariables;
    String downloadFolder;
    String fileName;
    private String pdfText;
    PdfReader pdfReader;



    public static final ResourceBundle serenityProperties = ResourceBundle.getBundle("serenity");
    static String rute = serenityProperties.getString("download.filesFolder");
    static String file = serenityProperties.getString("statements.fileName");
    static String statementFilePath = String.format("%s/%s", rute, file);

    public static ReadPdf downloadedInPath() throws IOException {
        return new ReadPdf();
    }

    public static ReadPdf as(Actor actor) {

        return actor.abilityTo(ReadPdf.class);
    }

    public String getText() throws IOException {

        int pagesNumber = pdfReader.getNumberOfPages();

        StringBuilder pdfText = new StringBuilder();

        for (int i = 1; i <= pagesNumber; i++) {

            pdfText.append(getTextFromPage(pdfReader, i));

        }
        return pdfText.toString();
    }
}
