package model;

public class Produto {

    private int codigoProduto;
    private String nomeProduto;
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Produto() {

    }

    public Produto(int codigoProduto, String nomeProduto, Marca marca) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.marca = marca;
    }

    

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

}