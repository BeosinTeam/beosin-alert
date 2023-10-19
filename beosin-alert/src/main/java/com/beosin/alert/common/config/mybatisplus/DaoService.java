package com.beosin.alert.common.config.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.beosin.alert.common.exception.ServiceException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 自定义基础服务
 *
 * @author shangye
 * @date 2022/02/22
 */
public class DaoService<M extends BaseDao<T>, T> extends ServiceImpl<M, T> {

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveBatch(Collection<T> entityList) {
        return saveBatch(entityList, DEFAULT_BATCH_SIZE);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        if (CollectionUtils.isEmpty(entityList)) {
            return Boolean.FALSE;
        }
        int size = entityList.size();
        if (size <= batchSize) {
            boolean flag = (baseMapper.insertBatchSomeColumn(entityList) == size);
            if (!flag) {
                throw new ServiceException("批量插入失败");
            }
        } else {
            ArrayList<T> ts = new ArrayList<>(entityList);
            int start = 0;
            int end = start + batchSize;
            while (start < size) {
                if (end > size) {
                    end = size;
                }
                List<T> subList = ts.subList(start, end);
                boolean flag = (baseMapper.insertBatchSomeColumn(subList) == subList.size());
                if (!flag) {
                    throw new ServiceException("批量插入失败");
                }
                start = end;
                end += batchSize;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public T getOne(Wrapper<T> queryWrapper) {
        if (queryWrapper instanceof LambdaQueryWrapper) {
            LambdaQueryWrapper<T> query = (LambdaQueryWrapper<T>) queryWrapper;
            return super.getOne(query.last(" limit 1 "));
        }
        if (queryWrapper instanceof QueryWrapper) {
            QueryWrapper<T> query = (QueryWrapper<T>) queryWrapper;
            return super.getOne(query.last(" limit 1 "));
        }
        throw new ServiceException("查询类型错误");
    }
}
