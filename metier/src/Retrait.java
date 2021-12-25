package src;

import java.util.Date;

public class Retrait extends Operation{

    public Retrait() {
    }

    public Retrait(int numero, Date dateOperation, double montant) {
        super(numero, dateOperation, montant);
    }
}
