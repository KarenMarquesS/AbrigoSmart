package org.example.abrigosmart.dto;

import org.example.abrigosmart.model.EtapaEnum;
import org.example.abrigosmart.model.Relatorio;
import org.example.abrigosmart.model.Usuario;

import java.time.LocalDate;

public class RelatorioDTO {

    private int id_report;
    private EtapaEnum etapa;
    private LocalDate data_relatorio;
    private Usuario gerado_pelo_usuario;


    public RelatorioDTO() {
    }

    public RelatorioDTO(int id_report, EtapaEnum etapa, LocalDate data_relatorio, Usuario gerado_pelo_usuario) {
        this.id_report = id_report;
        this.etapa = etapa;
        this.data_relatorio = data_relatorio;
        this.gerado_pelo_usuario = gerado_pelo_usuario;
    }

    public RelatorioDTO(Relatorio relatorio) {
        this.id_report = relatorio.getId_report();
        this.etapa = relatorio.getEtapa();
        this.data_relatorio = relatorio.getData_relatorio();
        this.gerado_pelo_usuario = relatorio.getGerado_pelo_usuario();
    }

    public int getId_report() {
        return id_report;
    }

    public void setId_report(int id_report) {
        this.id_report = id_report;
    }

    public EtapaEnum getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapaEnum etapa) {
        this.etapa = etapa;
    }

    public LocalDate getData_relatorio() {
        return data_relatorio;
    }

    public void setData_relatorio(LocalDate data_relatorio) {
        this.data_relatorio = data_relatorio;
    }

    public Usuario getGerado_pelo_usuario() {
        return gerado_pelo_usuario;
    }

    public void setGerado_pelo_usuario(Usuario gerado_pelo_usuario) {
        this.gerado_pelo_usuario = gerado_pelo_usuario;
    }
}
