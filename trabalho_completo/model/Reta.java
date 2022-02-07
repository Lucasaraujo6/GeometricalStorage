package trabalho_completo.model;

public class Reta extends FiguraGeometrica{

    private Ponto a;
    private Ponto b;

    public Reta() {
        a = new Ponto(0, 0);
        b = new Ponto(0, 1);
    }

    public Reta(Ponto a, Ponto b) {
        this.a = a;
        this.b = b;
    }

    public Ponto getA() {
        return a;
    }

    public int getX() {
        return a.getX();
    }

    public int getY() {
        return a.getY();
    }

    public Ponto getB() {
        return b;
    }

    public double getTamanho() {
        
        return Math.pow(Math.pow(Math.max(a.getX(),b.getX())-Math.min(a.getX(),b.getX()), 2)
        + Math.pow(Math.max(a.getY(),b.getY())-Math.min(a.getY(),b.getY()), 2), (1 / 2.0));
        //System.out.println(" "+ a.getX() +" "+ a.getY() +" "+ b.getX() +" "+ b.getY());
    }
    @Override
    public String toString() {
        return "Reta----\n" + 
        "Tamanho = " + getTamanho();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Reta reta = (Reta) o;

        return getClass() == reta.getClass();
    }

    
    public int hashCode() {
        return 8;
    }
}
