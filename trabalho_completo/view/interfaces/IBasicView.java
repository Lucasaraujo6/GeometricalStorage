package trabalho_completo.view.interfaces;

public interface IBasicView {

    public void showLnMsg(String msg);
    public void showMsg(String msg);
    public int askInt(String msg);
    public String askNext(String msg);
    public void askVazio();
    public boolean hasNextInt();
}
