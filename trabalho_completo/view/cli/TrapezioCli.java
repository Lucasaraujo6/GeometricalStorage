package trabalho_completo.view.cli;


import trabalho_completo.model.Ponto;
import trabalho_completo.model.Trapezio;

/**
 * A classe TrapezioCosole atribui os parâmetros de entrada de um novo objeto trapezio.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class TrapezioCli extends AbstractCRUDCli<Trapezio>{

    public Trapezio create(){
        showMsg("Digite dois inteiros para as coordenadas do primeiro ponto do trapezio:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto a = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do segundo ponto do trapezio:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto b = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do terceiro ponto do trapezio:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto c = new Ponto(x, y);
        
        showMsg("Digite dois inteiros para as coordenadas do quarto ponto do trapézio:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto d = new Ponto(x, y);
        
        Trapezio trap = new Trapezio(a, b, c, d);
        return trap;
    }
}
