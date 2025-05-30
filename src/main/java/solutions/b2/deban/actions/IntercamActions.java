package solutions.b2.deban.actions;

import org.junit.jupiter.api.Assertions;
import solutions.b2.deban.propriedades.IntercamProps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static solutions.b2.deban.utils.Utils.getDadosFiller;

public class IntercamActions implements IntercamProps {

    public void validarCampoProduto() {
        List<String> dados = getDadosFiller(intercamNomeArq, 5,7);

        for (String dado : dados) {
            if (!produtos.contains(dado)) {
                fail("Foi reportado um produto com o domínio incorreto: " +dado);
            } else
                assertTrue(true);
        }
    }

    public void validarCampoModalidade() {
        List<String> dados = getDadosFiller(intercamNomeArq, 7,8);

        for (String dado : dados) {
            if (!modalidade.contains(dado)) {
                fail("Foi reportado uma modalidade com o domínio incorreto: " +dado);
            } else
                assertTrue(true);
        }
    }

    public void validarCampoTaxaIntercambio() {
        List<String> dados = getDadosFiller(intercamNomeArq, 17,21);

        for (String dado : dados) {
            double taxa = Double.parseDouble(dado.substring(0,2) + "." + dado.substring(2));

            if (taxa >= 7.00) {
                Assertions.fail("Foi gerado registro com taxa de intercambio maior ou igual a 7.00%: " + taxa);
            } else
                Assertions.assertTrue(true);
        }
    }
}
