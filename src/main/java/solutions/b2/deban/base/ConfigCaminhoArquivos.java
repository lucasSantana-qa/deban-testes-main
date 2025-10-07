package solutions.b2.deban.base;

public class ConfigCaminhoArquivos {

    public static String getCaminhoArquivos() {
        return String.format("C:\\Testes automatizados\\DEBAN\\arquivos_deban\\%s\\%s\\", SetData.anoReferencia, SetData.trim);
    }
}