package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.ContatosProps;
import solutions.b2.deban.utils.Contato;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static solutions.b2.deban.utils.Utils.*;

public class ContatosActions implements ContatosProps {

    public void validarContatos() {
        List<Contato> contatosAtual = new ArrayList<>();

        for (int i=1; i<=getNumLinhasFiller(contatosNomeArq);i++) {
            String tipoContato = getDado(i, 5,6);
            String nome = getDado(i, 6,56);
            String cargo = getDado(i, 56,106);
            String telefone = getDado(i, 106, 156);
            String email = getDado(i,156,206 );

            Contato contato = new Contato(tipoContato, nome, cargo, telefone, email);
            contatosAtual.add(contato);
        }

        List<Contato> contatosEsperado = getContatos();

        assertEquals(contatosEsperado.size(), contatosAtual.size(), "Quantidade de contatos divergente");

        for (int i = 0; i < contatosEsperado.size(); i++) {
            Contato esperado = contatosEsperado.get(i);
            Contato atual = contatosAtual.get(i);

            assertEquals(esperado.tipoContato(), atual.tipoContato(), "Erro no tipoContato do contato " + i);
            assertEquals(esperado.nome(), atual.nome(), "Erro no nome do contato " + i);
            assertEquals(esperado.cargo(), atual.cargo(), "Erro no cargo do contato " + i);
            assertEquals(esperado.telefone(), atual.telefone(), "Erro no telefone do contato " + i);
            assertEquals(esperado.email(), atual.email(), "Erro no email do contato " + i);
        }
    }

    private static List<Contato> getContatos() {
        List<Contato> contatosEsperado = new ArrayList<>();
        contatosEsperado.add(new Contato(tipoContatoEsperados[0], nomesEsperados[0], cargosEsperados[0], telefonesEsperados[0], emailsEsperados[0]));
        contatosEsperado.add(new Contato(tipoContatoEsperados[1], nomesEsperados[0], cargosEsperados[0], telefonesEsperados[0], emailsEsperados[0]));
        contatosEsperado.add(new Contato(tipoContatoEsperados[2], "", "", "", emailsEsperados[2]));
        contatosEsperado.add(new Contato(tipoContatoEsperados[1], nomesEsperados[1], cargosEsperados[1], telefonesEsperados[0], emailsEsperados[1]));
        return contatosEsperado;
    }

    public void validarQtdDePosicoesLinhasFillerContatos() {
        int qtdLinhasFiller = getNumLinhasFiller(contatosNomeArq);

        for (int i = 1; i <= qtdLinhasFiller; i++) {
            int tamanhoLinha = getLinha(contatosNomeArq, i).length();

            if (tamanhoLinha > contatosQtdLinhasFiller) {
                fail("Linha " + i + " excedeu o limite de posições");
            }
        }
    }

    private String getDado(int linha, int inicio, int fim) {
        return getLinha(contatosNomeArq, linha).substring(inicio,fim).trim();
    }
}