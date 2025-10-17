package solutions.b2.deban.base;

public class ConfigCaminhoArquivos {

    private static final String basePath = "C:\\Testes_automatizados\\DEBAN\\";

    public static String getCaminhoArquivos() {
        return String.format(basePath+"arquivos_deban\\%s\\%s\\", SetData.anoReferencia, SetData.trim);
    }

    public static String getBasePath() {
        return basePath;
    }
}