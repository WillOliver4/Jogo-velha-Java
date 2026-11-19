import modelo.Marca;
import modelo.Tabuleiro;

public class AnalistaSituacional
{
    private Tabuleiro tabDoJogo;

    public AnalistaSituacional (Tabuleiro tab) throws Exception
    {
        // colocar tab em tabDoJogo
        if (tab == null)
            throw new Exception("O tabuleiro nao pode ser nulo.");

        tabDoJogo = tab;
    }

    public Marca getMarcaDoVencedor ()
    {
        // descobrir se ha um vencedor e retornar
        // a marca dele; retornara null, quando
        // nao houver vencedor
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Marca linha = verificarSequencia(i, 0, 0, 1);
                if (linha != null)
                    return linha;

                Marca coluna = verificarSequencia(0, i, 1, 0);
                if (coluna != null)
                    return coluna;
            }

            Marca diagonal = verificarSequencia(0, 0, 1, 1);
            if (diagonal != null)
                return diagonal;

            return verificarSequencia(0, 2, 1, -1);
        }
        catch (Exception erro)
        {
            throw new IllegalStateException(erro);
        }
    }

    private Marca verificarSequencia (int lin, int col, int passoLin, int passoCol) throws Exception
    {
        Marca primeira = tabDoJogo.getMarcaNaPosicao(lin, col);
        if (primeira == null)
            return null;

        for (int i = 1; i < 3; i++)
            if (!primeira.equals(tabDoJogo.getMarcaNaPosicao(lin + i * passoLin, col + i * passoCol)))
                return null;

        return primeira;
    }

    private boolean tabuleiroCheio ()
    {
        // verificar se todas as posicoes do
        // tabuleiro estao preenchidas (!=null)
        // retornando true em caso afirmativo,
        // ou false em caso negativo
        try
        {
            for (int lin = 0; lin < 3; lin++)
                for (int col = 0; col < 3; col++)
                    if (!tabDoJogo.haMarcaNaPosicao(lin, col))
                        return false;

            return true;
        }
        catch (Exception erro)
        {
            throw new IllegalStateException(erro);
        }
    }

    public boolean fimDeJogo ()
    {
        // se getMarcaDoVencedor != null,
        // retorna true
        // se tabuleiroCheio == true,
        // retorna true
        // caso contrario, retorna false
        return getMarcaDoVencedor() != null || tabuleiroCheio();
    }

    @Override
    public String toString ()
    {
        // faça
        Marca vencedor = getMarcaDoVencedor();
        if (vencedor != null)
            return "Vencedor: " + vencedor;

        if (tabuleiroCheio())
            return "Deu velha!";

        return "Partida em andamento.";
    }

    @Override
    public boolean equals (Object obj)
    {
        // retornar true se this for igual a obj ou false caso contrario
        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        AnalistaSituacional outro = (AnalistaSituacional) obj;
        return tabDoJogo.equals(outro.tabDoJogo);
    }

    @Override
    public int hashCode ()
    {
        // faça
        return tabDoJogo.hashCode();
    }
}
