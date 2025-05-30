package solutions.b2.deban.utils;

import solutions.b2.deban.propriedades.SegmentoProps;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public record SegmentoEsperado(String nome, Set<CharSequence> descricoes, String codigo) implements SegmentoProps {

    public static List<SegmentoEsperado> getSegmentosEsperados() {
        return Arrays.asList(
                new SegmentoEsperado("Cuidados pessoais", descricaoCuidadosPessoais, "401"),
                new SegmentoEsperado("Bares e Restaurantes", descricaoBresRestaurantes, "402"),
                new SegmentoEsperado("Companhias aéreas e afins", descricaoCompanhiaAereasAfins, "403"),
                new SegmentoEsperado("Cultura e Esportes", descricaoCulturaEsportes, "404"),
                new SegmentoEsperado("Educação", descricaoEducacao, "405"),
                new SegmentoEsperado("Eletrônicos e eletrodomésticos", descricaoEletronicos, "406"),
                new SegmentoEsperado("Farmácias e Cuidados com a saúde", descricaoFarmacia, "407"),
                new SegmentoEsperado("Grandes Atacadistas", descricaoAtacadistas, "408"),
                new SegmentoEsperado("Outros Serviços e Profissionais Liberais", descricaoServicosLiberais, "409"),
                new SegmentoEsperado("Jogos e Loteria", descricaoJogosELoteria, "410"),
                new SegmentoEsperado("Livrarias e afins", descricaoLivrariaEAfins, "411"),
                new SegmentoEsperado("Alimentação", descricaoAlimentacao, "412"),
                new SegmentoEsperado("Móveis e construção", descricaoMoveisEConstrucao, "413"),
                new SegmentoEsperado("Pequenos supermercados e afins", descricaoSupermercadosEAfins, "414"),
                new SegmentoEsperado("Combustíveis e afins", descricaoCombustiveisAfins, "415"),
                new SegmentoEsperado("Roupas, sapatos, acessórios e afins", descricaoRoupasSapatosAcess, "416"),
                new SegmentoEsperado("Serviços médicos e afins", descricaoServicosMedicos, "417"),
                new SegmentoEsperado("Turismo e afins", descricaoTurismo, "418"),
                new SegmentoEsperado("Autos, peças e afins", descricaoAutosPecasEAfins, "419"),
                new SegmentoEsperado("Petshop", descricaoPetShop, "420"),
                new SegmentoEsperado("Comércio e serviços em geral", descricaoComercioEServicosGeral, "421"),
                new SegmentoEsperado("Serviços Financeiros", descricaoServicosFinanceiros, "422"),
                new SegmentoEsperado("Outros", descricaoOutros, "423"),
                new SegmentoEsperado("Instituições Financeiras", descricaoInstituicoesFinanceiras, "424"),
                new SegmentoEsperado("Serviços Públicos", descricaoServicosPublicos, "425"),
                new SegmentoEsperado("Seguros", descricaoSeguros, "426"),
                new SegmentoEsperado("Utilities (inclui telecom)", descricaoUtilities, "427"),
                new SegmentoEsperado("Subadquirentes", descricaoSubadiquirentes, "428")
        );
    }
}
