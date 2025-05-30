package solutions.b2.deban.actions;

import org.junit.jupiter.api.Assertions;
import solutions.b2.deban.propriedades.SegmentoProps;
import solutions.b2.deban.utils.SegmentoEsperado;

import java.util.List;

import static solutions.b2.deban.utils.SegmentoEsperado.getSegmentosEsperados;
import static solutions.b2.deban.utils.Utils.getDadosFiller;

public class SegmentoActions implements SegmentoProps {

    public void validarSegmentos() {
        List<String> linhas = getDadosFiller(segmentoNomeArq, 0, 303);

        for (String linha : linhas) {
            for (SegmentoEsperado segmentoEsperado : getSegmentosEsperados()) {

                String nomeSegmento = linha.substring(0, 50).trim();
                if (nomeSegmento.equals(segmentoEsperado.nome())) {

                    String descricao = linha.substring(50, 300).trim();
                    if (!segmentoEsperado.descricoes().contains(descricao)) {
                        Assertions.fail("Descrição incorreta para segmento: " + segmentoEsperado.nome());
                    }

                    String codigo = linha.substring(300, 303).trim();
                    if (!codigo.equals(segmentoEsperado.codigo())) {
                        Assertions.fail("Código incorreto para segmento: " + segmentoEsperado.nome());
                    }
                }
            }
        }
    }
}
