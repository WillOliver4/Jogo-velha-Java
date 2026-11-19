package modelo;

public class Tabuleiro implements Cloneable
{
    // a principio, toda igual a null
    private Marca matriz [][] = new Marca [3][3];

    public Tabuleiro ()
    {}

    public boolean haMarcaNaPosicao (int lin, int col) throws Exception
    {
        // verifico se em matriz[lin][col]
        // tem null, retornando false em caso
        // afirmativo, ou true em caso negativo
        // dar excecao caso lin ou col invalido
        return getMarcaNaPosicao(lin, col) != null;
    }

    public Marca getMarcaNaPosicao (int lin, int col) throws Exception
    {
        // retornar a marca que tem em
        // matriz[lin][col]
        // dar excecao caso lin ou col invalido
        if (lin < 0 || lin > 2 || col < 0 || col > 2)
            throw new Exception("Linha e coluna devem estar entre 0 e 2.");

        return matriz[lin][col];
    }

    public void setMarcaNaPosicao (Marca mrc, int lin, int col) throws Exception
    {
        // colocar mrc em matriz[lin][col],
        // dar excecao caso lin ou col invalido
        // dar excecao caso mrc seja null
        if (lin < 0 || lin > 2 || col < 0 || col > 2)
            throw new Exception("Linha e coluna devem estar entre 0 e 2.");

        if (mrc == null)
            throw new Exception("A marca nao pode ser nula.");

        if (matriz[lin][col] != null)
            throw new Exception("Essa posicao ja esta ocupada.");

        matriz[lin][col] = mrc;
    }

    @Override
    public String toString ()
    {
        // retornar em um String o tabuleiro
        // formatado para ser exibido na tela
        String texto = "";

        for (int lin = 0; lin < 3; lin++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (matriz[lin][col] == null)
                    texto += " ";
                else
                    texto += matriz[lin][col].getSimbolo();

                if (col < 2)
                    texto += " | ";
            }

            texto += "\n";
            if (lin < 2)
                texto += "--+---+--\n";
        }

        return texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Tabuleiro outro = (Tabuleiro) obj;

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
            {
                if (matriz[lin][col] == null)
                {
                    if (outro.matriz[lin][col] != null)
                        return false;
                }
                else if (!matriz[lin][col].equals(outro.matriz[lin][col]))
                    return false;
            }

        return true;
    }

    @Override
    public int hashCode ()
    {
        // faça
        int resultado = 1;

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
            {
                resultado = 31 * resultado;
                if (matriz[lin][col] != null)
                    resultado += matriz[lin][col].hashCode();
            }

        return resultado;
    }

    // construtor de copia
    public Tabuleiro (Tabuleiro modelo) throws Exception
    {
        // faça
        if (modelo == null)
            throw new Exception("O tabuleiro de origem nao pode ser nulo.");

        for (int lin = 0; lin < 3; lin++)
            for (int col = 0; col < 3; col++)
                if (modelo.matriz[lin][col] != null)
                    matriz[lin][col] = new Marca(modelo.matriz[lin][col].getSimbolo());
    }

    @Override
    public Object clone ()
    {
        // faça
        try
        {
            return new Tabuleiro(this);
        }
        catch (Exception erro)
        {
            throw new IllegalStateException("Nao foi possivel copiar o tabuleiro.", erro);
        }
    }
}
