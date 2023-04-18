package br.com.fiap.saude.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "T_CONSULTA")
public class ConsultaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private MedicoModel medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @Column(nullable = false)
    private LocalDateTime horario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private HospitalModel hospital;

    // construtores, getters e setters aqui



    public HospitalModel getHospital() {
        return hospital;
    }

    public void setHospital(HospitalModel hospital) {
        this.hospital = hospital;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MedicoModel getMedico() {
        return medico;
    }

    public void setMedico(MedicoModel medico) {
        this.medico = medico;
    }

    public PacienteModel getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

}
