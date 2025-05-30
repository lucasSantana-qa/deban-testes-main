package solutions.b2.deban.propriedades;

import java.util.List;

public interface ConccredProps {

    String conccredNomeArq = "CONCCRED.txt";
    int conccredPosicoesFiller = 53;

    List<String> conccredBandeirasPorLinha = List.of("08", "08", "08", "02", "02", "02", "01", "01", "01");
    List<String> conccredFuncoesPorLinha = List.of("C", "D", "E", "C", "D", "E", "C", "D", "E");
}
