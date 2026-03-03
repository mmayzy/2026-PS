"""
Mayara Mierzva
Programação de Sistemas
2026.02.24
Objetivo: Ajudar a controlar o estoque de produtos.
"""
# lista de armazenamento de produtos:
estoque = [
    {"produto": "Teclado", "em estoque": 15},
    {"produto": "Mouse", "em estoque": 25},
    {"produto": "Memória RAM", "em estoque": 5}
]

while True: # exibe a lista de opçoes dentro do programa, o laço while serve para que o programa não tenha de ser executado várias vezes para realizar mais de uma ação.
    print("=" * 40)
    print("            Seja bem-vindo!   ")
    print("     SISTEMA DE CONTROLE DE ESTOQUE")

    print("OPÇÕES:")
    print("Digite 'E' para analisar os produtos em estoque.")
    print("Digite 'A' para cadastrar um produto.")
    print("Digite 'B' para buscar um produto.")
    print("Digite 'S' para sair")
    print("=" * 40)

    opcoes =  input("Escolha uma opção: ").strip().upper() # pede para o usuário selecionar uma opção.

    if opcoes == 'S': # A opção "S" encerra o código. 
       if estoque:
            mais_critico = min(estoque, key=lambda x: x["em estoque"]) #procura o produto mais c´ritico, key=lambda x:x entra na lista do estoque, e compara valores, trazendo o menor com "min"
            print(f"\nAlerta! Produto quase esgotado: '{mais_critico['produto']}' ({mais_critico['em estoque']} unid.).") # mnostra o produto mais crítico ao encerrar.

        
            print("Programa encerrado. Volte sempre!") # mensagem de despedida impressa na tela quando o programa é encerrado.
            break # O laço while se encerra aqui, ou seja, o programa encerra também.
        
    elif opcoes == 'E': # a opçao 'e', exibe todos os produtos do estoque, e ainda permite que seja consultado a situação de um único produto específico.
        print("         ===== RELATÓRIO DE ESTOQUE ====")
        critico = 0
        adequado = 0
        excesso = 0 # o reltório de estoque, são as variáveis que armazenam a situação do prod. de acordo com a qtd
        
        for item in estoque: # laço FOR para analisar a situação de cada produto de acordo com a qtd.
            nome = item["produto"]
            qtd = item["em estoque"]
            if qtd < 5:
                situacao = "CRÍTICO"
                critico += 1
            elif 5 <= qtd <= 20:
                situacao = "ADEQUADO"
                adequado += 1
            else:
                situacao = "EM EXCESSO"
                excesso += 1 # a cada produto que se encontra em cada situação, +1 é add a cada variável.
                
            print(f"Produto: {nome:<15} | Qtd: {qtd:<3} | Situação: {situacao}") # mostra o produto e a situação.

        print("=" * 60)
        print(f"RESUMO: Crítico: {critico} | Adequado: {adequado} | Em excesso: {excesso}") # mini relatório final
        print("=" * 60)
        
        while True:
            busca = input("\nDeseja consultar a situação de um produto específico? (Se sim, digite o nome do produto. Para voltar, digite 'V'.): ").strip().lower() # pergunta se quer ver a situaçãode um produto específico.
            
            if busca == 'v': # se a busca for igual a v, ele volta ao menu inicial.
                break
            
            achou = False ## busca dps da analise
            for item in estoque:
                if item["produto"].lower() == busca: # busca o produto por nome
                    
                    qtd = item["em estoque"]
                    sit = "CRÍTICO" if qtd < 5 else "ADEQUADO" if qtd <= 20 else "EXCESSO"
                    print(f"-> Resultado: {item['produto']} tem {qtd} unidades. Situação: {sit}")
                    achou = True
                    break
            
            if not achou:
                print("Produto não encontrado.") # se não achou, envia a msg
            else:
                break
        
           

    elif opcoes == 'A':
        print(" =====CADASTRO DE PRODUTO====")
        novoP = input("Nome do produto: ").strip() # opção de cadastro de produto
        
        while True:    
            try:
                qtdP = int(input(f"Quantidade de '{novoP}': "))
                if qtdP < 0:
                    print("Erro, digite apenas números maiores ou iguais a 0") # não deixa que a qtd seja menor que zero
                else:
                    estoque.append({"produto": novoP, "em estoque": qtdP})
                    print(f"{novoP} adicionado!") 
                    break
            except ValueError:
                print("Erro, digite apenas números inteiros na quantidade.")
            
            input("\nPressione ENTER para continuar o cadastro: ")


    elif opcoes == 'B': ## busca direto no menu
        print("=====BUSCA DE PRODUTO=====")
        busca = input("Buscar por nome: ").strip().lower() 
        achou = False
        
        for item in estoque:
            if item["produto"].lower() == busca:
                qtd = item["em estoque"] 
                sit = "CRÍTICO" if qtd < 5 else "ADEQUADO" if qtd <= 20 else "EXCESSO"  
                print(f"Produto: {item['produto']} | Quantidade: {item['em estoque']}")
                achou = True
                break
        
        if not achou:
            print("Produto não encontrado na lista.")
        
        voltar = input("\nPressione ENTER para voltar ao menu inicial eou 'S' para sair: ")
        if voltar == "S":
            print(f"RESUMO: Crítico: {critico} | Adequado: {adequado} | Em excesso: {excesso}")
            print("Programa encerrado. Volte sempre!")
            break # encerra o programa

        
     