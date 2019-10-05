package com.dtstack.multiple.auth.util;

import java.security.MessageDigest;
import java.util.Objects;

/**
 * @author <a href="mailto:guchen@dtstack.com">古尘 At 袋鼠云</a>.
 * @description TODO
 * @date 2019/10/6 00:10
 */
public class SecretUtils {

        /**
         * MD5密码加密
         *
         * @param text 需加密的源字符串
         * @return 返回加密后的字符串
         */
        public static String md5(String text) {
            Objects.requireNonNull(text);
            return hash("MD5", text);
        }

        public static String hash(String algorithm, String text) {
            Objects.requireNonNull(text);

            try {
                MessageDigest md = MessageDigest.getInstance(algorithm);
                byte[] bytes = md.digest(text.getBytes("utf-8"));
                return toHex(bytes);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static final String md5hex(String... str) {
            String base = String.join("", str);
            return md5(base);
        }

        private static String toHex(byte[] bytes) {
            StringBuilder result = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(b & 0xFF);
                if (hex.length() == 1)
                    result.append("0");
                result.append(hex);
            }
            return result.toString();
        }
}
