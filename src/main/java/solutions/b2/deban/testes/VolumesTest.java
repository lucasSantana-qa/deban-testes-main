package solutions.b2.deban.testes;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import solutions.b2.deban.propriedades.ConccredProps;
import solutions.b2.deban.propriedades.DescontoProps;
import solutions.b2.deban.propriedades.IntercamProps;

import java.math.BigDecimal;

import static solutions.b2.deban.utils.Utils.*;

public class VolumesTest implements DescontoProps, ConccredProps, IntercamProps {

    protected BigDecimal volumeTransacaoDesconto = getVolumeValorTransacao(descontoNomeArq, 30, 45);
    protected BigDecimal volumeTransacaoConccred = getVolumeValorTransacao(conccredNomeArq, 26, 41);
    protected BigDecimal volumeTransacaoIntercam = getVolumeValorTransacao(intercamNomeArq, 21, 36);

    protected int volumeDesconto = getVolumeQtdTransacoes(descontoNomeArq, 45,57);
    protected int volumeConccred = getVolumeQtdTransacoes(conccredNomeArq, 42, 53);
    protected int volumeIntercam = getVolumeQtdTransacoes(intercamNomeArq, 36, 48);

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de valor financeiro entre os arquivos Desconto e Intercam")
    public void testVolumesValorTransacoesDescontoIntercam() {
        validarVolumeValorTransacao(volumeTransacaoDesconto, volumeTransacaoIntercam, descontoNomeArq, intercamNomeArq);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de valor financeiro entre os arquivos Desconto e Conccred")
    public void testVolumesValorTransacoesDescontoConccred() {
        validarVolumeValorTransacao(volumeTransacaoDesconto, volumeTransacaoConccred, descontoNomeArq, conccredNomeArq);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de valor financeiro entre os arquivos Conccred e Intercam")
    public void testVolumesValorTransacoesIntercamConccred() {
        validarVolumeValorTransacao(volumeTransacaoConccred, volumeTransacaoIntercam, conccredNomeArq, intercamNomeArq);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de quantidade de transações entre os arquivos Desconto e Intercam")
    public void testVolumesQtdTransacoesDescontoIntercam() {
        validarVolumeQtdTransacao(volumeDesconto, volumeIntercam, descontoNomeArq, intercamNomeArq);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de quantidade de transações entre os arquivos Desconto e Conccred")
    public void testVolumesQtdTransacoesDescontoConccred() {
        validarVolumeQtdTransacao(volumeDesconto, volumeConccred, descontoNomeArq, conccredNomeArq);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Validação de volumes")
    @Description("Valida o volume de quantidade de transações entre os arquivos Intrercam e Conccred")
    public void testVolumesQtdTransacoesIntercamConccred() {
        validarVolumeQtdTransacao(volumeIntercam, volumeConccred, intercamNomeArq, conccredNomeArq);
    }
}