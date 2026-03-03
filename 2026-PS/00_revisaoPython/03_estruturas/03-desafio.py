"""
NOME: Mayara Mierzva
DISCIPLINA: Programação de Sistemas
DATA: 2026.03.03
DESCRIÇÃO: Sistema interativo para o gerenciamento de uma biblioteca
"""

## lista que armazena os livros definitivos e os que serão cadastrados, os autores, anos e o estado.
livros = [
    {
        "titulo": "Drácula",
        "autor": "Bram Stoker",
        "ano": "1897",
        "disponivel": True
    },
    {
        "titulo": "A Metamorfose",
        "autor": "Franz Kafka",
        "ano": "1915",
        "disponivel": True
    },
    {
        "titulo": "O Cemitério",
        "autor": "Stephen King",
        "ano": "1983",
        "disponivel": True
    }
]
def menuInicial(): #função do menu inicial
    print("=" * 40)
    
    print("SISTEMA BIBLIOTECÁRIO".center(40))

    print("OPÇÕES:")
    print("[1] Cadastro de livros")
    print("[2] Buscar por autor")
    print("[3] Empréstimos")
    print('[4] Devoluções')
    print("[5] Sair")
    print("=" * 40)


while True: # o while roda um programa até que seja obrigado a parar com um break(esse só quebra se a opção de sair for clicada)
    menuInicial() # função do menu inicial chamada.
    opcao = input("Escolha uma opção: ")
    
    if opcao == "5": # opção p sair
        print("\n" + "=" * 40)
        print("RELATÓRIO FINAL".center(40)) # imprime o relatório final antes de encerrra totalmente
        print("=" * 40)

        # variáveis do relatotio final
        totalL = len(livros)
        disponiveis = 0
        emprestados = 0
        livrosE = []

       
        for livro in livros:
            if livro.get("disponivel") == True: # se o livro estiver marcado como disponível/emprestado, add +1 a variável do relatório final.
                disponiveis += 1
            else:
                emprestados += 1
                livrosE.append(livro["titulo"])

        
        print(f"Total de livros: {totalL}")
        print(f"Livros Disponíveis: {disponiveis}")
        print(f"Livros Emprestados: {emprestados}")
        
        if livrosE:
            print("=" * 40)
            print("LIVROS EMPRESTADOS:")
            for titulo in livrosE:
                print(f"{titulo}")
        else:
            print("\nTodos os livros estão disponíveis!")

        print("=" * 40)
        print("Programa encerrado... Volte Sempre!")
        break

    if opcao == "1": # cadastro de livros
        print("=" * 40)
        print("CADASTRO DE LIVROS".center(40))
        print("=" * 40)
        titulo = input("Título: ")
        autor = input("Autor: ")
       
        while True:
            try:
                 ano = int(input("Ano de lançamento: ")) # pede o ano com uma verificação, apenas int aceito
                 break
            except ValueError: # verificação com uma msg
                print("Erro. Por favor, digite apenas o número do ano.")

        livroN = {
            "titulo": titulo,
            "autor": autor,
            "ano": ano,
            "disponivel": True 
        }
        
        livros.append(livroN)
        print(f"\nLivro '{titulo}' cadastrado com sucesso!")
        print("\n" + "-" * 40)
        print("CATÁLOGO ATUALIZADO".center(40))
        print("-" * 40)

        for l in livros: #mostra o catálogo atualizado após o cadastro
            
            if "disponivel" in l:
                status = "Disponível" if l["disponivel"] else "Emprestado"
            else:
                status = "Emprestado" if l.get("emprestado") else "Disponível"
                
            print(f"{l['titulo']} ({l['ano']})  | {l['autor']} | [{status}]")
        
        print("=" * 40)
        input("\nPressione ENTER para voltar ao menu...")

    elif opcao == "2":
        print("=" * 40)
        print("BUSCA POR AUTOR".center(40))
        busca = input("Digite o nome do autor: ").lower() # busca por autor, com letras minusculas ou maíusculas.

        print("=" * 40)
        print(f"Resultados para: {busca.upper()}")
        print("=" * 40)
        encontrou = False

        

        for livro in livros:
            if "disponivel" in livro:
                status = "Disponível" if livro["disponivel"] else "Emprestado"
            else:
                status = "Emprestado" if livro.get("emprestado") else "Disponível"
            if busca in livro["autor"].lower():
               
                print(f"{livro['titulo']} ({livro['ano']}) - Status: {status}")
                encontrou = True
        
        if not encontrou:
            print("Parece que não temos esse livro!")
        print("=" * 40)
        print("[M] para voltar ao menu inicial, ou [S] para encerrar.")
        
        opcao1 = input("Escolha: ").lower()
        
        if opcao1 == 's':
            print("Programa encerrado. Voltr sempre!")
            break

    elif opcao == "3":  # empréstimo de livros
        print("=" * 40)
        print("REGISTRO DE EMPRÉSTIMO".center(40))
        livroE = input("Digite o título do livro que deseja emprestar: ").lower()
        achou = False

        for livro in livros:
            if livro["titulo"].lower() == livroE:
                achou = True
                if livro.get("disponivel") == True:
                    livro["disponivel"] = False # inverte o estado do livro
                    print(f"\n Empréstimo realizado: '{livro['titulo']}' agora está EMPRESTADO.")
                else:
                    print(f"\n Parece que o livro '{livro['titulo']}' já está emprestado no momento!")
                break   

        if not achou:
            print("\nParece que não temos esse livro.")
        input("\nPressione ENTER para continuar...")
    
    elif opcao == "4":  # devolução
        print("=" * 40)
        print("REGISTRAR DEVOLUÇÃO".center(40))
        livroD = input("Digite o título do livro que deseja devolver: ").lower()
        achou = False

        for livro in livros:
            if livro["titulo"].lower() == livroD:
                achou = True
                if livro.get("disponivel") == False:
                    livro["disponivel"] = True # inverte o estado.
                    print(f"\nDevolução concluída: '{livro['titulo']}' agora está DISPONÍVEL.")
                else:
                    print(f"\n Este livro está DISPONÍVEL no sistema.")
                break
        
        if not achou:
            print("\nParece que não temos esse livro!")
        input("\nPressione ENTER para continuar...")