package com.beosin.alert.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 检测结果enum风险url
 *
 * @author shangye
 * @date 2022/04/26
 */
@Getter
@AllArgsConstructor
public enum RiskUrlDetectionResultEnum {
    // 实例，安全与危险
    SAFE(0),

    DANGER(1);

    private final int value;


}
