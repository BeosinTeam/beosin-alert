package com.beosin.alert.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * url扫描dto
 *
 * @author shangye
 * @date 2022/04/24
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UrlScanResponseDTO {


    /**
     * results
     */
    @JsonProperty("results")
    private List<ResultsDto> results;

    /**
     * total
     */
    @JsonProperty("total")
    private Integer total;

    /**
     * took
     */
    @JsonProperty("took")
    private Integer took;

    /**
     * hasMore
     */
    @JsonProperty("has_more")
    private Boolean hasMore;

    /**
     * ResultsDto
     */
    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ResultsDto {
        /**
         * task
         */
        @JsonProperty("task")
        private TaskDto task;

        /**
         * sort
         */
        @JsonProperty("sort")
        private List<Object> sort;

        /**
         * TaskDto
         */
        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class TaskDto {
            /**
             * visibility
             */
            @JsonProperty("visibility")
            private String visibility;
            /**
             * method
             */
            @JsonProperty("method")
            private String method;
            /**
             * domain
             */
            @JsonProperty("domain")
            private String domain;
            /**
             * apexDomain
             */
            @JsonProperty("apexDomain")
            private String apexDomain;
            /**
             * time
             */
            @JsonProperty("time")
            private String time;
            /**
             * uuid
             */
            @JsonProperty("uuid")
            private String uuid;
            /**
             * url
             */
            @JsonProperty("url")
            private String url;
            /**
             * tags
             */
            @JsonProperty("tags")
            private List<String> tags;
        }


    }
}
