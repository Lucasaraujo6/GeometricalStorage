package trabalho_completo.controller;

import trabalho_completo.dao.DAO;
import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.view.cli.*;
import trabalho_completo.controller.rendsController.*;
import trabalho_completo.view.gui.DesenhoBoard;
import trabalho_completo.view.gui.MenuPrincipalGUI;


/**
 * A classe LucasPaint contém o menu de opções e alguns de seus métodos.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class LucasPaint {
    private MenusViews tela = new MenusViews();
    private DAO dao = new DAO(10);
    private AbstractCRUDController controller;
    MenuPrincipalGUI gui =  new MenuPrincipalGUI(dao,this);
    
    public void mostrarMenu(){

        OpcoesMenuEnum opcao = null;

        do{
            opcao = tela.askOpcaoMenuPrincial();
            if (opcao!=OpcoesMenuEnum.FAIL){
                tela.showMsg("\n========================================\n"+
                "              MENU "+opcao+"\n" +
                  "========================================\n");
            }
            switch (opcao){
                case QUADRADO:
                    controller = new QuadradoController(dao);
                    controller.start(dao,1);
                    break;
                case RETANGULO:
                    controller = new RetanguloController(dao);
                    controller.start(dao,2);
                    break;
                case CIRCULO:
                    controller = new CirculoController(dao);
                    controller.start(dao,3);
                    break;
                case LOSANGO:
                    controller = new LosangoController(dao);
                    controller.start(dao,4);
                    break;
                case TRAPEZIO:
                    controller = new TrapezioController(dao);
                    controller.start(dao,5);
                    break;
                case TRIANGULO:
                    controller = new TrianguloController(dao);
                    controller.start(dao,6);
                    break;
                case PONTO:
                    controller = new PontoController(dao);
                    controller.start(dao,7);
                    break;                
                case RETA:
                    controller = new RetaController(dao);
                    controller.start(dao,8);
                   break;
                case TEXTO:
                    controller = new TextoController(dao);
                    controller.start(dao,9);
                    break;
                case BACKUP:
                    dao.menu();
                    break;    
                case LISTAR:
                    if(dao.getVetor()!=null){
                        dao.listar(dao.getVetor());
                        tela.askVazio();
                    }
                    break;
                case APAGAR:
                    dao.apagar();
                    tela.askVazio();
                break;
                case DESENHAR:
                    new DesenhoBoard(dao.getVetor());
                break;
                case SAIR:
                    System.exit(0);
                break;
                default:
                    break;
            }
        }while (opcao != OpcoesMenuEnum.SAIR);
    }
}
