package br.com.fiap.saude.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_HOSPITAL")
public class HospitalModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false, unique = true, length = 80)
    private String nomeHospital;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String horarioFuncionamento;

    @OneToMany(mappedBy = "hospital")
    private List<ConsultaModel> consultaDisponivel;

    public HospitalModel() {}

    public HospitalModel(UUID id, String endereco, String nomeHospital, String telefone, String horarioFuncionamento, List<ConsultaModel> consultaDisponivel) {
        this.id = id;
        this.endereco = endereco;
        this.nomeHospital = nomeHospital;
        this.telefone = telefone;
        this.horarioFuncionamento = horarioFuncionamento;
        this.consultaDisponivel = consultaDisponivel;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeHospital() {
        return nomeHospital;
    }

    public void setNomeHospital(String nomeHospital) {
        this.nomeHospital = nomeHospital;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }
}

