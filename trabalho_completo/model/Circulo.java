package trabalho_completo.model;

/**
 * A classe Circulo instancia um novo objeto círculo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Circulo extends FiguraGeometrica {

    protected Ponto origem;
    private int tamanhoDiametro;

    public Circulo() {
        this(new Ponto(0, 0),100);
    }

    public Circulo(int tamanhoDiametro) {
        this(new Ponto(0, 0), tamanhoDiametro);
    }

    public Circulo(Ponto origem, int tamanhoDiametro) {
        this.tamanhoDiametro = tamanhoDiametro;
        this.origem = origem;
    }

    public double getDiametro() {
        return tamanhoDiametro;
    }
    public Ponto getOrigem() {
        return origem;
    }


    public double getArea() {
        return tamanhoDiametro * tamanhoDiametro * Math.PI / 4;
    }

    public double getPerimetro() {
        return tamanhoDiametro * Math.PI;
    }

    @Override
    public String toString() {
        return "Circulo----\n" + 
        "Área = " + getArea() + "\n"+
        "Perímetro = " + getPerimetro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Circulo circulo = (Circulo) o;

        return tamanhoDiametro == circulo.tamanhoDiametro;
    }

    public int hashCode() {
        return 3;
    }
}
