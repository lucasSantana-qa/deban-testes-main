import os
import pandas as pd

extracao_caminho = r"C:\Testes automatizados\DEBAN\extracao\transacoes.csv"
saida_caminho = r"src\main\resources\transacoes_extraidas.xlsx"


def retornar_soma_dados_excel(arquivo_entrada, coluna_filtro):
    # Lê o CSV
    df = pd.read_csv(arquivo_entrada, sep=",", decimal=".")

    # # Filtro (opcional)
    # if coluna_filtro in df.columns:
    #     df_filtrado = df[df[coluna_filtro] == 450]
    # else:
    df_filtrado = df

    # Colunas que queremos somar
    colunas_para_somar = ["tarifa_intercambio", "soma_trn", "qtd_trn", "tarifa_desconto"]

    # Calcula as somas apenas das colunas que existem no arquivo
    somas = {}
    for col in colunas_para_somar:
        if col in df_filtrado.columns:
            somas[col] = df_filtrado[col].sum()
        else:
            somas[col] = None  # mantém chave para rastreabilidade

    # Cria DataFrame de resultado consolidado
    df_resultado = pd.DataFrame([somas])

    # Garante que o diretório de saída exista
    os.makedirs(os.path.dirname(saida_caminho), exist_ok=True)

    # Gera o Excel com as somas
    df_resultado.to_excel(saida_caminho, index=False)

    print(f"Arquivo de extração gerado com sucesso !")
    return df_resultado

if __name__ == "__main__":
    resultado = retornar_soma_dados_excel(extracao_caminho, "valor_total_intercambio")