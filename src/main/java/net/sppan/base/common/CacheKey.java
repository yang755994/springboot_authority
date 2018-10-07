package net.sppan.base.common;

import net.sppan.base.common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;

import static net.sppan.base.common.Constats.*;

/**
 * 缓存key
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/7 11:33
 */
public class CacheKey {

	/**
	 * 共享使用次数key
	 * @param conditionId
	 * @param siteCode
	 * @param goodSn
	 * @return
	 */
	public static String buildShareCountKey(String conditionId, String siteCode, String goodSn) {
		Object[] keys = new Object[] { PROMOTION_PRICE_SHARE_QTY, siteCode, conditionId, goodSn};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 用户价格使用次数（绑定sku）
	 * 
	 * @param siteCode
	 * @param userId
	 * @param conditionId
	 * @param goodSn
	 * @return
	 */
	public static String buildPriceUserCounterKey(String siteCode, String pipelineCode, Long userId, String conditionId,
			String goodSn) {
		Object[] keys = new Object[] { PROMOTION_PRICE_USER_COUNTER, siteCode, pipelineCode, conditionId, goodSn,
				userId };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 价格信息key
	 * 
	 * @param siteCode
	 * @param pipelineCode
	 * @param warehouseCode
	 * @param goodSn
	 * @return
	 */
	public static String buildPriceKey(String siteCode, String pipelineCode, String warehouseCode,
			String goodSn) {
		Object[] keys = new Object[] { PROMOTION_PRICE, siteCode, pipelineCode, warehouseCode, goodSn };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

    /**
     * 赠送抽奖次数
     *
     * @param siteCode
     * @param activityId
     * @param userId
     * @return
     */
    public static String buildGiveRaffleCountKey(String siteCode, String activityId, Long userId) {
        Object[] keys = new Object[] { PROMOTION_ACTIVITY_USER, siteCode, activityId, userId};
        return StringUtils.join(keys, SEPAREATOR_CHARACTER);
    }

	/**
	 * 价格使用次数
	 *
	 * @param siteCode
	 * @param conditionId
	 * @param goodSn
	 * @return
	 */
	public static String buildPriceCounterKey(String siteCode, String pipelineCode, String conditionId, String goodSn) {
		Object[] keys = new Object[] { PROMOTION_PRICE_USER_COUNTER, siteCode, pipelineCode, conditionId, goodSn };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 赠送抽奖次数（单日）
	 *
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @param type
	 * @return
	 */
	public static String buildDayGiveRaffleCountKey(String siteCode, String activityId, Long userId, Integer type) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_GIVE_DAY_USE_COUNTER, siteCode, activityId, userId, type, DateUtils.getCurrentDateString()};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 赠送抽奖次数（总计）
	 *
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @param type
	 * @return
	 */
	public static String buildGiveRaffleCountKey(String siteCode, String activityId, Long userId, Integer type) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_GIVE_USE_COUNTER, siteCode, activityId, userId, type};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 分享抽奖活动的次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildShareRaffleCountKey(String siteCode, String pipelineCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_SHARE, siteCode, pipelineCode, activityId, userId };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 集赞兑换次数
	 * @param siteCode      - 站点编码
	 * @param activityId    - 活动ID
	 * @param userId        - 用户ID
	 * @return
	 * Created by JinLin.Yang on 2018/7/7/0007 15:12
	 */
	public static String buildPraiseRaffleCountKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_PRAISE, siteCode, activityId, userId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
     * 订单兑换次数
     * @param siteCode      - 站点编码
     * @param activityId    - 活动ID
     * @param userId        - 用户ID
     * @param orderSn       - 订单号
	 * @return
	 * Created by JinLin.Yang on 2018/7/7/0007 20:20
	 */
	public static String buildOrderRaffleCountKey(String siteCode, String activityId, Long userId, String orderSn) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_ORDER, siteCode, activityId, userId, orderSn};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 抽奖活动信息
	 * 
	 * @param siteCode
	 * @param activityId
	 * @return
	 */
	public static String buildRaffleActivityKey(String siteCode, String activityId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE, siteCode, activityId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 抽奖总使用次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildRaffleUserCounterKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_COUNTER, siteCode, activityId, userId};
		String counterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return counterKey;
	}

	/**
	 * 单日用户抽奖使用次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildRaffleDayUserCounterKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_DAY_USE_COUNTER, siteCode, activityId, userId, DateUtils.getCurrentDateString()};
		String dayUserCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return dayUserCounterKey;
	}

	/**
	 * 奖品单日用户中奖次数
	 * 
	 * @param siteCode
	 * @return
	 */
	public static String buildPrizeDayUserCounterKey(String siteCode, String activityId, Integer prizeRank) {
		Object[] keys = new Object[] { PROMOTION_PRIZE_DAY_USE_COUNTER, siteCode, activityId, prizeRank, DateUtils.getCurrentDateString()};
		String dayUserCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return dayUserCounterKey;
	}

