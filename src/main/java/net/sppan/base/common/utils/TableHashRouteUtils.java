package net.sppan.base.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 分表规则
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/10/9 11:40
 */
public class TableHashRouteUtils {
	
	public static void main(String[] args) {
		System.out.println(doSelect("GBDQG888"));
	}
	
    private TableHashRouteUtils() {
    }

    /**
     * 待添加入Hash环的表
     */
    private static String[] tables = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
            "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
            "51", "52", "53", "54", "55", "56", "57", "58", "59", "60",
            "61", "62", "63", "64", "65", "66", "67", "68", "69", "70",
            "71", "72", "73", "74", "75", "76", "77", "78", "79", "80",
            "81", "82", "83", "84", "85", "86", "87", "88", "89", "90",
            "91", "92", "93", "94", "95", "96", "97", "98", "99"};
    private static List<String> servers = Arrays.asList(tables);
    private static ConsistentHashSelector selector = new ConsistentHashSelector(servers);

    /**
     * 50个分片表，传入goodSn获取表分片位置
     *
     * @param goodSn
     * @return
     */
    public static String doSelect(String goodSn) {
        return selector.select(goodSn);
    }

    private static final class ConsistentHashSelector {
        private final TreeMap<Long, String> virtualServers;
        private final int replicaNumber;

        /**
         * 初始化hash环
         *
         * @param servers
         */
        public ConsistentHashSelector(List<String> servers) {
            this.virtualServers = new TreeMap<>();
            this.replicaNumber = 160;
            for (String invoker : servers) {
                for (int i = 0; i < replicaNumber / 4; i++) {
                    byte[] digest = md5(invoker + i);
                    for (int h = 0; h < 4; h++) {
                        long m = hash(digest, h);
                        virtualServers.put(m, invoker);
                    }
                }
            }
        }

        /**
         * 找到key所在的分片位置
         *
         * @param key
         * @return
         */
        public String select(String key) {
            byte[] digest = md5(key);
            return selectForKey(hash(digest, 0));
        }

        /**
         * 通过hash值获取在hash环中的位置
         *
         * @param hash
         * @return
         */
        private String selectForKey(long hash) {
            Long key = hash;
            if (!virtualServers.containsKey(key)) {
                SortedMap<Long, String> tailMap = virtualServers.tailMap(key);
                if (tailMap.isEmpty()) {
                    key = virtualServers.firstKey();
                } else {
                    key = tailMap.firstKey();
                }
            }
            return virtualServers.get(key);
        }

        /**
         * 获取hash值
         *
         * @param digest
         * @param number
         * @return
         */
        private long hash(byte[] digest, int number) {
            return (((long) (digest[3 + number * 4] & 0xFF) << 24)
                    | ((long) (digest[2 + number * 4] & 0xFF) << 16)
                    | ((long) (digest[1 + number * 4] & 0xFF) << 8)
                    | (digest[number * 4] & 0xFF))
                    & 0xFFFFFFFFL;
        }

        /**
         * md5加密
         *
         * @param value
         * @return
         */
        private byte[] md5(String value) {
            MessageDigest md5;
            try {
                md5 = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
            md5.reset();
            byte[] bytes = null;
            try {
                bytes = value.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
            md5.update(bytes);
            return md5.digest();
        }
    }

    /**
     * 查询当前分表路由列表
     * @return
     */
    public static String[] getTables() {
        return tables;
    }

}
