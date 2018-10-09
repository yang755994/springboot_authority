package net.sppan.base.controller.web.common;

import net.sppan.base.common.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yangzhigang
 * @Date: 2018/10/8 20:51
 * @Description:
 */
@RestController
public class RabbitMQController {

    @RequestMapping("/send")
    @ResponseBody
    public JsonResult send() {
        try {
            //MqSendUtils.send(MQEnum.Queue.PRICE_CALC_SENDER_PROMOTION, MQEnum.Exchange.PRICE_CALC_SENDER_PROMOTION, "test", MQEnum.Namespace.DEFAULT_MQ_NAMESPACE);
            return JsonResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResult.failure(-1, e.getMessage());
        }
    }
}
