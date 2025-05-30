package solutions.b2.deban.propriedades;

import java.util.Set;

public interface SegmentoProps {

    String segmentoNomeArq = "SEGMENTO.txt";

    int segmentoqtdPosicoesLinhaFiller = 303;

    Set<CharSequence> descricaoCuidadosPessoais = Set.of("Loja de cosméticos",
            "Clínicas de estética facial / corporal",
            "Salão de beleza / barbearia / depilação / manicure",
            "Navalha elétrica - venda e serviços",
            "Centro de saunas e massagens");

    Set<CharSequence> descricaoBresRestaurantes = Set.of("Restaurantes",
            "Bares, pubs e casas noturnas",
            "Lanchonetes de comidas rápidas (fast food)",
            "Bares de sinuca");

    Set<CharSequence> descricaoCompanhiaAereasAfins = Set.of("Reservado para cias aéreas específicas"
            ,"Outras cias aéreas","Aeroportos e serviços ligados a aeronaves");

    Set<CharSequence> descricaoCulturaEsportes = Set.of("Bandas, orquestras, artistas diversos",
            "Cinemas, produções cinematográficas",
            "Serviços de recreação e festas",
            "Boliche",
            "Loja instrumento musicais",
            "Galeria de arte (art dealers & galleries)",
            "Loja de bicicletas - vendas e serviços",
            "Serviços gerais para esportes",
            "Lojas de vídeos",
            "Dança (estúdios, escolas e salões)",
            "Quadras de esporte / propaganda esportiva",
            "Lojas de diversão / vídeo game / lan house / ciber café",
            "Academias / clubes",
            "Parque de diversão, circo e afins",
            "Atrações turísticas e exposições",
            "Aquários e zoológicos",
            "Aulas de golf",
            "Teatros, produc. teatr. e espetáculos",
            "Produtores e distribuidores de filmes");

    Set<CharSequence> descricaoEducacao = Set.of("Educação primária e secundária",
            "Universidades e faculdades",
            "Educação a distância",
            "Escola de comércios e secretariado",
            "Escola de negócios/vocações",
            "Colégios",
            "Serviços de cuidados de crianças");

    Set<CharSequence> descricaoEletronicos = Set.of("Produtos digitais - jogos",
            "Computadores, equipamentos e softwares",
            "Lojas de eletrodomésticos",
            "Loja de eletrônicos",
            "Conserto de equip. áudio e tv",
            "Conserto de eletrônicos",
            "Loja artigos eletrônicos",
            "Redes de computadores / serviços de informação",
            "Loja de software",
            "Programação de computadores e process. de dados",
            "Serviço de recuperação de informação",
            "Computadores: consertos e reparos",
            "Produtos digitais - aplicativos de software (exceto jogos)",
            "Produtos digitais - diversas categorias",
            "Máquinas de escrever - venda, aluguel e serviços",
            "Produtos digitais de comunicação social audiovisual");

    Set<CharSequence> descricaoFarmacia = Set.of("A/d de equipamento hospitalares, médicos e oftálmicos",
            "Farmacêuticos",
            "Farmácias",
            "Aparelhos auditivos - vendas e serviços",
            "Bens ortopédicos - próteses");

    Set<CharSequence> descricaoAtacadistas = Set.of("Venda por atacado (wholesale clubs)",
            "Atacados de bebidas alcoólicas");

    Set<CharSequence> descricaoServicosLiberais = Set.of("Outros serviços pessoais",
            "Serviços de impressão e arte gráfica",
            "Serviço de extermínio e desinfetação",
            "Serviço limpeza e manutenção",
            "Lavanderia - familiar e comercial",
            "Lavandaria, limpeza e serviços de vestuário",
            "Lavanderia tinturaria",
            "Laboratórios de teste (para testes não médicos)",
            "Lojas de penhores",
            "Agências de análise de crédito de consumidores",
            "Agência de cobrança de dívidas",
            "Corretores de imóveis",
            "Serviço de secretariado e estenografia",
            "Laboratórios fotográficos",
            "Serviços de negócios",
            "Estúdios de fotografia",
            "Serviço funerário",
            "Serviço de encontros e acompanhante",
            "Serviços de prep. imposto de renda",
            "S. De aconselhamento de dívidas, casamento e pessoal",
            "Publicidades",
            "Agências de emprego",
            "Consultoria empresarial e serviços de relações públicas",
            "Agências de detetives, proteção e de segurança",
            "Venda direta (direct sell/door-to-door)",
            "Outros vendedores de marketing direto",
            "Serviços jurídicos - advogados",
            "Arquitetura, engenharia e agrimensura",
            "Contabilidade, auditoria e serviços de contabilidade",
            "Outros serviços profissionais de especializados",
            "Org. Sind., assoc. Cult. e outras assoc. não classif.",
            "Organizações de serviços beneficentes e sociais",
            "Associações cívicas e sociais",
            "Organizações políticas",
            "Organizações religiosas");

