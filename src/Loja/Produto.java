    package Loja;

    public class Produto {
        private String codigoBarras;
        private String descricao;
        private Double preco;
        private int estoque;

        public Produto(String codigoBarras, String descricao, Double preco, int estoque){
            this.codigoBarras = codigoBarras;
            this.descricao = descricao;
            this.estoque = estoque;
            this.preco = preco;
        }

        public String getCodigoBarras() {
            return codigoBarras;
        }

        public void setCodigoBarras(String codigoBarras) {
            this.codigoBarras = codigoBarras;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public Double getPreco() {
            return preco;
        }

        public void setPreco(Double preco) {
            this.preco = preco;
        }

        public int getEstoque() {
            return estoque;
        }

        public void setEstoque(int estoque) {
            this.estoque = estoque;
        }
        
    }
        