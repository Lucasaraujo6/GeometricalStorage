package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.LosangoCli;
import trabalho_completo.model.Losango;

public class LosangoController extends AbstractCRUDController<Losango> {
    
    public LosangoController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new LosangoGui();
        //}else {
            tela = new LosangoCli();
        //}
    }
    
}