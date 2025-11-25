package Loja;

import javax.swing.JOptionPane;

public class Pix extends Pagamento{
    String id;
    
    public Pix(String id, double valor){
        super(valor);
        this.id = id;
    }
    @Override
    public void processarPagamento(){
        JOptionPane.showMessageDialog(null, "O pagamento foi realizado por "+ id + "no valor de R$" + valor);

    }
}

