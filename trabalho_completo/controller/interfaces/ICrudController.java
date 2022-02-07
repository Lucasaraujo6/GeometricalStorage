package trabalho_completo.controller.interfaces;

import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.dao.DAO;

public interface ICrudController<T> {

    public OpcoesMenuEnum start(DAO dao, int i);
    public T create(); //removi pois cada figura terá seu próprio criar.
    public void read(DAO dao, int hash);  //removi pois cada figura terá seu próprio ler.
    public void update(DAO dao, int i); //removi pois cada figura terá seu próprio atualizar.
    public void delete(DAO dao, int i);


}
