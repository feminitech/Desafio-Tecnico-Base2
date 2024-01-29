package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TarefasPage {
    private WebDriver driver;

    private By resumoField = By.id("summary");
    private By descricaoField = By.id("description");
    private By criarTarefaButton = By.className("btn btn-primary btn-white btn-round");
    private By popupMensagemErro = By.linkText("Preencha este campo.");

    public TarefasPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherCampos(String resumo, String descricao) {
        WebElement resumoElement = driver.findElement(resumoField);
        resumoElement.sendKeys(resumo);

        WebElement descricaoElement = driver.findElement(descricaoField);
        descricaoElement.sendKeys(descricao);
    }

    public void clicarCriarTarefa() {
        WebElement criarTarefaButtonElement = driver.findElement(criarTarefaButton);
        criarTarefaButtonElement.click();
    }

    public void clicarCriarTarefaSemPreencherCampos() {
        WebElement criarTarefaButtonElement = driver.findElement(criarTarefaButton);
        criarTarefaButtonElement.click();
    }

    public String obterPopupMensagemErro() {
        WebElement popupMensagemErroElement = driver.findElement(popupMensagemErro);
        return popupMensagemErroElement.getText();
    }

    public boolean isPaginaReporteBugAberta() {
        return driver.findElement(resumoField).isDisplayed();
    }
}
