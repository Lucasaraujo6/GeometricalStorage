package trabalho_completo.model;

//import java.util.ArrayList;
/**
 * A classe FiguraGeometrica determina alguns parâmetros para todas herdeiras
 *
 * @author Lucas
 * @version inicial
 *
 */
public class FiguraGeometrica extends Renderizaveis{
    
    protected Ponto a;
    protected Ponto b;
    protected Ponto c;
    protected Ponto d;

    public double getArea(){
        return -1;
    }
    public double getPerimetro(){
        return -1;
    }
    
    public int getX(Ponto a){
        return a.getX();
    }
    public int getY(Ponto a){
        return a.getY();
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
    public Ponto getD() {
        return d;
    }
    public double setLado(Ponto qualquer1, Ponto qualquer2) {
        return Math.pow(Math.pow(Math.max(qualquer1.getX(), qualquer2.getX()) - Math.min(qualquer1.getX(), qualquer2.getX()), 2)
                + Math.pow(Math.max(qualquer1.getY(), qualquer2.getY()) - Math.min(qualquer1.getY(), qualquer2.getY()), 2), (1 / 2.0));
    }
    public double setCoeficiente(Ponto qualquer1, Ponto qualquer2){
        if ((qualquer1.getX() - qualquer2.getX()) == 0) {
            return 90;
        } else {
            return (qualquer2.getY() - qualquer1.getY()) / (qualquer2.getX() - qualquer1.getX());
        }
    }

}
