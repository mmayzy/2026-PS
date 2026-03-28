# ==================================
# SISTEMA DE GEOPOLÍTICA
# ==================================
# Disciplina: Programação de Sistemas (PS)
# Aula: 12 e 13 
# Autor: Mayara, Yuri e Otávio.
# Data: 2026.03.28
# Repositório: https://github.com/mmayzy/2026-PS.git
# ==================================
#
# DESCRIÇÃO:
# Sistema de gepolitica que permite criar países, ve a história, acessar algumas informações, etc..
#
# ===================================

import datetime # importa a data atual
import os # imposta informações do sistema operacional para nao salvar em pastas erradas.
DIRETORIO_ATUAL = os.path.dirname(os.path.abspath(__file__))  # pega o caminho da pasta do projeto

# junta o caminho da pasta com o nome do arquivo
ARQUIVO = os.path.join(DIRETORIO_ATUAL, "dados.txt")

SEPARADOR = "|"

def carregar_dados():
    paises = []
    try:
        with open(ARQUIVO, "r", encoding="utf-8") as f:
            for linha in f:
                
                partes = linha.strip().split(SEPARADOR)
                if len(partes) == 6:
                    paises.append({
                        "nome": partes[0],
                        "pop": int(partes[1]),
                        "pib": float(partes[2]),
                        "ano_fund": int(partes[3]),
                        "governante": partes[4],
                        "fato_hist": partes[5]
                    })
    except FileNotFoundError:
        # se o arquivo não existe, retorna lista vazia sem erro
        return []
    except Exception as e:
        print(f"Erro ao carregar banco de dados. {e}")
    return paises # essa função carrega dados salvos no programa

def salvar_dados(paises):
    
    try:
        with open(ARQUIVO, "w", encoding="utf-8") as f:
            for p in paises:
                linha = f"{p['nome']}|{p['pop']}|{p['pib']}|{p['ano_fund']}|{p['governante']}|{p['fato_hist']}\n"
                f.write(linha)
    except Exception as e:
        print(f"Erro ao salvar. {e}") # essa função salva os dados que cadastramos ao encerrarmos o programa com a tecla 0

def cadastrar(paises):
    
    print("\n""========== FUNDAÇÃO DE NOVA NAÇÃO ==========")
    try:
        
        nome = input("Nome do país: ").strip()
        pop = int(input("População Total (em milhões): "))
        pib = float(input("PIB (em trilhões): "))
        ano_fund = int(input("Ano de Fundação: "))
        governante = input("Primeiro líder: ").strip()
        fato_hist = input("Resumo da história: ").strip()

        # operador lógico AND para validação
        if nome != "" and pop > 0:
            paises.append({
                "nome": nome, "pop": pop, "pib": pib,
                "ano_fund": ano_fund, "governante": governante,
                "fato_hist": fato_hist
            })
            print(f"{nome} adicionado ao mapa!")
        else:
            print("Dados inválidos.")
    except ValueError:
        print("Erro: Use apenas números para População, PIB e Ano.") # essa função é usada para cadastrar países e envia para salvar m=na primeirs função do cód.

def consultar_e_historia(paises):
    
    print("\n""========== RELATÓRIO GEOPOLÍTICO ==========")
    
    
    if not paises:
        print("Nenhum dado no mapa mundi.")
        return

    ano_atual = datetime.datetime.now().year
    
    for i, p in enumerate(paises, 1):
        
        idade = ano_atual - p['ano_fund']
        pib_per_capita = (p['pib'] * 10**6) / p['pop'] # Cálculo em milhões
        
        status = "Potência" if p["pib"] >= 2.0 else "Em desenvolvimento"
        
        print(f"{i}. {p['nome'].upper()} ({idade} anos de história)")
        print(f"   Status: {status} | PIB: ${p['pib']}T")
        print("=" * 40) # essa função permite que o relatório apoareca na função.

# --- NOVA FUNÇÃO ADICIONADA ---
def exibir_detalhes_historicos(paises):
    print("\n"" ============= ARQUIVOS HISTÓRICOS ============")
    if not paises:
        print("A história ainda não foi escrita.")
        return

    busca = input("Digite o nome da nação para ler sua história: ").strip().lower()
    achou = False
    ano_atual = datetime.datetime.now().year

    for p in paises:
        if p['nome'].lower() == busca:
            idade = ano_atual - p['ano_fund']
            print(f"\n======== MEMÓRIAS DE {p['nome'].upper()} ============")
            print(f" - Primeiro Líder: {p['governante']}")
            print(f"- Fundação: Ano {p['ano_fund']} ({idade} anos atrás)")
            print(f"- Um pouco da história:: {p['fato_hist']}")
            print("=" * 30)
            achou = True
            break
    
    if not achou:
        print("Nação não encontrada nos registros.") # função que permite analisar a história dos países
# ------------------------------

def dissolucao(paises):
    
    consultar_e_historia(paises)
    if not paises: return
    
    try:
        indice = int(input("\nÍndice da nação a ser dissolvida: ")) - 1
       
        if 0 <= indice < len(paises):
            removido = paises.pop(indice)
            print(f"A nação {removido['nome']} deixou de existir.")
        else:
            print("Índice inexistente.")
    except ValueError:
        print("Entrada inválida.") # apaga um país do banco de dados dados.txt

def menu():
    paises = carregar_dados()

    # TÓPICO 4: Estrutura de Repetição (WHILE) para o menu
    while True:
        print("\n ========== 🌍 SISTEMA DE GEOPOLÍTICA MUNDIAL ==========")
        print("1. Fundar ou cadastrar país")
        print("2. Consultar países (Geral)")
        print("3. Ver história de um país")
        print("4. Dissolver nação")
        print("0. Salvar e encerrar")
        print("=========================================================")

        opcao = input("Escolha: ")

        
        if opcao == "1":
            cadastrar(paises)
        elif opcao == "2":
            consultar_e_historia(paises)
        elif opcao == "3":
            exibir_detalhes_historicos(paises) 
        elif opcao == "4":
            dissolucao(paises)
        elif opcao == "0":
            salvar_dados(paises)
            print("💾 Dados salvos com sucesso. Saindo...")
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    menu() # função que aparece ao ser executada.