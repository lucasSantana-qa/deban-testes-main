package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.DatabaseProps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static solutions.b2.deban.base.SetData.getTrimestre;

public class DatabaseActions implements DatabaseProps {

    public void validarTamanhoDaLinha(int tamanhoLinha) {
        assertEquals(databaseQtdLinhasHeader, tamanhoLinha);
    }

    public void validarCampoDataBase(String mes) {
        switch (getTrimestre()) {
            case primeiro:
                assertEquals("03", mes);
                break;
            case segundo:
                assertEquals("06", mes);
                break;
            case terceiro:
                assertEquals("09", mes);
                break;
            case quarto:
                assertEquals("12", mes);
                break;
        }
    }
}
