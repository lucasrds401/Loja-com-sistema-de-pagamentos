package Loja;
import javax.swing.JOptionPane;

public class MenuLoja{
    private String nome, localizacao;
    private Produto[] produtos = new Produto[5];
    private int totalvendido = 0;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
    public Produto[] getProdutos() {
        return produtos;
    }
    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }
    public int getTotalvendido() {
        return totalvendido;
    }
    public void setTotalvendido(int totalvendido) {
        this.totalvendido = totalvendido;
    }

    public void cadastrarProduto(){
        for(int i = 0; i < produtos.length; i++){   
            JOptionPane.showMessageDialog(null, "Cadastro do "+ (i+1) + "° Produto");
            String codigo = JOptionPane.showInputDialog("Digite o código de barras: ");
            String descricao = JOptionPane.showInputDialog("Digite a descricao do produto: ");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do produto: "));
            int estoque = Integer.parseInt(JOptionPane.showInputDialog("Digite o estoque do produto:"));            
            
            produtos[i] = new Produto(codigo, descricao, preco, estoque);
        }
    }

    public void vender(){
        String codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
        Produto p = null;

        for(Produto prod : produtos){
            if(prod.getCodigoBarras().equals(codigo)){
                p = prod;
                break;
            }
        }

        if(p == null){
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        }

        int qntd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de produtos para comprar: "));

        while(qntd > p.getEstoque()){
            qntd = Integer.parseInt(JOptionPane.showInputDialog("Só temos " + p.getEstoque() + " Desse produto, digite um valor válido: "));
        }

        double valorCompra = p.getPreco() * qntd;

        int escolha = Integer.parseInt(JOptionPane.showInputDialog("formas de pagamento: \n[1] PIX \n[2] Crédito \n[3] Débito"));
        Pagamento pagamento = null;

        switch (escolha) {
            case 1:String id = JOptionPane.showInputDialog("Digite o ID do pix para pagamento: ");
                pagamento = new Pix(id, valorCompra);
                break;
            case 2:
                String numCartao = JOptionPane.showInputDialog("Digite o número do cartão de Crédito: ");
                pagamento = new CartaoCredito(numCartao, valorCompra);
                break;
            case 3:
                String numCartaoD = JOptionPane.showInputDialog("Digite o número do cartão de Débito: ");
                pagamento = new CartaoDebito(numCartaoD, valorCompra);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida!");
                return;
        }

        pagamento.processarPagamento();

        p.setEstoque(p.getEstoque() - qntd);

        totalvendido += valorCompra;

    }
        public void relatorio(){
    JOptionPane.showMessageDialog(null, "RELATÓRIO\nLoja: " + nome + "\nLocalização: " + localizacao + "\nTotal vendido: R$" + totalvendido);

    for(int i = 0; i < produtos.length; i++){
        Produto p = produtos[i];

        if(p != null && p.getEstoque() > 0){
            JOptionPane.showMessageDialog(null, "Relatório do " + (i + 1) + "° produto:" + "\nProduto: " + p.getDescricao() + "\nCódigo: " + p.getCodigoBarras() +
                "\nPreço: R$" + p.getPreco() +
                "\nEstoque: " + p.getEstoque()
            );
        }
    }
}

}