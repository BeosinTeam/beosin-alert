package com.beosin.alert.common.domain.dto;

import com.beosin.alert.common.enums.RiskUrlDetectionResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * url标记dto
 *
 * @author shangye
 * @date 2022/04/26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiskUrlTagDTO {

    /**
     * 风险的url
     */
    private String url;

    /**
     * 这个风险url来自哪个网站，数据源
     */
    private String source;

    /**
     * 检测结果
     */
    private RiskUrlDetectionResultEnum detectionResult;

    /**
     * 风险标签
     */
    private List<String> tags;
}
