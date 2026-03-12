def kg_para_libras(kg):
    '''Converte quilogramas para libras (lb)'''
    return kg* 2.20462

def libras_para_kg(lb):
    '''Converte libras (lb) para quilogramas (kg)'''
    return lb / 2.20462

if __name__ == "__main__":
    print("teste do módulo de massa")
    print(f"10 kg - {kg_para_libras(10):.2f} lb")
    print(f"22.05 lb - {libras_para_kg(22.05):.2f} kg")
    print("teste concluído")