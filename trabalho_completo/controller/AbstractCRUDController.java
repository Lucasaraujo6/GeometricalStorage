package trabalho_completo.controller;

import trabalho_completo.dao.DAO;
import trabalho_completo.model.*;
import trabalho_completo.view.cli.*;
import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.controller.interfaces.ICrudController;
import trabalho_completo.view.interfaces.ICRUDFiguraView;


public abstract class AbstractCRUDController<T> extends AbstractCRUDCli<T> implements ICrudController<T>{
    protected ICRUDFiguraView<T> tela;
    private DAO dao;

    public AbstractCRUDController(DAO dao) {
        this.dao = dao;
    }
    

    @Override
    public OpcoesMenuEnum start(DAO dao, int hash) {

        OpcoesMenuEnum opcao;
        do {
            opcao = askOpcaoMenuFigs();
            if (opcao != OpcoesMenuEnum.FAIL) {
                showMsg("Escolhi: " + opcao + "\n");
            }
            switch (opcao) {
                case NOVO:
                    dao.insertRenderizavel((Renderizaveis) tela.create());
                    tela.askVazio();
                    showMsg("\n");
                    break;
                case EDITAR:
                    if(dao.contem(hash)){
                        tela.update(dao, hash);
                    }
                    tela.askVazio();
                    tela.showMsg("\n");
                    break;
                case LISTAR:
                    dao.listar(hash);
                    tela.askVazio1();
                    tela.showMsg("\n");
                    break;
                case MOSTRAR:
                    if(dao.contem(hash)){
                        dao.listar(hash);
                        tela.read(dao, hash);
                    }
                    tela.askVazio();
                    tela.showMsg("\n");
                    break;
                case EXCLUIR:
                    if(dao.contem(hash)){
                        delete(dao, hash);
                    }                   
                    tela.askVazio1();
                    tela.showMsg("\n");
                    break;
                case VOLTAR:
                    opcao=OpcoesMenuEnum.SAIR;
                    break;
                default:
                    break;
            }


        }while (opcao != OpcoesMenuEnum.SAIR);

        return OpcoesMenuEnum.SAIR;
    }
    @Override
    public T create() {
        // TODO Auto-generated method stub
        return null;
    }


    public void read(DAO dao, int hash) {
    }

    @Override
    public void update(DAO lp, int i) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(DAO lp, int hash){
        dao.listar(hash);
        showLnMsg("Qual a posição a apagar?");
        int j = askInt();
        dao.apagar(j);
    }
}
