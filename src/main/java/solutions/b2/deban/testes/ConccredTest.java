package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.actions.ConccredActions;
import solutions.b2.deban.propriedades.ConccredProps;
import solutions.b2.deban.utils.Utils;
import solutions.b2.deban.utils.UtilsDados;

import static solutions.b2.deban.utils.Utils.*;

public class ConccredTest implements ConccredProps, UtilsDados {

    ConccredActions conccredActions = new ConccredActions();

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida a quantidade de posições no registro header")
    @Severity(SeverityLevel.CRITICAL)
    public void testQtdPosicoesHeader() {
        validarQuantidadePosicoesLinha(conccredNomeArq, 0, 32);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida o campo 'Nome' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoNomeArquivoHeader() {
        String campoNome = getLinha(conccredNomeArq, 0).substring(0, 8);
        validarCampoNome("CONCCRED", campoNome);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida o formato da data no campo 'Data Geração' do arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoDataGeracaoHeader() {
        validarFormatoCampoDataGeracao(conccredNomeArq);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida o campo 'CNPJ'. Deve ser apresentado os 8 primeiros dígitos do cnpj do credenciador")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoCNPJHeader() {
        String campoCNPJ = getLinha(conccredNomeArq, 0).substring(16, 24);
        validarCampoCnpj(campoCNPJ);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida o campo 'Quantidade de registros'. A quantidade de registros filler deve ser igual a quantidade apresentada neste campo")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoQtdRegistrosHeader() {
        String campoQtdReg = getLinha(conccredNomeArq, 0).substring(24, 32).trim();
        validarCampoQuantidadeReg(campoQtdReg, conccredNomeArq);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida a quantidade de posições que o registro filler deve conter no arquivo")
    @Severity(SeverityLevel.CRITICAL)
    public void testQuantidadePosicoesLinhasFiller() {
        validarQuantidadeDePosicoesLinhasFiller(conccredNomeArq, conccredPosicoesFiller);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'Ano' nas linhas contidas no filler")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoAnoFiller() {
        validarCampoAno(conccredNomeArq);
    }

    @Test
    @Feature("Arquivo Contatos")
    @Description("Valida o campo 'Trimestre' nas linhas contidas no filler, deve ser o trimestre de referência em que" +
            "o arquivo foi gerado")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoTrimestreFiller() {
        Utils.validarCampoTrimestre(conccredNomeArq);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida se no campo 'Bandeira' não aparece nenhum outro código além de '1', '2', e '8' e se aparecem de três em três")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoBandeiraFiller() {
        conccredActions.validarCampoBandeira();
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida se no campo 'Função', por bandeira, aparecem apenas códigos 'C', 'D', e 'E'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoFuncaoFiller() {
        conccredActions.validarCampoFuncao();
    }


    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida se algum registro do campo 'Quantidade de estabelecimentos credenciados' não teve suas quantidades" +
            "efetivamente somadas'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoEstabelecimentosCredenciadosFiller() {
        conccredActions.validarCamposNaoSomados("Quantidade de estabelecimentos credenciados", 8,17);
    }

    @Test
    @Feature("Arquivo Conccred")
    @Description("Valida se algum registro do campo 'Quantidade de estabelecimentos credenciados ativos' não teve suas quantidades" +
            " efetivamente somadas'")
    @Severity(SeverityLevel.CRITICAL)
    public void testCampoEstabelecimentosCredenciadosAtivFiller() {
        conccredActions.validarCamposNaoSomados("Quantidade de estabelecimentos credenciados ativos", 17,26);
    }
}
