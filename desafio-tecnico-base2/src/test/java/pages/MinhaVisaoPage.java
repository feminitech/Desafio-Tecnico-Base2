package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MinhaVisaoPage {
    private WebDriverWait wait;
    
    private By NomeUsuarioCabecalho = By.linkText("nayara.valadares ( Nayara Valadares )");

    public MinhaVisaoPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 10);
    }

    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(NomeUsuarioCabecalho));
    }

    public String obterNomeUsuarioCabecalho() {
        WebElement nomeUsusario = wait.until(ExpectedConditions.visibilityOfElementLocated(NomeUsuarioCabecalho));
        WebElement nomeUsuarioElement = nomeUsusario.findElement(By.linkText("nayara.valadares ( Nayara Valadares )"));
        return nomeUsuarioElement.getText();
    }

}
