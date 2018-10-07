package net.sppan.base.controller.web.redis;

import net.sppan.base.common.CacheKey;
import net.sppan.base.common.Constats;
import net.sppan.base.common.JsonResult;
import net.sppan.base.common.utils.ApiParamCheckUtil;
import net.sppan.base.common.utils.FastJSONHelper;
import net.sppan.base.service.RedisService;
import net.sppan.base.vo.BasePriceRedis;
import net.sppan.base.vo.PriceDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * redis
 * @author: yangzhigang
 * @Date: 2018/10/7 10:47
 * @Description:
 */
@Controller
@RequestMapping("/web/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/set")
    @ResponseBody
    public JsonResult set(@RequestParam("key") String key, @RequestParam("value") String value) {
        try {
            redisService.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success("success", value);
    }

    @RequestMapping("/del")
    @ResponseBody
    public JsonResult del(@RequestParam("key") String key) {
        try {
            redisService.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
        return JsonResult.success();
    }

    @RequestMapping(value={"/","/index"})
    public String index(){
        return "web/redis/index";
    }

    @RequestMapping(value = "/getPrice", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult getPrice(@RequestBody BasePriceRedis price) {
        String validate = ApiParamCheckUtil.checkParam(price);
        if (StringUtils.isNotEmpty(validate)) {
            return JsonResult.failure(validate);
        }
        try {
            String key = CacheKey.buildPriceKey(Constats.SITE_CODE, price.getPipelineCode(), price.getWarehouseCode(), price.getGoodSn());
            String data = redisService.get(key);
            return JsonResult.success("success", FastJSONHelper.deserializeList(data, PriceDto.class));
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
    }

    @RequestMapping(value = "/delPrice", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delPrice(@RequestBody BasePriceRedis price) {
        String validate = ApiParamCheckUtil.checkParam(price);
        if (StringUtils.isNotEmpty(validate)) {
            return JsonResult.failure(validate);
        }
        try {
            String key = CacheKey.buildPriceKey(Constats.SITE_CODE, price.getPipelineCode(), price.getWarehouseCode(), price.getGoodSn());
            redisService.del(key);
            return JsonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(e.getMessage());
        }
    }
}
