package trabalho_completo.model;

public class Ponto extends FiguraGeometrica{

    private int x;
    private int y;

    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Ponto----\n" +
                "x=" + x +
                ", y=" + y;
    }

    public int hashCode() {
        return 7;
    }
}
