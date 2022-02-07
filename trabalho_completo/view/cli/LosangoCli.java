package trabalho_completo.view.cli;


import trabalho_completo.model.Losango;
import trabalho_completo.model.Ponto;


/**
 * A classe LosangoCosole atribui os parâmetros de entrada de um novo objeto Losango.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class LosangoCli extends AbstractCRUDCli<Losango>{

    public Losango create(){
        showMsg("Digite a seguir as coordenadas do losango (de forma consecutiva):\n");
        showMsg("Digite dois inteiros para as coordenadas do ponto A do LOSANGO:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto a = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do sponto B do LOSANGO:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto b = new Ponto(x, y);

        showMsg("Digite dois inteiros para as coordenadas do ponto C ponto do LOSANGO:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto c = new Ponto(x, y);
        
        showMsg("Digite dois inteiros para as coordenadas do ponto D do LOSANGO:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto d = new Ponto(x, y);
        
        Losango los = new Losango(a, b, c, d);
        return los;
    }
}