	/**
	 * 奖品用户中奖次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param prizeRank
	 * @return
	 */
	public static String buildPrizeUserCounterKey(String siteCode, String activityId, Integer prizeRank, Long userId) {
		Object[] keys = new Object[] { PROMOTION_PRIZE_USE_COUNTER, siteCode, activityId, prizeRank, userId};
		String userCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return userCounterKey;
	}

	/**
	 * 奖品中奖次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param prizeRank
	 * @return
	 */
	public static String buildPrizeCounterKey(String siteCode, String activityId, Integer prizeRank) {
		Object[] keys = new Object[] { PROMOTION_PRIZE_COUNTER, siteCode, activityId, prizeRank};
		String counterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return counterKey;
	}

	/**
	 * 配件使用次数
	 * 
	 * @param siteCode
	 * @param priceId
	 * @return
	 */
	public static String buildPartsCounterKey(String siteCode, String priceId) {
		Object[] keys = new Object[] { PARTS_COUNT_INFO, siteCode, priceId };
		String partsCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return partsCounterKey;
	}

	/**
	 * coupon用户使用次数
	 * 
	 * @param siteCode
	 * @param code
	 * @param userId
	 * @return
	 */
	public static String buildCouponUserCounterKey(String siteCode, String code, Long userId) {
		Object[] keys = new Object[] { PROMOTION_COUPON_USER_COUNTER, siteCode, code, userId };
		String couponUserCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return couponUserCounterKey;
	}

	/**
	 * coupon使用次数
	 * 
	 * @param siteCode
	 * @param code
	 * @return
	 */
	public static String buildCouponCounterKey(String siteCode, String code) {
		Object[] keys = new Object[] { PROMOTION_COUPON_USER_COUNTER, siteCode, code };
		String couponCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return couponCounterKey;
	}


	/**
	 * 获取模板发放coupon总次数Key
	 */
	public static String buildTemplateCouponTotalCountKey(String siteCode,String code){
		Object[] keys = new Object[] { COUPON_TEMPLATE_COUNT_INFO, siteCode, code };
		String counterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return counterKey;
	}

	/**
	 * 获取模板发放coupon 用户 次数Key
	 */
	public static String buildTemplateCouponUserCountKey(String siteCode,String code,long userId){
		Object[] keys = new Object[] { COUPON_TEMPLATE_COUNT_INFO, siteCode, code, userId };
		String userCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return userCounterKey;
	}

	/**
	 * 用户普通活动使用次数/活动规则priority使用次数
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildActivityUserCounterKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_ACTIVITY_CNT, siteCode, activityId, userId };
		String activityCounterKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return activityCounterKey;
	}

	/**
	 * 订单支付成功次数
	 * 
	 * @param siteCode
	 * @param pipelineCode
	 * @param conditionId
	 * @param goodSn
	 * @return
	 */
	public static String buildPricePayedCountKey(String siteCode, String pipelineCode, String conditionId,
			String goodSn) {
		Object[] keys = new Object[] { PROMOTION_PAY_PRICE_USER_COUNTER, siteCode, pipelineCode, conditionId, goodSn };
		String payedCountKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return payedCountKey;
	}

