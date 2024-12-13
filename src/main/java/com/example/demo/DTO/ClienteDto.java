package com.example.demo.DTO;

public class ClienteDto {

    private Long cliId;
    private String cliNombre;
    private String cliApellido;
    private String cliCedula;

    public ClienteDto(Long cliId, String cliNombre, String cliApellido, String cliCedula) {
        this.cliId = cliId;
        this.cliNombre = cliNombre;
        this.cliApellido = cliApellido;
        this.cliCedula = cliCedula;
    }

    public Long getCliId() {
        return cliId;
    }

    public void setCliId(Long cliId) {
        this.cliId = cliId;
    }

    public String getCliNombre() {
        return cliNombre;
    }

    public void setCliNombre(String cliNombre) {
        this.cliNombre = cliNombre;
    }

    public String getCliApellido() {
        return cliApellido;
    }

    public void setCliApellido(String cliApellido) {
        this.cliApellido = cliApellido;
    }

    public String getCliCedula() {
        return cliCedula;
    }

    public void setCliCedula(String cliCedula) {
        this.cliCedula = cliCedula;
    }
}
