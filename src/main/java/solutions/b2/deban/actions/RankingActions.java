package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.RankingProps;
import solutions.b2.deban.utils.Utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static solutions.b2.deban.utils.Utils.getLinha;
import static solutions.b2.deban.utils.Utils.getNumLinhasFiller;

public class RankingActions implements RankingProps {

    public void validarCampoCodigoEstabelecimento() {
        List<String> dados = Utils.getDadosFiller(rankingNomeArq, 5,13);

        for (int i=0; i<dados.size(); i++) {
            String codigoEstab = dados.get(i);
            assertNotEquals("00000000", codigoEstab, "Foi reportado código estabelecimento '00000000' na linha "+(i+2));
        }
    }

    public void validarRanqueamento() {
        List<String> codigosEstabs = getCodigosEstabs();
        List<String> codEstabs = new ArrayList<>(removerDuplicatas(codigosEstabs));
        Map<String, BigDecimal> totais = new HashMap<>();

        for (int i = 0; i< codigosEstabs.size(); i++) {
            String linha = getLinha(rankingNomeArq, i+1);
            String codigo = codigosEstabs.get(i);

            String valorStr = linha.substring(22, 35) + "." + linha.substring(linha.length() - 2);
            BigDecimal valorBigDecimal = new BigDecimal(valorStr);

            totais.merge(codigo, valorBigDecimal, BigDecimal::add);
        }
        totais.remove("99999998");

        List<String> expectedRanking = totais.entrySet().stream()
                .sorted(Map.Entry.<String,BigDecimal>comparingByValue().reversed())
                .map(Map.Entry::getKey).toList();

        List<String> rankingArq = codEstabs.subList(0, Math.min(15, codEstabs.size()));

        assertEquals(expectedRanking, rankingArq, "O ranqueamento dos 15 maiores está incorreto");
    }

    public void validarTamanhoRanqueamento() {
        List<String> codEstabs = new ArrayList<>(removerDuplicatas(getCodigosEstabs()));
        assertEquals(16, codEstabs.size());
    }

    public void validarPosicaoDuzentosMenores() {
        List<String> codEstabs = new ArrayList<>(removerDuplicatas(getCodigosEstabs()));
        assertEquals("99999998", codEstabs.get(15));
    }

    private List<String> getCodigosEstabs() {
        List<String> dadosEstabs = new ArrayList<>();

        for (int i=1; i<=getNumLinhasFiller(rankingNomeArq); i++) {
            String linha = getLinha(rankingNomeArq, i);

            if (linha.substring(19,22).contains("401")) {
                dadosEstabs.add(linha.substring(5,13));
            }
        }

        return dadosEstabs;
    }

    private List<String> removerDuplicatas(List<String> dados) {
        return dados.stream().distinct().toList();
    }

}
