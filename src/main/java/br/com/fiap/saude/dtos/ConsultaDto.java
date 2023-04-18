package br.com.fiap.saude.dtos;
import br.com.fiap.saude.model.HospitalModel;
import br.com.fiap.saude.model.MedicoModel;
import br.com.fiap.saude.model.PacienteModel;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ConsultaDto {
    @NotNull
    private LocalDateTime dataConsulta;

    @NotNull
    private UUID hospitalid;

    @NotNull
    private UUID medicoid;

    @NotNull
    private UUID pacienteid;

    // Adicionando campo hospital e seus getters e setters
    private HospitalModel hospital;
    public void setHospitalid(UUID hospitalid) {
        this.hospitalid = hospitalid;
        this.hospital = new HospitalModel();
        this.hospital.setId(hospitalid);
    }
    public UUID getHospitalid() {
        return hospitalid;
    }
    public void setHospital(HospitalModel hospital) {
        this.hospital = hospital;
        this.hospitalid = hospital.getId();
    }
    public HospitalModel getHospital() {
        return hospital;
    }

    // Adicionando campo medico e seus getters e setters
    private MedicoModel medico;
    public void setMedicoid(UUID medicoid) {
        this.medicoid = medicoid;
        this.medico = new MedicoModel();
        this.medico.setId(medicoid);
    }
    public UUID getMedicoid() {
        return medicoid;
    }
    public void setMedico(MedicoModel medico) {
        this.medico = medico;
        this.medicoid = medico.getId();
    }
    public MedicoModel getMedico() {
        return medico;
    }

    // Adicionando campo paciente e seus getters e setters
    private PacienteModel paciente;
    public void setPacienteid(UUID pacienteid) {
        this.pacienteid = pacienteid;
        this.paciente = new PacienteModel();
        this.paciente.setId(pacienteid);
    }
    public UUID getPacienteid() {
        return pacienteid;
    }
    public void setPaciente(PacienteModel paciente) {
        this.paciente = paciente;
        this.pacienteid = paciente.getId();
    }
    public PacienteModel getPaciente() {
        return paciente;
    }
}