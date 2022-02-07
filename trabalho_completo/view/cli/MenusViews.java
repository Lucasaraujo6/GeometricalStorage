package trabalho_completo.view.cli;

import trabalho_completo.model.enums.OpcoesMenuEnum;

//import com.ibm.j9ddr.vm29.structure.stringTableUTF8Query;
/**
 * A classe PaintViewConsole contém funções de interação com o usuário.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class MenusViews extends BasicConsole{


    public OpcoesMenuEnum askOpcaoMenuPrincial(){
        //Loop até entregar uma opção válida
        String opcao;
        
        showMsg("\n========================================\n"+
                "              MENU PRINCIPAL\n" +
                  "========================================\n"+
                "Digite uma opção: \n" +
                "Interagir com:\n"+
                "1 - Quadrados\n" +
                "2 - Retangulo\n" +
                "3 - Círculo\n" +
                "4 - Losango\n" +
                "5 - Trapezio\n" +
                "6 - Triangulo\n" +
                "7 - Ponto\n" +
                "8 - Reta\n" +
                "9 - Texto\n" +
                "Gestão\n"+
                "B - Banco de dados\n" +
                "A - Apagar Item\n" +
                "L - Listar\n" +
                "D - Desenhar\n" +
                "X - Sair\nOpção: ");

        opcao = in.next();

        switch (opcao){
            case "1":
                return OpcoesMenuEnum.QUADRADO;
            case "2":
                return OpcoesMenuEnum.RETANGULO;
            case "3":
                return OpcoesMenuEnum.CIRCULO;
            case "4":
                return OpcoesMenuEnum.LOSANGO;
            case "5":
                return OpcoesMenuEnum.TRAPEZIO;
            case "6":
                return OpcoesMenuEnum.TRIANGULO; 
            case "7":
                return OpcoesMenuEnum.PONTO;   
             case "8":
                return OpcoesMenuEnum.RETA; 
            case "9":
                return OpcoesMenuEnum.TEXTO;  
            case "B":
                return OpcoesMenuEnum.BACKUP;                 
            case "A":
                return OpcoesMenuEnum.APAGAR;       
            case "L":
                return OpcoesMenuEnum.LISTAR;
            case "D":
                return OpcoesMenuEnum.DESENHAR;
            case "X":
                return OpcoesMenuEnum.SAIR;
            default:
                showLnMsg("Opção inválida, digite uma opção válida!\n");
                return OpcoesMenuEnum.FAIL;
            }
            
    }
   

    public OpcoesMenuEnum askOpcaoMenuDAO(){
        //Loop até entregar uma opção válida
        String opcao;
        
        showMsg("Digite uma opção:\n" +
                "1 - Salvar\n" +
                "2 - Recuperar\n" +
                "3 - Resetar vetor atual\n" +
                "4 - Listar Backup\n" +
                "5 - Limpar Backup\n" +
                "X - Voltar\n");
            
        opcao = in.next();

        switch (opcao){
            case "1":
                return OpcoesMenuEnum.SALVAR;
            case "2":
                return OpcoesMenuEnum.RECUPERAR;
            case "3":
                return OpcoesMenuEnum.RESETAR;
            case "4":
                return OpcoesMenuEnum.LISTAR;
            case "5":
                return OpcoesMenuEnum.APAGAR;
            case "X":
                return OpcoesMenuEnum.VOLTAR;
            default:
            showLnMsg("Opção inválida, digite uma opção válida!\n");
                return OpcoesMenuEnum.FAIL;
            }
    }

}
