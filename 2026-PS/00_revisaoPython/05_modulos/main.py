# ======================================================
# SISTEMA DE CONVERSÃO DE UNIDADES
# ======================================================
# Disciplina : Programação de Sistemas (PS)
# Aula       : 07 — Revisão: Módulos
# Autor      : Mayara Mierzva
# Data       : 2026.03.10
# Repositório: https://github.com/mmayzy/2026-PS.git
# ======================================================


from conversores import (
    celsius_para_fahrenheit, celsius_para_kelvin, fahrenheit_para_celsius,
    km_para_milhas, milhas_para_km, metros_para_pes, kelvin_para_celsius,
    kg_para_libras, libras_para_kg
)
from utils import cabecalho_secao, formatar_resultado, linha_separadora, validar_numero


def ler_valor(mensagem, min_val=None):
    while True:
        entr = input(mensagem)
        sucesso, resultado = validar_numero(entr, minimo=min_val)
        if sucesso:
            return resultado
        print(f"   Erro. {resultado}")
              
def menu_temperatura():
    print(cabecalho_secao("Conversão de Temperatura"))
    valor = ler_valor("Valor em °C: ")
    
    print(formatar_resultado("°C → °F", valor, "°C", 
                             celsius_para_fahrenheit(valor), "°F"))
    print(formatar_resultado("°C → K", valor, "°C", 
                             celsius_para_kelvin(valor), "K"))

def menu_distancia():
    print(cabecalho_secao("Conversão de Distância"))
    valor = ler_valor("  Valor em km: ", min_val=0)
    
    print(formatar_resultado("km → mi", valor, "km", 
                             km_para_milhas(valor), "mi"))
    # Note: valor * 1000 converte km para metros para usar a função metros_para_pes
    print(formatar_resultado("km → pés", valor, "m", 
                             metros_para_pes(valor * 1000), "pés"))
def menu_massa():
    print(cabecalho_secao("Conversão de Massa"))
    valor = ler_valor("Valor em kg: ", min_val=0)
    print(formatar_resultado("kg → lb", valor, "kg", kg_para_libras(valor), "lb"))

def main():
    print(linha_separadora())
    print("  SISTEMA DE CONVERSÃO DE UNIDADES")
    print(linha_separadora())

    opcoes = {"1": menu_temperatura, "2": menu_distancia, "3": menu_massa}

    while True:
        print("\n  [1] Temperatura   [2] Distância   [3] Massa [0] Sair")
        escolha = input("  Opção: ").strip()

        if escolha == "0":
            print("\nSistema encerrado.")
            break
        elif escolha in opcoes:
            opcoes[escolha]()
        else:
            print("  Opção inválida.")

if __name__ == "__main__":
    main()