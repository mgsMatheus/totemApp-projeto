package br.com.fiap.saude.dtos;

import jakarta.validation.constraints.NotBlank;

public class MedicoDto {

    @NotBlank
    private String CRM;
    @NotBlank
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    private String especialidade;

    public MedicoDto(String CRM, String nome, String telefone, String especialidade) {
        this.CRM = CRM;
        this.nome = nome;
        this.telefone = telefone;
        this.especialidade = especialidade;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }


    //    @NotBlank
//    private String numeroRegistro;
//    @NotBlank
//    private HospitalModel hospital;
//    @NotBlank
//    @Future
//    private List<LocalDateTime> horariosDisponiveis;

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
