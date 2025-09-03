package solutions.b2.deban.base;

import org.junit.jupiter.api.BeforeAll;
import solutions.b2.deban.utils.UtilsDados;

import java.io.File;

public class BaseTest implements UtilsDados {

    @BeforeAll
    public static void teardown() {
        gerarExcelExtracao();
    }

    private static void gerarExcelExtracao() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "PyModule\\Test.py");
            pb.directory(new File(System.getProperty("user.dir")));

            pb.start();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

}