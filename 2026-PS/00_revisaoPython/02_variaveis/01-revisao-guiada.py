# ==========================================================
# SISTEMA DE APROVAÇÃO DE ALUNOS
# ==========================================================
# Disciplina : Programação de Sistemas (PS)
# Aula       : 04 — Revisão: Variáveis, Tipos e Controle de Fluxo
# Autor      : Mayara Mierzva
# Data       : 2026.03.15
# Repositório: https://github.com/mmayzy/2026-PS.git
# ==========================================================
#
# DESCRIÇÃO:
# Este programa processa as notas de uma turma e determina
# a situação de cada aluno (Aprovado, Recuperação ou Reprovado).
# Conceitos utilizados: variáveis, tipos de dados, operadores,
# estruturas de seleção e estruturas de repetição.
# ==========================================================

# ---- DADOS DA TURMA ----
# Uma lista de dicionários: cada dicionário representa um aluno

turma = [
    {"nome": "Ana",   "nota1": 8.0, "nota2": 7.5},
    {"nome": "Bruno", "nota1": 4.5, "nota2": 5.0},
    {"nome": "Carla", "nota1": 2.0, "nota2": 3.5},
]

print("=== Resultado da Turma ===")
print()

# O 'for' percorre cada aluno da lista automaticamente
for aluno in turma:
    nome  = aluno["nome"]
    nota1 = aluno["nota1"]
    nota2 = aluno["nota2"]
    media = (nota1 + nota2) / 2
    
    if media >= 6.0:
        situacao = "Aprovado"
    elif media >= 4.0:
        situacao = "Recuperação"
    else:
        situacao = "Reprovado"
        
    print(f"Aluno    : {nome}")
    print(f"Média    : {media:.2f}")
    print(f"Situação : {situacao}")
    print("-" * 30)

    continuar = "sim"
while continuar == "sim":
    print("\nDeseja processar outro aluno? (sim/nao): ", end="")
    continuar = input().lower()
    
    if continuar == "sim":
        nome_novo = input("Digite o nome do aluno: ")
        n1 = float(input("Digite a nota 1: "))
        n2 = float(input("Digite a nota 2: "))
        
        m = (n1 + n2) / 2
        
        if m >= 6.0:
            status = "Aprovado"
        elif m >= 4.0:
            status = "Recuperação"
        else:
            status = "Reprovado"
            
        print(f"\nResultado: {nome_novo}:")
        print(f"Média: {m:.2f} | Situação: {status}")
        print("-" * 30)