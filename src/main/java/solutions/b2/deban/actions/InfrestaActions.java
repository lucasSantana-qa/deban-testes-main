package solutions.b2.deban.actions;

import org.junit.jupiter.api.Assertions;
import solutions.b2.deban.propriedades.InfrestaProps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.b2.deban.utils.Utils.*;

public class InfrestaActions implements InfrestaProps {

    public void validarCampoUf () {
        List<String> dados = getDadosFiller(infrestaNomeArq, 5,7);

        assertArrayEquals(ufs, dados.toArray());
    }

    public void validarCampoQtdEstabelecimentos() {
        List<String> dados = getDadosCampoQtdEstabelecimentos();

        for (String dado : dados) {
            Assertions.assertNotEquals(0, Integer.parseInt(dado), "Reportado UF com 0 estabelecimentos no campo Quantidade Total de Estabelecimentos");
        }
    }

    public void validarCampoQtdCapturaEletronica() {
        List<String> dadosQtdEstabelecimentos = getDadosCampoQtdEstabelecimentos();
        List<String> dadosQtdCapturaEletronica = getDadosCampoQtdCapturaEletronica();

        for (int i=0; i<getNumLinhasFiller(infrestaNomeArq);i++) {
            String dadoQtdEstabelecimentos = dadosQtdEstabelecimentos.get(i);
            String dadoQtdCapturaEletronica = dadosQtdCapturaEletronica.get(i);

            assertEquals(dadoQtdEstabelecimentos, dadoQtdCapturaEletronica, "O número no campo Quantidade de " +
                    "Estabelecimentos com Captura Eletrônica não é igual ao campo Quantidade de Estabelecimentos na linha " + i);
        }
    }

    public void validarCampoQtdCapturaRemota() {
        List<String> dadosQtdCapturaRemota = getDadosFiller(infrestaNomeArq, 31,39);

        for (int i=0; i<getNumLinhasFiller(infrestaNomeArq); i++) {
            String dadoQtdCapturaRemota = dadosQtdCapturaRemota.get(i);

            Assertions.assertEquals("00000000", dadoQtdCapturaRemota);
        }
    }

    public void validarCampoQtdCapturaManual() {
        List<String> dadosQtdCapturaManual = getDadosFiller(infrestaNomeArq, 15,23);

        for (int i=0; i<getNumLinhasFiller(infrestaNomeArq); i++) {
            String dadoQtdCapturaManual = dadosQtdCapturaManual.get(i);

            Assertions.assertEquals("00000000", dadoQtdCapturaManual);
        }
    }

    private List<String> getDadosCampoQtdEstabelecimentos() {
        return getDadosFiller(infrestaNomeArq,7,15);
    }

    private List<String> getDadosCampoQtdCapturaEletronica() {
        return getDadosFiller(infrestaNomeArq, 23,31);
    }

}
