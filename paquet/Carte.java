package paquet;

/**
 * Version: 1.0
 *
 * author: Sofia
 */

public class Carte
{
    private Rang rang;
    private Couleur couleur;

    public Carte(Rang pRang, Couleur pCouleur)
    {
        rang = pRang;
        couleur = pCouleur;
    }

    public Rang getRang()
    {
        return rang;
    }

    public Couleur getCouleur()
    {
        return couleur;
    }

    @Override
    public String toString()
    {
        return getRang() + " de " + getCouleur();
    }
}
