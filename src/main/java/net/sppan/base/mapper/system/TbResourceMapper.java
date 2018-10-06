package net.sppan.base.mapper.system;

import net.sppan.base.entity.system.TbResource;
import net.sppan.base.mapper.support.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Mapper
 *
 * @author yangzhigang
 * @since 2018-10-6
 *
 */
public interface TbResourceMapper extends BaseMapper<TbResource> {

    Page<TbResource> queryByPage(Pageable pageRequest, @Param("params") Map<String, Object> params);
}