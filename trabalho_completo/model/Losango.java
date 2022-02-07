package trabalho_completo.model;

/**
 * A classe Losango instancia um novo objeto Losango.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Losango extends Quadrilatero{

    private double diagonal1, diagonal2;
    public Losango(){}
    public Losango(Ponto a, Ponto b, Ponto c, Ponto d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        setDiagonais();
    }

    /**
     * Retorna o coeficiente angular entre dois pontos (vulgo coeficiente angular de uma reta)
     *
     * @author Lucas
     * @version inicial
     *
     */
    public void setDiagonais() {
        if (setCoeficiente(a, b)==setCoeficiente(c, d)){
            
            diagonal1 = Math.pow(Math.pow(Math.max(a.getX(), c.getX()) - Math.min(a.getX(), c.getX()), 2)
            + Math.pow(Math.max(a.getY(), c.getY()) - Math.min(a.getY(), c.getY()), 2), (1 / 2.0));
            
            diagonal2 = Math.pow(Math.pow(Math.max(b.getX(), d.getX()) - Math.min(b.getX(), d.getX()), 2)
            + Math.pow(Math.max(b.getY(), d.getY()) - Math.min(b.getY(), d.getY()), 2), (1 / 2.0));
        }else {
            diagonal1 = Math.pow(Math.pow(Math.max(a.getX(), b.getX()) - Math.min(a.getX(), b.getX()), 2)
                + Math.pow(Math.max(a.getY(), b.getY()) - Math.min(a.getY(), b.getY()), 2), (1 / 2.0));
            
            diagonal2 = Math.pow(Math.pow(Math.max(c.getX(), d.getX()) - Math.min(c.getX(), d.getX()), 2)
                + Math.pow(Math.max(c.getY(), d.getY()) - Math.min(c.getY(), d.getY()), 2), (1 / 2.0));
        }
    }
    
    public double getPerimetro() {
        return setLado(a,b) + setLado(b,c) + setLado(c,d) + setLado(a,d);
    }

    public double getArea() {
        // double semiperimetro = perimetro / 2;
        // area = (baseMaior + baseMenor) * Math.pow(((semiperimetro - baseMaior) * (semiperimetro - baseMenor)
        //         * (semiperimetro - baseMaior - ladoDireito) * (semiperimetro - baseMaior - ladoEsquerdo)), 1 / 2.0)
        //         / (baseMaior - baseMenor);
        return (diagonal1+diagonal2)/2;
    }

    @Override
    public String toString() {
        return "Losango----\n" + 
        "Área = " + getArea() + "\n"+
        "Perímetro = " + getPerimetro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Losango losango = (Losango) o;

        return getArea() == losango.getArea();
    }

    public int hashCode() {
        return 4;
    }
    
}
