package solutions.b2.deban.base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInfo;
import solutions.b2.deban.base.ConfigTrimestre;

import java.io.File;
import java.io.IOException;

import static solutions.b2.deban.base.ConfigTrimestre.trimestre;

public class BaseTest {

    @BeforeAll
    public static void setupTrimestre(TestInfo info) {
        System.out.println("Iniciando testes: " + info.getDisplayName());
        trimestre = ConfigTrimestre.TrimestreEnum.primeiro;
    }

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
            e.printStackTrace();
        }
    }

}