package com.beosin.alert.common.domain.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 恶意网站记录表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "risk_url_log")
public class RiskUrlLogPO implements Serializable {
    /**
     *
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户的ip
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 用户访问的域名
     */
    @TableField(value = "domain")
    private String domain;

    /**
     *
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}