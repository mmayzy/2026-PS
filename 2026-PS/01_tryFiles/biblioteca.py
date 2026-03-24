# ==================================
# SISTEMA DE BIBILIOTECA
# ==================================
# Disciplina: Programação de Sistemas (PS)
# Aula: 10 - Sistema de biblioteca
# Autor: Mayara Mierzva
# Data: 2026.03.24
# Repositório: https://github.com/mmayzy/2026-PS.git
# ==================================
#
# DESCRIÇÃO:
# Sistema de biblioteca com lista de livros, busca, cadastro, empestimos, 
# devoluções, etc...
# ===================================

import os
from datetime import datetime

# Centralizar o nome evita erros de digitação em todo o código
DIRETORIO_ATUAL = os.path.dirname(os.path.abspath(__file__))
ARQUIVO   = os.path.join(DIRETORIO_ATUAL, "biblioteca.txt")
HISTORICO = os.path.join(DIRETORIO_ATUAL, "historico.txt")
SEPARADOR = "|"  # separa campos em cada linha do .txt

def carregar_catalogo():
    """Le o .txt e reconstroi a lista de dicionarios."""
    catalogo = []
    try:
        # 'r' = leitura | encoding='utf-8' garante acentos corretos
        with open(ARQUIVO, "r", encoding="utf-8") as f:
            for linha in f:
                linha = linha.strip()
                if not linha:        # ignora linhas vazias
                    continue
                
                partes = linha.split(SEPARADOR)
                if len(partes) != 3:  # linha malformada -> pula
                    continue
                
                titulo, autor, disponivel_str = partes
                catalogo.append({
                    "titulo":     titulo,
                    "autor":      autor,
                    # a string "True" no arquivo precisa virar bool True
                    "disponivel": disponivel_str == "True"
                })
    
    except FileNotFoundError:
        pass  # primeira execucao: arquivo ainda nao existe - tudo bem
    
    return catalogo

def salvar_catalogo(catalogo):
    """Grava toda a lista no arquivo .txt."""
    try:
        # 'w' = write: cria se nao existir, sobrescreve se existir
        with open(ARQUIVO, "w", encoding="utf-8") as f:
            for livro in catalogo:
                linha = f"{livro['titulo']}{SEPARADOR}{livro['autor']}{SEPARADOR}{livro['disponivel']}\n"
                f.write(linha)
                
        print(f"   Catalogo salvo em '{ARQUIVO}'.")
        
    except IOError as e:
        # IOError: disco cheio, permissao negada, etc.
        print(f"   Erro ao salvar: {e}")

def registrar_no_historico(acao):
    """Guarda a data e o que foi feito num txt separado."""
    agora = datetime.now().strftime("%d/%m/%Y %H:%M")
    try:
        # 'a' serve pra adicionar no fim sem apagar o que ja tinha
        with open(HISTORICO, "a", encoding="utf-8") as f:
            f.write(f"[{agora}] {acao}\n")
    except IOError as e:
        print(f"Erro ao gravar historico: {e}")

def listar_livros(catalogo):
    """Exibe todos os livros com numeração e status."""
    print("\n" + "=" * 50)
    print("   CATÁLOGO DA BIBLIOTECA")
    print("=" * 50)

    if not catalogo:
        print("Nenhum livro cadastrado.")
        return

    for i, livro in enumerate(catalogo, 1):
        status = "Disponível" if livro["disponivel"] else "Emprestado"
        print(f"  {i}. {livro['titulo']} - {livro['autor']}  [{status}]")

    print("=" * 50)

def adicionar_livro(catalogo):
    """Coleta dados via input e adiciona um novo livro ao catálogo."""
    print("\n--- Adicionar Novo Livro ---")

    titulo = input("Título: ").strip()
    autor  = input("Autor : ").strip()

    if not titulo or not autor:
        print(" Título e autor são obrigatórios.")
        return

   
    for livro in catalogo:
        if livro["titulo"].lower() == titulo.lower():
            print("Erro: Este livro já existe no catálogo!")
            return

    catalogo.append({
        "titulo":     titulo,
        "autor":      autor,
        "disponivel": True
    })

    salvar_catalogo(catalogo)
    print(f"   '{titulo}' adicionado com sucesso!")

