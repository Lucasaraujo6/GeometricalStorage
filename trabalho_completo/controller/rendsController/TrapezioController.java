package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.TrapezioCli;
import trabalho_completo.model.Trapezio;

public class TrapezioController extends AbstractCRUDController<Trapezio> {
    
    public TrapezioController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new TrapezioGui();
        //}else {
            tela = new TrapezioCli();
        //}
    }
    
}