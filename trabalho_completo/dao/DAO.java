package trabalho_completo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import trabalho_completo.model.Renderizaveis;
import trabalho_completo.model.enums.OpcoesMenuEnum;
import trabalho_completo.view.cli.MenusViews;

/**
 * A classe DAOCosole é um objeto de acesso aos dados.
 *
 * @author Lucas
 * @version inicial
 *
 */
public class DAO extends MenusViews{
    
    private int quantidade;
    private Renderizaveis[] vetor;
    private Renderizaveis[] backRenderizaveis;
    public File diretorio;
    public DAO(int tamanho){
        vetor = new Renderizaveis[tamanho];
        backRenderizaveis = new Renderizaveis[10];
    }

    public void menu() {

        OpcoesMenuEnum opcao = null;

        do {
            opcao = askOpcaoMenuDAO();
            if (opcao != OpcoesMenuEnum.FAIL) {
                showMsg("Escolhi: " + opcao + "\n");
            }
            switch (opcao) {
                case SALVAR:
                    salvarConsole();
                    break;
                case RECUPERAR:
                    recuperar();
                    break;
                case RESETAR:
                    apagaratual(); 
                    break;
                case VOLTAR:
                    break;
                case APAGAR:
                    resetar();
                case LISTAR:
                    if(backRenderizaveis!=null){
                        listar(backRenderizaveis);
                    }
                    break;       
                default:
                    break;
            }
        } while (opcao != OpcoesMenuEnum.VOLTAR);
    }



