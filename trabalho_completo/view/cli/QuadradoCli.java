package trabalho_completo.view.cli;

import trabalho_completo.dao.DAO;
import trabalho_completo.model.Quadrado;
import trabalho_completo.model.Ponto;

/**
 * A classe QuadradoCosole atribui os parâmetros de entrada de um novo objeto
 * quadrado.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class QuadradoCli extends AbstractCRUDCli<Quadrado>{

    public Quadrado create() {
        showMsg("Digite dois inteiros para a origem do quadrado:\n");
        int x = in.nextInt();
        int y = in.nextInt();
        Ponto origem = new Ponto(x, y);
        showMsg("Digite um inteiro para o tamanho do lado do quadrado:\n");
        int tamanho = in.nextInt();
        Quadrado quad = new Quadrado(origem, tamanho);
        return quad;
    }

    public void update(DAO lp, int i){
        lp.listar(i);
        showMsg("Posição do vetor a editar: ");
        int posicao = askInt();
        Quadrado figura = (Quadrado) lp.getVetor(posicao);
        showMsg("Informação a editar:\n1: Origem\n2: Tamanho do lado\n");
        int opcao = askInt();
        Ponto origem;
        double tamanho;
        if (opcao == 1){
            showMsg("Digite dois inteiros para a origem do quadrado:\n");
            int x = in.nextInt();
            int y = in.nextInt();
            origem = new Ponto(x, y);
            tamanho = figura.setLado(figura.getA(), figura.getB());
        } else if (opcao == 2){
            showMsg("Digite um inteiro para o novo tamanho do lado:\n");
            origem = figura.getA();
            tamanho = in.nextInt();
        }else{showMsg("Opção inválida. Tente editar novamente.\n");
        return;
        }
        Quadrado quad = new Quadrado(origem, (int) tamanho);
        lp.setVetor(posicao, quad);
        showMsg("\nFigura editada com sucesso!\n\n");
    }

    public void read(DAO lp, int hash){
        showLnMsg("Escolha a posição a tratar dentre os quadrados armazenados: ");
        lp.listar(hash);
        showMsg("Digite o número da posição a tratar: ");
        Quadrado quad = (Quadrado) lp.getVetor(askInt()-1);
        showLnMsg("\nTipo de figura: Quadrado\nOrigem: (" + quad.getX(quad.getA()) +", " + quad.getY(quad.getA()) +
                ")\nTamanho dos lados: " + quad.setLado(quad.getA(), quad.getB()) +
                "\nÁrea: " + quad.getArea() + "\nPerímetro: " + quad.getPerimetro()+"\n");
    }

}
