package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.IntercamActions;
import solutions.b2.deban.propriedades.IntercamProps;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class IntercamTest implements IntercamProps, UtilsDados {

    IntercamActions intercamActions = new IntercamActions();

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(intercamNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(intercamNomeArq, 0).substring(0, 8);
        validarCampoNome("INTERCAM", campoNome);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(intercamNomeArq);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(intercamNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(intercamNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, intercamNomeArq);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(intercamNomeArq, intercamPosicoesFiller);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(intercamNomeArq);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        validarCampoTrimestre(intercamNomeArq);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Produto' não foi gerado código fora do intervalo 31-38")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoProdutoFiller() {
        intercamActions.validarCampoProduto();
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Modalidade do cartão' não foi gerado código além de 'P', 'H', 'C'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoModalidadeFiller() {
        intercamActions.validarCampoModalidade();
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Função' não aparece nenhum código além de 'C','D', e 'E'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFuncaoFiller() {
        validarCampoFuncao(intercamNomeArq, 8,9);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo bandeira não aparece nenhum outro código além de '1', '2', e '8'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoBandeiraFiller() {
        validarCampoBandeira(intercamNomeArq, 9,11);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Forma de captura' não aparece códigos além de '1', '2' e '5'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFormaCaptura() {
        validarCampoFormaCaptura(intercamNomeArq, 11,12);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Numero de parcelas' não aparece valores fora do intervalo 01-12 ")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNumParcelas() {
        validarCampoNumParcelas(intercamNomeArq,12,14);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Segmento' não aparece códigos fora do intervalo 400-428")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoSegmento() {
        validarCampoSegmento(intercamNomeArq, 14,17);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Taxa de intercâmbio' não foi gerado taxa acima de 6,99%")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTaxaIntercambio() {
        intercamActions.validarCampoTaxaIntercambio();
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Valor das transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.BLOCKER)
    public void testCampoValorTransacaoFiller() {
        validarCampoValorTransacaoDiferenteDeZero(intercamNomeArq, 21,36);
    }

    @Test
    @Feature("Arquivo Intercam")
    @Description("Valida se no campo 'Quantidade de transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.BLOCKER)
    public void testCampoQuantidadeTransacaoFiller() {
        validarCampoQuantidadeTransacaoDiferenteDeZero(intercamNomeArq, 36,48);
    }
}