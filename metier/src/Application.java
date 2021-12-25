package src;

import java.util.List;

public class Application {

    public static void main(String[] args) {

       try {
           Compte compteCourant = new CompteCourant(1, 8000, 5000);
           Compte cpEpargne = new CompteEpargne(2, 30000, 5.5);

           compteCourant.verser(50000);
           compteCourant.retirer(3000);
           compteCourant.verser(4000);
           compteCourant.virement(400, cpEpargne);
           compteCourant.retirer(7000);

           System.out.println("solde compteCourant=" + compteCourant.consulterSolde());
           System.out.println("solde compteEpargne=" + cpEpargne.consulterSolde());
           System.out.println("---------------------------------------------");
           List<Operation> operationList = compteCourant.getOperations();
           for (Operation o : operationList) {
               System.out.println(o.getClass().getSimpleName() + "----" + o.getNumero() + "---" + o.getDateOperation() + "---" + o.getMontant());
           }
           System.out.println("Total versements du compte compteCourant=" + compteCourant.totalVersement());
           System.out.println("Total retraits du compte compteCourant=" + compteCourant.totalRetraits());

           //compteCourant.retirer(80000000);

           System.out.println("Mettre à jour le solde");

           compteCourant.updateSolde();
           cpEpargne.updateSolde();

           System.out.println("Solde du compte comptCourant="+ compteCourant.consulterSolde());
           System.out.println("Solde du compte comptEpargne="+ cpEpargne.consulterSolde());
       }catch(Exception e){
           System.out.println(e.getMessage());
       }

    }
}
