package paquet;

/**
 * Version: 1.0
 *
 * author: Sofia
 */

public class Paquet
{
    private Carte[] paquet;
    private int nbCartesPigees = 0;

    public Paquet()
    {
        paquet = new Carte[52];

        Couleur[] couleurs = Couleur.values();
        Rang[] rangs = Rang.values();

        int index = 0;

        for (int i = 0; i < (couleurs.length); i++)
        {
            for (int j = 0; j < (rangs.length); j++)
            {
                paquet[index] = new Carte(rangs[j], couleurs[i]);
                index++;
            }
        }

        melanger();
    }

    private static int aleatoireBorne(int pMin, int pMax)
    {
        return ((int) (Math.random() * (pMax - pMin + 1))) + pMin;
    }

    private void melanger()
    {
        for (int i = 0; i < 100; i++)
        {
            permuter(aleatoireBorne(0, 51), aleatoireBorne(0, 51));
        }
    }

    private void permuter(int pPos1, int pPos2)
    {
        Carte temp = paquet[pPos1];

        paquet[pPos1] = paquet[pPos2];
        paquet[pPos2] = temp;
    }

    public int getNombreDeCartes()
    {
        return paquet.length - nbCartesPigees;
    }

    public Carte piger()
    {
        Carte carteDessus = null;

        if (nbCartesPigees < paquet.length)
        {
            carteDessus = paquet[nbCartesPigees++];
        }

        return carteDessus;
    }
}
