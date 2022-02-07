package trabalho_completo.model;

/**
 * A classe Quadrado instancia um novo objeto Quadrado.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class Quadrado extends Retangulo{

    private int tamanhoLado;

    public Quadrado(){
    }

    public Quadrado(int tamanhoLado){
        this(new Ponto(0,0), tamanhoLado);
    }

    public Quadrado(Ponto origem, int tamanhoLado) {
       super(origem,tamanhoLado,tamanhoLado);
    }


    // public double getArea(){
    //     return tamanhoLado*tamanhoLado;
    // }

    // public double getPerimetro(){
    //     return tamanhoLado*4;
    // }

    @Override
    public String toString() {
            return "Quadrado----\n" + 
            "Área = " + getArea() + "\n"+
            "Perímetro = " + getPerimetro();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadrado quadrado = (Quadrado) o;

        return tamanhoLado == quadrado.tamanhoLado;
    }

    public int hashCode() {
        return 1;
    }
}
