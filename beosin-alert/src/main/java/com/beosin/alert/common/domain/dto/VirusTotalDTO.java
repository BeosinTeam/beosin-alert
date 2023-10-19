package com.beosin.alert.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * virustotal dto
 *
 * @author shangye
 * @date 2022/04/24
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VirusTotalDTO {

    /**
     * data
     */
    @JsonProperty("data")
    private DataDto data;


    /**
     * DataDto
     */
    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DataDto {
        /**
         * attributes
         */
        @JsonProperty("attributes")
        private AttributesDto attributes;


        /**
         * AttributesDto
         */
        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AttributesDto {


            /**
             * lastAnalysisStats
             */
            @JsonProperty("last_analysis_stats")
            private LastAnalysisStatsDto lastAnalysisStats;

            @JsonProperty("last_analysis_results")
            private Map<String, AnalysisResultsDto> lastAnalysisResultsDto;


            /**
             * LastAnalysisStatsDto
             */
            @Data
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class LastAnalysisStatsDto {
                /**
                 * harmless
                 */
                @JsonProperty("harmless")
                private Integer harmless;
                /**
                 * malicious
                 */
                @JsonProperty("malicious")
                private Integer malicious;
                /**
                 * suspicious
                 */
                @JsonProperty("suspicious")
                private Integer suspicious;
                /**
                 * undetected
                 */
                @JsonProperty("undetected")
                private Integer undetected;
                /**
                 * timeout
                 */
                @JsonProperty("timeout")
                private Integer timeout;
            }


            @Data
            @NoArgsConstructor
            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class AnalysisResultsDto {

                /**
                 * category
                 */
                @JsonProperty("category")
                private String category;
                /**
                 * result
                 */
                @JsonProperty("result")
                private String result;
                /**
                 * method
                 */
                @JsonProperty("method")
                private String method;
                /**
                 * engineName
                 */
                @JsonProperty("engine_name")
                private String engineName;

            }
        }
    }
}
