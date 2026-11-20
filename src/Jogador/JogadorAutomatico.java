package jogador;


import modelo.Marca;
import modelo.Tabuleiro;

// aqui estou implementando modelo.marca e tabuleiro porque o jogador automatico precisa saber qual a sua marca e o estado do tabuleiro para poder jogar sozinho
// nesse sentido, é necessario implantar tanto na interface 

public class JogadorAutomatico implements Jogador
{
    private Marca     marca     = null;
    private Tabuleiro tabDoJogo = null;

    public JogadorAutomatico (Tabuleiro tab) throws Exception
    {
        // atribuir tab para tabDoJogo
        // fazer o jogador escolher sua marca
        // via sorteio de numeros aleatorio
        if (tab == null)
            throw new Exception("O tabuleiro nao pode ser nulo.");

        tabDoJogo = tab;
        if ((int)(Math.random()*2) == 0)
            marca=new Marca('X');
        else
            marca=new Marca('O');
    }

    public JogadorAutomatico (Tabuleiro tab, Marca mrc) throws Exception
    {
        // atribuir tab para tabDoJogo
        // e mrc para marca
        if (tab == null || mrc == null)
            throw new Exception("Tabuleiro e marca nao podem ser nulos.");

        tabDoJogo = tab;
        marca = mrc;
    }

    public Marca getMarca ()
    {
        // retorna a marca do jogador
        return marca;
    }

    public void facaSuaJogada ()
    {
        try
        {
            Marca adversaria = new Marca(marca.getSimbolo() == 'X' ? 'O' : 'X');
            // tentando ganhar na linha 0
            if (tentarSequencia(marca, 2, 0, 0, 0, 1))
                return;
            // tentando ganhar na linha 1
            if (tentarSequencia(marca, 2, 1, 0, 0, 1))
                return;
            // tentando ganhar na linha 2
            if (tentarSequencia(marca, 2, 2, 0, 0, 1))
                return;
            // tentando ganhar na coluna 0
            if (tentarSequencia(marca, 2, 0, 0, 1, 0))
                return;
            // tentando ganhar na coluna 1
            if (tentarSequencia(marca, 2, 0, 1, 1, 0))
                return;
            // tentando ganhar na coluna 2
            if (tentarSequencia(marca, 2, 0, 2, 1, 0))
                return;
            // tentando ganhar na diagonal principal
            if (tentarSequencia(marca, 2, 0, 0, 1, 1))
                return;
            // tentando ganhar na diagonal secundaria
            if (tentarSequencia(marca, 2, 0, 2, 1, -1))
                return;
            // tentando atrapalhar vitoria na linha 0
            if (tentarSequencia(adversaria, 2, 0, 0, 0, 1))
                return;
            // tentando atrapalhar vitoria na linha 1
            if (tentarSequencia(adversaria, 2, 1, 0, 0, 1))
                return;
            // tentando atrapalhar vitoria na linha 2
            if (tentarSequencia(adversaria, 2, 2, 0, 0, 1))
                return;
            // tentando atrapalhar vitoria na coluna 0
            if (tentarSequencia(adversaria, 2, 0, 0, 1, 0))
                return;
            // tentando atrapalhar vitoria na coluna 1
            if (tentarSequencia(adversaria, 2, 0, 1, 1, 0))
                return;
            // tentando atrapalhar vitoria na coluna 2
            if (tentarSequencia(adversaria, 2, 0, 2, 1, 0))
                return;
            // tentando atrapalhar vitoria na diagonal principal
            if (tentarSequencia(adversaria, 2, 0, 0, 1, 1))
                return;
            // tentando atrapalhar vitoria na diagonal secundaria
            if (tentarSequencia(adversaria, 2, 0, 2, 1, -1))
                return;
            // tentando jogada de futuro na linha 0
            if (tentarSequencia(marca, 1, 0, 0, 0, 1))
                return;
            // tentando jogada de futuro na linha 1
            if (tentarSequencia(marca, 1, 1, 0, 0, 1))
                return;
            // tentando jogada de futuro na linha 2
            if (tentarSequencia(marca, 1, 2, 0, 0, 1))
                return;
            // tentando jogada de futuro na coluna 0
            if (tentarSequencia(marca, 1, 0, 0, 1, 0))
                return;
            // tentando jogada de futuro na coluna 1
            if (tentarSequencia(marca, 1, 0, 1, 1, 0))
                return;
            // tentando jogada de futuro na coluna 2
            if (tentarSequencia(marca, 1, 0, 2, 1, 0))
                return;
            // tentando jogada de futuro na diagonal principal
            if (tentarSequencia(marca, 1, 0, 0, 1, 1))
                return;
            // tentando jogada de futuro na diagonal secundaria
            if (tentarSequencia(marca, 1, 0, 2, 1, -1))
                return;
            // termine jogando num lugar qualquer que esteja livre
            for (int lin = 0; lin < 3; lin++)
                for (int col = 0; col < 3; col++)
                    if (!tabDoJogo.haMarcaNaPosicao(lin, col))
                    {
                        tabDoJogo.setMarcaNaPosicao(marca, lin, col);
                        return;
                    }

            throw new Exception("O tabuleiro esta cheio.");
        }
        catch (Exception erro)
        // ignorando pois sei que n o estou usando posicao invalida nem comparando com equals um null
        {
            // Se houver um erro inesperado, ele sera informado pelo programa principal.
            throw new IllegalStateException(erro);
        }
    }

    private boolean tentarSequencia (Marca alvo, int quantidade, int lin, int col,
                                    int passoLin, int passoCol) throws Exception
    {
        int iguais = 0;
        int vazias = 0;
        int linLivre = -1;
        int colLivre = -1;

        for (int i = 0; i < 3; i++)
        {
            int l = lin + i * passoLin;
            int c = col + i * passoCol;
            Marca atual = tabDoJogo.getMarcaNaPosicao(l, c);

            if (atual == null)
            {
                vazias++;
                linLivre = l;
                colLivre = c;
            }
            else if (alvo.equals(atual))
                iguais++;
        }

        if (iguais == quantidade && vazias == 3 - quantidade)
        {
            tabDoJogo.setMarcaNaPosicao(marca, linLivre, colLivre);
            return true;
        }

        return false;
    }

    @Override
    public String toString ()
    {
        return "Computador (" + marca + ")";
    }
}
