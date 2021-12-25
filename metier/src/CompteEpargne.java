package src;

import java.util.Date;

public class CompteEpargne extends  Compte{

    private double taux ;

    public CompteEpargne() {
    }

    public CompteEpargne(int code, double solde, double taux) {
        super(code, solde);
        this.taux = taux;
    }

    @Override
    public void retirer(double montant) {
        if(montant > solde) throw new RuntimeException("solde insuffisant !");
        Retrait r = new Retrait(operations.size()+1, new Date(), montant);
        operations.add(r);
        solde = solde - montant;
    }

    @Override
    public void updateSolde() {
     solde = solde*(1 + taux/1000);
    }


}
