package com.beosin.alert.common.domain.vo;

import com.beosin.alert.common.enums.RiskUrlDetectionResultEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PluginRiskUrlVO {

    @Builder.Default
    @JsonProperty("detection_result")
    private Integer detectionResult = RiskUrlDetectionResultEnum.SAFE.getValue();

    @Builder.Default
    @JsonProperty("source_name")
    private String sourceName = "";

    @Builder.Default
    @JsonProperty("source_url")
    private String sourceUrl = "";
}
