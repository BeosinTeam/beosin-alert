package com.beosin.alert.actions.impl;

import com.beosin.alert.actions.IPublicAction;
import com.beosin.alert.common.domain.po.RiskUrlLogPO;
import com.beosin.alert.common.domain.po.RiskUrlPO;
import com.beosin.alert.common.domain.vo.PluginRiskUrlVO;
import com.beosin.alert.common.enums.RiskUrlDetectionResultEnum;
import com.beosin.alert.service.RiskUrlLogService;
import com.beosin.alert.service.RiskUrlService;
import com.beosin.alert.utils.IPAddressUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * public 实现类
 *
 * @author shangye
 * @date 2022/03/31
 */
@Service
public class PublicActionImpl implements IPublicAction {

    @Resource
    private RiskUrlService riskUrlService;
    @Resource
    private RiskUrlLogService riskUrlLogService;


    @Override
    public PluginRiskUrlVO checkPluginRiskUrl(String url, Boolean isWeb3) {
        // 默认是安全的
        PluginRiskUrlVO vo = PluginRiskUrlVO.builder().build();
        String domain = riskUrlService.getDomainFromUrl(url);
        if (StringUtils.isBlank(domain)) {
            return vo;
        }

        String ip = StringUtils.trimToEmpty(IPAddressUtils.getClientIp());
        if (StringUtils.isNotEmpty(ip)) {
            RiskUrlLogPO riskUrlLog = RiskUrlLogPO.builder()
                    .ip(ip)
                    .domain(domain)
                    .createTime(LocalDateTime.now())
                    .build();
            riskUrlLogService.save(riskUrlLog);
        }

        RiskUrlPO riskUrl = riskUrlService.getByUrl(domain);
        // 这里会存在safe的情况，因为urlscan.io获取的脚本存在不能判断是危险的数据
        if (riskUrl == null || riskUrl.getDetectionResult().equals(RiskUrlDetectionResultEnum.SAFE.getValue())) {
            return vo;
        }
        vo.setDetectionResult(riskUrl.getDetectionResult());
        vo.setSourceName(riskUrl.getSource());
        vo.setSourceUrl(riskUrlService.trimPrefix(riskUrl.getHomePageLink()));

        return vo;
    }


}
