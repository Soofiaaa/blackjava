package jeu21;
import java.util.Scanner;

/**
 * Version: 1.0
 *
 * author: Sofia
 */

public class Application21
{
    private Partie21 partie;

    public static boolean validerOuiNon()
    {
        Scanner clavier = new Scanner(System.in);
        char reponse;

        do
        {
            System.out.println("\nVoulez-vous jouer une autre partie ? (o/n)");
            reponse = clavier.nextLine().toUpperCase().charAt(0);
        }
        while (reponse != 'N' && reponse != 'O');

        return (reponse == 'O');
    }

    public Application21()
    {
        do
        {
            partie = new Partie21();
            partie.jouer();
        }
        while (validerOuiNon());

        System.out.println("\nAu revoir!");
    }

    public static void main(String[] args)
    {
        new Application21();

        System.exit(0);
    }

}
