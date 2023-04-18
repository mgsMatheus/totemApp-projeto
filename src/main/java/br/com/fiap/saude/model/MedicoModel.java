package br.com.fiap.saude.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "T_MEDICO")
public class MedicoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String CRM;
    @Column(nullable = false, length = 80)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String especialidade;
    @OneToMany(mappedBy = "medico")
    private List<ConsultaModel> consultaDisponivel;

    public List<ConsultaModel> getConsultaDisponivel() {
        return consultaDisponivel;
    }

    public void setConsultaDisponivel(List<ConsultaModel> consultaDisponivel) {
        this.consultaDisponivel = consultaDisponivel;
    }
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}

