def Leia():
    v1 = int(input('Digite um valor: ' ))
    
    v2 = int(input('Digite outro valor: ' )) ## essas duas variáveis, que compõe a função Leia, armazenam o que o usuário digitou.
    while True: # acontece um loop até que uma op valida seja digitada.
        op = input('Digite a operação [* / + -] ou digite "s" para sair: ')
        if op.lower() == "s":
            print("programa fechado.")
            return
    
        if op == '+':
            res = Soma(v1,v2) 
            break 
        elif op == '-':
            res = Subtracao(v1,v2)
            break
        elif op == '*':
            res = Multiplicacao(v1,v2)
            break
        elif op == '/':
            if v2 == 0: # verificação da divisão por 0, o programa continua rodando e pede outra operação.
                print("Divisão por 0 não é aceita, tente novamente.")
            else:
             res = Divisao(v1,v2)
             break # termina o loop
# o break é adcionado no fim de cada condição, pois se não ele ficará pedindo a operação novamente, sem calcular. com o break ele vai p proxima linha.
        else:
            print("Por favor, digite apenas as operações válidas.")
    msg = f'{v1} {op} {v2}'
   

    Escreva(msg, res)
# soma
def Soma(v1, v2):
    return(v1+v2)
   

# subtração

def Subtracao(v1, v2):
    return(v1-v2)

# multiplicação

def Multiplicacao(v1, v2):
    return(v1*v2)

# divisão

def Divisao(v1, v2):
    return(v1/v2)

def Escreva(msg, resultado):
    print(f'{msg} = {resultado}')

Leia()


