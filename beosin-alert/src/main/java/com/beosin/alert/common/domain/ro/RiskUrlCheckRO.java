package com.beosin.alert.common.domain.ro;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiskUrlCheckRO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String url;

    @NotNull
    @JsonProperty("web3_flag")
    private Boolean web3Flag;
}
