package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.TextoCli;
import trabalho_completo.model.Texto;

public class TextoController extends AbstractCRUDController<Texto> {
    
    public TextoController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new TextoGui();
        //}else {
            tela = new TextoCli();
        //}
    }
    
}