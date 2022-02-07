package trabalho_completo.model;

/**
 * A classe Retangulo instancia um novo objeto retangulo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Retangulo extends Quadrilatero{

    public Retangulo() {
    }

    public Retangulo(Ponto origem, int base, int altura) {
        a = origem;
        b = new Ponto(origem.getX()+base,origem.getY());
        c = new Ponto(origem.getX()+base,origem.getY()+altura);
        d = new Ponto(origem.getX(),origem.getY()+altura);  
    }

    // public Ponto getA() {
    //     return a;
    // }

    // public Ponto getB() {
    //     return b;
    // }

    // public Ponto getC() {
    //     return c;
    // }

    // public Ponto getD() {
    //     return d;
    // }

    public double getArea(){
        return setLado(a, b) * setLado(c, d);
    }

    public double getPerimetro(){
        return setLado(a, b)*2 + 2*setLado(c, d);
    }

    @Override
    public String toString() {
        return "Retângulo----\n" + 
        "Área = " + getArea() + "\n"+
        "Perímetro = " + getPerimetro();
    }

    public int hashCode() {
        return 2;
    }
}
