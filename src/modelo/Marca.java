package modelo;

// em marca.java nós vamos trabalhar os valores que representam X e O, pra colocar no jogo
// e precisamos trabalhar com manipualçao de dados como o tostring, equals e hashcode, para que possamos comparar as marcas e colocar no tabuleiro
public class Marca
{
    private char simbolo;

    public Marca (char smb) throws Exception
    {
        // validar smb, garantindo que ele
        // seja 'X' ou 'O' e coloca-lo em
        // simbolo
        // dar excecao em caso de valor invalido
        if (smb != 'X' && smb != 'O')
            throw new Exception("A marca deve ser X ou O.");

        simbolo = smb;
    }

    public char getSimbolo ()
    {
        // retornar simbolo
        return simbolo;
    }

    @Override
    public String toString ()
    {
        return ""+simbolo;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Marca outra = (Marca) obj;
        return simbolo == outra.simbolo;
    }

    @Override
    public int hashCode ()
    {
        // faça
        return simbolo;
    }
}