    Set<CharSequence> descricaoJogosELoteria = Set.of("Loteria de propriedade do governo (países específicos)",
            "Cassinos, loterias e jogos de azar",
            "Loteria pública",
            "Cassinos online licenciado",
            "Corrida de cavalos licenciado");

    Set<CharSequence> descricaoLivrariaEAfins = Set.of("Copiadoras e fotocopiadoras",
            "Atac. e distrib. de livros, periódicos e jornais",
            "Lojas de discos",
            "Livrarias",
            "Editoras - publicações e impressões",
            "Equipamentos de fotografia, cópia e microfilme",
            "Artigos de papelaria e suprimentos para escritório",
            "Papelarias",
            "Banca de jornal e provedor de notícias");

    Set<CharSequence> descricaoAlimentacao = Set.of("Açougueiro (freezer/meat lockers)",
            "Loja de doces",
            "Loja de produtos de lacticínios",
            "Confeitarias",
            "Loja de alimentos variados",
            "Distribuição e produção de alimentos",
            "Mercadorias não duráveis (não classif. em outro)");

    Set<CharSequence> descricaoMoveisEConstrucao = Set.of("Restauração de móveis",
            "Equip./distrib. de hardware",
            "Limpeza de tapetes e estofados",
            "Material para construção",
            "Material de construção (pequeno/médio porte)",
            "Material de construção produtos brutos",
            "Lojas de vidros, tintas e papéis de parede",
            "Venda de equipamentos, incluindo de ferragem",
            "Jardinagem",
            "Loja de móveis",
            "Loja de pisos",
            "Loja de estofados",
            "Lareiras e acessórios",
            "Loja de móveis especializada",
            "Empreiteiros em geral - comercial e residencial",
            "Prest. De serv. Para ar cond., encanamento e aquec.",
            "Eletricistas e serviços elétricos",
            "Pedreiros e serviços de instalação",
            "Marceneiros e serviços de carpintaria",
            "Demais serviços de reforma e construção",
            "Aluguel de equipamento e mobília de escritórios",
            "Conserto de ar-condicionado",
            "Serralheiros e soldadores",
            "Centros de serviços de metais (metal service centers)",
            "Equip. de aquecimento/encanamento",
            "Suprimentos industriais (não classificado em outro)",
            "Atacadistas e distribuidores de mercadorias duráveis",
            "Móveis para escritórios",
            "Piscinas e banheiras - serviços, suprimentos e vendas",
            "Serviços de paisagismo e horticultura");

    Set<CharSequence> descricaoSupermercadosEAfins = Set.of("Mercearias/supermercados",
            "Lojas de variedades",
            "Loja mercadorias gerais",
            "Lojas especializadas não listadas anteriormente");

    Set<CharSequence> descricaoCombustiveisAfins = Set.of("Distribuidor automatizado de combustível",
            "Revendedores de combustíveis",
            "Postos de gasolina");

    Set<CharSequence> descricaoRoupasSapatosAcess = Set.of("Roupa esportiva",
            "Atacadistas e distribuidores de roupas",
            "Atacadistas e distribuidores de calçados",
            "Artigos masculinos",
            "Roupas femininas pronta para usar",
            "Acessórios femininos e lingeries",
            "Roupas masculinas, femininas e infantis",
            "Sapatos",
            "Loja de peles",
            "Roupa unissex",
            "Costureiras e alfaiates",
            "Lojas de peruca",
            "Conserto de relógios e joias",
            "Armarinhos e lojas de tecido",
            "Tecidos e produtos de armarinho",
            "Joalheria, pedras preciosas, metais",
            "Relojoaria",
            "Aluguel de roupas - fantasias, uniformes e roupas sociais",
            "Loja/reparo de sapatos",
            "Artigos para crianças e bebês",
            "Serviços gerias para vestimenta",
            "Artigos de couro");

    Set<CharSequence> descricaoServicosMedicos = Set.of("Médicos",
            "Dentistas e ortodontistas",
            "Osteopatas",
            "Quiropraxia",
            "Oftalmologista e optometristas",
            "Tratamentos pediátricos",
            "Casas de repouso, recuperação e enfermagem",
            "Hospitais",
            "Ambulâncias",
            "Análises clínicas médicas e dentais",
            "Medicina em geral e praticantes de serviços de saúde");

