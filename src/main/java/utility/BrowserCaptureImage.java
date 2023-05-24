package utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BrowserCaptureImage {

    /**
     * Captura una imagen de la página web actual y la guarda en un archivo.
     *
     * @param driver El controlador del navegador web.
     * @throws IOException Si ocurre un error al capturar la imagen o guardar el archivo.
     */
    public static void captureImage(WebDriver driver) throws IOException {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
        String filename = "captureImage" + "_" + methodName + "_" + localDateTime + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshotFile, new File("new" + filename));
    }
}
