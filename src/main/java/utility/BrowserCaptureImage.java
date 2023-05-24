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
    public static void captureImage(WebDriver driver) throws IOException {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String localDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss"));
        String filename = "captureImage" + "_" + methodName + "_" + localDateTime + ".png";
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshotFile, new File("new" + filename));
    }
}
