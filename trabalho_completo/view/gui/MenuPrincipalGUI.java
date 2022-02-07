package trabalho_completo.view.gui;
// Java program to implement
// a Simple Registration Form
// using Java Swing
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import trabalho_completo.controller.LucasPaint;
import trabalho_completo.dao.DAO;
 
public class MenuPrincipalGUI
    extends JFrame{ 
    // Components of the Form
    
    private Container c;
    private JLabel title;
    private JLabel title1;
    private JLabel title2;
    private JButton quadrado;
    private JButton losango;
    private JButton triangulo;
    private JButton texto;
    private JButton retangulo;
    private JButton trapezio;
    private JButton circulo;
    private JButton ponto;
    private JButton reta;
    private JButton backup;
    private JButton listar;
    //private JButton apagar;
    private JButton desenhar;
    

    // constructor, to initialize the components
    // with default values.
    public MenuPrincipalGUI(DAO dao, LucasPaint lp)
    {

        ButtonListener listener = new ButtonListener(dao);
        setTitle("Menu Principal");
        setBounds(300, 90, 820, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(400,100);           
        setResizable(false);
    

 
        c = getContentPane();
        c.setLayout(null);
 
        title = new JLabel("Interagir com");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        ponto = new JButton("Ponto");
        ponto.setFont(new Font("Arial", Font.PLAIN, 15));
        ponto.setSize(100, 20);
        ponto.setLocation(100, 100);
        ponto.addActionListener(listener);
        c.add(ponto);

        reta = new JButton("Reta");
        reta.setFont(new Font("Arial", Font.PLAIN, 15));
        reta.setSize(100, 20);
        reta.setLocation(200, 100);
        reta.addActionListener(listener);
        c.add(reta);

        triangulo = new JButton("Triângulo");
        triangulo.setFont(new Font("Arial", Font.PLAIN, 15));
        triangulo.setSize(100, 20);
        triangulo.setLocation(300, 100);
        triangulo.addActionListener(listener);
        c.add(triangulo);

        circulo = new JButton("Círculo");
        circulo.setFont(new Font("Arial", Font.PLAIN, 15));
        circulo.setSize(100, 20);
        circulo.setLocation(400, 100);
        circulo.addActionListener(listener);
        c.add(circulo);

        quadrado = new JButton("Quadrado");
        quadrado.setFont(new Font("Arial", Font.PLAIN, 15));
        quadrado.setSize(100, 20);
        quadrado.setLocation(500, 100);
        quadrado.addActionListener(listener);
        c.add(quadrado);

        retangulo= new JButton("Retângulo");
        retangulo.setFont(new Font("Arial", Font.PLAIN, 15));
        retangulo.setSize(100, 20);
        retangulo.setLocation(600, 100);
        retangulo.addActionListener(listener);
        c.add(retangulo);

        texto= new JButton("Texto");
        texto.setFont(new Font("Arial", Font.PLAIN, 15));
        texto.setSize(100, 20);
        texto.setLocation(250, 120);
        texto.addActionListener(listener);
        c.add(texto);

        trapezio= new JButton("Trapézio");
        trapezio.setFont(new Font("Arial", Font.PLAIN, 15));
        trapezio.setSize(100, 20);
        trapezio.setLocation(350, 120);
        trapezio.addActionListener(listener);
        c.add(trapezio);

        losango= new JButton("Losango");
        losango.setFont(new Font("Arial", Font.PLAIN, 15));
        losango.setSize(100, 20);
        losango.setLocation(450, 120);
        losango.addActionListener(listener);
        c.add(losango);

        title1 = new JLabel("Gerir");
        title1.setFont(new Font("Arial", Font.PLAIN, 30));
        title1.setSize(300, 30);
        title1.setLocation(360, 200);
        c.add(title1);

        backup = new JButton("Banco de dados");
        backup.setFont(new Font("Arial", Font.PLAIN, 15));
        backup.setSize(150, 20);
        backup.setLocation((400-150), 270);
        backup.addActionListener(listener);
        c.add(backup);

        // apagar = new JButton("Apagar");
        // apagar.setFont(new Font("Arial", Font.PLAIN, 15));
        // apagar.setSize(150, 20);
        // apagar.setLocation((400-75), 270);
        // apagar.addActionListener(listener);
        // c.add(apagar);

        listar = new JButton("Listar");
        listar.setFont(new Font("Arial", Font.PLAIN, 15));
        listar.setSize(150, 20);
        listar.setLocation((400), 270);
        listar.addActionListener(listener);
        c.add(listar);

        title2 = new JLabel("Desenhar");
        title2.setFont(new Font("Arial", Font.PLAIN, 30));
        title2.setSize(300, 30);
        title2.setLocation(330, 340);
        c.add(title2);

        desenhar = new JButton("Desenhar");
        desenhar.setFont(new Font("Arial", Font.PLAIN, 15));
        desenhar.setSize(150, 20);
        desenhar.setLocation(325, 400);
        desenhar.addActionListener(listener);
        c.add(desenhar);
  
 
        setVisible(true);
    }
 
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    protected class ButtonListener implements ActionListener{
        private DAO dao;
        public ButtonListener(DAO dao){
            this.dao = dao;
        }
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == quadrado) {
                setVisible(false);
                //QuadradoGUI roda = new QuadradoGUI(dao,MenuPrincipalGUI.this);
                
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new QuadradoGUI( dao, MenuPrincipalGUI.this, 1);
                    }
                });
            } else if (e.getSource() == listar) {
                setVisible(false);
                //QuadradoGUI roda = new QuadradoGUI(dao,MenuPrincipalGUI.this);
                
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new ListarGeralGUI(dao.getVetor(), MenuPrincipalGUI.this);
                    }
                });
            }else if (e.getSource() == desenhar) {
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new DesenhoBoard(dao.getVetor(), MenuPrincipalGUI.this);
                    }
                });
            }
            else if (e.getSource() == backup) {
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new BancoDeDadosGUI(dao, MenuPrincipalGUI.this);
                    }
                });
            }
        }
    }
}