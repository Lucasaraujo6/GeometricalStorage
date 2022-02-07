package trabalho_completo.model;

public class Texto extends Renderizaveis {
    
    private String texto;
    private Ponto a;

    public Texto(Ponto origem, String texto){
        this.texto = texto;
        this.a = origem;
    }

    public Texto() {
    }

    public String getTexto(){    
        return this.texto;
    }

    public Ponto getA() {
        return this.a;
    }
    public int getX(Ponto a){
        return a.getX();
    }
    public int getY(Ponto a){
        return a.getY();
    }



    @Override
    public String toString() {
        return "Texto----\n" +
        "Conteúdo: " + getTexto();
    }

    public int hashCode() {
        return 9;
    }

}

