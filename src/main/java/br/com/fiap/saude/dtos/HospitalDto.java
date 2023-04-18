package br.com.fiap.saude.dtos;


import br.com.fiap.saude.model.ConsultaModel;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


public class HospitalDto {

    @NotBlank
    private String endereco;
    @NotBlank
    private String nomeHospital;
    @NotBlank
    private String telefone;
    @NotBlank
    private String horarioFuncionamento;

    @OneToMany(mappedBy = "hospital")
    private List<ConsultaModel> consultaDisponivel;



    public HospitalDto(String endereco, String nomeHospital, String telefone, String horarioFuncionamento) {
        this.endereco = endereco;
        this.nomeHospital = nomeHospital;
        this.telefone = telefone;
        this.horarioFuncionamento = horarioFuncionamento;
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
