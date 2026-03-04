# Arquivo: 01b-debug.py
# ATENÇÃO: 4 erros propositais. Encontre e corrija todos!

catalogo = [
    {"titulo": "Código Limpo", "autor": "Robert C. Martin", "disponivel": True},
    {"titulo": "Entendendo Algoritmos", "autor": "Aditya Bhargava", "disponivel": False},
    {"titulo": "Python Fluente", "autor": "Luciano Ramalho", "disponivel": True},
]

# Erro 1: 
print("Primeiro livro:", catalogo[0]["titulo"]) # CORREÇÃO: 3 foi ajustado para 0, pois o usuario quer acessar o primeiro item mas só há 3, então como é uma lista, começa no 0.

print("\nLivros disponíveis:")
for livro in catalogo:
    # Erro 2:
    if livro["disponivel"] == True: # CORREÇÃO: ao inverter o false com true, o codigo filtra apenas os disponíveis
        print(f' ✅ {livro["titulo"]}')

total = len(catalogo)
print(f"\nTotal de livros: {total}")

# Erro 3: 
for chave, valor in catalogo[0].items(): # CORREÇÃO: items percorre todos os itens do dicionário
    print(f" {chave}: {valor}")

# Erro 4:
primeiro_autor = catalogo[0]["autor"] # CORREÇÃO: Estava escrito errado, com a primeira letra maiúscula
print("\nAutor do primeiro livro:", primeiro_autor)