package jogador;

import java.io.*;
import modelo.Marca;
import modelo.Tabuleiro;

public class JogadorHumano implements Jogador
{
    private Marca          marca     = null;
    private Tabuleiro      tabDoJogo = null;
    private static BufferedReader teclado = new BufferedReader
                                        (new InputStreamReader
                                        (System.in));

    public JogadorHumano (Tabuleiro tab) throws Exception
    {
        // atribuir tab para tabDoJogo
        // pedir para o jogador escolher
        // sua marca e permitir digitacao
        // intanciando marca
        if (tab == null)
            throw new Exception("O tabuleiro nao pode ser nulo.");

        tabDoJogo = tab;
        while (marca == null)
        {
            System.out.print("Escolha sua marca (X/O): ");
            String entrada = lerEntrada().toUpperCase();

            if (entrada.equals("X") || entrada.equals("O"))
                marca = new Marca(entrada.charAt(0));
            else
                System.out.println("Digite X ou O.");
        }
    }
// aqui eu tenho um construtor
    public JogadorHumano (Tabuleiro tab, Marca mrc) throws Exception
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

    public void facaSuaJogada () throws IOException
    {
        // pergunta para o jogador onde ele quer
        // jogar, permitindo digitacao e chamando
        // os métodos apropriados de tabDoJogo
        while (true)
        {
            System.out.println("Sua vez (" + marca + "). Use linha e coluna de 1 a 3.");
            System.out.print("Linha: ");
            String linha = lerEntrada();
            System.out.print("Coluna: ");
            String coluna = lerEntrada();

            try
            {
                int lin = Integer.parseInt(linha);
                int col = Integer.parseInt(coluna);
                if (lin < 1 || lin > 3 || col < 1 || col > 3)
                    throw new Exception("Linha e coluna devem estar entre 1 e 3.");

                // eu tenho o lin -1 pq esse -1 é para ajustar o valor digitado pelo jogador, que é de 1 a 3, para o índice do array, que é de 0 a 2
                tabDoJogo.setMarcaNaPosicao(marca, lin - 1, col - 1);
                return;
            }
            catch (NumberFormatException erro)
            {
                System.out.println("Digite apenas numeros inteiros.");
            }
            catch (Exception erro)
            {
                System.out.println(erro.getMessage());
            }
        }
    }

    public void vcGanhou ()
    {
        // mostra mensagem indicando vitoria
        System.out.println("Voce ganhou!");
    }

    public void vcPerdeu ()
    {
        // mostra mensagem indicando derrota
        System.out.println("O computador ganhou. Voce perdeu.");
    }

    public void deuVelha ()
    {
        // mostra mensagem indicando empate
        System.out.println("Deu velha! Empate.");
    }

    public boolean querMaisUmaPartida () throws IOException
    {
        // perguntar se deseja jogar de novo
        // permitindo digitacao e retornando
        // true ou false, conforme a resposta
        while (true)
        {
            System.out.print("Jogar novamente? (S/N): ");
            String resposta = lerEntrada();

            if (resposta.equalsIgnoreCase("S"))
                return true;
            if (resposta.equalsIgnoreCase("N"))
                return false;

            System.out.println("Digite S ou N.");
        }
    }

    private String lerEntrada () throws IOException
    {
        String entrada = teclado.readLine();
        if (entrada == null)
            throw new EOFException("Entrada encerrada.");

        return entrada.trim();
    }

    @Override
    public String toString ()
    {
        return "Jogador humano (" + marca + ")";
    }
}
