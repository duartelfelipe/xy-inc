package br.com.xyinc.xyincpi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "ponto_interesse")
public class PontoInteresse {

    @Id
    @GeneratedValue
    @Column(name = "pi_codigo")
    private Integer id;

    @NotBlank(message = "Informe o nome do ponto de interesse.")
    @Column(name = "pi_nome")
    private String nome;

    @NotNull
    @Min(value = 0, message = "Coordenada X deve ser maior ou igual a zero.")
    @Column(name = "pi_coord_x")
    private Integer coordX;

    @NotNull
    @Min(value = 0, message = "Coordenada Y deve ser maior ou igual a zero.")
    @Column(name = "pi_coord_y")
    private Integer coordY;

    public PontoInteresse() {
        super();
    }

    public PontoInteresse(String nome, Integer coordX, Integer coordY) {
        super();
        this.nome = nome;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCoordX() {
        return coordX;
    }

    public void setCoordX(Integer coordX) {
        this.coordX = coordX;
    }

    public Integer getCoordY() {
        return coordY;
    }

    public void setCoordY(Integer coordY) {
        this.coordY = coordY;
    }

}
