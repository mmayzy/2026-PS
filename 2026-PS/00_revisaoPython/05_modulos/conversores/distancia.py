# conversores/distancia.py

def km_para_milhas(km):
    """Converte quilômetros para milhas."""
    return km * 0.621371


def milhas_para_km(milhas):
    """Converte milhas para quilômetros."""
    return milhas / 0.621371


def metros_para_pes(metros):
    """Converte metros para pés."""
    return metros * 3.28084


if __name__ == "__main__": ##bloco 5 
    print("teste distancia.py")
    print(f"1 km = {km_para_milhas(1)} mi (esperado: ~0.6214)")
    print(f"100 m = {metros_para_pes(100)} ft (esperado: 328.084)")
    print("testes de distância ok")