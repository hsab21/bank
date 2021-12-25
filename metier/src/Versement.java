package src;

import java.util.Date;

public class Versement extends Operation {
    public Versement() {
    }

    public Versement(int numero, Date dateOperation, double montant) {
        super(numero, dateOperation, montant);
    }
}
