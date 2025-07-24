package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.DescontoActions;
import solutions.b2.deban.base.BaseTest;
import solutions.b2.deban.propriedades.DescontoProps;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class DescontoTest extends BaseTest implements DescontoProps, UtilsDados {

    DescontoActions descontoActions = new DescontoActions();

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(descontoNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(descontoNomeArq, 0).substring(0,8);
        validarCampoNome("DESCONTO", campoNome);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(descontoNomeArq);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(descontoNomeArq, 0).substring(16,24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(descontoNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, descontoNomeArq);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(descontoNomeArq, descontoPosicoesLinhaFiller);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(descontoNomeArq);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        validarCampoTrimestre(descontoNomeArq);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Função' não aparece nenhum código além de 'C','D', e 'E'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFuncaoFiller() {
        validarCampoFuncao(descontoNomeArq, 5,6);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo bandeira não aparece nenhum outro código além de '1', '2', e '8'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoBandeiraFiller() {
        validarCampoBandeira(descontoNomeArq, 6,8);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Forma de captura' não aparece códigos além de '1', '2' e '5'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFormaCaptura() {
        validarCampoFormaCaptura(descontoNomeArq, 8,9);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Numero de parcelas' não aparece valores fora do intervalo 01-12 ")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNumParcelas() {
        validarCampoNumParcelas(descontoNomeArq,9,11);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Segmento' não aparece códigos fora do intervalo 400-428")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoSegmento() {
        validarCampoSegmento(descontoNomeArq, 11,14);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida a ausência de registro contendo a taxa de desconto mínima maior que a taxa de desconto máxima")
    @Severity(SeverityLevel.CRITICAL)
    public void testTaxaMinMenorQueTaxaMax() {
        descontoActions.validarTaxaMinMenorQueTaxaMax();
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida a ausência de registro contendo a taxa de desconto mínima maior que a taxa de desconto média")
    @Severity(SeverityLevel.CRITICAL)
    public void testTaxaMinMenorQueTaxaMed() {
        descontoActions.validarTaxaMinMenorQueTaxaMed();
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida a ausência de registro contendo a taxa de desconto máxima menor que a taxa de desconto média")
    @Severity(SeverityLevel.CRITICAL)
    public void testTaxaMaxMaiorQueTaxaMed() {
        descontoActions.validarTaxaMaxMaiorQueTaxaMed();
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Valor das transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.BLOCKER)
    public void testCampoValorTransacaoFiller() {
        validarCampoValorTransacaoDiferenteDeZero(descontoNomeArq, 30,45);
    }

    @Test
    @Feature("Arquivo Desconto")
    @Description("Valida se no campo 'Quantidade de transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.BLOCKER)
    public void testCampoQuantidadeTransacaoFiller() {
        validarCampoQuantidadeTransacaoDiferenteDeZero(descontoNomeArq, 45,57);
    }
}
