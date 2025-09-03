package solutions.b2.deban.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface UtilsDados {

    String cnpjCredenciador = "17351180";

    Charset formatoArq = StandardCharsets.ISO_8859_1;

    Set<String> bandeiras = Set.of("01", "02", "08");
    Set<String> funcoes = Set.of("C", "D", "E");
    Set<String> formas_captura = Set.of("1", "2", "5");
    Set<String> numero_parcelas = Set.of("01","02","03","04","05","06","07","08","09","10","11","12");
    Set<Integer> segmentos = IntStream.rangeClosed(400,428).boxed().collect(Collectors.toSet());
}
