package src;

import java.util.Date;

public class CompteCourant extends Compte{
    private double decouvert;

    @Override
    public void retirer(double montant) {
        if(montant > solde + decouvert) throw new RuntimeException("solde insuffisant !");
        Retrait r = new Retrait(operations.size()+1, new Date(), montant);
        operations.add(r);
        solde = solde - montant;
    }

    @Override
    public void updateSolde() {

    }

    public CompteCourant() {
    }

    public CompteCourant(int code, double solde, double decouvert) {
        super(code, solde);
        this.decouvert = decouvert;
    }
}
