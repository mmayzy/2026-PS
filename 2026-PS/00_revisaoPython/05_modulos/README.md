PROJETO: SISTEMA DE CONVERSÃO.
DESCRIÇÃO: O Sistema de Conversão é um sistema que realiza conversões de temperatura, distância e massa.

ESTRUTURA DE ARQUIVOS:
PASTA RAIZ: 05_modulos
PASTAS: 
Conversores
- __init__.py
- distancia.py
- massa.py
- temperatura.py

Utils
- __init__.py
- formatador.py
- validador.py

Outros arquivos: __pycache__, main.py 9PONTO DE ENTRADA)

Como Executar o Projeto?
Para rodar este sistema, no seu computador ou no GitHub Codespaces, siga as etapas abaixo:

1. Abra o Terminal

2. Entre na pasta do projeto (manualmente, ou digitando "cd 05_modulos" no terminal.):
Certifique-se de estar na pasta raiz 05_modulos/.

3. Execute o arquivo principal utilizando Python, manualmente ou escrevendo "python main.py" no terminal.

4. Agora interaja com o menu!

MÓDULOS DISPONÍVEIS:
O sistema está dividido em quatro módulos:
1. Temperatura (temperatura.py)

Celsius para Fahrenheit: Transforma temperaturas para o sistema americano.

Celsius para Kelvin: Transforma temperaturas para a escala absoluta (usada na ciência).

2. Distância (distancia.py)

Km para Milhas: Ideal para conversões de velocidade ou distâncias longas.

Metros para Pés: Útil para medidas de altura ou construção civil.

3. Massa (massa.py)

Kg para Libras (lb): Converte o peso do sistema métrico para o imperial.

Libras (lb) para Kg: Faz o cálculo inverso de forma precisa.

4. Utilitários e Validação (utils/)

Validador: Protege o sistema contra erros. Se você digitar uma letra onde deveria ser um número, o validador impede o programa de parar por conta do erro.

Formatador: organiza as msgs no terminal.


EXEMPLOS DE USO:
 - Para uma tarefa de casa ou estudos de física
 - pesquisas científicas 
 - etc...