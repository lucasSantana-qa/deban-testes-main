package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.ContatosProps;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.b2.deban.utils.Utils.*;

public class ContatosActions implements ContatosProps {

    public void validarCampoTipoContato() {
        List<String> dados = new ArrayList<>(getDadosFiller(contatosNomeArq,5, 6));
        List<String> dadosEsperados = new ArrayList<>(tipoContato);

        assertEquals(dadosEsperados, dados);
    }

    public void validarCampoNome() {
        List<String> dados = getDadosFiller(contatosNomeArq,6, 56);
        List<String> dadosEsperados = new ArrayList<>(nomes);

        assertEquals(dadosEsperados, dados);
    }

    public void validarCampoCargo() {
        List<String> dados = getDadosFiller(contatosNomeArq,56, 106);
        List<String> dadosEsperados = new ArrayList<>(cargos);

        assertEquals(dadosEsperados, dados);
    }

    public void validarCampoNumeroTelefone() {
        List<String> dados = getDadosFiller(contatosNomeArq,106, 156);
        List<String> dadosEsperados = new ArrayList<>(numTelefone);

        assertEquals(dadosEsperados, dados);
    }

    public void validarCampoEmail() {
        List<String> dados = getDadosFiller(contatosNomeArq,156, 192);
        List<String> dadosEsperados = new ArrayList<>(emails);

        assertEquals(dadosEsperados, dados);
    }

    public void validarQtdDePosicoesLinhasFillerContatos() {
        int qtdLinhasFiller = getNumLinhasFiller(contatosNomeArq);

        for (int i=1; i<=qtdLinhasFiller; i++) {
            int tamanhoLinha = getLinha(contatosNomeArq, i).length();

            if (tamanhoLinha > contatosQtdLinhasFiller) {
                fail("Linha " + i + " excedeu o limite de posições");
            }
        }
    }

    public void validarContatos() {

    }
}
