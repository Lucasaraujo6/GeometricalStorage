package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.RetaCli;
import trabalho_completo.model.Reta;

public class RetaController extends AbstractCRUDController<Reta> {
    
    public RetaController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new RetaGui();
        //}else {
            tela = new RetaCli();
        //}
    }
    
}