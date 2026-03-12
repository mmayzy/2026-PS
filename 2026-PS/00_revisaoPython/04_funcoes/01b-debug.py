# Arquivo: 01b-debug.py
# ATENÇÃO: 4 erros propositais. Encontre e corrija todos!

def saudacao(nome, turno="manhã"):
    mensagem = f"Bom {turno}, {nome}!"
    return mensagem # CORREÇÃO: adicionado o return para devolver a msg.

saudacao("Ana")
print(saudacao("Bruno", "tarde"))


def dobrar(x):
    resultado = x * 2
    return resultado # CORREÇÃO: adcionado o return para que o print exibisse o valor.


print("Dobro de 5:", dobrar(5))


total = 0
def incrementar():
    global total # CORREÇÃO: 'global' adcionado p modificar variável fora da função.
    total = total + 1


incrementar()
print("Total:", total)


def contagem(n):
    if n < 0: # CORREÇÃO: falta do caso base p impedir erro de recursão infinita.
        return
    print(n)
    contagem(n - 1)


contagem(3)