package trabalho_completo.model;

/**
 * A classe Quadrilatero determina alguns parâmetros para todas herdeiras
 *
 * @author Lucas
 * @version inicial
 *
 */
public abstract class Quadrilatero extends FiguraGeometrica{

    protected Ponto origem;

    public Quadrilatero() {
    }
    public abstract double getArea();
    public abstract double getPerimetro();
    
}
