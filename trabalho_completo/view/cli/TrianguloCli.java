package trabalho_completo.view.cli;



import trabalho_completo.model.Ponto;
import trabalho_completo.model.Triangulo;


/**
 * A classe TrianguloConsole atribui os parâmetros de entrada de um novo objeto triângulo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class TrianguloCli extends AbstractCRUDCli<Triangulo>{

    public Triangulo create(){
        showMsg("Digite dois inteiros para as coordenadas do primeiro ponto do triangulo:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto a = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do segundo ponto do triangulo:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto b = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do terceiro ponto do triangulo:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto c = new Ponto(x, y);
        
        Triangulo triang = new Triangulo(a, b, c);
        return triang;
    }
}
