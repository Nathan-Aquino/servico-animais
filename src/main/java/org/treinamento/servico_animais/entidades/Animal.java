package org.treinamento.servico_animais.entidades;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Integer id;

    // coluna para definir se o animal é cachorro ou gato etc.
    @Column(nullable=false)
    private String tipoAnimal;

    @Column(nullable=false)
    private String nomeProvisorio;

    @Column(nullable=false)
    private Integer idadeEstimada;

    @Column(nullable=false)
    private String raca;

    @Column(nullable=false)
    private Date dataEntrada;

    @Column
    private Date dataAdocao;

    @Column(nullable=false)
    private String condicaoChegada;

    @Column(nullable=false)
    private String nomeRecebedor;

    @Column
    private Date dataObito;

    @Column(nullable=false)
    private String porte;

    public Integer getId () {
        return id;
    }

    public String getNomeProvisorio() {
        return nomeProvisorio;
    }

    public void setNomeProvisorio(String nomeProvisorio) {
        this.nomeProvisorio = nomeProvisorio;
    }

    public Integer getIdadeEstimada() {
        return idadeEstimada;
    }

    public void setIdadeEstimada(Integer idadeEstimada) {
        this.idadeEstimada = idadeEstimada;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataAdocao() {
        return dataAdocao;
    }

    public void setDataAdocao(Date dataAdocao) {
        this.dataAdocao = dataAdocao;
    }

    public String getCondicaoChegada() {
        return condicaoChegada;
    }

    public void setCondicaoChegada(String condicaoChegada) {
        this.condicaoChegada = condicaoChegada;
    }

    public String getNomeRecebedor() {
        return nomeRecebedor;
    }

    public void setNomeRecebedor(String nomeRecebedor) {
        this.nomeRecebedor = nomeRecebedor;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    
}
