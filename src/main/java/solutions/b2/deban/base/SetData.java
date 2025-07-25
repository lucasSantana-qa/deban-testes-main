package solutions.b2.deban.base;

public class SetData {

    public static String anoReferencia = "2025";

    protected static TrimestreEnum trimestre = TrimestreEnum.segundo;

    public static TrimestreEnum getTrimestre() {
        return trimestre;
    }

    public enum TrimestreEnum {
        primeiro,
        segundo,
        terceiro,
        quarto
    }
}
