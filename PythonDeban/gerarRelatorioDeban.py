import os
import json
import xlsxwriter
from collections import defaultdict

ALLURE_RESULTS_DIR = 'C:\\Testes automatizados\\DEBAN-TESTES\\allure-results'
EXCEL_REPORT_PATH = 'C:\\Testes automatizados\\DEBAN\\relatorios\\relatorio-testes.xlsx'

workbook = xlsxwriter.Workbook(EXCEL_REPORT_PATH)

wrap_format = workbook.add_format({'text_wrap': True, 'border': 1})
cell_format = workbook.add_format({'border': 1})

def extrair_dados():
    dados = []
    for filename in os.listdir(ALLURE_RESULTS_DIR):
        if filename.endswith('-result.json'):
            with open(os.path.join(ALLURE_RESULTS_DIR, filename), encoding='utf-8') as f:
                json_data = json.load(f)

                feature = 'N/A'
                severity = 'unspecified'
                for label in json_data.get('labels', []):
                    if label.get('name') == 'feature':
                        feature = label.get('value', 'N/A')
                    if label.get('name') == 'severity':
                        severity = label.get('value', 'unspecified')

                nome = json_data.get('name', 'Sem nome')
                descricao = json_data.get('description', 'Sem descrição')
                status = json_data.get('status', 'unknown')

                erro = ''
                if status == 'failed':
                    erro = json_data.get('statusDetails', {}).get('message', '').replace('\n', ' ').strip()

                dados.append({
                    'feature': feature.strip().replace('\n', ' ').replace('"', "'"),
                    'nome': nome.strip().replace('\n', ' ').replace('"', "'"),
                    'descricao': descricao.strip().replace('\n', ' ').replace('"', "'"),
                    'status': status.strip(),
                    'erro': erro,
                    'severity': severity.strip()
                })
    return dados

def gerar_excel_com_grafico(dados):
    # Agrupar por status e severity
    status_severity_count = defaultdict(lambda: defaultdict(int))
    severities_set = set()

    for item in dados:
        status_severity_count[item['status']][item['severity']] += 1
        severities_set.add(item['severity'])

    severities = sorted(severities_set)
    statuses = ['passed', 'failed']

    worksheet = workbook.add_worksheet('Relatório')

    # Formatos
    header_format = workbook.add_format({'bold': True, 'bg_color': '#D9E1F2', 'border': 1})

    # Cabeçalhos
    headers = ['Feature', 'Nome', 'Descrição', 'Status', 'Severity']
    for col, header in enumerate(headers):
        worksheet.write(0, col, header, header_format)

    # Larguras
    worksheet.set_column('A:A', 20)
    worksheet.set_column('B:B', 47)
    worksheet.set_column('C:C', 131)
    worksheet.set_column('D:D', 10)
    worksheet.set_column('E:E', 12)

    # Dados
    for row, item in enumerate(dados, start=1):
        worksheet.write(row, 0, item['feature'], cell_format)
        worksheet.write(row, 1, item['nome'], cell_format)
        worksheet.write(row, 2, item['descricao'], cell_format)
        worksheet.write(row, 3, item['status'], cell_format)
        worksheet.write(row, 4, item['severity'], cell_format)

    # Aba do gráfico
    chart_sheet = workbook.add_worksheet('Gráfico')
    chart_sheet.write(0, 0, 'Severity', header_format)
    for col_idx, status in enumerate(statuses):
        chart_sheet.write(0, col_idx + 1, status.capitalize(), header_format)

    for row_idx, severity in enumerate(severities, start=1):
        chart_sheet.write(row_idx, 0, severity, cell_format)
        for col_idx, status in enumerate(statuses):
            count = status_severity_count[status].get(severity, 0)
            chart_sheet.write(row_idx, col_idx + 1, count, cell_format)

    # Gráfico de barras
    chart = workbook.add_chart({'type': 'column'})
    for col_idx, status in enumerate(statuses):
        chart.add_series({
            'name': status,
            'categories': f'=Gráfico!$A$2:$A${len(severities)+1}',
            'values': f'=Gráfico!${chr(66+col_idx)}$2:${chr(66+col_idx)}${len(severities)+1}',
            'data_labels': {'value': True},
        })

    chart.set_title({'name': 'Status dos Testes por Severidade'})
    chart.set_x_axis({'name': 'Severidade'})
    chart.set_y_axis({'name': 'Quantidade'})
    chart.set_style(10)
    chart.set_legend({'position': 'top'})

    chart_sheet.insert_chart('E2', chart, {'x_scale': 1.8, 'y_scale': 1.5})

    # Aba extra: Falhas Detalhadas
    falhas = [d for d in dados if d['status'] == 'failed']
    if falhas:
        falha_sheet = workbook.add_worksheet('Falhas Detalhadas')
        falha_headers = ['Feature', 'Nome do Teste', 'Severity', 'Erro']
        for col, header in enumerate(falha_headers):
            falha_sheet.write(0, col, header, header_format)

        falha_sheet.set_column('A:A', 20)
        falha_sheet.set_column('B:B', 45)
        falha_sheet.set_column('C:C', 12)
        falha_sheet.set_column('D:D', 100)

        for row, item in enumerate(falhas, start=1):
            falha_sheet.write(row, 0, item['feature'], cell_format)
            falha_sheet.write(row, 1, item['nome'], cell_format)
            falha_sheet.write(row, 2, item['severity'], cell_format)
            falha_sheet.write(row, 3, item['erro'], wrap_format)

    workbook.close()
    print(f'Excel gerado com gráfico e falhas detalhadas: {EXCEL_REPORT_PATH}')

if __name__ == '__main__':
    dados = extrair_dados()
    if not dados:
        print("Nenhum arquivo JSON de resultado do Allure encontrado.")
    else:
        dados.sort(key=lambda x: x['feature'].lower())
        gerar_excel_com_grafico(dados)