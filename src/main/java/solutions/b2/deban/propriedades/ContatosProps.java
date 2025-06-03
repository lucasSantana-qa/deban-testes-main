package solutions.b2.deban.propriedades;

import java.util.List;

public interface ContatosProps {

    String contatosNomeArq = "CONTATOS.txt";

    List<String>numTelefone = List.of("(34) 3256 - 7290", "(34) 3256 - 7290","", "(34) 3256 - 7290");
    List<String>nomes = List.of("Monica Yukari Fukazawa Kitahara","Monica Yukari Fukazawa Kitahara", "", "Kenia Ferreira Alves");
    List<String>cargos = List.of("DIRETOR","DIRETOR", "", "Analista");
    List<String>emails = List.of("monicak@tribanco.com.br","monicak@tribanco.com.br", "fiscal@tribanco.com.br", "keniaf@tribanco.com.br");
    List<String> tipoContato = List.of("D","T", "I", "T");

    int contatosQtdLinhasFiller = 206;


}
