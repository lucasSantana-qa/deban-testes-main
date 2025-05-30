package solutions.b2.deban.actions;

import org.junit.jupiter.api.Assertions;
import solutions.b2.deban.propriedades.LucrcredProprs;
import solutions.b2.deban.utils.Utils;

public class LucrcredActions implements LucrcredProprs {

    public void validarCampoComValorZero(String nomeCampo, int inicio, int fim) {
        String linha = Utils.getLinha(lucrcredNomeArq, 1);

        String campo = linha.substring(inicio, fim);
        Assertions.assertEquals(lucrcredPosicoesCamposVazios, campo, String.format("O campo '%s' está com valor diferente de 0", nomeCampo));
    }

    public void validarCampoPreenchido(String nomeCampo, int inicio, int fim) {
        String linha = Utils.getLinha(lucrcredNomeArq, 1);
        String campo = linha.substring(inicio, fim);

        Assertions.assertNotEquals(lucrcredPosicoesCamposVazios, campo, String.format("O campo '%s' está com valor igual a 0", nomeCampo));
    }
}