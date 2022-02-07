package trabalho_completo.controller.rendsController;

import trabalho_completo.controller.AbstractCRUDController;
import trabalho_completo.dao.DAO;
import trabalho_completo.view.cli.TrianguloCli;
import trabalho_completo.model.Triangulo;

public class TrianguloController extends AbstractCRUDController<Triangulo> {
    
    public TrianguloController(DAO dao) { //, Boolean isGui
        super(dao);
        //if(isGui) {
        //    tela = new TrianguloGui();
        //}else {
            tela = new TrianguloCli();
        //}
    }
    
}