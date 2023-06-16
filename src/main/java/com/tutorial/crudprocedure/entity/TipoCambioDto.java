
package com.tutorial.crudprocedure.entity;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class TipoCambioDto {
    @JsonProperty(value = "origen")
    private String origen;
    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }
}
