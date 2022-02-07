package trabalho_completo.view.gui;


import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.*;
import java.awt.*;
import trabalho_completo.dao.DAO;
import javax.swing.table.DefaultTableModel;
import java.io.File;
public class BancoDeDadosGUI
    extends JFrame{     
      
      protected MenuPrincipalGUI madre;
      protected DAO dao;
      protected JFrame frame;

      protected Container c;
      protected JLabel title, title1;
      protected JButton recuperar, resetar, listar, btnlistar, salvar, limpar, voltar;
      protected JTable table;
      protected JPanel cards, cardSalvar, cardRecuperar, cardResetar, cardListar, cardLimpar;
      protected File diretorio;
      protected JTextField textoX1;

      // button commands

      //public MenuCRUDGui(DAO dao, MenuPrincipalGUI madre)
      public BancoDeDadosGUI( DAO dao,MenuPrincipalGUI madre){
            this.madre = madre;
            this.dao = dao;
            diretorio = null;
            c = getContentPane();
            c.setLayout(null);      
            getWidth();
            setBounds(300, 90, 820, 600);
            setLocation(400,100); 
            //setLocationRelativeTo(null);        
            setDefaultCloseOperation(EXIT_ON_CLOSE);        
            setResizable(false);
            setVisible(true);
            
            title = new JLabel("Menu Banco de Dados");            
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(380, 30);
            title.setLocation(280, 25);
            c.add(title);

            salvar = new JButton("Salvar");
            salvar.setFont(new Font("Arial", Font.PLAIN, 15));
            salvar.setSize(150, 40);
            salvar.setLocation(185, 70);
      //  listar.addActionListener(listener);
            c.add(salvar);

            recuperar = new JButton("Recuperar");
            recuperar.setFont(new Font("Arial", Font.PLAIN, 15));
            recuperar.setSize(150, 40);
            recuperar.setLocation(150+185, 70);
      //    recuperar.addActionListener(listener);
           c.add(recuperar);
            
            resetar = new JButton("Limpar vetor atual");
            resetar.setFont(new Font("Arial", Font.PLAIN, 15));
            resetar.setSize(150, 40);
            resetar.setLocation(150*2+185, 70);
      //      resetar.addActionListener(listener);
            c.add(resetar);

            listar = new JButton("Listar backup");
            listar.setFont(new Font("Arial", Font.PLAIN, 15));
            listar.setSize(150, 40);
            listar.setLocation(185, 110);
      //       listar.addActionListener(listener);
            c.add(listar);

            limpar = new JButton("Limpar backup");
            limpar.setFont(new Font("Arial", Font.PLAIN, 15));
            limpar.setSize(150, 40);
            limpar.setLocation(185+150, 110);
           // limpar.addActionListener(listener);
            c.add(limpar);

            voltar = new JButton("Voltar");
            voltar.setFont(new Font("Arial", Font.PLAIN, 15));
            voltar.setSize(150, 40);
            voltar.setLocation(185+300, 110);
            //voltar.setContentAreaFilled(false);
            //voltar.setOpaque(true);
            voltar.setBackground(new Color(255,215,0));
            c.add(voltar); 

            cardRecuperar = new JPanel();
            cardRecuperar.setBackground(new Color(0,2,0));

            cardSalvar = new JPanel();
            cardSalvar.setBackground(new Color(255,215,0));

            cardLimpar = new JPanel();
            cardLimpar.setBackground(new Color(255,0,0));
            
            cardResetar = new JPanel();
            cardResetar.setBackground(new Color(0,255,0));

            cardListar = new JPanel();
            cardListar.setBackground(new Color(0,0,255));
            cardListar.add(table());

            cards = new JPanel(new CardLayout());
            cards.setSize(new DimensionUIResource(getWidth()-200, getHeight()-260));
            cards.setLocation(100,180);
            //cards.setBackground(new Color(0,0,255));

            cards.add(cardRecuperar, "cardRecuperar");
            cards.add(cardSalvar, "cardSalvar");
            cards.add(cardLimpar, "cardLimpar");
            cards.add(cardResetar, "cardResetar");
            cards.add(cardListar, "cardListar");
            c.add(cards);

            ControlActionListenter cal = new ControlActionListenter();
            voltar.addActionListener(cal);
            limpar.addActionListener(cal);
            recuperar.addActionListener(cal);
            salvar.addActionListener(cal);
            resetar.addActionListener(cal);
            listar.addActionListener(cal);

      }
      private class ControlActionListenter implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
               // String cmd = e.getActionCommand();
               JFileChooser fc = new JFileChooser();
               
               fc.setDialogTitle("Escolher diretório");
               fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                  if (e.getSource()==voltar){
                        madre.setVisible(true);
                        dispose();
                  }else if (e.getSource()==limpar){
                        cl.show(cards, "cardLimpar");
                        if(JOptionPane.showConfirmDialog(null, "Deseja apagar o backup atual?")==JOptionPane.YES_OPTION){
                              dao.resetar(dao.diretorio);
                              JOptionPane.showMessageDialog(null, "Backup apagado com sucesso! ", "Reset", JOptionPane.YES_NO_CANCEL_OPTION);
                        }else JOptionPane.showMessageDialog(null, "Operação cancelada com sucesso! ", "Cancelada", JOptionPane.YES_NO_CANCEL_OPTION);
                        resetWindow();
                  }else if (e.getSource()==recuperar){
                        cl.show(cards, "cardRecuperar");
                              if(dao.diretorio == null){
                                    JOptionPane.showMessageDialog(null,  "É necessário ter salvo ter um backup salvo para restaurar.", "Erro", JOptionPane.OK_CANCEL_OPTION);
                              }else{
                                    if(JOptionPane.showConfirmDialog(null, "Deseja substituir o vetor atual com os dados do backup?")==JOptionPane.YES_OPTION){
                                          dao.recuperar(dao.diretorio);                              
                                          JOptionPane.showMessageDialog(null, "Dados restaurados com sucesso! ", "Recuperado", JOptionPane.YES_NO_CANCEL_OPTION);
                                    }else JOptionPane.showMessageDialog(null, "Operação cancelada com sucesso! ", "Cancelada", JOptionPane.YES_NO_CANCEL_OPTION);

                              }
                  }else if (e.getSource()==salvar){
                        cl.show(cards, "cardSalvar");
                        int res = fc.showOpenDialog(null);
                        if(res == JFileChooser.APPROVE_OPTION){
                              diretorio = fc.getSelectedFile();
                              dao.setDitetorio(diretorio);
                              dao.salvar(diretorio);
                              JOptionPane.showMessageDialog(null, "Backup salvo com sucesso! ", "Salvo", JOptionPane.INFORMATION_MESSAGE);// + diretorio.getName());
                              resetWindow();
                        }
                        else{
                              JOptionPane.showMessageDialog(null,  "Voce nao selecionou nenhum diretorio.", "Cancelamento", JOptionPane.OK_CANCEL_OPTION);
                        }
                  }else if (e.getSource()==resetar){
                        cl.show(cards, "cardResetar");
                        if(JOptionPane.showConfirmDialog(null, "Deseja apagar o vetor atual?")==JOptionPane.YES_OPTION){
                              dao.setVetor(0);
                              JOptionPane.showMessageDialog(null, "Dados apagados com sucesso! ", "Limpeza", JOptionPane.YES_NO_CANCEL_OPTION);
                        }else JOptionPane.showMessageDialog(null, "Operação cancelada com sucesso! ", "Cancelada", JOptionPane.YES_NO_CANCEL_OPTION);

                  }else if (e.getSource()==listar){
                        cl.show(cards, "cardListar");
                  }
            }
      }

      protected JTable table(){
            table = new JTable();   
            table.setModel(new DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                    "ID", "Tipo", "Perímetro", "Área"
                }
            ));        
    
            JScrollPane jScrollPane = new JScrollPane();      
    
            jScrollPane.setViewportView(table);
            GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(128, 128, 128)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)
                    )
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(100, Short.MAX_VALUE)
                    )
            );
            pack();
    
            int qntdInterna = getTamanho();
    
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object data[] = new Object[4];
            model.addRow(new String [] {
                "ID", "Tipo", "Perímetro", "Área"
            });
            //tive de somar mais um à quantidade interna, por questões de layout tive de inserir uma linha para título além da original.
            for(int i = 0; i < qntdInterna+1; i++)
            {
               if (dao.getBack(i)!=null){
                    data[0] = i;
                    data[1] = dao.getBack(i).getClass().getSimpleName();
                    data[2] = dao.getBack(i).getPerimetro();
                    data[3] = dao.getBack(i).getArea();
                    model.addRow(data);
                }
            }
            return table;
        
      }
      public int getTamanho(){
            int qntd=0;
            for (int i = 0; i < dao.getBack().length; i++) {
                  if(this.dao.getBack(i) != null) {
                        qntd++;
                  }
            }
            return qntd+1;
      }
      private void resetWindow(){
            dispose();
            new BancoDeDadosGUI(dao, madre);
      }


}