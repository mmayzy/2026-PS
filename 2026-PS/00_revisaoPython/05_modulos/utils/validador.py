def validar_numero(valor_str, minimo=None, maximo=None):
    '''tenta converter uma string para float e verifica limites e
    retorna: sucesso, resultado ou erro.'''
    
    try:
        # converte a string para número decimal
        valor = float(valor_str)
        
        ## verificacão para ver se o valor é menor que o mínimo permitido
        if minimo is not None and valor < minimo:
            return False, f"O valor deve ser pelo menos {minimo}."
            
        #verifica se o valor é maior que o máximo permitido
        if maximo is not None and valor > maximo:
            return False, f"O valor não pode ser maior que {maximo}."
            
        #retorna se o teste der certo
        return True, valor
        
    except ValueError:
        #para caso o usuário digitar algo errado
        return False, "Entrada inválida. Por favor, digite apenas números."