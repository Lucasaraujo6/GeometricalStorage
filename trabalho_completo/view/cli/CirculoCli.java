package trabalho_completo.view.cli;


import trabalho_completo.dao.DAO;
import trabalho_completo.model.Circulo;
import trabalho_completo.model.Ponto;


/**
 * A classe CirculoCosole atribui os parâmetros de entrada de um novo objeto círculo.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class CirculoCli extends AbstractCRUDCli<Circulo>{

    public Circulo create() {
        showMsg("Digite dois inteiros para a origem do circulo:\n");
        int x  = in.nextInt();
        int y = in.nextInt();
        Ponto origem = new Ponto(x, y);
        showMsg("Digite um inteiro para o diametro do circulo:\n");
        int tamanho = in.nextInt();
        Circulo circ = new Circulo(origem, tamanho);
        return circ;
    }

    public void update(DAO lp, int i){
        lp.listar(i);
        showMsg("Posição do vetor a editar: ");
        int posicao = askInt();
        Circulo figura = (Circulo) lp.getVetor(posicao);
        showMsg("Informação a editar:\n1: Origem\n2: Tamanho do diâmetro\n");
        int opcao = askInt();

        Ponto origem;
        double diametro;
        if (opcao == 1){
            showMsg("Digite dois inteiros para a origem do círculo:\n");
            int x = in.nextInt();
            int y = in.nextInt();

            origem = new Ponto(x, y);
            diametro = figura.setLado(figura.getA(), figura.getB());
        } else if (opcao == 2){
            showMsg("Digite um inteiro para o novo tamanho do diâmetro:\n");
            origem = figura.getA();
            diametro = in.nextInt();
        }else{showMsg("Opção inválida. Tente editar novamente.\n");
        return;
        }
        Circulo circ = new Circulo(origem, (int) diametro);
        lp.setVetor(posicao, circ);
        showMsg("\nFigura editada com sucesso!\n\n");
    }

    public void read(DAO lp){
        showLnMsg("Escolha a posição a tratar dentre os círculos armazenados: ");
        lp.listar(1);
        showMsg("Digite o número da posição a tratar: ");
        Circulo circ = (Circulo) lp.getVetor(askInt());
        showLnMsg("\nTipo de figura: Círculo\nOrigem: (" + circ.getX(circ.getA()) +", " + circ.getY(circ.getA()) +
                ")\nTamanho do diâmetro: " + circ.setLado(circ.getA(), circ.getB()) +
                "\nÁrea: " + circ.getArea() + "\nCircunferência: " + circ.getPerimetro()+"\n");
    }
}
