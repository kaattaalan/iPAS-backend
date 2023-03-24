package com.ingg.ipas.payload.request;

import javax.validation.constraints.NotBlank;

public class PassRequest extends CommonRequest {

    @NotBlank
    private String passName;

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }
}
