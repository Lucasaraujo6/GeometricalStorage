package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.RetanguloCli;
import trabalho_completo.model.Retangulo;

public class RetanguloController extends AbstractCRUDController<Retangulo> {
    
    public RetanguloController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new RetanguloGui();
        //}else {
            tela = new RetanguloCli();
        //}
    }
    
}
