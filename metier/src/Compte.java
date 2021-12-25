package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract  class Compte {

    protected int code ;
    protected double solde;
    protected List<Operation> operations = new ArrayList<>();

    public Compte() {
    }

    public Compte(int code, double solde) {
        this.code = code;
        this.solde = solde;
    }

    public void verser(double montant){
        Versement versment = new Versement(operations.size()+1, new Date(), montant);
        operations.add(versment);
        solde+= montant;
    }
    public abstract void retirer(double montant);

    public void virement(double montant , Compte cp2){
        retirer(montant);
        cp2.verser(montant);
    }
    public double consulterSolde(){
        return solde ;
    }
    public abstract void updateSolde();

    public List<Operation> getOperations(){
        return operations;
    }

    public double totalVersement(){
        double somme = 0;
        for (Operation o : operations){
            if( o instanceof Versement)
               somme = somme + o.getMontant();
        }
        return  somme;
    }

    public double totalRetraits(){
        double somme = 0;
        for (Operation o : operations){
            if( o instanceof Retrait)
                somme = somme + o.getMontant();
        }
        return  somme;
    }
}