    public Renderizaveis[] getVetor(){
        return vetor.clone();
    }
    public Renderizaveis[] getBack(){
        return backRenderizaveis.clone();
    }
    public Renderizaveis[] getVetor(int hash, int aleatoria){
        int j=0;
        Renderizaveis[] temp = new Renderizaveis[contar(hash)];
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && vetor[i].hashCode() == hash) {
                temp[j] = vetor[i];
                j++;
            }
        }
        return temp.clone();
    }

    public Renderizaveis getVetor(int i){
        return vetor.clone()[i];
    }   
    public Renderizaveis getBack(int i){
        if(backRenderizaveis[i]!=null){
            return backRenderizaveis.clone()[i];
        }else return null;
    } 

    public void setVetor(int i,Renderizaveis fig){
        vetor[ i - 1 ]= fig;
    }

    /** VETOR - LISTA todos os rends do vetor
     * 
     * 
     */  
    public void listar(Renderizaveis[] vet){
        this.quantidade = 0;
        for (int i = 0; i < vet.length; i++) {
            if(vet[i]!=null) {
                showLnMsg("Estou em "+i);
                showLnMsg("Posição "+ (i+1) + ":\n----" + vet[i].toString()+"\n");
                quantidade++;
            }
        }
        if (quantidade==0){
            showLnMsg("O sistema não possui nenhum objeto armazenado.");
        }
    }
    public boolean vetorCheio(){
        if(getVetor(vetor.length-1)!= null){
            return true;
        }return false;
    }
    /** VETOR - APAGAR Console
     * 
     * 
     */ 
    public void apagar(){
        listar(vetor);
        if (quantidade>0){
            showLnMsg("Qual a posição a apagar?");
            int i = askInt();
            vetor[i-1]=null;
            showLnMsg("\nFigura apagada com sucesso!");
            reordenar();
            quantidade--;
        }
    }


    /** VETOR - APAGA rend de mesma hash
     * 
     * 
     */ 
    public void apagar(int i){
        
            vetor[i-1]=null;
            showLnMsg("\nFigura apagada com sucesso!");
            reordenar();
            quantidade--;
    }

    /** VETOR - REORNEDA os valores para removel null
     * 
     * 
     */     
    public void reordenar(){
        for (int i=0;i<vetor.length;i++){
            int posicaoLivre = -1;
            if(vetor[i]==null && posicaoLivre == -1){ //encontra a posicao livre
                posicaoLivre=i;
                int j=posicaoLivre + 1;
                while(j <vetor.length){
                    if (vetor[j]!=null){ //encontra o vetor a realocar
                        vetor[posicaoLivre]=vetor[j];
                        vetor[j]=null;
                        j=vetor.length;
                    }
                    j++;
                }
            }
        }
    }

    /** VETOR - INSERE NOVO rend 
     * 
     * 
     */ 
    public boolean insertRenderizavel(Renderizaveis fig){
        //vetor[i] = fig;
        for (int i=0; i < vetor.length;i++){
            if (i==(vetor.length-1) && vetor[i]!=null){
                cheio();
                return true;
            }
            if (vetor[i] == null){
                vetor[i] = fig;
                showLnMsg("\nFigura adicionada com sucesso!\n");
                break;
            }
        }
        return true;
    }
    
    /** VETOR - APAGA TUDO Console
     * 
     */      
    private void apagaratual(){
        if(backRenderizaveis[0]==null){
            int i = askInt("Caso você apague esses dados, não terá backup, pois o mesmo está vazio.\n" +
                    "Como proceder?\n" +
                    "1: Apagar os dados\n" +
                    "2: Cancelar\n" +
                    "3: Salvar backup e limpar dados\n");
            if(i==1){
                setVetor(0);            

                }else if (i==3){
                    salvar();
                    setVetor(0);                
                    showLnMsg("Dados armazenados e apagados com sucesso!!!");
                    }else{
                        showLnMsg("Operação cancelada!\n");
                    }
        }else{
            setVetor(0);        
            showLnMsg("Dados apagados com sucesso!!!\nEstouaqui");
            return;
        }
    }
    
    /** VETOR - RESETA o vetor
     *  qualquer número é a confirmação do reset
     * 
     */     
    public void setVetor(int aletatorio){
        for (int i = 0; i<vetor.length;i++){
            vetor[i] = null;
        }
    }

    /** VETOR - LISTA rends de mesma hash
     * 
     * 
     */ 
    public void listar(int hash){
        if(!contem(hash)){
            showLnMsg("O vetor não possui nenhum objeto do tipo selecionado.");
        }else{
            for (int i = 0; i < vetor.length; i++) {
                if(vetor[i] != null && vetor[i].hashCode() == hash) {
                    showLnMsg("Posição "+ (i+1) + ":\n----" + vetor[i].toString()+"\n");
                }
            }
        }
    }

    /** VETOR - CONTA rends de mesma classe (com sorte)
     * 
     * 
     */ 
    public boolean contem(int hash){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && vetor[i].hashCode() == hash) {
                return true;
            }
        }
        return false;
    }
    public int contar(int hash){
        int qntd=0;
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] != null && vetor[i].hashCode() == hash) {
                qntd++;
            }
        }
        return qntd;
    }

    /** BACKUP - RECUPERA do backup para o vetor
     * 
     * 
     */     
    private void setVetor(Renderizaveis[] fig){
        for (int i = 0; i<vetor.length;i++){
            vetor[i] = fig[i];
        }
    }
    
    /** BACKUP - Reset Console
     * 
     */
    private void resetar(){
        int i = askInt("Você irá deletar o backup atual. Deseja prosseguir?\n" +
                    "1: Sim\n" +
                    "2: Não\n");
        if(i==1){
            try{
                backRenderizaveis = null;
                File arquivo = new File("Renderizaveis.dat");
                arquivo.delete();
                showLnMsg("Backup excluído com sucesso!");
                askVazio();
                showLnMsg("\n");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{showLnMsg("Operação cancelada.\n");
            askVazio();
            showLnMsg("\n");
        }
            
    }
    public void resetar(File diretorio){
        try{
            for (int i = 0;i<backRenderizaveis.length;i++){
                backRenderizaveis[i]=null;
            }
            File arquivo = new File(diretorio+"\\Renderizaveis.dat");
            arquivo.delete();
            diretorio=null;
            showLnMsg("Backup excluído com sucesso!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /** BACKUP - Verifica restrições de salvamento do backup
     * 
     */    
    private void salvarConsole(){
        if(backRenderizaveis[0]==null){
            salvar();
            showLnMsg("Backup salvo com sucesso!!!\n");
        }else {
            int i=0;
            do{
                try{
                    i = askInt("Deseja substituir os dados prévios?\n" +
                        "1: Sim\n" +
                        "2: Não\n");
                    }catch(Exception e){showLnMsg("Escolha 1 para sim e 2 para não");
                        in.nextLine();
                    }
                }while(i!=1 && i!=2);
            if(i==1){
                salvar();
                showLnMsg("Backup salvo com sucesso!!!");
            }else{showLnMsg("Operação cancelada com sucesso!!!");
            }
        }
    }
    
    /** BACKUP - SALVAR 
     * 
     */
    public void salvar(){
        try{
            FileOutputStream arquivo = new FileOutputStream("Renderizaveis.dat");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            for     (int i = 0;i<backRenderizaveis.length;i++){
                backRenderizaveis[i]=getVetor(i);
            }
            out.writeObject(backRenderizaveis);
            out.close();
        }catch(Exception e){
            listar(backRenderizaveis);
            e.getMessage();
        }
    }
    public void salvar(File file){
        try{
            FileOutputStream arquivo = new FileOutputStream(file.getAbsolutePath()+"\\Renderizaveis.dat");
            ObjectOutputStream out = new ObjectOutputStream(arquivo);
            backRenderizaveis=getVetor();
            out.writeObject(backRenderizaveis);
            out.close();
        }catch(Exception e){
            listar(backRenderizaveis);
            e.getMessage();
        }
    }

    /** BACKUP - RECUPERA Console
     * 
     */    
    private void recuperar(){
        if (backRenderizaveis[0]==null){
            showLnMsg("Não há um backup armazenado; impossível recuperar.\n");
            askVazio();
        }else{
            int i = askInt("Você irá substituir os dados atualmente armazenados. Deseja prosseguir?\n" +
                    "1: Sim\n" +
                    "2: Não\n");
            if(i==1){
                try{
                    FileInputStream arquivo = new FileInputStream(this.diretorio+"\\Renderizaveis.dat");
                    ObjectInputStream in = new ObjectInputStream(arquivo);
                    setVetor((Renderizaveis[]) in.readObject());
                    in.close();
                    showLnMsg("Backup recuperado com sucesso!!!");
                    showLnMsg("\n");
                }catch(Exception e){
                    e.printStackTrace();
                    listar(backRenderizaveis);
                }
            }else{
                showMsg("Operação cancelada com sucesso!!!");
            }
        }
    }

    public void recuperar(File diretorio){
        try{
            FileInputStream arquivo = new FileInputStream(diretorio+"\\Renderizaveis.dat");
            ObjectInputStream in = new ObjectInputStream(arquivo);
            setVetor((Renderizaveis[]) in.readObject());
            in.close();
            showLnMsg("Backup recuperado com sucesso!!!");
        }catch(Exception e){
            e.printStackTrace();
            listar(backRenderizaveis);
        }   
    }
    public void setDitetorio(File diretorio){
        this.diretorio = diretorio;
    }
}
