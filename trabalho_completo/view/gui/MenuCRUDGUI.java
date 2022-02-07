package trabalho_completo.view.gui;


import javax.swing.*;
import java.awt.*;
import trabalho_completo.dao.DAO;
import javax.swing.table.DefaultTableModel;

public class MenuCRUDGUI<T>
    extends JFrame{     
      
      protected MenuPrincipalGUI madre;
      protected DAO dao;
      protected JFrame frame;
      protected int hash;

      protected Container c;
      protected JLabel title;
      protected JButton detalhar;
      protected JButton editar;
      protected JButton apagar, btnApagar;
      protected JButton criar;
      protected JButton listar;
      protected JButton desenhar;   
      protected JButton voltar;
      protected int layout;
      protected JTable table;

      final String cardText = "Card 0";
      final String cardCriarText = "Card 1";
      final String cardListarText = "Card 2";
      final String cardApagarText = "Card 6";
      final String card4Text = "Card 4";
      final String card5Text = "Card 5";
      final String cardDesenharText = "Card 3";
      final String card7Text = "Card 7";
      protected JPanel cards;
      protected JLabel textoInsert, idApagarLabel;
      protected JButton btnInsert, btnDesenhar;
      protected JTextField textoX1, textoY1, textoX2, textoY2, textoX3, textoY3, textoX4, textoY4, tamanho, idApagarField;

      // button commands
      protected final String CREATE = "CREATE";
      protected final String LIST = "LIST";
      protected final String DELETE = "DELETE";
      protected final String EDIT = "EDIT";
      protected final String SHOW = "SHOW";
      protected final String DRAW = "DRAW";
      protected final String MENU = "MENU";
      protected final String VOLTAR = "VOLTAR";

      //public MenuCRUDGui(DAO dao, MenuPrincipalGUI madre)
      public MenuCRUDGUI()
      {}
      public MenuCRUDGUI(MenuPrincipalGUI madre, DAO dao, int hash)
      {
            this.madre = madre;
            this.dao = dao;
            this.hash = hash;
            frame = new MenuCRUDGUI<T>();
      //     c = getContentPane();
      //      c.setLayout(null);
            setLocationRelativeTo(null);            
            
            frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);


            frame.setLocation(440,150);        
            frame.setSize(740,600);
            frame.setVisible(true);


            title = new JLabel("Menu ");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(300, 30);
            title.setLocation(350, 30);
      //        c.add(title);

            criar = new JButton("Criar");
            criar.setFont(new Font("Arial", Font.PLAIN, 15));
            criar.setSize(100, 20);
            criar.setLocation(100, 100);
            criar.setActionCommand(CREATE);
      //        c.add(criar);

            listar = new JButton("Listar");
            listar.setFont(new Font("Arial", Font.PLAIN, 15));
            listar.setSize(100, 20);
            listar.setLocation(200, 100);
            listar.setActionCommand(LIST);
      //  listar.addActionListener(listener);
      //        c.add(listar);

            detalhar = new JButton("Detalhar");
            detalhar.setFont(new Font("Arial", Font.PLAIN, 15));
            detalhar.setSize(100, 20);
            detalhar.setLocation(300, 100);
            detalhar.setActionCommand(SHOW);
      //    detalhar.addActionListener(listener);
      //     c.add(detalhar);
            
            editar = new JButton("Editar");
            editar.setFont(new Font("Arial", Font.PLAIN, 15));
            editar.setSize(100, 20);
            editar.setLocation(400, 100);
            editar.setActionCommand(EDIT);
      //      editar.addActionListener(listener);
      //      c.add(editar);

            apagar = new JButton("Apagar");
            apagar.setFont(new Font("Arial", Font.PLAIN, 15));
            apagar.setSize(100, 20);
            apagar.setLocation(500, 100);
            apagar.setActionCommand(DELETE);
            btnApagar = new JButton("Apagar");
            btnApagar.setFont(new Font("Arial", Font.PLAIN, 15));
            btnApagar.setSize(100, 20);
            btnApagar.setLocation(100, 200);
            idApagarLabel = new JLabel("Insira, a seguir, o ID da figura a apagar:");
            idApagarLabel.setFont(new Font("Arial", Font.PLAIN, 20));
            idApagarLabel.setSize(100, 20);
            idApagarLabel.setLocation(100, 100);
            idApagarField = new JTextField(6);
            idApagarField.setLocation(400, 300);
            
      //       apagar.addActionListener(listener);
      //       c.add(apagar);

            desenhar = new JButton("Desenhar");
            desenhar.setFont(new Font("Arial", Font.PLAIN, 15));
            desenhar.setSize(100, 20);
            desenhar.setLocation(600, 100);
            desenhar.setActionCommand(DRAW);
            btnDesenhar = new JButton("Desenhar todos");
            btnDesenhar.setFont(new Font("Arial", Font.PLAIN, 30));
            btnDesenhar.setSize(400, 80);
            btnDesenhar.setLocation(600, 100);
      //      desenhar.addActionListener(listener);
      //      c.add(desenhar);

            voltar = new JButton("Voltar");
            voltar.setFont(new Font("Arial", Font.PLAIN, 15));
            voltar.setSize(100, 20);
            voltar.setLocation(700, 100);
            //voltar.setContentAreaFilled(false);
            //voltar.setOpaque(true);
            voltar.setBackground(new Color(255,215,0));
            voltar.setActionCommand(VOLTAR);

            textoInsert = new JLabel("Insira a seguir, respectivamente, as coordenadas da origem e o tamanho:");
            textoInsert.setFont(new Font("Arial", Font.PLAIN, 20));
            textoInsert.setSize(100, 20);
            textoInsert.setLocation(900, 900);
            textoX1 = new JTextField(6);
            textoY1 = new JTextField(6);
            textoX2 = new JTextField(6);
            textoY2 = new JTextField(6);
            textoX3 = new JTextField(6);
            textoY3 = new JTextField(6);
            textoX4 = new JTextField(6);
            textoY4 = new JTextField(6);
            tamanho = new JTextField(7);
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
                    .addGap(32, 32, 32)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)
                    )
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)
                    )
            );
            pack();
    
            int qntdInterna = getTamanho(hash);
    
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            Object data[] = new Object[4];
            model.addRow(new String [] {
                "ID", "Tipo", "Perímetro", "Área"
            });
            //tive de somar mais um à quantidade interna, por questões de layout tive de inserir uma linha para título além da original.
            for(int i = 0; i < qntdInterna+1; i++)
            {
               if (dao.getVetor(i)!=null && dao.getVetor(i).hashCode()==hash){
                    data[0] = i;
                    data[1] = dao.getVetor(i).getClass().getSimpleName();
                    data[2] = dao.getVetor(i).getPerimetro();
                    data[3] = dao.getVetor(i).getArea();
                    model.addRow(data);
                }
            }
            return table;
        
      }
      public int getTamanho(int hash){
            int qntd=0;
            for (int i = 0; i < dao.getVetor().length; i++) {
                  if(this.dao.getVetor(i) != null && this.dao.getVetor(i).hashCode() == hash) {
                        qntd++;
                  }
            }
            return qntd+1;
      }


}