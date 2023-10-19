package com.beosin.alert.actions;

import com.beosin.alert.common.domain.vo.PluginRiskUrlVO;


/**
 * ipublic行动
 *
 * @author shangye
 * @date 2022/03/31
 */
public interface IPublicAction {



    /**
     * 检查插件风险url
     *
     * @param url    url
     * @param isWeb3 是web3
     * @return {@code CommonResult<?>}
     */
    PluginRiskUrlVO checkPluginRiskUrl(String url, Boolean isWeb3);
}
