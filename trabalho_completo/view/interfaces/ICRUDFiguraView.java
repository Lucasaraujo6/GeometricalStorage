package trabalho_completo.view.interfaces;

import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.dao.DAO;;

//Interface CRUD
public interface ICRUDFiguraView<T> extends IBasicView{

    public OpcoesMenuEnum askOpcaoMenuFigs();
    public T create();
    public void read(DAO dao, int hash);
    public void update(DAO lp, int i);
    public void delete(DAO dao, int i);
    public void askVazio1();

}
