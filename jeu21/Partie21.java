package jeu21;
import paquet.Paquet;
import java.util.Scanner;

/**
 * Version: 1.0
 *
 * author: Sofia
 */

public class Partie21
{
    private Main21 jeuJoueur;
    private Main21 jeuBanquier;
    private Paquet paquet;

    public Partie21()
    {
        paquet = new Paquet();
        jeuJoueur = new Main21(paquet, 2);
        jeuBanquier = new Main21(paquet,2);
    }

    private static boolean validerConserverOuJouer()
    {
        Scanner input = new Scanner(System.in);
        char charRetourner = ' ';

        do
        {
            System.out.println("\n(C)onserver son jeu ou (P)iger une carte ?");
            charRetourner = input.nextLine().toUpperCase().charAt(0);
        }
        while (charRetourner != 'C' && charRetourner != 'P');

        return charRetourner == 'C';
    }

    private void faireJouerLeJoueur()
    {
        int valeurDebut = 3;

        while (jeuJoueur.getValeurMain21() < 21 && !validerConserverOuJouer())
        {
            jeuJoueur = new Main21(paquet, 3);
            System.out.println(jeuJoueur);
            valeurDebut++;
        }

        if (jeuJoueur.getValeurMain21() == 21)
        {
            System.out.println("\nVous avez gagnez !");
        }

        else if (jeuJoueur.getValeurMain21() > 21)
        {
            System.out.println("\nVous avez perdu: vous avez dépassé 21.");
        }
    }

    private void faireJouerLeBanquier()
    {
        if (jeuJoueur.getValeurMain21() < 21)
        {
            int valeurDebut = 3;

            while (jeuBanquier.getValeurMain21() < jeuJoueur.getValeurMain21() && jeuBanquier.getValeurMain21() < 21)
            {
                System.out.println("\nLe banquier pige...");
                jeuBanquier = new Main21(paquet, 3);
                System.out.println(jeuBanquier);
                valeurDebut++;
            }

            if (jeuBanquier.getValeurMain21() == 21)
            {
                System.out.println("\nLe banquier a gagné!");
            }

            else if (jeuBanquier.getValeurMain21() > jeuJoueur.getValeurMain21() && jeuBanquier.getValeurMain21() <= 21)
            {
                System.out.println("\nVous avez perdu: votre main est plus faible.");
            }

            else if (jeuBanquier.getValeurMain21() > 21)
            {
                System.out.println("\nVous avez gagné! Le banquier a dépassé 21");
            }
        }
    }

    public void jouer()
    {
        System.out.println("Jeu du banquier : \n" + jeuBanquier);
        System.out.println("Votre jeu : \n" + jeuJoueur);

        faireJouerLeJoueur();
        faireJouerLeBanquier();
    }
}
