package trabalho_completo.model;

/**
 * A classe Triângulo instancia um novo objeto triângulo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Triangulo extends FiguraGeometrica {

    private double tamanhoLado1, tamanhoLado2, tamanhoLado3;
    protected Ponto a, b, c;
    
    public Triangulo(){}
    
    public Triangulo(Ponto a, Ponto b, Ponto c) {
        this.a=a;
        this.b=b;
        this.c=c;
        tamanhoLado1 = setLado(a, b);
        tamanhoLado2 = setLado(b, c);
        tamanhoLado3 = setLado(a, c);
    }
    public Ponto getA() {
        return a;
    }
    public Ponto getB() {
        return b;
    }
    public Ponto getC() {
        return c;
    }
    public double getArea() {
        double semiperimetro = getPerimetro()/2;
        return Math.pow(semiperimetro*(semiperimetro-tamanhoLado1)*(semiperimetro-tamanhoLado2)*(semiperimetro-tamanhoLado3),(1/2.0));
    }

    public double getPerimetro() {
        return tamanhoLado1 + tamanhoLado2 + tamanhoLado3;
    }

    public double setLado(Ponto qualquer1, Ponto qualquer2) {
        double tamanho = Math.pow(Math.pow(Math.max(qualquer1.getX(),qualquer2.getX())-Math.min(a.getX(),qualquer2.getX()), 2)
        + Math.pow(Math.max(qualquer1.getY(),qualquer2.getY())-Math.min(qualquer1.getY(),qualquer2.getY()), 2), (1 / 2.0));;
        return tamanho;
    }

    @Override
    public String toString() {
        return "Triângulo----\n" + 
        "Área = " + getArea() + "\n"+
        "Perímetro = " + getPerimetro();
}

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Triangulo triangulo = (Triangulo) o;

        return getArea() == triangulo.getArea();
    }

    public int hashCode() {
        return 6;
    }
}
