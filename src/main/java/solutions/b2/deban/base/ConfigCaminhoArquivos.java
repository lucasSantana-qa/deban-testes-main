package solutions.b2.deban.base;

public class ConfigCaminhoArquivos {

    public static String getCaminhoArquivos() {
        String trim = "";

        switch (ConfigTrimestre.trimestre) {
            case primeiro -> trim = "1";
            case segundo -> trim = "2";
            case terceiro -> trim = "3";
            case quarto -> trim = "4";
        }
        return String.format("C:\\Testes automatizados\\DEBAN\\arquivos_deban\\%s\\%s\\", BaseTest.anoReferencia, trim);
    }
}