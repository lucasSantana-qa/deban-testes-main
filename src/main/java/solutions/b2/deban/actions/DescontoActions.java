package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.DescontoProps;
import solutions.b2.deban.utils.UtilsDados;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static solutions.b2.deban.utils.Utils.*;

public class DescontoActions implements DescontoProps, UtilsDados {

    public void validarTaxaMinMenorQueTaxaMax() {
        List<String> dadosTaxaMin = getCampoTaxaMin();
        List<String> dadosTaxaMax = getCampoTaxaMax();

        for (int i=0; i<dadosTaxaMin.size(); i++) {
            int dadoTaxaMin = Integer.parseInt(dadosTaxaMin.get(i).trim());
            int dadoTaxaMax = Integer.parseInt(dadosTaxaMax.get(i).trim());

            if (dadoTaxaMax < dadoTaxaMin) {
                fail("No registro "+ (i+1)  +" a taxa máxima "+ dadoTaxaMax +" é menor que a taxa mínima "+ dadoTaxaMin);
            } else
                assertTrue(true);
        }
    }

    public void validarTaxaMinMenorQueTaxaMed() {
        List<String> dadosTaxaMin = getCampoTaxaMin();
        List<String> dadosTaxaMed = getCampoTaxaMed();

        for (int i=0; i<dadosTaxaMin.size(); i++) {
            int dadoTaxaMin = Integer.parseInt(dadosTaxaMin.get(i));
            int dadoTaxaMed = Integer.parseInt(dadosTaxaMed.get(i));

            if (dadoTaxaMed < dadoTaxaMin) {
                fail("No registro "+ (i+1)  +" a taxa média "+ dadoTaxaMed +" é menor que a taxa mínima "+ dadoTaxaMin);
            }
        }
    }

    public void validarTaxaMaxMaiorQueTaxaMed() {
        List<String> dadosTaxaMax = getCampoTaxaMax();
        List<String> dadosTaxaMed = getCampoTaxaMed();

        for (int i=0; i<dadosTaxaMax.size(); i++) {
            int dadoTaxaMax = Integer.parseInt(dadosTaxaMax.get(i));
            int dadoTaxaMed = Integer.parseInt(dadosTaxaMed.get(i));

            if (dadoTaxaMax < dadoTaxaMed) {
                fail("No registro "+ (i+1)  +" a taxa máxima "+ dadoTaxaMax +" é menor que a taxa média "+ dadoTaxaMed);
            }
        }
    }

    private List<String> getCampoTaxaMin() {
       return getDadosFiller(descontoNomeArq, 18, 22);
    }

    private List<String> getCampoTaxaMax() {
        return getDadosFiller(descontoNomeArq, 22, 26);
    }

    private List<String> getCampoTaxaMed() {
        return getDadosFiller(descontoNomeArq, 14, 18);
    }

}