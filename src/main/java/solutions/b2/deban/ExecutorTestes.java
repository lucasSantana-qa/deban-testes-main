package solutions.b2.deban;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ExecutorTestes {
    public static void main(String[] args) {
        try {
            String projectDir = "C:\\Testes automatizados\\DEBAN\\DEBAN-TESTES-MAIN";

            Scanner s = new Scanner(System.in);

            System.out.println("Antes de começar as validações, insira as seguintes informações: ");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Qual o ano dos arquivos ?");
            String ano = s.next();
            System.out.println("Qual o trimestre dos arquivos ? (1,2,3 ou 4)");
            String trim = s.next();

            System.out.println("Iniciando validações");
            ProcessBuilder pb1 = new ProcessBuilder( "cmd.exe","/c",String.format("mvn -q clean test -Dtrim=%s -Dano=%s", trim, ano));
            pb1.directory(new File(projectDir));

            // Redireciona a saída e o erro
            pb1.redirectErrorStream(true);

            // Inicia o processo
            Process process = pb1.start();

            // Lê a saída do processo
            printProcessOutput(process);

            ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "allure serve");

            pb2.directory(new File(projectDir));
            pb2.redirectErrorStream(true);

            Process processAllure = pb2.start();
            printProcessOutput(processAllure);

            processAllure.waitFor();

        } catch (IOException e) {
            e.fillInStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printProcessOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.ISO_8859_1))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}