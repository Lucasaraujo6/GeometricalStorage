package trabalho_completo.view.gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;

import trabalho_completo.model.Renderizaveis;


public class ListarGeralGUI extends JFrame {
    private int tamanho;
    private MenuPrincipalGUI madre;
    
    public ListarGeralGUI(Renderizaveis[] vetor, MenuPrincipalGUI madre) {
        this(vetor);
        this.madre = madre;
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(400,100);           

    }
    public ListarGeralGUI(Renderizaveis[] vetor) {
        table(vetor);
    }
    public ListarGeralGUI() {
    }
    public JTable table(Renderizaveis[] vetor){
        JTable table = new JTable();   
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
    
        tamanho = getTamanho(vetor);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object data[] = new Object[4];
        for(int i = 0; i < tamanho+1; i++)
        {
            data[0] = i;
            data[1] = vetor[i].getClass().getSimpleName();
            data[2] = vetor[i].getPerimetro();
            data[3] = vetor[i].getArea();
            model.addRow(data);
        }
        return table;
    }

    private int getTamanho(Renderizaveis[] vetor){
        for (int i = 0; i < 10 ; i++){
            if(vetor[i] == null && vetor.length>0){
                return i-1;
            }
        }return 10;
    }
    @Override
    public void dispose() {
          madre.setVisible(true);
          super.dispose();
    }
}
