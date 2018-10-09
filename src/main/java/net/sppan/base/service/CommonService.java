package net.sppan.base.service;

import net.sppan.base.enums.OperateEnum;
import net.sppan.base.vo.SqlGenerateDto;

import java.util.List;

/**
 * @author: yangzhigang
 * @Date: 2018/10/9 14:33
 * @Description:
 */
public interface CommonService {

    /**
     * 价格生成sql语句
     * @param req
     * @param operateEnum
     * @return
     */
    List<String> generateSql(SqlGenerateDto req, OperateEnum operateEnum);
}
