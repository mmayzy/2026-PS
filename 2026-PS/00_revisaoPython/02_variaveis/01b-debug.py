# Erro 1: 
nome  = input("Digite o nome do aluno: ") # CORREÇÃO: "input" estava escrito com m.


nota1 = float(input("Digite a nota 1: "))
nota2 = float(input("Digite a nota 2: "))

# Erro 2:
media = (nota1 + nota2) / 2 
#  CORREÇÃO: a conta estava sem os parenteses, e sem eles, a nota2 iria dividir com o 2 antes de somar com a nota1


if media >= 6.0:
    situacao = "Aprovado"
elif media >= 4.0:
    situacao = "Recuperação"
else:
    situacao = "Reprovado"

# Erro 3: 
print(f"Aluno: {nome} | Média: {media:.2f} | Situação: {situacao}")
# CORREÇÃO: "print" estava escrito errado.
