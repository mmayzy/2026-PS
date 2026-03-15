# debug_teste/01b-debug.py
# ATENÇÃO: 4 erros propositais. Encontre e corrija todos!
# Rode de dentro de 05_modulos/: python debug_teste/01b-debug.py

''' from conversores import temperatura 

from conversores import celsius_para_kelvin, km_para_milhas
resultado = celsius_para_kelvin(25)
print(f"25°C em K: {resultado}")

from utils import formatar_resultado
print(formatar_resultado("teste", 100, "km", 62.1, "mi"))
print(f"50 km = {km_para_milhas(50):.2f} mi")'''

import sys # sys é usado para manipular o ambiente
import os # os é o sistema operacional para acessar os arquivos

sys.path.append(os.path.dirname(os.path.dirname(__file__))) #pega o local do arquivo, sobe de pasta (até a raiz) e mostra ao codigio onde buscar módulos.

from conversores.temperatura import celsius_para_kelvin

#from conversores import celsius_para_kelvin
resultado = celsius_para_kelvin(25)
print(f"25°C em K: {resultado}")

from utils.formatador import formatar_resultado
print(formatar_resultado("teste", 100, "km", 62.1, "mi"))

from conversores import km_para_milhas
print(f"50 km = {km_para_milhas(50):.2f} mi")

# import algo apagado