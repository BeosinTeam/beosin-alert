package com.beosin.alert.common.config.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * 扩展通用mapper
 *
 * @author shangye
 * @date 2022/02/22
 */
public interface BaseDao<T> extends BaseMapper<T> {

    /**
     * 通过实体类列表，批量插入
     *
     * @param entityList 实体列表
     * @return {@code Integer}
     */
    int insertBatchSomeColumn(Collection<T> entityList);
}
