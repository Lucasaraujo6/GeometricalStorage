package trabalho_completo.view.cli;

import trabalho_completo.dao.*;
import trabalho_completo.model.Ponto;
import trabalho_completo.model.Texto;

/**
 * A classe QuadradoCosole atribui os parâmetros de entrada de um novo objeto
 * quadrado.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class TextoCli extends AbstractCRUDCli<Texto> {

     public Texto create() {
        showMsg("Digite dois inteiros para a origem do texto:\n");
        int x = in.nextInt();
        int y = in.nextInt();
        Ponto origem = new Ponto(x, y);
        String texto = askNext("Digite o texto a inserir na coordenada: \n");

        Texto text = new Texto(origem, texto);
        return text;
    }

    public void update(DAO lp){
        showMsg("Posição do texto a editar: ");
        int posicao = askInt();
        Texto figura = (Texto) lp.getVetor(posicao);
        showMsg("Informação a editar:\n1: Origem\n2: Texto\n");
        int opcao = askInt();
        Ponto origem;
        String text;
        if (opcao == 1){
            showMsg("Digite dois inteiros para a origem do quadrado:\n");
            int x = in.nextInt();
            int y = in.nextInt();
            origem = new Ponto(x, y);
            text = figura.getTexto();
        } else if (opcao == 2){
            origem = figura.getA();
            text = askNext("Digite um novo texto a armazenar:\n");
        }else{showMsg("Opção inválida. Tente editar novamente.\n");
        return;
        }
        Texto texto = new Texto(origem, text);
        lp.setVetor(posicao, texto);
        showMsg("\nVetor editada com sucesso!\n\n");
    }

    public void read(DAO lp){
        showLnMsg("Escolha a posição a MOSTRAR DETALHADAMENTE dentre os índices seguintes: ");
        lp.listar(9);
        Texto text = (Texto) lp.getVetor(askInt());
        showLnMsg("\nTipo de conteúdo: Texto\nOrigem: (" + text.getX(text.getA()) +", " + text.getY(text.getA()) +
                ")\nConteúdo literal: " + text.getTexto()+"\n");
    }

    public void delete(DAO lp, int i){
        showLnMsg("Escolha a posição a EXCLUIR dentre os índices seguintes: ");
        lp.listar(i);
        showMsg("Digite o número da posição a EXCLUIR: ");
        lp.apagar(askInt());
    }
}
