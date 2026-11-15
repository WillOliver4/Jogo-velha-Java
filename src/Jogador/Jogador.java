package jogador;

import modelo.Marca;

public interface Jogador
{
    public Marca getMarca();

    public void facaSuaJogada() throws Exception;

    public String toString();
}
