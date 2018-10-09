package net.sppan.base.controller.web.common;

import net.sppan.base.common.JsonResult;
import net.sppan.base.common.utils.ApiParamCheckUtil;
import net.sppan.base.common.utils.DateUtils;
import net.sppan.base.common.utils.FileUtils;
import net.sppan.base.common.utils.TableHashRouteUtils;
import net.sppan.base.enums.OperateEnum;
import net.sppan.base.service.CommonService;
import net.sppan.base.vo.SqlGenerateDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

/**
 * @author: yangzhigang
 * @Date: 2018/10/9 11:42
 * @Description:
 */
@RequestMapping("/web/common")
@Controller
public class CommonController {

    @Autowired
    private CommonService commonService;

    @RequestMapping({"/index", "/"})
    public String index() {
        return "/web/common/index";
    }

    @RequestMapping(value = "/router", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult router(@RequestParam("router") String router) {
        if (StringUtils.isEmpty(router)) {
            return JsonResult.failure(-1, "分表字段传入为空");
        }
        String routerId = TableHashRouteUtils.doSelect(router);
        return JsonResult.success("success", routerId);
    }

    @RequestMapping(value = "/generateDeleteSql", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult generateDeleteSql(@RequestBody SqlGenerateDto req) {
        String validate = ApiParamCheckUtil.checkParam(req);
        if (StringUtils.isNotEmpty(validate)) {
            return JsonResult.failure(-1, validate);
        }
        try {
            List<String> results = commonService.generateSql(req, OperateEnum.DELETE);
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            FileUtils.writeTxtFile(results, new File(path + File.separator + "generateSql_" + DateUtils.parseTimestamp(DateUtils.getCurrentTimestamp()) + ".sql"));
            StringBuffer sb = new StringBuffer();
            results.stream().forEach(s -> sb.append(s));
            return JsonResult.success("success", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(-1, e.getMessage());
        }
    }

    @RequestMapping(value = "/generateSelectSql", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult generateSelectSql(@RequestBody SqlGenerateDto req) {
        String validate = ApiParamCheckUtil.checkParam(req);
        if (StringUtils.isNotEmpty(validate)) {
            return JsonResult.failure(-1, validate);
        }
        try {
            List<String> results = commonService.generateSql(req, OperateEnum.SELECT);
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
            FileUtils.writeTxtFile(results, new File(path + File.separator + "generateSql_" + DateUtils.parseTimestamp(DateUtils.getCurrentTimestamp()) + ".sql"));
            StringBuffer sb = new StringBuffer();
            results.stream().forEach(s -> sb.append(s));
            return JsonResult.success("success", sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(-1, e.getMessage());
        }
    }
}
