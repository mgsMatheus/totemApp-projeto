package br.com.fiap.saude.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name= "T_MEDICO")
public class MedicoModel implements Serializable {


    private static final long serialVersionUID = 1L;
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

    public MedicoModel() {}
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

//    @Column(nullable = false)
//    private String numeroRegistro;

//    @ManyToOne
//    @JoinColumn(name = "hospital_id")
//    private HospitalModel hospital;

//    @ElementCollection
//    private List<LocalDateTime> horariosDisponiveis;

    // Construtores, getters e setters


//    public String getNumeroRegistro() {
//        return numeroRegistro;
//    }
//
//    public void setNumeroRegistro(String numeroRegistro) {
//        this.numeroRegistro = numeroRegistro;
//    }
//
//    public HospitalModel getHospital() {
//        return hospital;
//    }
//
//    public void setHospital(HospitalModel hospital) {
//        this.hospital = hospital;
//    }
//
//    public List<LocalDateTime> getHorariosDisponiveis() {
//        return horariosDisponiveis;
//    }
//
//    public void setHorariosDisponiveis(List<LocalDateTime> horariosDisponiveis) {
//        this.horariosDisponiveis = horariosDisponiveis;
//    }
}

