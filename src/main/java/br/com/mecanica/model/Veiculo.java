package br.com.mecanica.model;

public class Veiculo {


    private int id;
    private int idCliente;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;

    public Veiculo(int id, int idCliente ,String placa, String marca,String modelo, String cor,String ano){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.id = id;
        this.idCliente = idCliente;
    }

    public Veiculo() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {return idCliente;}

    public void setIdCliente(int idCliente) { this.idCliente = idCliente;}

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {this.cor = cor;}

    public String getAno() {return ano;}

    public void setAno(String ano) {this.ano = ano;}

}
