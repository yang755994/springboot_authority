package net.sppan.base.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.sppan.base.common.utils.DateUtils;
import net.sppan.base.common.utils.TableHashRouteUtils;
import net.sppan.base.enums.OperateEnum;
import net.sppan.base.service.CommonService;
import net.sppan.base.vo.SqlGenerateDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * CommonService
 * @author: yangzhigang
 * @Date: 2018/10/9 14:41
 * @Description:
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Override
    public List<String> generateSql(SqlGenerateDto req, OperateEnum operateEnum) {
        List<String> results = new ArrayList<>();
        if (StringUtils.isNotEmpty(req.getSkus())) {
            List<String> skus = Lists.newArrayList(Sets.newHashSet(Arrays.asList(req.getSkus().split(","))));
            int size = skus.size();
            for (int i = 0; i < size; i++) {
                String goodSn = skus.get(i);
                String routerId = TableHashRouteUtils.doSelect(goodSn);
                if (i != size - 1) {
                    StringBuffer sb = buildSql(operateEnum, req, goodSn, routerId, false);
                    results.add(sb.toString());
                }
                else {
                    StringBuffer sb = buildSql(operateEnum, req, goodSn, routerId, true);
                    results.add(sb.toString());
                }
            }
        }
        else {
            int size = 100;
            for (int i = 0; i < size; i++) {
                String routerId = String.valueOf(i);
                if (i != size - 1) {
                    StringBuffer sb = buildSql(operateEnum, req, null, routerId, false);
                    results.add(sb.toString());
                }
                else {
                    StringBuffer sb = buildSql(operateEnum, req, null, routerId, true);
                    results.add(sb.toString());
                }
            }
        }
        return results;
    }

    /**
     * 构建sql
     * @param req
     * @param goodSn
     * @param routerId
     * @param isLast
     * @return
     */
    private StringBuffer buildSql(OperateEnum op, SqlGenerateDto req, String goodSn, String routerId, boolean isLast) {
        int currentTime = DateUtils.getCurrentTimestamp();
        String select = "select id,good_sn,start_time,end_time,price_id,condition_id,create_time,creator_name,sys_update_time from price_" + routerId + " ";
        String delete = "delete from price_" + routerId + " ";
        String where = "where status = 1 and end_time >= " + currentTime + " and end_time != start_time ";
        StringBuffer sb = new StringBuffer();
        if (op == OperateEnum.DELETE) {
            sb.append(delete);
        }
        if (op == OperateEnum.SELECT) {
            sb.append(select);
        }
        sb.append(where);
        if (StringUtils.isNotEmpty(goodSn)) {
            sb.append("and good_sn = '" + goodSn + "' ");
        }
        if (StringUtils.isNotEmpty(req.getPipelineCode())) {
            sb.append("and pipeline_code = '" + req.getPipelineCode() + "' ");
        }
        if (StringUtils.isNotEmpty(req.getPriceName())) {
            sb.append("and price_name = '" + req.getPriceName() + "' ");
        }
        if (StringUtils.isNotEmpty(req.getSysLabelId())) {
            sb.append("and sys_label_id = '" + req.getSysLabelId() + "' ");
        }
        if (Objects.nonNull(req.getTemplateId())) {
            sb.append("and template_id = " + req.getTemplateId() + " ");
        }
        if (!isLast) {
            sb.append(op == OperateEnum.DELETE ? ";  \n" : "union  \n");
        }
        return sb;
    }
}
