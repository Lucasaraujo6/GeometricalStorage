package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.QuadradoCli;
import trabalho_completo.model.Quadrado;

public class QuadradoController extends AbstractCRUDController<Quadrado> {
    
    public QuadradoController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new QuadradoGui();
        //}else {
            tela = new QuadradoCli();
        //}

    }

    
}
