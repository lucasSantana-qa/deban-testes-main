package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.DatabaseActions;
import solutions.b2.deban.base.BaseTest;
import solutions.b2.deban.propriedades.DatabaseProps;

import static solutions.b2.deban.utils.Utils.*;

public class DatabaseTest extends BaseTest implements DatabaseProps {

    DatabaseActions databaseActions = new DatabaseActions();

    @Test
    @Feature("Arquivo Database")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhaHeader() {
        int tamanhoLinha = getLinha(databaseNomeArq, 0).length();
        databaseActions.validarTamanhoDaLinha(tamanhoLinha);
    }

    @Test
    @Feature("Arquivo Database")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String nomeArquivo = getLinha(databaseNomeArq,0).substring(0,8).trim();
        validarCampoNome("DATABASE", nomeArquivo);
    }

    @Test
    @Feature("Arquivo Database")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(databaseNomeArq);
    }

    @Test
    @Feature("Arquivo Database")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String cnpjArquivo = getLinha(databaseNomeArq, 0).substring(16, 24).trim();
        validarCampoCnpj(cnpjArquivo);
    }

    @Test
    @Feature("Arquivo Database")
    @Description("Valida o campo 'Database', deve conter no, formato yyyy-MM, o ultimo mês do trimestre de referência")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDatabaseHeader() {
        String campoDB = getLinha(databaseNomeArq, 0).substring(28, 30);
        databaseActions.validarCampoDataBase(campoDB);
    }
}
