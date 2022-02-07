package trabalho_completo.view.gui;

import javax.swing.*;

import trabalho_completo.model.Circulo;
import trabalho_completo.model.Losango;
import trabalho_completo.model.Ponto;
import trabalho_completo.model.Quadrado;
import trabalho_completo.model.Renderizaveis;
import trabalho_completo.model.Reta;
import trabalho_completo.model.Retangulo;
import trabalho_completo.model.Texto;
import trabalho_completo.model.Trapezio;
import trabalho_completo.model.Triangulo;

import java.awt.*;

public class DesenhoBoard extends JFrame {
    private Reta reta = new Reta();
    private Quadrado quad = new Quadrado();
    private Retangulo retang = new Retangulo();
    private Circulo circ = new Circulo();
    private Losango losang = new Losango();
    private Trapezio trap = new Trapezio();
    private Triangulo triang = new Triangulo();
    private Texto text = new Texto();
    private Ponto ponto1 = new Ponto();
    private Ponto ponto2 = new Ponto();
    private Ponto ponto3 = new Ponto();
    private Ponto ponto4 = new Ponto();
    private Renderizaveis[] vetor = new Renderizaveis[10];
    private MenuPrincipalGUI madre;

    public DesenhoBoard(Renderizaveis[] lp, MenuPrincipalGUI madre) {
        setSize(1400,900);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Achou que eu estava brincando!?");
        vetor = lp;
        this.madre = madre;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public DesenhoBoard(Renderizaveis[] lp) {
        setSize(1400,900);
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("Achou que eu estava brincando!?");
        vetor = lp;
    }
    public void paint(Graphics g){
        for (int i=0;i<vetor.length;i++){
            
            if(vetor[i]!=null && vetor[i].hashCode()==8){
                reta = (Reta)vetor[i];
                ponto1 = reta.getA();
                ponto2 = reta.getB();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==1){
                quad = (Quadrado)vetor[i];
                ponto1 = quad.getA();
                ponto2 = quad.getB();
                ponto3 = quad.getC();
                ponto4 = quad.getD();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
                g.drawLine(ponto2.getX(), ponto2.getY(), ponto3.getX(), ponto3.getY());
                g.drawLine(ponto3.getX(), ponto3.getY(), ponto4.getX(), ponto4.getY());
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto4.getX(), ponto4.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==2){
                retang = (Retangulo)vetor[i];
                ponto1 = retang.getA();
                ponto2 = retang.getB();
                ponto3 = retang.getC();
                ponto4 = retang.getD();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
                g.drawLine(ponto2.getX(), ponto2.getY(), ponto3.getX(), ponto3.getY());
                g.drawLine(ponto3.getX(), ponto3.getY(), ponto4.getX(), ponto4.getY());
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto4.getX(), ponto4.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==3){
                circ = (Circulo)vetor[i];
                ponto1 = circ.getOrigem();
                int altura = (int) circ.getDiametro();
                g.drawOval(ponto1.getX(), ponto1.getY(), altura, altura);
                
            }
            if(vetor[i]!=null && vetor[i].hashCode()==4){
                losang = (Losango)vetor[i];
                ponto1 = losang.getA();
                ponto2 = losang.getB();
                ponto3 = losang.getC();
                ponto4 = losang.getD();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
                g.drawLine(ponto2.getX(), ponto2.getY(), ponto3.getX(), ponto3.getY());
                g.drawLine(ponto3.getX(), ponto3.getY(), ponto4.getX(), ponto4.getY());
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto4.getX(), ponto4.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==5){
                trap = (Trapezio)vetor[i];
                ponto1 = trap.getA();
                ponto2 = trap.getB();
                ponto3 = trap.getC();
                ponto4 = trap.getD();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
                g.drawLine(ponto2.getX(), ponto2.getY(), ponto3.getX(), ponto3.getY());
                g.drawLine(ponto3.getX(), ponto3.getY(), ponto4.getX(), ponto4.getY());
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto4.getX(), ponto4.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==6){
                triang = (Triangulo)vetor[i];
                ponto1 = triang.getA();
                ponto2 = triang.getB();
                ponto3 = triang.getC();
                g.drawLine(ponto1.getX(), ponto1.getY(), ponto2.getX(), ponto2.getY());
                g.drawLine(ponto2.getX(), ponto2.getY(), ponto3.getX(), ponto3.getY());
                g.drawLine(ponto3.getX(), ponto3.getY(), ponto1.getX(), ponto1.getY());
            }
            if(vetor[i]!=null && vetor[i].hashCode()==7){
                ponto1 = (Ponto)vetor[i];
                g.fillOval(ponto1.getX(), ponto1.getY(), 10, 10);
            }
            if(vetor[i]!=null && vetor[i].hashCode()==9){
                text = (Texto)vetor[i];
                Ponto origem = text.getA();            
                g.drawString(text.getTexto(), origem.getX(), origem.getY());
            }
        }
    }
    @Override
    public void dispose() {
        madre.setVisible(true);
        super.dispose();
    }

}


