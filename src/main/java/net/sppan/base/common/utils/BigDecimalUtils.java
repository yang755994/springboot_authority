package net.sppan.base.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/9 14:48
 */
public class BigDecimalUtils {

	public static final int DEFAULT_SCALE = 2;

	public static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

	/**
	 * 加法
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static BigDecimal add(BigDecimal param1, BigDecimal param2) {
		BigDecimal bigDecimal = null;
		bigDecimal = param1.add(param2);
		return setScale(bigDecimal);
	}

	/**
	 * 减法
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static BigDecimal sub(BigDecimal param1, BigDecimal param2) {
		BigDecimal bigDecimal = null;
		bigDecimal = param1.subtract(param2);
		return setScale(bigDecimal);
	}

	/**
	 * 乘法
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		return mul(v1, v2, BigDecimal.ONE, BigDecimal.ONE);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1
	 *            乘数
	 * @param v2
	 *            乘数
	 * @param v3
	 *            乘数
	 * @return 三个参数的积
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2, BigDecimal v3) {
		return mul(v1, v2, v3, BigDecimal.ONE);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param b1
	 *            v1 乘数
	 * @param b2
	 *            v2 乘数
	 * @param scale
	 *            小数位
	 * @param mode
	 *            进位方式
	 * @return
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2, int scale, RoundingMode mode) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return v1.multiply(v2).setScale(scale, mode);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param b1
	 *            v1 乘数
	 * @param b2
	 *            v2 乘数
	 * @param v3
	 *            v3 乘数
	 * @param scale
	 *            小数位
	 * @param mode
	 *            进位方式
	 * @return
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2, BigDecimal v3, int scale, RoundingMode mode) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return v1.multiply(v2).multiply(v3).setScale(scale, mode);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1
	 *            乘数
	 * @param v2
	 *            乘数
	 * @param v3
	 *            乘数
	 * @param v4
	 *            乘数
	 * @return 四个参数的积
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2, BigDecimal v3, BigDecimal v4) {
		BigDecimal bigDecimal = null;
		bigDecimal = v1.multiply(v2).multiply(v3).multiply(v4);
		return setScale(bigDecimal);
	}

	/**
	 * 除法
	 * 
	 * @param param1
	 * @param param2
	 * @return
	 */
	public static BigDecimal div(BigDecimal param1, BigDecimal param2) {
		BigDecimal bigDecimal = null;
		bigDecimal = param1.divide(param2, DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP); // 不能整除，保留两位小数
		return setScale(bigDecimal);
	}

	/**
	 * 除法
	 * 
	 * @param param1
	 * @param param2
	 * @param scale
	 *            保留小数点位数
	 * @return
	 * @datetime 2016年8月6日下午3:25:24
	 */
	public static BigDecimal div(BigDecimal param1, BigDecimal param2, int scale) {
		BigDecimal bigDecimal = null;
		bigDecimal = param1.divide(param2, scale, BigDecimal.ROUND_HALF_UP);
		return bigDecimal;
	}

	/**
	 * 除法
	 * 
	 * @param v1
	 * @param v2
	 * @param scale
	 * @param mode
	 * @return
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale, RoundingMode mode) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		return v1.divide(v2, scale, mode);
	}

	/**
	 * 保留两位小数
	 * 
	 * @param bigDecimal
	 * @return
	 */
	public static BigDecimal setScale(BigDecimal bigDecimal) {
		return bigDecimal.setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_UP);
	}

	public static BigDecimal getBigDecimal(Object val) {
		return new BigDecimal(val.toString());
	}

	public static void main(String[] args) {
		BigDecimal param1 = new BigDecimal(12);
		BigDecimal param2 = new BigDecimal(3.33);
		System.out.println(add(param1, param2));
		System.out.println(sub(param1, param2));
		System.out.println(mul(param1, param2));
		System.out.println(div(param1, param2, 8));
	}

}