    Set<CharSequence> descricaoTurismo = Set.of("Agências de viagens",
            "MCCs específicos de hotéis/acomodação",
            "Hotéis",
            "Acampamentos recreativos e desportivos",
            "Transporte de passageiros em trem (longa distância)",
            "Cruzeiros",
            "Marinas, serviços e fornecedores",
            "MCCs específicos de empresas locadoras de carros",
            "Aluguel de automóveis",
            "Aluguel de motor home",
            "Aluguel e arrendamento de barcos, esquis e iates",
            "Serviços de acampamentos");

    Set<CharSequence> descricaoAutosPecasEAfins = Set.of("Pintura e polimento",
            "Aluguel de caminhõe",
            "Serviços de limpeza e polimento",
            "Atacadistas e distribuidores de acessórios de veículos",
            "Venda de carros e caminhões (novos e usados)",
            "Venda de carros usados",
            "Lojas de automóveis, lojas de acessórios doméstico",
            "Loja de pneus",
            "Loja de peças e acessórios de carros",
            "Venda de barcos motorizados",
            "Artigos para acampamento",
            "Lojas de motocicletas e acessórios",
            "Venda de trailers",
            "Estacionamentos e garagens de carro",
            "Funilarias e pintura automotiva",
            "Borracharias",
            "Lojas de pintura de automóveis",
            "Serviços para carros (não concessionária)",
            "Lava jato",
            "Guincho",
            "Concessionária de moto de neve",
            "Serviços gerias para carros");

    Set<CharSequence> descricaoPetShop = Set.of("Veterinária",
            "Loja de animais");

    Set<CharSequence> descricaoComercioEServicosGeral = Set.of("Loja de fotografia",
            "Lojas de barracas e toldos",
            "Cervejas, vinhos e licores",
            "Tabacaria",
            "Lojas de artigos de segunda mão / brechós",
            "Loja de antiguidades",
            "L. de reprodução de antiguidades",
            "Loja de presentes",
            "Loja de copos/cristais",
            "Produtos artesanais",
            "Loja de moedas e selos",
            "Loja de bens religiosos",
            "Floricultura",
            "Loja de brinquedos",
            "Fornecedores de máquinas de videogame ou jogos",
            "Loja de consertos gerais e serviços relacionados",
            "A/d de máquinas e equipamentos comerciais",
            "Opticians, optical goods, and eyeglasses",
            "Lojas de departamentos",
            "Atacadistas e distribuidores de flores, plantas e sementes",
            "Metalúrgicos",
            "Empreiteiro para serviços especializado",
            "Produtos químicos e semelhantes",
            "Produtos de petróleo",
            "Pedágios",
            "Serviços de transporte",
            "Tempo compartilhado",
            "Transporte ferroviário de carga",
            "Transporte local de passageiros, incluindo balsas",
            "Limusines e táxis",
            "Companhias de ônibus",
            "Duty free stores");

    Set<CharSequence> descricaoServicosFinanceiros = Set.of("Corretores de residências móveis",
            "Pagamentos de impostos",
            "Ordens de pagamento por transferência bancária",
            "Instituição financeira - agências e serviços",
            "Casas de câmbio",
            "Corretor de imóveis (aluguel)",
            "Energia elétrica / gás / água / saneamento",
            "Transações de provisão de fundos");

    Set<CharSequence> descricaoOutros = Set.of("Assinatura comercial",
            "Demolições, sucatas, desmanches de automóveis",
            "Associação de carros",
            "Clubes de compras",
            "Fabricação de placas e serviços relacionados",
            "Produtores de vinho",
            "Produtores de champanhe",
            "Cooperativa agrícola",
            "Serv. Diretos de viagens",
            "Catálogo de comércios",
            "Marketing direto - saída",
            "Marketing direto - entrada",
            "Lojas de desconto",
            "Transporte de carga rodoviário e armazenamento",
            "Correios - aéreo, terrestre e transitórios",
            "Armazenamento agrícola, refrigeração, bens domésticos",
            "Serviços de telecomunicação",
            "Tarifas telefônicas resumidas mensais",
            "Telegrafo",
            "Intra-company purchases");

    Set<CharSequence> descricaoInstituicoesFinanceiras = Set.of("Bancos / lojas de poupança e inst. Financeira",
            "Instituição financeira - caixa eletrônico");

    Set<CharSequence> descricaoServicosPublicos = Set.of("Pensão alimentícia",
            "Multas (fines)",
            "Pagamentos de títulos e finanças",
            "Serviços governamentais",
            "Postagens");

    Set<CharSequence> descricaoSeguros = Set.of("Venda de seguro",
            "Marketing direto de seguros");

    Set<CharSequence> descricaoUtilities = Set.of("Telefones e equipamentos de telecom",
            "Serviços de tv a cabo/paga");

    Set<CharSequence> descricaoSubadiquirentes = Set.of("Catálogo de varejo");

}
