package solutions.b2.deban.actions;

import solutions.b2.deban.base.SetData;
import solutions.b2.deban.propriedades.DatabaseProps;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseActions implements DatabaseProps {

    public void validarTamanhoDaLinha(int tamanhoLinha) {
        assertEquals(databaseQtdLinhasHeader, tamanhoLinha);
    }

    public void validarCampoDataBase(String mes) {
        switch (SetData.trim) {
            case "1":
                assertEquals("03", mes);
                break;
            case "2":
                assertEquals("06", mes);
                break;
            case "3":
                assertEquals("09", mes);
                break;
            case "4":
                assertEquals("12", mes);
                break;
        }
    }
}
