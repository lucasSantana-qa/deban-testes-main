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
        apresentarVolumesLucrcred();
        apresentarVolumesRanking();
    }

    private static void apresentarVolumesConcDescInterc() {
        BigDecimal volumeConccredTrn = getVolumeValorTransacao(conccredNomeArq, 26, 41);
        BigDecimal volumeDescontoTrn = getVolumeValorTransacao(descontoNomeArq, 30, 45);
        BigDecimal volumeIntercamTrn = getVolumeValorTransacao(intercamNomeArq, 21, 36);

        Integer volumeConccredQtd = getVolumeQtdTransacoes(conccredNomeArq, 41, 53);
        Integer volumeDescontoQtd = getVolumeQtdTransacoes(descontoNomeArq, 45, 57);
        Integer volumeIntercamQtd = getVolumeQtdTransacoes(intercamNomeArq, 36, 48);

        String conccTrnFormatado = formatarValorMoeda(volumeConccredTrn);
        String descTrnFormatado = formatarValorMoeda(volumeDescontoTrn);
        String intercTrnFormatado = formatarValorMoeda(volumeIntercamTrn);

        String conccQtdFormatado = formatarInteiro(volumeConccredQtd);
        String descQtdFormatado = formatarInteiro(volumeDescontoQtd);
        String intercQtdFormatado = formatarInteiro(volumeIntercamQtd);

        System.out.printf("Volumes Conccred, Desconto, intercam: \nConccred: %s | %s\nDesconto: %s | %s\nIntercam: %s | %s\n------------------------------------------------- \n",
                conccTrnFormatado, conccQtdFormatado, descTrnFormatado, descQtdFormatado, intercTrnFormatado, intercQtdFormatado);
    }

    private static void apresentarVolumesLucrcred() {
        String linha = getLinha(lucrcredNomeArq, 1);

        BigDecimal receitaTaxaDescontoBruta = new BigDecimal(linha.substring(5, 17).replaceFirst("(\\d+)(\\d{2})$", "$1.$2"));
        BigDecimal custoTaxaIntercambio = new BigDecimal(linha.substring(41, 53).replaceFirst("(\\d+)(\\d{2})$", "$1.$2"));

        String descontoFormatado = formatarValorMoeda(receitaTaxaDescontoBruta);
        String intercambioFormatado = formatarValorMoeda(custoTaxaIntercambio);

        System.out.printf("Volumes Lucrcred: \nReceita taxa de desconto: %s \nCusto tarifa de intercâmbio: %s\n------------------------------------------------- \n", descontoFormatado, intercambioFormatado);
    }

    private static void apresentarVolumesRanking() {
        BigDecimal volumeRankVlr = getVolumeValorTransacao(rankingNomeArq, 22,37);
        Integer volumeRankQtd = getVolumeQtdTransacoes(rankingNomeArq,37,49);

        String rankVlrFormatado = formatarValorMoeda(volumeRankVlr);
        String rankQtdFormatado = formatarInteiro(volumeRankQtd);

        System.out.printf("Volumes Ranking: \n%s | %s", rankVlrFormatado, rankQtdFormatado);
    }
}