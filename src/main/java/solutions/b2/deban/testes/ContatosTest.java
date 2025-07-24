package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.ContatosActions;
import solutions.b2.deban.base.BaseTest;
import solutions.b2.deban.propriedades.ContatosProps;
import solutions.b2.deban.utils.Utils;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class ContatosTest extends BaseTest implements UtilsDados, ContatosProps {
    ContatosActions contatosActions = new ContatosActions();

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        Utils.validarQuantidadePosicoesLinha(contatosNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeHeader() {
        String campoNome = getLinha(contatosNomeArq, 0).substring(0, 8);
        validarCampoNome("CONTATOS", campoNome);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCnpj = getLinha(contatosNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCnpj);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo Quantidade de Registros no header do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(contatosNomeArq, 0).substring(31, 32);
        Utils.validarCampoQuantidadeReg(campoQtdReg, contatosNomeArq);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(contatosNomeArq);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        contatosActions.validarQtdDePosicoesLinhasFillerContatos();
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(contatosNomeArq);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        Utils.validarCampoTrimestre(contatosNomeArq);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida se os contatos gerados estão correspondentes com os contatos esperados")
    @Severity(SeverityLevel.CRITICAL)
    public void testeValidaContatos() {
        contatosActions.validarContatos();
    }
}