package Loja;

import javax.swing.JOptionPane;

public class CartaoCredito extends Pagamento {
    String numCartao;
    public CartaoCredito(String numcartao, double valor){
        super(valor);
        this.numCartao = numcartao;
    }

    @Override
    public void processarPagamento(){
        JOptionPane.showMessageDialog(null, "O pagamento foi realizado pelo cartão de Crédito de número: "+ numCartao + "\nValor do pagamento: R$" + valor);
    }
}
