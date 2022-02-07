package trabalho_completo.view.cli;


import trabalho_completo.model.Ponto;


/**
 * A classe PontoCosole atribui os parâmetros de entrada de um novo objeto ponto.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class PontoCli extends AbstractCRUDCli<Ponto>{

    public Ponto create(){
        showMsg("Digite as coordenadas do ponto:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto ponto = new Ponto(x, y);
        return ponto;
    }
    
}
