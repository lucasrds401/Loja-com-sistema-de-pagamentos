package Loja;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        MenuLoja x = new MenuLoja();

        x.setNome(JOptionPane.showInputDialog("Digite o nome da Loja: "));
        x.setLocalizacao(JOptionPane.showInputDialog("Digite a localizção da Loja: "));

        int opcao = 0;

        do{
            opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU \n[1] Cadastrar Produto \n[2] vender Produto \n[3] Gerar relatório \n[4] Sair"));
        
        switch (opcao) {
            case 1:
                x.cadastrarProduto();
                break;
            case 2:
                x.vender();
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "oi");
            case 4:
                JOptionPane.showMessageDialog(null, "Saindo do Sistema...");
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida! Digite 1 a 4: ");
        }

        }while(opcao != 4);

    }
}
