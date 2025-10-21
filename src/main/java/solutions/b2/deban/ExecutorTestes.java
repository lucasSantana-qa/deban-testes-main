package solutions.b2.deban;

import solutions.b2.deban.base.ConfigCaminhoArquivos;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ExecutorTestes {
    public static void main(String[] args) {
        try {
            String projectDir = ConfigCaminhoArquivos.getBasePath()+"\\DEBAN-TESTES-MAIN";

            Scanner s = new Scanner(System.in);

            System.out.println("Antes de começar as validações, insira as seguintes informações: ");

            boolean continua = false;
            while (!continua) {
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Qual o ano dos arquivos ?");
                int ano = s.nextInt();
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Qual o trimestre dos arquivos ? (1,2,3 ou 4)");
                int trim = s.nextInt();
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Qual arquivo deseja validar ? 0-Conccred 1-Contatos 2-Database 3-Desconto 4-Infresta 5-Intercam 6-Lucrcred 7-Ranking 8-Segmento 9-Todos");
                int numArq = s.nextInt();

                if (trim < 1 || trim > 4) {
                    System.err.println("Informe um valor correto para o trimestre");
                } else if (numArq < 0 || numArq > 9) {
                    System.err.println("Informe um número dentro da sequência dos arquivos");
                } else {
                    continua = true;
                    switch (numArq) {
                        case 0 -> executarTestes(trim, ano, "ConccredTest", new File(projectDir));
                        case 1 -> executarTestes(trim, ano, "ContatosTest", new File(projectDir));
                        case 2 -> executarTestes(trim, ano, "DatabaseTest", new File(projectDir));
                        case 3 -> executarTestes(trim, ano, "DescontoTest", new File(projectDir));
                        case 4 -> executarTestes(trim, ano, "InfrestaTest", new File(projectDir));
                        case 5 -> executarTestes(trim, ano, "IntercamTest", new File(projectDir));
                        case 6 -> executarTestes(trim, ano, "LucrcredTest", new File(projectDir));
                        case 7 -> executarTestes(trim, ano, "RankingTest", new File(projectDir));
                        case 8 -> executarTestes(trim, ano, "SegmentoTest", new File(projectDir));
                        case 9 -> executarTestes(trim, ano, "", new File(projectDir));
                    }
                }
            }

        } catch (IOException e) {
            e.fillInStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executarTestes(int trim, int ano,String arq, File projectDir) throws IOException, InterruptedException {
        ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", String.format("mvn clean test -Dtest=%s -Dtrim=%s -Dano=%s",arq, trim, ano));
        pb1.directory(new File(projectDir.toURI()));

        // Redireciona a saída e o erro
        pb1.redirectErrorStream(true);

        // Inicia o processo
        Process process = pb1.start();
        System.out.println("Iniciando validações");

        // Lê a saída do processo
        printProcessOutput(process);

        ProcessBuilder pb2 = new ProcessBuilder("cmd.exe", "/c", "allure serve");

        pb2.directory(new File(projectDir.toURI()));
        pb2.redirectErrorStream(true);

        System.out.println("Gerando relatório de execução de testes");
        Process processAllure = pb2.start();
        printProcessOutput(processAllure);

        processAllure.waitFor();
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