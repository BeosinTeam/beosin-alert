package com.beosin.alert.common.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author Hex
 * create at 2023-05-15 13:40
 */
@Data
@Builder
@TableName("risk_url")
public class RiskUrlPO {
    @TableId
    private Long id;
    private String url;
    private String source;
    private Integer detectionResult;
    private Date createTime;
    private Date updateTime;
    private String creator;
    private String homePageLink;
}
