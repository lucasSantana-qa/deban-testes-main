package solutions.b2.deban.base;

import org.junit.jupiter.api.BeforeAll;
import solutions.b2.deban.utils.UtilsDados;
import java.io.File;

public class BaseTest implements UtilsDados {

    @BeforeAll
    public static void setupRelatorioExcel() {
        gerarExcelExtracao();
    }

    private static void gerarExcelExtracao() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", ConfigCaminhoArquivos.getBasePath()+"DEBAN-TESTES-MAIN\\Filtragem_extracao.py");
            pb.directory(new File(System.getProperty("user.dir")));

            pb.start();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

}