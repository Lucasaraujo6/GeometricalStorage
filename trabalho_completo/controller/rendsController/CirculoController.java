package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.CirculoCli;
import trabalho_completo.model.Circulo;

public class CirculoController extends AbstractCRUDController<Circulo> {
    
    public CirculoController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new circuloGui();
        //}else {
            tela = new CirculoCli();
        //}
    }
}
