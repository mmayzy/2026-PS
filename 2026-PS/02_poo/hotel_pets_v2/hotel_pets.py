# ======================================================================
# Disciplina: Programação de Sistemas
# Data: 2026-05-12
# Autor: Mayara Mierzva
# Descrição: Programa simples desenvolvido para um hotel para pets, onde o recepcionista pode anotar
# as informações necessárias para o check-in do pet, além de guardar as informações quando
# quando o programa é encerrado.
#           
# ======================================================================

import pickle
import os

# ==============================================================================
# 1. A CLASSE PET 
# ==============================================================================
class Pet:
    def __init__(self, nome, especie, idade, raca, peso, nome_dono, vacinado):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.raca = raca
        self.peso = peso
        self.nome_dono = nome_dono
        self.vacinado = vacinado
        self.hospedado = False 

    def exibir_dados(self):
        status = "HOSPEDADO" if self.hospedado else "LIVRE"
        print(f"🐾 {self.nome:10} | {self.raca:12} | Dono: {self.nome_dono:10} | Status: {status}")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"{self.nome} já está no hotel.")
        else:
            self.hospedado = True
            print(f"Check-in de {self.nome} concluído!")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado.")
        else:
            self.hospedado = False
            print(f"Check-out de {self.nome} concluído!")

    def calcular_diaria(self):
        if self.idade <= 3: return 50.0
        elif 4 <= self.idade <= 10: return 60.0
        return 75.0

    def atualizar_peso(self, novo_peso):
        self.peso = novo_peso
        print(f"Peso de {self.nome} atualizado para {self.peso}kg.")

    def emitir_resumo(self):
        print(f"\n{' RESUMO INDIVIDUAL ':=^40}")
        print(f"Nome: {self.nome} ({self.especie}) - Raça: {self.raca}")
        print(f"Dono: {self.nome_dono} | Peso: {self.peso}kg")
        print(f"Vacinação: {'OK' if self.vacinado else 'PENDENTE'}")
        print(f"Diária atual: R$ {self.calcular_diaria():.2f}")
        print("="*40)

# ==============================================================================
# 2. PERSISTÊNCIA (TXT e BINÁRIO)
# ==============================================================================
lista_pets = []
ARQUIVO_BIN = "pets.bin"
ARQUIVO_TXT = "pets.txt"

def salvar_todos():
    # salvar em binário (pickle)
    # escolhi o pickle pois ele preserva o objeto inteiro (estados e tipos)
    with open(ARQUIVO_BIN, "wb") as f:
        pickle.dump(lista_pets, f)
    
    # Salvar em TXT 
    with open(ARQUIVO_TXT, "w", encoding="utf-8") as f:
        for p in lista_pets:
            linha = f"{p.nome};{p.especie};{p.idade};{p.raca};{p.peso};{p.nome_dono};{p.vacinado};{p.hospedado}\n"
            f.write(linha)
    print("\nDados salvos em BIN e TXT!")

def carregar_dados():
    global lista_pets
    try:
        if os.path.exists(ARQUIVO_BIN):
            with open(ARQUIVO_BIN, "rb") as f:
                lista_pets = pickle.load(f)
                print(f"✅ {len(lista_pets)} registros carregados.")
        else:
            print("ℹ️ Nenhum arquivo encontrado. Iniciando sistema vazio.")
    except (FileNotFoundError, EOFError, pickle.UnpicklingError):
        print("⚠️ Erro ao carregar ou arquivo inexistente. Iniciando lista vazia.")
        lista_pets = []

# ==============================================================================
# 3. FUNÇÕES DE BUSCA E RELATÓRIOS
# ==============================================================================
def buscar_pet():
    nome_busca = input("Digite o nome (ou parte dele): ").lower()
    encontrados = [p for p in lista_pets if nome_busca in p.nome.lower()]
    if not encontrados:
        print("❌ Nenhum pet encontrado com esse nome.")
    return encontrados

def relatorio_hospedados():
    print(f"\n{' PETS ATUALMENTE HOSPEDADOS ':=^40}")
    total_diarias = 0
    cont = 0
    for p in lista_pets:
        if p.hospedado:
            p.exibir_dados()
            total_diarias += p.calcular_diaria()
            cont += 1
    print("=" * 40)
    print(f"Total de Pets: {cont} | Faturamento Diário: R$ {total_diarias:.2f}")

# ==============================================================================
# 4. MENU PRINCIPAL
# ==============================================================================
def menu():
    carregar_dados()
    while True:
        print("\n===== PETVILLE - RECEPÇÃO =====")
        print("1. Cadastrar Pet")
        print("2. Listar Todos")
        print("3. Check-in/Out")
        print("4. Atualizar Peso")
        print("5. Buscar Pet")
        print("6. Resumo Individual")
        print("7. Relatório Hospedados")
        print("0. Sair")
        
        op = input("Escolha: ")

        if op == "1":
            try:
                nome = input("Nome: ")
                esp = input("Espécie: ")
                idade = int(input("Idade: "))
                raca = input("Raça: ")
                peso = float(input("Peso: "))
                dono = input("Dono: ")
                vac = input("Vacinado? (s/n): ").lower() == 's'
                lista_pets.append(Pet(nome, esp, idade, raca, peso, dono, vac))
                salvar_todos()
            except ValueError:
                print("❌ Erro: Idade e Peso precisam ser números.")

        elif op == "2":
            if not lista_pets:
                print("Lista vazia.")
            for p in lista_pets: p.exibir_dados()

        elif op == "3":
            pets = buscar_pet()
            if pets:
                p = pets[0] # Pega o primeiro que encontrar
                acao = input(f"1. Check-in ou 2. Check-out {p.nome}? ")
                # Usando os métodos da classe em vez de alterar atributo direto
                if acao == "1":
                    p.registrar_entrada()
                elif acao == "2":
                    p.registrar_saida()
                salvar_todos()

        elif op == "4":
            pets = buscar_pet()
            if pets:
                try:
                    novo_p = float(input(f"Novo peso para {pets[0].nome}: "))
                    pets[0].atualizar_peso(novo_p)
                    salvar_todos()
                except ValueError:
                    print("❌ Valor de peso inválido.")

        elif op == "5":
            for p in buscar_pet(): p.exibir_dados()

        elif op == "6":
            pets = buscar_pet()
            if pets: pets[0].emitir_resumo()

        elif op == "7":
            relatorio_hospedados()

        elif op == "0":
            print("Salvando dados e encerrando...")
            salvar_todos() # Garante o salvamento antes de fechar
            break

if __name__ == "__main__":
    menu()