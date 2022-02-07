package  trabalho_completo.view.gui;

import trabalho_completo.dao.DAO;
import trabalho_completo.model.Quadrado;
import trabalho_completo.model.Ponto;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



//QUADRADOGUI SERÁ EQUIVALENTE AO MEU CARDLAYOUT
public class QuadradoGUI extends MenuCRUDGUI<Quadrado> {
    //private DAO dao;
    //private int hash;
    //private JTable table;
    private JPanel cardListar, cardDesenhar;
    
    public QuadradoGUI( DAO dao, MenuPrincipalGUI madre, int hash){
        super(madre, dao, hash);
        addComponentToPane(frame.getContentPane());
        // frame.setUndecorated(true);
        // frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }
    public void addComponentToPane(Container pane) {
    pane.setLayout(new BorderLayout());
    title.setText("Quadrado");

    JPanel btnsFirstMenu = new JPanel();
    btnsFirstMenu.add(title);
    btnsFirstMenu.add(criar);
    btnsFirstMenu.add(listar);
    btnsFirstMenu.add(desenhar);
    //btnsFirstMenu.add(detalhar);
    btnsFirstMenu.add(apagar);
    //btnsFirstMenu.add(editar);
    btnsFirstMenu.add(voltar);
    btnsFirstMenu.setBackground(new Color(0,0,255));
    
    JPanel cardCriar = new JPanel();
    if(dao.vetorCheio()){
       textoInsert.setText("Vetor cheio, impossível adicionar nova figura!");
       cardCriar.add(textoInsert);
    }else{
        cardCriar.add(textoInsert);
        cardCriar.add(textoX1);
        cardCriar.add(textoY1);
        cardCriar.add(tamanho);
        cardCriar.add(btnInsert = new JButton("Inserir Fig"));
    }

    cardListar = new JPanel();
    cardListar.add(table());

    cardDesenhar = new JPanel();
    cardDesenhar.add(btnDesenhar);

    JPanel cardApagar = new JPanel();
    cardApagar.setLayout(new FlowLayout());
    cardApagar.add(idApagarLabel, BorderLayout.BEFORE_FIRST_LINE);
    cardApagar.add(idApagarField, BorderLayout.CENTER);
    cardApagar.add(btnApagar, BorderLayout.SOUTH);
    
    JPanel cardVazio = new JPanel();
    
    //Create the panel that contains the "cards".
    cards = new JPanel(new CardLayout());
    cards.add(cardVazio, cardText);
    cards.add(cardCriar, cardCriarText);
    cards.add(cardListar, cardListarText);
    cards.add(cardApagar, cardApagarText);
    cards.add(cardDesenhar, cardDesenharText);
    cards.setLocation(600,600);  
    pane.add(btnsFirstMenu,BorderLayout.BEFORE_FIRST_LINE);
    pane.add(cards, BorderLayout.CENTER);
    //OPÇÃO DO BOTÃO VOLTAR EM BAIXO
    //pane.add(voltar, BorderLayout.SOUTH);

    ControlActionListenter cal = new ControlActionListenter();
    criar.addActionListener(cal);
    listar.addActionListener(cal);
    desenhar.addActionListener(cal);
    detalhar.addActionListener(cal);
    apagar.addActionListener(cal);
    editar.addActionListener(cal);
    voltar.addActionListener(cal);
    btnInsert.addActionListener(cal);
    btnApagar.addActionListener(cal);
    btnDesenhar.addActionListener(cal);
    }
    
    private class ControlActionListenter implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (cards.getLayout());
            String cmd = e.getActionCommand();
           
            if (cmd.equals(CREATE)) {
                cl.show(cards, "Card 1");
            }else if (e.getSource()==btnInsert){
                    Ponto origem = new Ponto( Integer.parseInt(textoX1.getText()), Integer.parseInt(textoY1.getText()));
                    Quadrado quad = new Quadrado(origem, Integer.parseInt(tamanho.getText()));
                    dao.insertRenderizavel(quad);
                    textoX1.setText("");
                    textoY1.setText("");
                    tamanho.setText("");
                    resetWindow();
                }
            
                else if (cmd.equals(LIST)) {
                cl.show(cards, "Card 2");
            } 
            
            else if (cmd.equals(EDIT)) {
                cl.show(cards, "Card 5"); 
            }
            
            else if (cmd.equals(SHOW)) {            
                cl.show(cards, "Card 4");            
            } 
            
            else if (cmd.equals(DRAW)) {            
                cl.show(cards, "Card 3");            
            } else if (e.getSource()==btnDesenhar){
                new DesenhoBoard(dao.getVetor(hash, 123));
                
        } 
            
            else if (cmd.equals(DELETE)) {            
                cl.show(cards, "Card 6");            
                } else if (e.getSource()==btnApagar){
                    int pos = Integer.parseInt(idApagarField.getText());
                    if (dao.getVetor(pos).hashCode() == hash){
                        dao.apagar(pos+1);
                        idApagarField.setText("");
                        resetWindow();
                    }
            } 
            
            else if (cmd.equals(VOLTAR)) { 
                frame.dispose();
                madre.setVisible(true);
              //  madre.setVisible(true);       
           //     cl.show(cards, "Card 7");
            }
            
        }
    }
    private void resetWindow(){
        //table();
        frame.dispose();
        new QuadradoGUI(dao, madre,hash);
  }


}