def buscar_livro(catalogo):
    print("\n--- Buscar Livro ---")
    termo = input("Digite parte do título: ").strip().lower()

    try:
        resultados = [l for l in catalogo if termo in l["titulo"].lower()]

        if not resultados:
            print("Nenhum livro encontrado.")
            return

        print(f"\n   {len(resultados)} resultado(s):")
        for livro in resultados:
            status = "Disponível" if livro["disponivel"] else "Emprestado"
            print(f"   • {livro['titulo']} - {livro['autor']}  [{status}]")

    except Exception as e:
        print(f"Erro inesperado: {e}")

def registrar_emprestimo(catalogo):
    listar_livros(catalogo)
    if not catalogo:
        return
    
    print("\n--- Registrar Empréstimo ---")

    try:
        numero = int(input("Número do livro: ")) 

        if numero < 1 or numero > len(catalogo):
            print("   Número fora do intervalo.")
            return

        livro = catalogo[numero - 1]

        if not livro["disponivel"]:
            print(f" '{livro['titulo']}' já está emprestado.")
        else:
            livro["disponivel"] = False
            salvar_catalogo(catalogo)
            registrar_no_historico(f"EMPRESTIMO: {livro['titulo']}")
            print(f"   Empréstimo de '{livro['titulo']}' registrado.")

    except ValueError:
        print("Entrada inválida. Digite apenas o número.")


def devolver_livro(catalogo):
    listar_livros(catalogo)
    if not catalogo:
        return
    
    print("\n--- Registrar Devolução ---")

    try:
        numero = int(input("Número do livro a devolver: "))
        livro = catalogo[numero - 1]

        if livro["disponivel"]:
            print(f"   '{livro['titulo']}' já está disponível.")
        else:
            livro["disponivel"] = True
            salvar_catalogo(catalogo)
            registrar_no_historico(f"DEVOLUCAO: {livro['titulo']}")
            print(f"   Devolução de '{livro['titulo']}' registrada.")

    except ValueError:
        print("   Digite apenas o número do livro.")
    except IndexError:
        print("   Número fora da lista. Verifique os livros cadastrados.")

def exibir_historico(catalogo):
    """Le o arquivo de historico e joga na tela."""
    print("\n--- Historico de Operacoes ---")
    try:
        with open(HISTORICO, "r", encoding="utf-8") as f:
            dados = f.read()
            if not dados:
                print("O historico ainda ta vazio.")
            else:
                print(dados)
    except FileNotFoundError:
        print("Arquivo de historico nao encontrado.")

def menu():
    catalogo = carregar_catalogo()
    print("\n SISTEMA DE BIBLIOTECA - v2 (Persistência)")

    opcoes = {
        "1": ("Listar livros",           listar_livros),
        "2": ("Adicionar livro",          adicionar_livro),
        "3": ("Buscar livro",             buscar_livro),
        "4": ("Registrar empréstimo",     registrar_emprestimo),
        "5": ("Devolver livro",            devolver_livro),
        "6": ("Ver historico",             exibir_historico),
        "0": ("Sair",                     None),
    }

    while True:
        print("\n   Opções:")
        for chave, (descricao, _) in opcoes.items():
            print(f"   [{chave}] {descricao}")

        try:
            escolha = input("\n   Sua escolha: ").strip()
            if escolha not in opcoes:
                raise ValueError(f"Opção '{escolha}' inválida.")

        except ValueError as e:
            print(f" {e}")
            continue

        else:
            if escolha == "0":
                print("\n   Até logo!")
                break

            _, funcao = opcoes[escolha]
            funcao(catalogo)
        finally:
            pass

if __name__ == "__main__":
    menu()

# prescisam se chamar salvar-catalogo(): adicionar_livro, registrar_emprestimo 
# e devolver_livro, porque alteram conteúdo dentro do cód.
# não precisam: listar_livros e buscar_livro pois só realizam leitura de dados.