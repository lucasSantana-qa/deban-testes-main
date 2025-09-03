package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.LucrcredActions;
import solutions.b2.deban.propriedades.LucrcredProprs;
import java.math.BigDecimal;

import static solutions.b2.deban.utils.Utils.*;

public class LucrcredTest implements LucrcredProprs {

    LucrcredActions lucrcredActions = new LucrcredActions();

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(lucrcredNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(lucrcredNomeArq, 0).substring(0, 8);
        validarCampoNome("LUCRCRED", campoNome);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(lucrcredNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(lucrcredNomeArq);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(lucrcredNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, lucrcredNomeArq);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(lucrcredNomeArq, lucrcredPosicoesFiller);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(lucrcredNomeArq);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        validarCampoTrimestre(lucrcredNomeArq);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Receita de aluguel de equipamentos e de conectividade' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoReceitaAluguelEquipamentoFiller() {
        lucrcredActions.validarCampoComValorZero("Receita de aluguel de equipamentos e de conectividade",17,29);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Outras receitas do credenciador' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoOutrasReceitasFiller() {
        lucrcredActions.validarCampoComValorZero("Outras receitas do credenciador",29,41);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Custo de marketing e propaganda' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCustoDeMarketingFiller() {
        lucrcredActions.validarCampoComValorZero("Custo de marketing e propaganda",53,65);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Custo das taxas de acesso às bandeiras' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCustoDasTaxasBandeirasFiller() {
        lucrcredActions.validarCampoComValorZero("Custo das taxas de acesso às bandeiras",65,77);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Custo de riscos' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCustoDeRiscosFiller() {
        lucrcredActions.validarCampoComValorZero("Custos de riscos",77,89);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Custo de processamento front-end e back-end' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCustoFrontendBackendFiller() {
        lucrcredActions.validarCampoComValorZero("Custo de processamento front-end e back-end",89,101);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Outros custos do credenciador' foi gerado valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoOutrosCustosCredenciadorFiller() {
        lucrcredActions.validarCampoComValorZero("Outros custos do credenciador",89,101);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Receita da taxa de desconto bruta' foi preenchido com valor diferente de zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoReceitaTaxaDescontoFiller() {
        lucrcredActions.validarCampoPreenchido("Receita da taxa de desconto bruta",5,17);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se no campo 'Custo da tarifa de intercâmbio' foi preenchido com valor diferente de zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCustoTarifaIntercambioFiller() {
        lucrcredActions.validarCampoPreenchido("Custo da tarifa de intercâmbio",41,53);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se o valor contido no campo 'receita de desconto bruta' bate com o valor extraído do banco de dados ")
    @Severity(SeverityLevel.CRITICAL)
    public void testValorCampoReceitaTaxaDescontoFiller() {
        BigDecimal somaValorExtracao = getSomaValorExtracao();
        String dado = getLinha(lucrcredNomeArq, 1).substring(5, 17);

        BigDecimal valor = new BigDecimal(dado);
        BigDecimal valorFormatado = valor.movePointLeft(2);
        Assertions.assertEquals(somaValorExtracao, valorFormatado);
    }

    @Test
    @Feature("Arquivo Lucrcred")
    @Description("Valida se o valor contido no campo 'custo tarifa de intercâmbio' bate com o valor extraído do banco de dados ")
    @Severity(SeverityLevel.CRITICAL)
    public void testValorCampoCustoTarifaIntercambioFiller() {
        BigDecimal somaValorExtracao = getSomaValorExtracao();
        String dado = getLinha(lucrcredNomeArq, 1).substring(41, 53);

        BigDecimal valor = new BigDecimal(dado);
        BigDecimal valorFormatado = valor.movePointLeft(2);
        Assertions.assertEquals(somaValorExtracao, valorFormatado);
        System.out.println(valorFormatado);
    }
}