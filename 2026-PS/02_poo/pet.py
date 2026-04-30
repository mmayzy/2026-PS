'''
=================================================================
# ARQUIVO: pet.py
# Disciplina: Programação de Sistemas (2026-2)
# Aula: Aula 20 - Por que POO?
# Autor: Mayara Mierzva
# Conceitos: Classe, objeto, atributos, métodos, encapsulamento
# Atividade: Classe Pet
==================================================================
'''

class Pet:
    def __init__(self, nome, especie, idade, raca, peso, vacinado=False):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        # atributos adcioandos
        self.raca = raca
        self.peso = peso
        self.vacinado = vacinado
        self.hospedado = False

    def exibir_dados(self):
        print(f"\nFICHA DO PET: {self.nome}")
        print(f"Espécie: {self.especie} | Raça: {self.raca}")
        print(f"Idade: {self.idade} anos | Peso: {self.peso}kg")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")

    def registrar_entrada(self):
        # validação, verifica se já está hospedado
        if self.hospedado:
            print(f"Atenção: {self.nome} JÁ está hospedado!")
        else:
            self.hospedado = True
            print(f"Sucesso: Entrada de {self.nome} registrada.")

    def registrar_saida(self):
        # validação: verifica se está no hotel para poder sair
        if not self.hospedado:
            print(f"Erro: {self.nome} NÃO está no hotel para realizar saída.")
        else:
            self.hospedado = False
            print(f"Sucesso: Saída de {self.nome} registrada.")

    def calcular_diaria(self):
        # método que calcula valor baseado na idade
        valor = 50.00 if self.idade <= 3 else 75.00
        return valor

    def verificar_vacinacao(self):
        # método que checa status de saúde
        if self.vacinado:
            print(f"Saúde: {self.nome} está com as vacinas em dia.")
        else:
            print(f"Alerta: {self.nome} necessita de vacinação!")

    def atualizar_peso(self, novo_peso):
        # método para atualizar dados
        print(f"Atualizando peso de {self.nome}: {self.peso}kg -> {novo_peso}kg")
        self.peso = novo_peso

    def emitir_resumo(self):
        # metodo que consolida as informações
        print("=" * 35)
        print(f"RESUMO FINANCEIRO - {self.nome.upper()}")
        print(f"Valor da diária: R$ {self.calcular_diaria():.2f}")
        print(f"Hospedado no momento: {'Sim' if self.hospedado else 'Não'}")
        print("=" * 35)

# ==========================================
# TESTES DA ATIVIDADE
# ==========================================

# 1. 3 objetos diferentes
pet1 = Pet("Rex", "Cachorro", 5, "Golden Retriever", 32.0, True)
pet2 = Pet("Mimi", "Gato", 2, "Siamês", 4.5, False)
pet3 = Pet("Thor", "Cachorro", 8, "Bulldog", 25.0, True)

# 2. métodos no pet1
pet1.exibir_dados()
pet1.registrar_entrada() # Primeira entrada
pet1.registrar_entrada() # Teste de validação (já hospedado)

# 3. métodos no pet2
print("\n==== TESTE PET 2 ====")
pet2.verificar_vacinacao()
pet2.atualizar_peso(5.2)
pet2.emitir_resumo()

# 4. métodos no pet3
print("\n==== TESTE PET 3 ====")
pet3.registrar_saida() # Teste de validação (tentando sair sem entrar)
print(f"Valor da diária: R$ {pet3.calcular_diaria()}")