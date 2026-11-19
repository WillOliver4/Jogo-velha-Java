import jogador.*;
import modelo.Marca;
import modelo.Tabuleiro;
import java.io.*;

public class Velha
{
    public static void main (String[] args)
    {
        Tabuleiro           tabDoJogo;

        Jogador             jogador  = null;
        JogadorHumano       jogadorH = null;
        JogadorAutomatico   jogadorA = null;

        AnalistaSituacional analista;

        boolean jogadorHumanoComeca = (int)(Math.random()*2) == 0;
        boolean continuar;

        System.out.println("JOGO DA VELHA");

        do
        {
            try
            {
                tabDoJogo = new Tabuleiro ();
                if (jogadorHumanoComeca)
                    System.out.println("Voce comeca esta partida.");
                else
                    System.out.println("O computador comeca esta partida.");

                if (jogadorHumanoComeca)
                {
                    jogadorH = new JogadorHumano (tabDoJogo);
                    jogadorA = new JogadorAutomatico
                              (tabDoJogo,
                               new Marca(jogadorH.getMarca().getSimbolo()=='X'?'O':'X'));
                }
                else
                {
                    jogadorA = new JogadorAutomatico (tabDoJogo);
                    jogadorH = new JogadorHumano
                              (tabDoJogo,
                               new Marca(jogadorA.getMarca().getSimbolo()=='X'?'O':'X'));
                }

                analista = new AnalistaSituacional (tabDoJogo);

                if (jogadorHumanoComeca)
                    jogador=jogadorH;
                else
                    jogador=jogadorA;

                System.out.println("Sua marca: " + jogadorH.getMarca());
                System.out.println("Marca do computador: " + jogadorA.getMarca());
                System.out.println(tabDoJogo);

                do
                {
                    System.out.println(jogador);
                    jogador.facaSuaJogada();
                    System.out.println(tabDoJogo);

                    if (jogador==jogadorH)
                        jogador=jogadorA;
                    else
                        jogador=jogadorH;
                }
                while (!analista.fimDeJogo());

                Marca vencedor = analista.getMarcaDoVencedor();
                if (vencedor == null)
                    jogadorH.deuVelha ();
                else if (vencedor.equals(jogadorH.getMarca()))
                    jogadorH.vcGanhou ();
                else
                    if (vencedor.equals(jogadorA.getMarca()))
                        jogadorH.vcPerdeu ();
                    else
                        jogadorH.deuVelha ();

                jogadorHumanoComeca = !jogadorHumanoComeca;
                continuar = jogadorH.querMaisUmaPartida();
            }
            catch (EOFException e)
            {
                System.out.println("Entrada encerrada.");
                return;
            }
            catch (Exception e)
            {
                System.out.println("Erro: " + e.getMessage());
                return;
            }
        }
        while (continuar);

        System.out.println("Obrigado por jogar!");
    }
}
