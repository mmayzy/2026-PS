# =================================
# CALCULADORA DE NOTAS
# =================================
# Disciplina:  Programação de Sistemas (PS)
# Aula:    06 
# Autor:   Mayara Mierzva
# Data:   2026.03.08
# Repositório: https://github.com/mmayzy/2026-PS.git
# =================================
#
# DESCRIÇÃO:
#  Programa para calcular situações
#  de aprovação de uma turma.
# =================================
# FUNÇÕES
def exibir_cabecalho(): #exibe o cabeçalho
    ''' Exibe o cabeçalho do sistema no terminal. ''' # docstring: documentação da função.
    print("=" * 40)
    print("CALCULADORA DE NOTAS".center(40))
    print("=" * 40)

def solicitar_notas(nome_aluno): # solicida as notas e faz a validação
    """Solicita e valida as notas (entre 0 e 10)."""
    notasVal = []
    print(f"\n Notas de: {nome_aluno}")
    
    for i in range(1, 3):
        while True:
            nota = float(input(f"  Digite a Nota {i}: ")) # pede para digitar a nota entre 0 e 10, se não exibe msg de erro
            if 0 <= nota <= 10:
                notasVal.append(nota)
                break  
            else:
                print("Erro! Nota inválida! Digite um valor entre 0 e 10.")
    
    return notasVal[0], notasVal[1] # retorna a nota


def calcular_media(nota1,nota2): #calcula a média e mostra retornando
    media = (nota1 + nota2) / 2
    return media          

def verificar_situacao(media): # verifica a situação do aluno de acordo com a sua média
    """Retorna a situação do aluno com base na média fornecida."""
    if media >= 6.0:
        return "Aprovado"
    elif 4.0 <= media < 6.0:
        return "Recuperação"
    else:
        return "Reprovado"
    
def soma_recursiva(lista):
    if not lista: # caso base: lista vazia
        return 0
    return lista[0] +soma_recursiva(lista[1:])

def resumo_turma(situacoes):
    ap = situacoes.count("Aprovado")
    rec = situacoes.count("Recuperação")
    rep = situacoes.count("Reprovado")
    return ap, rec, rep #conta a situação da turma e depois imprime

def relatorio_aluno(nome, media, situacao):
    print(f"{nome:<15} | Média: {media:>4.1f} | Situação: {situacao}")

# INÍCIO DO CÓDIGO 
exibir_cabecalho() # começa exibindo o cabeçalho e listas começam vazias

lista_medias = []
lista_situacoes = []
nomes_alunos = [] 

for i in range(3):
    nome = input(f"\nDigite o nome do {i+1}º aluno: ")
    nomes_alunos.append(nome) #pede o nome dos alunos

print("\n" + " PROCESSAMENTO DE NOTAS ".center(50, "="))

# Processamento de cada aluno
for nome in nomes_alunos:
    n1, n2 = solicitar_notas(nome)
    m = calcular_media(n1, n2)
    s = verificar_situacao(m)
    
    lista_medias.append(m)
    lista_situacoes.append(s)
    relatorio_aluno(nome, m, s)

# cálculos da Turma
soma_total = soma_recursiva(lista_medias)
media_geral = soma_total / len(lista_medias) if lista_medias else 0
aprovados, recuperacao, reprovados = resumo_turma(lista_situacoes)

# exibe um relatório final
print("\n" + "=" * 50)
print("RESUMO FINAL DA TURMA".center(50))
print("=" * 50)
print(f"Média Geral da Turma: {media_geral:.2f}")
print(f"Total Aprovados     : {aprovados}")
print(f"Total Recuperação   : {recuperacao}")
print(f"Total Reprovados    : {reprovados}")
print("=" * 50)


print("\n" + "Fim do processamento.")
