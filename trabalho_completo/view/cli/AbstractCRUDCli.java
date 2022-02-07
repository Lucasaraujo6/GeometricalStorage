package trabalho_completo.view.cli;

import trabalho_completo.dao.DAO;
import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.view.interfaces.ICRUDFiguraView;
import trabalho_completo.model.Renderizaveis;

public abstract class AbstractCRUDCli<T>
        extends BasicConsole
        implements ICRUDFiguraView<T> {

    public OpcoesMenuEnum askOpcaoMenuFigs(){
        //Loop até entregar uma opção válida
        String opcao;

        
        showMsg("Digite uma opção:\n" +
                "1 - Novo\n" +
                "2 - Editar\n" +
                "3 - Listar\n" +
                "4 - Mostrar\n" +
                "5 - Excluir\n" +
                "X - Voltar\n");

        opcao = in.next();
        
        switch (opcao){
            case "1":
                return OpcoesMenuEnum.NOVO;
            case "2":
                return OpcoesMenuEnum.EDITAR;
            case "3":
                return OpcoesMenuEnum.LISTAR;
            case "4":
                return OpcoesMenuEnum.MOSTRAR;
            case "5":
                return OpcoesMenuEnum.EXCLUIR;
            case "X":
                return OpcoesMenuEnum.VOLTAR;
            default:
                showLnMsg("Opção inválida, digite uma opção válida!\n");
                return OpcoesMenuEnum.FAIL;
            }
    }

    public void delete(DAO lp, int i){
        showLnMsg("Escolha a posição a EXCLUIR: ");
        lp.listar(i);
        showMsg("Digite o número da posição a EXCLUIR: ");
        lp.apagar(askInt());
    }
 
    public void update(DAO lp, int i){
        lp.listar(i);
        showMsg("Posição do vetor a editar: ");
        int posicao = askInt();
        Renderizaveis figura = (Renderizaveis) create();
        lp.setVetor(posicao, figura);
        showMsg("\nFigura editada com sucesso!\n\n");
    }
    public void read(DAO dao, int hash) {
        showLnMsg("Escolha a posição a tratar dentre: ");
        dao.listar(hash);
        showMsg("Digite o número da posição a tratar: ");
        showLnMsg(dao.getVetor(askInt()-1).toString());
    }


}