	/**
	 * 中奖名单列表 (按奖品类型)
	 * 
	 * @param siteCode
	 * @param activityId
	 * @param type
	 * @return
	 */
	public static String buildRafflePrizeKey(String siteCode, String activityId, Integer type) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_PRIZE, siteCode, activityId, type};
		String prizeKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return prizeKey;
	}

	/**
	 * 中奖名单列表 (按活动ID)
	 *
	 * @param siteCode
	 * @param pipelineCode
	 * @param activityId
	 * @return
	 */
	public static String buildRafflePrizeKey(String siteCode, String pipelineCode, String activityId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_PRIZE, siteCode, pipelineCode, activityId, "*"};
		String prizeKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return prizeKey;
	}

	/**
	 * 模拟中奖名单列表
	 *
	 * @param siteCode
	 * @param activityId
	 * @param type
	 * @return
	 */
	public static String buildRaffleReceiveLogKey(String siteCode, String activityId, Integer type) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_RECEIVE_LOG, siteCode, activityId, type};
		String prizeKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return prizeKey;
	}

	/**
	 * 用户中奖记录
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildUserRafflePrizeKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_PRIZE_USER, siteCode, activityId, userId};
		String userPrizeKey = StringUtils.join(keys, SEPAREATOR_CHARACTER);
		return userPrizeKey;
	}

	/**
	 * 后置礼包
	 * 
	 * @param siteCode
	 * @param pipelineCode
	 * @return
	 */
	public static String buildRafflePostPackageKey(String siteCode, String pipelineCode) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_POST_PACKAGE, siteCode, pipelineCode };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 支付兑换抽奖次数key
	 * 
	 * @param siteCode
	 * @param userId
	 * @param orderSn
	 * @return
	 */
	public static String buildPayedOrderSn(String siteCode, Long userId, String orderSn) {
		Object[] keys = new Object[] { PROMOTION_RAFFLE_POST_PACKAGE, siteCode, userId, orderSn };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 活动基础信息key
	 * 
	 * @param siteCode
	 * @param activityId
	 * @return
	 */
	public static String buildActivityKey(String siteCode, String activityId) {
		Object[] keys = new Object[] { PROMOTION_ACTIVITY, siteCode, activityId };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}
	
	/**
	 * 店铺活动可参与活动列表key
	 * 
	 * @param siteCode
	 * @param shopCode
	 * @return
	 */
	public static String buildActivityShopKey(String siteCode, String shopCode) {
		Object[] keys = new Object[] { PROMOTION_ACTIVITY_SHOP, siteCode, shopCode };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	public static String buildShopTemplateCouponKey(String siteCode,String shopCode) {
		Object[] keys = new Object[] { PROMOTION_SHOP_TEMPLATE_COUPON, siteCode,shopCode };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	public static String buildPartsKey(String siteCode, String priceId) {
		Object[] keys = new Object[] { PROMOTION_PARTS, siteCode, priceId };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	public static String buildPayDiscountsKey(String siteCode) {
		Object[] keys = new Object[] { PAY_DISCOUNTS, siteCode };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	public static String buildPricePriorityKey(String siteCode) {
		Object[] keys = new Object[] { PROMOTION_PRICE_PRIORITY, siteCode };
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 积分规则key
	 * @param siteCode
	 * @return
	 */
	public static String buildIntegralRuleKey(String siteCode) {
		Object[] keys = new Object[] {PROMOTION_INTEGRAL_RULE, siteCode};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 获取裂变红包key
	 * @param siteCode
	 * @param activityId
	 * @return
	 */
	public static String buildRedPacketKey(String siteCode, String activityId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY, siteCode, activityId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 获取裂变红包用户单日已发起次数key
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
    public static String buildRedPacketDayUsedCountKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_USRR_COUNT, siteCode, activityId, userId, DateUtils.getCurrentDateString()};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
    }

	/**
	 * 获取裂变红包用户已发起的总次数
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildRedPacketUsedCountKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_USRR_COUNT, siteCode, activityId, userId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 获取裂变红包用户已助力的总次数
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildRedPacketAssitUsedCountKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_ASSIT_COUNT, siteCode, activityId, userId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 获取裂变红包用户单日已助力的总次数
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
	public static String buildRedPacketAssistDayUsedCountKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_ASSIT_COUNT, siteCode, activityId, userId, DateUtils.getCurrentDateString()};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 获取裂变红包IMEI已使用的总次数
	 * @param siteCode
	 * @param activityId
	 * @param imei
	 * @return
	 */
	public static String buildRedPacketImeiCountKey(String siteCode, String activityId, String imei) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_IMEI_COUNT, siteCode, activityId, imei};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 当前用户的助力名单列表
	 * @param siteCode
	 * @param activityRecord
	 * @return
	 */
    public static String buildAssistRedPacketUsersKey(String siteCode, String activityRecord) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_ASSIST_USRRS, siteCode, activityRecord};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
    }

	/**
	 * 当前IMEI的助力名单列表
	 * @param siteCode
	 * @param activityId
	 * @param imei
	 * @return
	 */
	public static String buildAssistRedPacketImeisKey(String siteCode, String activityId, String imei) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_ASSIST_IMEIS, siteCode, activityId, imei};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 用户拆红包信息
	 * @param siteCode
	 * @param activityRecord
	 * @param userId
	 * @return
	 */
    public static String buildCurrentUserDismantledAmountKey(String siteCode, String activityRecord, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_USRR, siteCode, activityRecord, userId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
    }

	/**
	 * 单日IMEI已使用次数
	 * @param siteCode
	 * @param activityRecord
	 * @param imei
	 * @return
	 */
	public static String buildRedPacketDayImeiCountKey(String siteCode, String activityRecord, String imei) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_IMEI_COUNT, siteCode, activityRecord, imei, DateUtils.getCurrentDateString()};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 当前用户发起的正在生效的activityRecordId
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @return
	 */
    public static String buildActivityRecordKey(String siteCode, String activityId, Long userId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_USRR_RECORD, siteCode, activityId, userId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
    }

	/**
	 * 当前用户发起的正在生效的红包
	 * @param siteCode
	 * @param activityRecordId(具有唯一性)
	 * @return
	 */
	public static String buildRedPacketUserRecordKey(String siteCode, String activityRecordId) {
		Object[] keys = new Object[] {RED_PACKET_ACTIVITY_USRR_RECORD, siteCode, activityRecordId};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 红包锁key
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @param type
	 * @return
	 */
	public static String buildRedPacketLockKey(String siteCode, String activityId, Long userId, Integer type) {
		Object[] keys = new Object[] {RED_PACKET_LOCK, siteCode, activityId, userId, type};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}

	/**
	 * 红包锁key
	 * @param siteCode
	 * @param activityId
	 * @param userId
	 * @param type
	 * @return
	 */
	public static String buildRedPacketLockKey(String siteCode, String activityId, Long userId, Long helpUserId, Integer type) {
		Object[] keys = new Object[] {RED_PACKET_LOCK, siteCode, activityId, userId, helpUserId, type};
		return StringUtils.join(keys, SEPAREATOR_CHARACTER);
	}
}