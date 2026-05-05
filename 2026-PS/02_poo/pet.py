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
    '''
    Esta classe representa um Pet em um sistema simples de hotel para pets.
    Em vez e guardar os dados do pet em um dicionário solto, como fazíamos
    na programação estruturada, agora agruupamos os
    dados e comportamentos de uma única classe.
    '''

    def __init__(self, nome, especie, idade, raca, peso, nome_dono, vacinado):
        '''
        MÉTODO CONSTRUTOR
        atributos adcionados: raca, peso, nome_dono e vacinado 
        conforme solicitado na Atividade 1.
        '''
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.raca = raca
        self.peso = peso
        self.nome_dono = nome_dono
        self.vacinado = vacinado
        self.hospedado = False # inicia como falso por padrão

    def exibir_dados(self):
        '''
        MÉTODO EXIBIR DADOS
        atualizado para exibir os novos atributos (Raça, Peso, Dono).
        '''
        print("\n" + "="*30)
        print(f"FICHA TÉCNICA: {self.nome}")
        print("=" * 30)
        print(f"Espécie: {self.especie}")
        print(f"Raça: {self.raca}")
        print(f"Idade: {self.idade} anos")
        print(f"Status: {'Hospedado' if self.hospedado else 'Disponível'}")
        print("="*30)

    def registrar_entrada(self):
        '''
        MÉTODO REGISTRAR ENTRADA
        verifica se o pet já está no hotel antes de mudar o status.
        '''
        if self.hospedado:
            print(f"=== AVISO: {self.nome} JÁ se encontra hospedado. ===")
        else:
            self.hospedado = True
            print(f"=== SUCESSO: Check-in de {self.nome} realizado! ===")

    def registrar_saida(self):
        '''
        MÉTODO REGISTRAR SAÍDA
        verifica se o pet está no hotel para permitir o check-out.
        '''
        if not self.hospedado:
            print(f"=== AVISO: {self.nome} não está hospedado. ===")
        else:
            self.hospedado = False
            print(f"=== SUCESSO: Check-out de {self.nome} realizado! ===")

    def calcular_diaria(self):
        '''
        MÉTODO CALCULAR DIÁRIA
        define valores baseados na faixa etária do pet.
        '''
        if self.idade <= 3:
            return 50.00
        elif 4 <= self.idade <= 10:
            return 60.00
        else:
            return 75.00

    def verificar_vacinacao(self):
        '''
        MÉTODO VERIFICAR VACINAÇÃO
        retorna msgs baseadas no atributo self.vacinado.
        '''
        if self.vacinado:
            print(f"INFO: Vacinação de {self.nome} está em dia.")
        else:
            print(f"ALERTA: {self.nome} está com vacinação pendente!")

    def atualizar_peso(self, novo_peso):
        '''
        MÉTODO ATUALIZAR PESO
        guarda um novo valor e substitui o atributo antigo.
        '''
        self.peso = novo_peso
        print(f"INFO: Peso de {self.nome} atualizado para {self.peso}kg.")

    def emitir_resumo(self):
        '''
        MÉTODO EMITIR RESUMO
        gera um relatório completo chamando o método calcular_diaria().
        '''
        valor_diaria = self.calcular_diaria()
        print(f"\n==== RESUMO GERAL DO PET ====")
        print(f"Pet: {self.nome} ({self.raca})")
        print(f"Idade: {self.idade} anos")
        print(f"Dono: {self.nome_dono}")
        print(f"Peso Atual: {self.peso}kg")
        print(f"Vacinação: {'OK' if self.vacinado else 'PENDENTE'}")
        print(f"Hospedagem: {'Ativa' if self.hospedado else 'Inativa'}")
        print(f"VALOR DA DIÁRIA: R$ {valor_diaria:.2f}")
        print("=" * 30)

# ==============================================================================
# TESTES DA CLASSE
# ==============================================================================

# Criando os objetos conforme o exemplo
pet1 = Pet("Rex", "Cachorro", 5, "Labrador", 22.5, "Maria", True)
pet2 = Pet("Mimi", "Gato", 2, "Siamês", 4.2, "João", True)
pet3 = Pet("Thor", "Cachorro", 11, "Vira-lata", 18.0, "Ana", False)

#demonstração Pet 1
pet1.exibir_dados()
pet1.registrar_entrada()
pet1.verificar_vacinacao()
# print pois o calcular_diaria apenas 'retorna' o valor
print("Diária:", pet1.calcular_diaria()) 
pet1.atualizar_peso(23.0)
pet1.emitir_resumo()

# Demonstração Pet 3
pet3.exibir_dados()
pet3.verificar_vacinacao()
pet3.registrar_entrada()
pet3.registrar_saida()
pet3.emitir_resumo()

# ==============================================================================
# TESTES ADICIONAIS
# ==============================================================================


pet4 = Pet("Ozzy", "Gato", 1, "Preto", 3.5, "Carol", False)
pet5 = Pet("Maya", "Cachorro", 3, "Golden Retriever", 15.0, "Beatriz", True)

print("\n=== TESTES ADICIONAIS ===")

pet4.registrar_entrada()
pet4.emitir_resumo()

pet5.verificar_vacinacao()
pet5.emitir_resumo()