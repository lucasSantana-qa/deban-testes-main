package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.InfrestaActions;
import solutions.b2.deban.propriedades.InfrestaProps;
import solutions.b2.deban.utils.Utils;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class InfrestaTest implements UtilsDados, InfrestaProps {

    InfrestaActions infrestaActions = new InfrestaActions();

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(infrestaNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeHeader() {
        String campoNome = Utils.getLinha(infrestaNomeArq, 0).substring(0, 8);
        validarCampoNome("INFRESTA", campoNome);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(infrestaNomeArq);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = Utils.getLinha(infrestaNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = Utils.getLinha(infrestaNomeArq, 0).substring(24, 32);
        validarCampoQuantidadeReg(campoQtdReg, infrestaNomeArq);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(infrestaNomeArq, infrestaPosicoesLinhaFiller);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(infrestaNomeArq);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        validarCampoTrimestre(infrestaNomeArq);
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida as UFs apresentadas no campo 'UF'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoUFFiller() {
        infrestaActions.validarCampoUf();
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida se o campo 'Quantidade de estabelecimentos' não teve registro gerado com valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdEstabelecimentosFiller() {
        infrestaActions.validarCampoQtdEstabelecimentos();
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida se o campo 'Quantidade de estabelecimento com captura eletrônica' possui a mesma quantidade" +
            "do campo 'Quantidade de estabelecimentos'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdCapturaEletronicaFiller() {
        infrestaActions.validarCampoQtdCapturaEletronica();
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida se o campo 'Quantidade de estabelecimentos com captura manual' foi gerado registro apenas com valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdCapturaManual() {
        infrestaActions.validarCampoQtdCapturaManual();
    }

    @Test
    @Feature("Arquivo Infresta")
    @Description("Valida se o campo 'Quantidade de estabelecimentos com captura remota' foi gerado registro apenas com valor igual a zero")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdCapturaRemota() {
        infrestaActions.validarCampoQtdCapturaRemota();
    }
}