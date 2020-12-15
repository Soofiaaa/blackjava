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
        this.paquet = new Paquet();
        this.jeuJoueur = new Main21(paquet, 2);
        this.jeuBanquier = new Main21(paquet,2);
    }

    private static boolean validerConserverOuJouer()
    {
        Scanner input = new Scanner(System.in);
        char charRetourner;

        do
        {
            System.out.println("\n(C)onserver son jeu ou (P)iger une carte ?");
            charRetourner = input.nextLine().toUpperCase().charAt(0);
        }
        while (charRetourner != 'C' && charRetourner != 'P');

        return (charRetourner == 'P');
    }

    private void faireJouerLeJoueur()
    {

        while (jeuJoueur.getValeurMain21() < 21 && validerConserverOuJouer())
        {
            jeuJoueur.piger();
            System.out.println("\nVotre jeu : \n" + jeuJoueur);
        }

        if (jeuJoueur.getValeurMain21() == 21)
        {
            System.out.println("Vous avez gagnez !");
        }
        else
        {
            System.out.println("Vous avez perdu. Vous avez dépassé 21");
        }
    }

    private void faireJouerLeBanquier()
    {
        if (jeuJoueur.getValeurMain21() < 21)
        {
            while (jeuBanquier.getValeurMain21() < jeuJoueur.getValeurMain21() && jeuBanquier.getValeurMain21() < 21)
            {
                jeuBanquier.piger();
                System.out.println("\nLe banquier pige... \nJeu du banquier : \n" + jeuBanquier);
            }

            if (jeuBanquier.getValeurMain21() <= 21)
            {
                System.out.println("\nVous avez perdu: votre main est plus faible.");
            }

            else
            {
                System.out.println("Vous avez gagné! Le banquier a dépassé 21");
            }
        }
    }

    public void jouer()
    {
        System.out.println("\nJeu du banquier : \n" + jeuBanquier);
        System.out.println("\nVotre jeu : \n" + jeuJoueur);

        if (jeuJoueur.getValeurMain21() == 21)
        {
            System.out.println("\nVous avez gagnez !");
        }

        else if (jeuBanquier.getValeurMain21() == 21)
        {
            System.out.println("\nLe banquier a gagné!");
        }

        else
        {
            faireJouerLeJoueur();
            faireJouerLeBanquier();
        }
    }
}
