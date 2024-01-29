package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.LoginPage;
import pages.MinhaVisaoPage;
import pages.TarefasPage;
import util.WebDriverManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

public class LoginAndTarefasSteps {
    private WebDriver driver = WebDriverManager.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private MinhaVisaoPage minhaVisaoPage = new MinhaVisaoPage(driver);
    private TarefasPage tarefasPage = new TarefasPage(driver);

    @Given("^que estou logado no Mantis$")
    public void que_estou_logado_no_Mantis() {
        loginPage.navigateToLoginPage();
        loginPage.enterUsername("nayara.valadares");
        loginPage.enterPassword("testebase2");
        loginPage.clickLoginButton();
        minhaVisaoPage.waitForPageToLoad();
    }

    @When("^clicar no botão \"Criar Tarefa\"$")
    public void clicar_no_botão_Criar_Tarefa() {
        tarefasPage.clicarCriarTarefa();
    }

    @Then("^a página de reporte de bug deve ser aberta$")
    public void a_página_de_reporte_de_bug_deve_ser_aberta() {
        assertTrue(tarefasPage.isPaginaReporteBugAberta());
    }

    public boolean isPaginaReporteBugAberta() {
        WebElement resumoElement = driver.findElement(By.id("resumo"));
        return resumoElement.isDisplayed();
    }

    @When("^preencher os campos obrigatórios:$")
    public void preencher_os_campos_obrigatórios(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        tarefasPage.preencherCampos(data.get(0).get("Resumo"), data.get(0).get("Descrição"));
    }

    @And("^clicar no botão \"Criar Nova Tarefa\"$")
    public void clicar_no_botão_Criar_Nova_Tarefa() {
        tarefasPage.clicarCriarTarefa();
    }

    @And("^devo ser redirecionado para a página da tarefa criada$")
    public void devo_ser_redirecionado_para_a_página_da_tarefa_criada() {
        assertTrue(tarefasPage.isPaginaReporteBugAberta());
    }

    @When("^clicar no botão \"Criar Tarefa\" sem preencher os campos obrigatórios$")
    public void clicar_no_botão_Criar_Tarefa_sem_preencher_os_campos_obrigatórios() {
        tarefasPage.clicarCriarTarefaSemPreencherCampos();
    }

    @Then("^deve ser exibido um pop-up com a mensagem \"([^\"]*)\"$")
    public void deve_ser_exibido_um_pop_up_com_a_mensagem(String mensagem) {
        assertEquals(mensagem, tarefasPage.obterPopupMensagemErro());
    }
}
