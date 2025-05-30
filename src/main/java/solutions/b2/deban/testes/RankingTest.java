package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.RankingActions;
import solutions.b2.deban.propriedades.RankingProps;

import static solutions.b2.deban.utils.Utils.*;

public class RankingTest implements RankingProps {

    RankingActions rankingActions = new RankingActions();

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(rankingNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(rankingNomeArq, 0).substring(0, 8);
        validarCampoNome("RANKING ", campoNome);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(rankingNomeArq);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(rankingNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(rankingNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, rankingNomeArq);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(rankingNomeArq, rankingQtdPosicoesLinhaFiller);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(rankingNomeArq);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        validarCampoTrimestre(rankingNomeArq);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Código do estabelecimento' não foi gerado codigo igual a 0")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCodigoEstabelecimentoFiller() {
        rankingActions.validarCampoCodigoEstabelecimento();
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Função' não aparece nenhum código além de 'C','D', e 'E'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFuncaoFiller() {
        validarCampoFuncao(rankingNomeArq, 13,14);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo bandeira não aparece nenhum outro código além de '1', '2', e '8'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoBandeiraFiller() {
        validarCampoBandeira(rankingNomeArq, 14,16);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Forma de captura' não aparece códigos além de '1', '2' e '5'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFormaCapturaFiller() {
        validarCampoFormaCaptura(rankingNomeArq, 16,17);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Numero de parcelas' não aparece valores fora do intervalo 01-12 ")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNumeroDeParcelasFiller() {
        validarCampoNumParcelas(rankingNomeArq, 17,19);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Segmento' não aparece códigos fora do intervalo 400-428")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoSegmentoFiller() {
        validarCampoSegmento(rankingNomeArq, 19,22);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Valor das transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoValorTransacaoFiller() {
        validarCampoValorTransacaoDiferenteDeZero(rankingNomeArq, 22,37);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida se no campo 'Quantidade de transações' não foi gerado registro com valor igual a 0")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQuantidadeTransacaoFiller() {
        validarCampoQuantidadeTransacaoDiferenteDeZero(rankingNomeArq, 37,49);
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida que os estabelecimentos '99999998' se encontram logo após os 15 maiores no segmento")
    @Severity(SeverityLevel.BLOCKER)
    public void testPosicaoDuzentosMenores() {
        rankingActions.validarPosicaoDuzentosMenores();
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida que o ranking do segmento é composto de 16 posições, 15 maiores e 200 menores (99999998)")
    @Severity(SeverityLevel.BLOCKER)
    public void testTamanhoRanqueamento() {
        rankingActions.validarTamanhoRanqueamento();
    }

    @Test
    @Feature("Arquivo Ranking")
    @Description("Valida a posição dos estabelecimentos no ranking dos 15 maiores de acordo com o volume financeiro")
    @Severity(SeverityLevel.BLOCKER)
    public void testRanqueamento() {
        rankingActions.validarRanqueamento();
    }
}