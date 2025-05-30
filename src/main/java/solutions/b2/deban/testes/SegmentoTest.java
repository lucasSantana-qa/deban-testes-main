package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.SegmentoActions;
import solutions.b2.deban.propriedades.SegmentoProps;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class SegmentoTest implements SegmentoProps, UtilsDados {

    SegmentoActions segmentoActions = new SegmentoActions();

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(segmentoNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(segmentoNomeArq, 0).substring(0, 8);
        validarCampoNome("SEGMENTO", campoNome);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(segmentoNomeArq);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(segmentoNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(segmentoNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, segmentoNomeArq);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhaFiller() {
        validarQuantidadeDePosicoesLinhasFiller(segmentoNomeArq, segmentoqtdPosicoesLinhaFiller);
    }

    @Test
    @Feature("Arquivo Segmento")
    @Description("Valida se os segmentos contidos no arquivo foram gerados corretamente, assim como seus respectivos códigos")
    @Severity(SeverityLevel.CRITICAL)
    public void testSegmentosFiller() {
        segmentoActions.validarSegmentos();
    }
}
