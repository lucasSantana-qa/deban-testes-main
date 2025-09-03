import pandas as pd

extracao_caminho = "C:\\Testes automatizados\\DEBAN\\extracao\\extracao_teste.csv"

def retornar_soma_dados_excel(arquivo_entrada,coluna_filtro, coluna_soma):
    df = pd.read_csv(arquivo_entrada, sep= ",", decimal= ".")

    # Exemplo de filtro (opcional)
    if coluna_filtro in df.columns:
        df_filtrado = df[df[coluna_filtro] == 450]
    else:
        df_filtrado = df

    # Soma da coluna
    soma = None
    if coluna_soma in df_filtrado.columns:
        soma = df_filtrado[coluna_soma].sum()

        # Criar um novo DataFrame só com o resultado
        df_resultado = pd.DataFrame({f"Soma_{coluna_soma}": [soma]})

        # Salvar apenas o valor em um novo arquivo
        df_resultado.to_excel("dados_extraidos.xlsx", index=False)

    return soma

if __name__ == "__main__":
    valor_soma_tarifa_intercambio = retornar_soma_dados_excel(extracao_caminho,
                                                              "valor_total_intercambio", "tarifa_intercambio")
    valor_soma_tarifa_desconto = retornar_soma_dados_excel(extracao_caminho, "valor_total_desconto", "tarifa_desconto")