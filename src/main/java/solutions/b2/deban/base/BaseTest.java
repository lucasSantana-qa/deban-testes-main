package solutions.b2.deban.base;

import org.junit.jupiter.api.AfterAll;
import solutions.b2.deban.utils.UtilsDados;

import java.io.File;

public class BaseTest implements UtilsDados {

    @AfterAll
    public static void teardown() {
        gerarRelatorioExcel();
    }

    private static void gerarRelatorioExcel() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "PythonDeban/gerarRelatorioDeban.py");
            pb.directory(new File(System.getProperty("user.dir")));

            Process process = pb.start();

            int exitCode = process.waitFor();

            if (exitCode != 0) {
                System.err.println("Erro ao gerar o relatório Excel. Código de saída: " + exitCode);
            } else {
                System.out.println("Relatório Excel gerado com sucesso.");
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

}