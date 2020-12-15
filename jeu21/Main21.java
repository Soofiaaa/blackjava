package jeu21;
import paquet.Carte;
import paquet.Paquet;
import paquet.Rang;

/**
 * Version: 1.0
 *
 * author: Sofia
 */

public class Main21
{
    public static final int NB_CARTES_MAIN_MAX = 10;
    private  Carte[] main;
    private int nbCartesMain;
    private Paquet paquet;

    public Main21(Paquet pPaquet, int pNbCartes)
    {
        this.paquet = pPaquet;
        nbCartesMain = 0;
        this.main = new Carte[NB_CARTES_MAIN_MAX];

        for (int i = 0; i < pNbCartes; i++)
        {
            this.piger();
        }
    }

    public Carte piger()
    {
        Carte cPige = paquet.piger();

        if (cPige != null)
        {
            main[nbCartesMain++] = cPige;
        }

        return cPige;
    }

    public int getNbCartes()
    {
        return nbCartesMain;
    }

    public Carte voir (int pPos)
    {
        Carte paquetMain = null;
        if (pPos >= 0 && pPos <= nbCartesMain)
        {
            paquetMain = main[pPos];
        }
        return paquetMain;
    }

    private int getValeurCarte21(Carte pCarte)
    {
        int valeurCarte = 0;

        if (pCarte.getRang() == Rang.AS)
        {
            valeurCarte = 11;
        }

        else if (pCarte.getRang() == Rang.DIX || pCarte.getRang() == Rang.VALET || pCarte.getRang() == Rang.DAME || pCarte.getRang() == Rang.ROI)
        {
            valeurCarte = 10;
        }

        else
        {
            switch (pCarte.getRang())
            {
                case DEUX:
                    valeurCarte = 2;
                    break;
                case TROIS:
                    valeurCarte = 3;
                    break;
                case QUATRE:
                    valeurCarte = 4;
                    break;
                case CINQ:
                    valeurCarte = 5;
                    break;
                case SIX:
                    valeurCarte = 6;
                    break;
                case SEPT:
                    valeurCarte = 7;
                    break;
                case HUIT:
                    valeurCarte = 8;
                    break;
                case NEUF:
                    valeurCarte = 9;
            }
        }

        return valeurCarte;
    }

    public int getValeurMain21()
    {
        int valeurMain = 0;

        for (int i = 0; i < nbCartesMain; i++)
        {
            valeurMain += getValeurCarte21(main[i]);
        }

        return valeurMain;
    }

    private String getStrMain()
    {
        String mainEnStr = "";

        for (int i = 0; i < nbCartesMain; i++)
        {
            mainEnStr += (i+1 + " - " + main[i] + "\n");
        }

        return mainEnStr;
    }

    @Override
    public String toString()
    {
        String msg = " -> 21 est dépassé.";

        if (getValeurMain21() <= 21)
        {
            msg = " -> " + (21 - getValeurMain21()) + " pour dépasser.";
        }

        return getStrMain() + "\nValeur de la main : " + getValeurMain21() + msg + "\n";
    }

    public static void main(String[] args)
    {
        Paquet paquet = new Paquet();
        Main21 carte1 = new Main21(paquet, 2);

        System.out.println(carte1);
        System.out.println(carte1.piger());
        System.out.println(carte1);
    }
}
