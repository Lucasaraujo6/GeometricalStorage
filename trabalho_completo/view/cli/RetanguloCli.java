package trabalho_completo.view.cli;



import trabalho_completo.model.Ponto;
import trabalho_completo.model.Retangulo;

/**
 * A classe RetaguloCosole atribui os parâmetros de entrada de um novo objeto retangulo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class RetanguloCli extends AbstractCRUDCli<Retangulo>{

    public Retangulo create(){
        showMsg("Digite dois inteiros para a origem do retângulo:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto origem = new Ponto(x, y);
        showMsg("Digite um inteiro para o tamanho da base do retangulo:\n");
        int base  = in.nextInt();
        showMsg("Digite um inteiro para o tamanho do lado do retangulo:\n");
        int lado  = in.nextInt();
        Retangulo ret = new Retangulo(origem, base , lado);
        return ret;
    }
}
