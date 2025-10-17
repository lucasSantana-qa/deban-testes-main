package solutions.b2.deban.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import solutions.b2.deban.base.ConfigCaminhoArquivos;
import solutions.b2.deban.base.SetData;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.b2.deban.base.ConfigCaminhoArquivos.getCaminhoArquivos;
import static solutions.b2.deban.base.SetData.*;

public class Utils implements UtilsDados {

    public static String getLinha(String nomeArq, int linhaDesejada) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(getCaminhoArquivos() + nomeArq), formatoArq))) {
            int atual = 0;
            String linha;
            while ((linha = br.readLine()) != null) {
                if (atual++ == linhaDesejada) {
                    return linha;
                }
            }
            throw new IllegalArgumentException("Linha não encontrada: " + linhaDesejada);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static BigDecimal getVolumeValorTransacao(String nomeArq, int incio, int fim) {
        List<String> dados = Utils.getDadosFiller(nomeArq, incio, fim);

        BigDecimal soma = BigDecimal.ZERO;
        for (String dado : dados) {
            String novoValor = dado.substring(0, dado.length() - 2) + "," + dado.substring(dado.length() - 2).trim();
            BigDecimal valorBigDecimal = new BigDecimal(novoValor.replace(",","."));
            soma = soma.add(valorBigDecimal);
        }
        return soma;
    }

    public static Integer getVolumeQtdTransacoes(String nomeArq, int inicio, int fim) {
        List<String> dados = getDadosFiller(nomeArq, inicio,fim);

        int volumeQtdTransacao = 0;
        for (String dado : dados) {
            int valor = Integer.parseInt(dado);
            volumeQtdTransacao += valor;
        }
        return volumeQtdTransacao;
    }

    public static void validarVolumeValorTransacao(BigDecimal volume1, BigDecimal volume2, String nomeArq1, String nomeArq2) {
        BigDecimal diferenca = volume1.subtract(volume2).abs().setScale(2, RoundingMode.UNNECESSARY);
        String diferencaFormatada = formatarValorMoeda(diferenca);
        String volume1Formatado = formatarValorMoeda(volume1);
        String volume2Formatado = formatarValorMoeda(volume2);

        if (volume1.compareTo(volume2) != 0) {
            fail(String.format("O volume de valor de transacões é diferente nos arquivos %s e %s \n volume1: %s volume2: %s \n Diferença: %s",
                    nomeArq1, nomeArq2, volume1Formatado, volume2Formatado, diferencaFormatada));
        } else
            assertTrue(true);
    }

    public static void validarVolumeQtdTransacao(int volume1, int volume2, String nomeArq1, String nomeArq2) {
        int diferenca = volume1 - volume2;

        String volume1Formatado = formatarInteiro(volume1);
        String volume2Formatado = formatarInteiro(volume2);

        if(diferenca != 0) {
            fail(String.format("O volume de valor de transacões é diferente nos arquivos %s e %s \n volume1: %s volume2: %s \n Diferença: %d",
                    nomeArq1, nomeArq2, volume1Formatado, volume2Formatado, diferenca));
        } else
            assertTrue(true);
    }

    public static List<String> getDadosFiller(String nomeArq, int inicio, int fim) {
        List<String> dados = new ArrayList<>();
        String caminho = getCaminhoArquivos() + nomeArq;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(caminho), formatoArq))) {

            boolean primeiraLinha = true;
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }
                if (linha.length() >= fim) {
                    String dado = linha.substring(inicio, fim).trim();
                    dados.add(dado);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + nomeArq, e);
        }
        return dados;
    }

    public static int getNumLinhasFiller(String nomeArq) {
        int contador = 0;
        Path caminho = Paths.get(getCaminhoArquivos() + nomeArq);

        try (BufferedReader reader = Files.newBufferedReader(caminho, formatoArq)) {
            String linha = reader.readLine();
            while ((linha = reader.readLine()) != null) {
                contador++;
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao contar linhas do arquivo: " + nomeArq, e);
        }

        return contador;
    }

    public static void validarCampoCnpj(String cnpj) {
        assertEquals(cnpjCredenciador, cnpj, "O campo CNPJ está incorreto");
    }

    public static void validarCampoNome(String esperado, String atual) {
        assertEquals(esperado, atual);
    }

    public static void validarCampoQuantidadeReg(String campoQtdReg, String nomeArq) {
        assertEquals(Integer.parseInt(campoQtdReg.trim()), getNumLinhasFiller(nomeArq));
    }

    public static void validarQuantidadePosicoesLinha(String nomeArq, int linha, int qtdEsperada) {
        assertEquals(qtdEsperada, getLinha(nomeArq, linha).length(), "A linha "+(linha+1)+" está com a quantidade de posições incorreta");
    }

    public static void validarCampoAno(String nomeArq) {
        List<String> dados = getDadosFiller(nomeArq, 0, 4);

        for (String dado : dados) {
            assertEquals(SetData.anoReferencia, dado);
        }
    }

    public static void validarCampoTrimestre(String nomeArq) {
        List<String> dados = getDadosFiller(nomeArq, 4, 5);

        String trimEsperado = trim;

        for (String dado : dados) {
            assertEquals(trimEsperado, dado);
        }
    }

    public static void validarQuantidadeDePosicoesLinhasFiller(String nomeArq, int qtdEsperada) {
        int qtdLinhasFiller = getNumLinhasFiller(nomeArq);

        for (int i=1; i<=qtdLinhasFiller; i++){
            validarQuantidadePosicoesLinha(nomeArq, i, qtdEsperada);
        }
    }

    public static void validarCampoFuncao(String nomeArq, int inicio, int fim) {
        for (String dado : getDadosFiller(nomeArq,inicio,fim)) {
            String campoFuncao = dado.trim();

            if (!funcoes.contains(campoFuncao)) {
                fail("Existe um domínio incorreto no campo função: " + campoFuncao);
            } else
                assertTrue(true);
        }
    }

    public static void validarCampoBandeira(String nomeArq, int inicio, int fim) {
        for (String dado : getDadosFiller(nomeArq,inicio,fim)) {
            String campoBandeira = dado.trim();

            if (!bandeiras.contains(campoBandeira)) {
                fail("Existe um domínio incorreto no campo bandeira: " + campoBandeira);
            } else
                assertTrue(true);
        }
    }

    public static void validarCampoFormaCaptura(String nomeArq, int inicio, int fim) {
        for (String dado : getDadosFiller(nomeArq,inicio, fim)) {
            String campoformaCaptura = dado.trim();

            if (!formas_captura.contains(campoformaCaptura)) {
                fail("Existe um domínio incorreto no campo forma de captura: " + campoformaCaptura);
            } else
                assertTrue(true);
        }
    }

    public static void validarCampoNumParcelas(String nomeArq, int inicio, int fim) {
        for (String dado : getDadosFiller(nomeArq,inicio,fim)) {
            String campoNumeroParcela = dado.trim();

            if (!numero_parcelas.contains(campoNumeroParcela)) {
                fail("Existe um domínio incorreto no campo número de parcelas: " + campoNumeroParcela);
            } else
                assertTrue(true);
        }
    }

    public static void validarCampoSegmento(String nomeArq, int inicio, int fim) {
        for (String dado : getDadosFiller(nomeArq, inicio,fim)) {
            String campoSegmento = dado.trim();

            if (!segmentos.contains(Integer.parseInt(campoSegmento))) {
                fail("Existe um domínio incorreto no campo Segmento: " + campoSegmento);
            } else
                assertTrue(true);
        }
    }

    public static void validarCampoValorTransacaoDiferenteDeZero(String nomeArq, int inicio, int fim) {
        List<String> dados = getDadosFiller(nomeArq, inicio,fim);
        int i = 1;

        for (String dado : dados) {
            assertNotEquals("000000000000000", dado, "Foi reportado registro com valor transação igual a 0 na linha " + i);
            i+=1;
        }
    }

    public static void validarCampoQuantidadeTransacaoDiferenteDeZero(String nomeArq, int inicio, int fim) {
        List<String> dados = getDadosFiller(nomeArq, inicio,fim);
        int i = 1;

        for (String dado : dados) {
            long dadoInt = Long.parseLong(dado);
            assertNotEquals(0, dadoInt, "Foi reportado registro com quantidade de transação igual a 0 na linha " + i);
            i+=1;
        }
    }

    public static void validarFormatoCampoDataGeracao(String nomeArq) {
        String dado = getLinha(nomeArq, 0).substring(8,16);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        try {
            LocalDate data = LocalDate.parse(dado, formatter);
            String dataFormatada = data.format(formatter);

            assertEquals(dado, dataFormatada, "A data não está exatamente no formato yyyyMMdd.");
        } catch (DateTimeParseException e) {
            fail("A data nao pode ser parseada no formato yyyyMMdd -> " + e.getMessage());
        }
    }

    public static BigDecimal getVolumeExtracao(int colunaExcel) {
        String caminhoArquivo = ConfigCaminhoArquivos.getBasePath()+"DEBAN-TESTES-MAIN\\src\\main\\resources\\transacoes_extraidas.xlsx";

        try (FileInputStream fis = new FileInputStream((caminhoArquivo));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // primeira aba
            Row row = sheet.getRow(1); // linha 1 (a segunda, pois é zero-based)
            Cell cell = row.getCell(colunaExcel); // coluna A

            return BigDecimal.valueOf(cell.getNumericCellValue());
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static String formatarValorMoeda(BigDecimal valorBigDecimal) {
        return NumberFormat.getCurrencyInstance(new Locale("pt", "BR")).format(valorBigDecimal);
    }

    public static String formatarInteiro(Integer valor) {
        return NumberFormat.getIntegerInstance(new Locale("pt", "BR")).format(valor);
    }

    public static BigDecimal formataValorDuasCasasDecimais(String dado) {
        BigDecimal valor = new BigDecimal(dado);
        return valor.movePointLeft(2);
    }
}