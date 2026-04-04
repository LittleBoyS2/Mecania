package br.com.mecanica.model;

public class Veiculo {


    private int Id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private String ano;

    public Veiculo(int Id, String placa, String marca,String modelo, String cor,String ano){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.Id = Id;
    }

    public Veiculo() {}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

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
