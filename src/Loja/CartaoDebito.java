package Loja;

import javax.swing.JOptionPane;

public class CartaoDebito extends Pagamento{
    String numCartaoD;

    public CartaoDebito(String numCartaoD, double valor){
        super(valor);
        this.numCartaoD = numCartaoD;
    }
    public void processarPagamento(){
        JOptionPane.showMessageDialog(null, "O pagamento foi realizado no cartão de débito com número: "+ numCartaoD+ "\nValor: R$" + valor);
    }
}
