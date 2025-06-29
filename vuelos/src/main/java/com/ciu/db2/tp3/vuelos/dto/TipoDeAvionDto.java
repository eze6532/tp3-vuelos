package com.ciu.db2.tp3.vuelos.dto;

public class TipoDeAvionDto {

    private String nombreTipoDeAvion;
    private int cantMaxDeAsientos;
    private String empresa;

    public TipoDeAvionDto() {
    }

    public TipoDeAvionDto(String nombreTipoDeAvion, int cantMaxDeAsientos, String empresa) {
        this.nombreTipoDeAvion = nombreTipoDeAvion;
        this.cantMaxDeAsientos = cantMaxDeAsientos;
        this.empresa = empresa;
    }

    public String getNombreTipoDeAvion() {
        return nombreTipoDeAvion;
    }

    public void setNombreTipoDeAvion(String nombreTipoDeAvion) {
        this.nombreTipoDeAvion = nombreTipoDeAvion;
    }

    public int getCantMaxDeAsientos() {
        return cantMaxDeAsientos;
    }

    public void setCantMaxDeAsientos(int cantMaxDeAsientos) {
        this.cantMaxDeAsientos = cantMaxDeAsientos;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}
