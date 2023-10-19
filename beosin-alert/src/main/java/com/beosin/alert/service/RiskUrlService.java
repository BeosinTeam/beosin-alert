package com.beosin.alert.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.beosin.alert.common.domain.po.RiskUrlPO;

import java.util.Collection;
import java.util.List;

/**
 * @author Hex
 * create at 2023-05-12 14:44
 */
public interface RiskUrlService extends IService<RiskUrlPO> {

    /**
     * 通过url集合查询
     *
     * @param urlColl url科尔
     * @return {@code List<RiskUrl>}
     */
    List<RiskUrlPO> listByUrlColl(Collection<String> urlColl);

    String trimPrefix(String url);

    String getDomainFromUrl(String url);

    /**
     * 通过url
     *
     * @param url url
     * @return {@code RiskUrl}
     */
    RiskUrlPO getByUrl(String url);
}
