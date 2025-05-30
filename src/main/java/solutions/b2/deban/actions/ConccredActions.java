package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.ConccredProps;
import solutions.b2.deban.utils.UtilsDados;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.b2.deban.utils.Utils.*;

public class ConccredActions implements ConccredProps, UtilsDados {

    public void validarCampoBandeira() {
        List<String> dados = getDadosFiller(conccredNomeArq, 5,7);
        assertEquals(conccredBandeirasPorLinha, dados, "");
    }

    public void validarCampoFuncao() {
        List<String> dados = getDadosFiller(conccredNomeArq, 7,8);
        assertEquals(conccredFuncoesPorLinha, dados);
    }

    public void validarCamposNaoSomados(String campo, int inicio, int fim) {
        List<String> dados = getDadosFiller(conccredNomeArq, inicio, fim);

        for (String dado : dados) {
            Integer dadoInteger = Integer.parseInt(dado);

            assertNotEquals(0, dadoInteger, String.format("Foi gerado valor igual a 0 no campo '%s'", campo));
        }
    }
}
