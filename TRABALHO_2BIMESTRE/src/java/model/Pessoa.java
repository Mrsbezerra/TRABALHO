package model;

public class Pessoa {

    private int codigoPessoa;
    private String nomePessoa;
    private String cpfPessoa;
    private String senhaPessoa;

    public Pessoa() {

    }

    public Pessoa(int codigoPessoa, String nomePessoa, String cpfPessoa, String senhaPessoa) {
        this.codigoPessoa = codigoPessoa;
        this.nomePessoa = nomePessoa;
        this.cpfPessoa = cpfPessoa;
        this.senhaPessoa = senhaPessoa;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpfPessoa() {
        return cpfPessoa;
    }

    public void setCpfPessoa(String cpfPessoa) {
        this.cpfPessoa = cpfPessoa;
    }

    public String getSenhaPessoa() {
        return senhaPessoa;
    }

    public void setSenhaPessoa(String senhaPessoa) {
        this.senhaPessoa = senhaPessoa;
    }
}