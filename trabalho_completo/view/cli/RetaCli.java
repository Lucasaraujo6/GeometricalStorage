package trabalho_completo.view.cli;


import trabalho_completo.model.Ponto;
import trabalho_completo.model.Reta;


/**
 * A classe RetaCosole atribui os parâmetros de entrada de um novo objeto Reta.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class RetaCli extends AbstractCRUDCli<Reta>{

    public Reta create(){
        showMsg("Digite as coordenadas do início da reta:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto inicio = new Ponto(x, y);
        showMsg("Digite as coordenadas do fim da reta:\n");
        x  = in.nextInt();
        y = in.nextInt();
        Ponto fim = new Ponto(x, y);
        Reta reta = new Reta(inicio, fim);
        return reta;
    }
}
