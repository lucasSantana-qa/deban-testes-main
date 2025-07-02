package solutions.b2.deban;

import java.math.BigDecimal;

import static solutions.b2.deban.propriedades.ConccredProps.*;
import static solutions.b2.deban.propriedades.DescontoProps.*;
import static solutions.b2.deban.propriedades.IntercamProps.*;
import static solutions.b2.deban.propriedades.LucrcredProprs.*;
import static solutions.b2.deban.propriedades.RankingProps.*;
import static solutions.b2.deban.utils.Utils.*;

public class ApresentadorDados {
    public static void main(String[] args) {
        apresentarVolumesConcDescInterc();
        apresentarVolumesRanking();
        apresentarVolumesLucrcred();
    }

    private static void apresentarVolumesConcDescInterc() {
        BigDecimal volumeConccredTrn = getVolumeValorTransacao(conccredNomeArq, 26, 41);
        BigDecimal volumeDescontoTrn = getVolumeValorTransacao(descontoNomeArq, 30, 45);
        BigDecimal volumeIntercamTrn = getVolumeValorTransacao(intercamNomeArq, 21, 36);

        Integer volumeConccredQtd = getVolumeQtdTransacoes(conccredNomeArq, 41, 53);
        Integer volumeDescontoQtd = getVolumeQtdTransacoes(descontoNomeArq, 45, 57);
        Integer volumeIntercamQtd = getVolumeQtdTransacoes(intercamNomeArq, 36, 48);

        System.out.printf("DADOS PARA O GOOGLE COLAB\n\nVolumes Conccred, Desconto, intercam: \nValor: [%s, %s, %s]\nQuantidade: [%s, %s, %s]\n-------------------------------------------------\n",
                volumeConccredTrn, volumeDescontoTrn, volumeIntercamTrn, volumeConccredQtd, volumeDescontoQtd, volumeIntercamQtd);
    }

    private static void apresentarVolumesLucrcred() {
        String linha = getLinha(lucrcredNomeArq, 1);

        BigDecimal receitaTaxaDescontoBruta = new BigDecimal(linha.substring(5, 17).replaceFirst("(\\d+)(\\d{2})$", "$1.$2"));
        BigDecimal custoTaxaIntercambio = new BigDecimal(linha.substring(41, 53).replaceFirst("(\\d+)(\\d{2})$", "$1.$2"));

        System.out.printf("Volumes Lucrcred - Receita taxa de desconto, Custo tarifa de intercâmbio\n[%s, %s]", receitaTaxaDescontoBruta, custoTaxaIntercambio);
    }

    private static void apresentarVolumesRanking() {
        BigDecimal volumeRankVlr = getVolumeValorTransacao(rankingNomeArq, 22,37);
        Integer volumeRankQtd = getVolumeQtdTransacoes(rankingNomeArq,37,49);

        System.out.printf("Volumes Ranking: \nValor: %s\nQuantidade: %s\n-------------------------------------------------\n", volumeRankVlr, volumeRankQtd);
    }
}