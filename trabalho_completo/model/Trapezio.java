package trabalho_completo.model;

/**
 * A classe Trapezio instancia um novo objeto trapezio.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Trapezio extends Quadrilatero {

    private double baseMenor, baseMaior, ladoEsquerdo, ladoDireito;

    public Trapezio(){}
    public Trapezio(Ponto a, Ponto b, Ponto c, Ponto d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.setBases();
        this.getPerimetro();
        this.getArea();
    }

    public void setBases() {
        if (setCoeficiente(a, b) == setCoeficiente(c, d)) {
            if (setLado(a, b) > setLado(c, d)) {
                baseMaior = setLado(a, b);
                baseMenor = setLado(c, d);
                ladoDireito = setLado(c, b);
                ladoEsquerdo = setLado(d, a);
            } else {
                baseMenor = setLado(a, b);
                baseMaior = setLado(c, d);
                ladoEsquerdo = setLado(c, b);
                ladoDireito = setLado(d, a);
            }
        } else {
            if (setLado(a, b) > setLado(d, a)) {
                baseMaior = setLado(c, b);
                baseMenor = setLado(d, a);
                ladoDireito = setLado(c, d);
                ladoEsquerdo = setLado(a, b);
            } else {
                baseMaior = setLado(d, a);
                baseMenor = setLado(c, b);
                ladoDireito = setLado(a, b);
                ladoEsquerdo = setLado(c, d);
            }
        }
        //System.out.println(baseMaior + "BASEMAIOR\n" + baseMenor + "BASEMENOR\n" + ladoDireito + "LADODIREITO\n"
        //        + ladoEsquerdo + "LADOESQUERDO\n");
    }

    public double getAltura() {
        return Math.pow((baseMaior + ladoDireito + ladoEsquerdo - baseMenor)
                        * (-baseMaior + ladoDireito + ladoEsquerdo + baseMenor)
                        * (-baseMaior - ladoDireito + ladoEsquerdo + baseMenor)
                        * (-baseMaior + ladoDireito - ladoEsquerdo + baseMenor), (1 / 2.0))
                        / (2 * (baseMaior - baseMenor));
                        //System.out.println(altura + "ALTURA");
    }

    public double getPerimetro() {
        return setLado(d, a) + setLado(c, a) + setLado(b, a) + setLado(b, c);
        // System.out.println(tamanhoLado1+"tamanhoLado1\n"+tamanhoLado2+"tamanhoLado2\n"+tamanhoLado3+"tamanhoLado3\n"+tamanhoLado4+"tamanhoLado4\n");
    }

    public double getArea() {
        // double semiperimetro = perimetro / 2;
        // area = (baseMaior + baseMenor) * Math.pow(((semiperimetro - baseMaior) * (semiperimetro - baseMenor)
        //         * (semiperimetro - baseMaior - ladoDireito) * (semiperimetro - baseMaior - ladoEsquerdo)), 1 / 2.0)
        //         / (baseMaior - baseMenor);
        return (baseMaior+baseMenor)*getAltura()/2;
    }

    @Override
    public String toString() {
        return "Trapezio----\n" + 
        "Área = " + getArea() + "\n"+
        "Perímetro = " + getPerimetro();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Trapezio trapezio = (Trapezio) o;

        return getArea() == trapezio.getArea();
    }

    public int hashCode() {
        return 5;
    }
}
