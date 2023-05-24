package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Highlighter {

    /**
     * Resalta un elemento en la página web cambiando su estilo. Utiliza JavaScript para cambiar el atributo "style"
     * del elemento y le aplica un fondo rojo y un borde negro.
     * Luego, espera 500 milisegundos y restaura el estilo original del elemento.
     *
     * @param driver  El controlador del navegador web.
     * @param element El elemento a resaltar.
     */
    public static void highlightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor javascript=(JavascriptExecutor)driver;

        javascript.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid black;');", element);

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
        javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
}
