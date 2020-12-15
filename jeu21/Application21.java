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
        Scanner input = new Scanner(System.in);
        System.out.println("\nVoulez-vous jouer une autre partie ? (o/n)");

        return input.nextLine().toUpperCase().charAt(0) == 'O';
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
