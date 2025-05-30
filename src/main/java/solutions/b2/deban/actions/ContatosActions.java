package solutions.b2.deban.actions;

import solutions.b2.deban.propriedades.ContatosProps;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static solutions.b2.deban.utils.Utils.*;

public class ContatosActions implements ContatosProps {

    public void validarCampoTipoContato() {
        List<String> dados = getDadosFiller(contatosNomeArq,5, 6);
        String[] dadosEsperados = {tipoContato[0], tipoContato[1], tipoContato[1], tipoContato[2]};

        assertArrayEquals(dadosEsperados, dados.toArray(), "Gerado tipo de contato diferente do esperado");
    }

    public void validarCampoNome() {
        List<String> dados = getDadosFiller(contatosNomeArq,6, 56);
        String[] dadosEsperados = {nomes[0], nomes[0], nomes[1], ""};

        assertArrayEquals(dadosEsperados, dados.toArray(), "Gerado nome diferente do esperado");
    }

    public void validarCampoCargo() {
        List<String> dados = getDadosFiller(contatosNomeArq,56, 106);
        String[] dadosEsperados = {cargos[0], cargos[0], cargos[1], ""};

        assertArrayEquals(dadosEsperados, dados.toArray(), "Gerado cargo diferente do esperado");
    }

    public void validarCampoNumeroTelefone() {
        List<String> dados = getDadosFiller(contatosNomeArq,106, 156);
        String[] dadosEsperados = {numTelefone[0], numTelefone[0], numTelefone[1], ""};

        assertArrayEquals(dadosEsperados, dados.toArray(), "Gerado número de telefone diferente do esperado");
    }

    public void validarCampoEmail() {
        List<String> dados = getDadosFiller(contatosNomeArq,156, 192);
        String[] dadosEsperados = {emails[0], emails[0], emails[1], emails[2]};

        assertArrayEquals(dadosEsperados, dados.toArray(), "Gerado emails diferentes do esperado");
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

}
