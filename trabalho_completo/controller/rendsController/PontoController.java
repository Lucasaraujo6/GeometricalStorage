package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.PontoCli;
import trabalho_completo.model.Ponto;

public class PontoController extends AbstractCRUDController<Ponto> {
    
    public PontoController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new PontoGui();
        //}else {
            tela = new PontoCli();
        //}
    }
    
}