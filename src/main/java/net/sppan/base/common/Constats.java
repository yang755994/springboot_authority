package net.sppan.base.common;

public interface Constats {
	
	public static final String CURRENTUSER = "_currentUser";

	public static final String SITE_CODE = "GB";


	/**
	 * 价格共享次数
	 */
	public static final String PROMOTION_PRICE_SHARE_QTY = "promo:p:s";

	/**
	 * GB价格实例
	 */
	public static final String PRICE_REDIS_NAMESPACE = "_price";

	/**
	 * 分隔符
	 */
	public static final String SEPAREATOR_CHARACTER = ":";
	/**
	 * 删除标识
	 */
	public static final String DELETE = SEPAREATOR_CHARACTER + "d";
	/**
	 * 缓存默认过期时间
	 */
	public static final int CACHE_DEFALUT_TIMEOUT = 72 * 60 * 60;
	/**
	 * 价格 key前缀
	 */
	public static final String PROMOTION_PRICE = "promo:p";
	/**
	 * 价格优先级 key前缀
	 */
	public static final String PROMOTION_PRICE_PRIORITY = "promo:pr";
	/**
	 * 店铺对应系统coupon key前缀
	 */
	public static final String PROMOTION_SHOP_TEMPLATE_COUPON = "promo:s:c";
	/**
	 * coupon模板发放次数前缀
	 */
	public static final String COUPON_TEMPLATE_COUNT_INFO = "promo:t:c";
	/**
	 * coupon 使用次数 key前缀
	 */
	public static final String PROMOTION_COUPON_USER_COUNTER = "promo:c:c";

	/**
	 * 配件使用数量前缀
	 */
	public static final String PARTS_COUNT_INFO = "promo:pt:c";
	/**
	 * 配件
	 */
	public static final String PROMOTION_PARTS = "promo:pt";
	/**
	 * 价格使用次数
	 */
	public static final String PROMOTION_PRICE_USER_COUNTER = "promo:p:c";
	/**
	 * 支付后价格使用次数
	 */
	public static final String PROMOTION_PAY_PRICE_USER_COUNTER = "promo:p:p:c";
	/**
	 * 奖品使用次数
	 */
	public static final String PROMOTION_PRIZE_COUNTER = "promo:r:p:c";
	/**
	 * 奖品单日抽取使用上限
	 */
	public static final String PROMOTION_PRIZE_DAY_USE_COUNTER = "promo:r:p:c:d";
	/**
	 * 奖品用户使用上限
	 */
	public static final String PROMOTION_PRIZE_USE_COUNTER = "promo:r:p:c:u";

	/**
	 * 支付折扣
	 */
	public static final String PAY_DISCOUNTS = "promo:pay";
	/**
	 * 后置礼包前缀
	 */
	public static final String PROMOTION_RAFFLE_POST_PACKAGE = "promo:r:pp";
	/**
	 * 抽奖key前缀
	 */
	public static final String PROMOTION_RAFFLE = "promo:r";
	/**
	 * 中奖key前缀
	 */
	public static final String PROMOTION_RAFFLE_PRIZE = "promo:r:p";
	/**
	 * 抽奖模拟中奖名单前缀
	 */
	public static final String PROMOTION_RAFFLE_RECEIVE_LOG = "promo:r:r:l";
	/**
	 * 用户中奖key前缀
	 */
	public static final String PROMOTION_RAFFLE_PRIZE_USER = "promo:r:p:u";
	/**
	 * 抽奖用户使用次数
	 */
	public static final String PROMOTION_RAFFLE_COUNTER = "promo:r:c";
	/**
	 * 满赠赠送抽奖次数/支付金额兑换赠送抽奖次数
	 */
	public static final String PROMOTION_ACTIVITY_USER = "promo:r:u";
	/**
	 * 用户单日赠送抽奖次数
	 */
	public static final String PROMOTION_RAFFLE_GIVE_DAY_USE_COUNTER = "promo:r:g:d:u:c";
	/**
	 * 用户赠送抽奖次数
	 */
	public static final String PROMOTION_RAFFLE_GIVE_USE_COUNTER = "promo:r:g:u:c";
	/**
	 * 分享抽奖活动的次数
	 */
	public static final String PROMOTION_RAFFLE_SHARE = "promo:r:s";
	/**
	 * 集赞兑换次数
	 */
	public static final String PROMOTION_RAFFLE_PRAISE = "promo:r:praise";
	/**
	 * 订单兑换抽奖次数
	 */
	public static final String PROMOTION_RAFFLE_ORDER = "promo:r:o";
	/**
	 * 用户单日抽奖已使用次数
	 */
	public static final String PROMOTION_RAFFLE_DAY_USE_COUNTER = "promo:r:c:d";
	/**
	 * 营销活动key前缀
	 */
	public static final String PROMOTION_ACTIVITY = "promo:a";
	/**
	 * 店铺可参与活动key前缀
	 */
	public static final String PROMOTION_ACTIVITY_SHOP = "promo:a:s";

	/**
	 * 营销活动参与次数key前缀
	 */
	public static final String PROMOTION_ACTIVITY_CNT = "promo:a:c";

	/**
	 * 积分规则
	 */
	public static final String PROMOTION_INTEGRAL_RULE = "promo:i:r";

	/**
	 * 裂变红包缓存前缀
	 */
	public static final String RED_PACKET_ACTIVITY = "promo:a:rp";

	/**
	 * 裂变红包用户已发起次数前缀
	 */
	public static final String RED_PACKET_ACTIVITY_USRR_COUNT = "promo:a:rp:u:c";

	/**
	 * 裂变红包用户已助力次数前缀
	 */
	public static final String RED_PACKET_ACTIVITY_ASSIT_COUNT = "promo:a:rp:assit:c";

	/**
	 * 裂变红包IMEI已使用次数前缀
	 */
	public static final String RED_PACKET_ACTIVITY_IMEI_COUNT = "promo:a:rp:imei:c";

	/**
	 * 裂变红包用户助力名单列表
	 */
	public static final String RED_PACKET_ACTIVITY_ASSIST_USRRS = "promo:a:rp:users";

	/**
	 * 裂变红包IMEI助力名单列表
	 */
	public static final String RED_PACKET_ACTIVITY_ASSIST_IMEIS = "promo:a:rp:imeis";

	/**
	 * 当前用户已拆金额
	 */
	public static final String RED_PACKET_ACTIVITY_USRR = "promo:a:rp:u";

	/**
	 * 当前用户发起的正在生效的红包
	 */
	public static final String RED_PACKET_ACTIVITY_USRR_RECORD = "promo:a:rp:ur";

	/**
	 * 裂变红包锁缓存前缀
	 */
	public static final String RED_PACKET_LOCK = "promo:a:rp:l";
}
