package com.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Qgs123
 * @version 1.0
 * @date 2022/11/20 10:14
 **/
public class StringUtil {
    public StringUtil() {
    }

    public static String trim(String s) {
        if (s == null) {
            return null;
        } else {
            s = s.trim();
            return s;
        }
    }

    public static String nvlStr(String a, String b) {
        return a == null ? b : a;
    }

    public static String rTrim(String str) {
        for(int i = str.length() - 1; i > 0; --i) {
            if (str.charAt(i) != ' ') {
                return str;
            }

            str = str.substring(0, i);
        }

        return str.trim();
    }

    public static String lTrim(String str) {
        for(int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != ' ') {
                return str;
            }

            str = str.substring(i + 1, str.length());
        }

        return str.trim();
    }


    public static byte[] gbk2utf8(String chenese) {
        char[] c = chenese.toCharArray();
        byte[] fullByte = new byte[3 * c.length];

        for(int i = 0; i < c.length; ++i) {
            int m = c[i];
            String word = Integer.toBinaryString(m);
            StringBuffer sb = new StringBuffer();
            int len = 16 - word.length();

            for(int j = 0; j < len; ++j) {
                sb.append("0");
            }

            sb.append(word);
            sb.insert(0, "1110");
            sb.insert(8, "10");
            sb.insert(16, "10");
            String s1 = sb.substring(0, 8);
            String s2 = sb.substring(8, 16);
            String s3 = sb.substring(16);
            byte b0 = Integer.valueOf(s1, 2).byteValue();
            byte b1 = Integer.valueOf(s2, 2).byteValue();
            byte b2 = Integer.valueOf(s3, 2).byteValue();
            byte[] bf = new byte[]{b0, 0, 0};
            fullByte[i * 3] = bf[0];
            bf[1] = b1;
            fullByte[i * 3 + 1] = bf[1];
            bf[2] = b2;
            fullByte[i * 3 + 2] = bf[2];
        }

        return fullByte;
    }



    public static int chnStrLen(String chinaString) {
        int len = 0;

        for(int i = 0; i < chinaString.length(); ++i) {
            if (chinaString.charAt(i) > 255) {
                len += 2;
            } else {
                ++len;
            }
        }

        return len;
    }

    public static int getChnNumber(String chinaString) {
        int len = 0;

        for(int i = 0; i < chinaString.length(); ++i) {
            if (chinaString.charAt(i) > 255) {
                ++len;
            }
        }

        return len;
    }

    public static int getchrNumber(String chinaString) {
        int len = 0;

        for(int i = 0; i < chinaString.length(); ++i) {
            if (chinaString.charAt(i) <= 255) {
                ++len;
            }
        }

        return len;
    }

    public static final int getCssLength(String value, int chinaLen, int englishLen) {
        int clen = 0;
        int elen = 0;
        int i = 0;

        for(int j = value.length(); i < j; ++i) {
            if (value.charAt(i) > 255) {
                clen += chinaLen;
            } else {
                elen += englishLen;
            }
        }

        return clen + elen;
    }


    public static String decode(String originalString, String encoding) throws UnsupportedEncodingException {
        return URLDecoder.decode(originalString, encoding);
    }

    public static String encode(String originalString, String encoding) throws UnsupportedEncodingException {
        return URLEncoder.encode(originalString, encoding);
    }


    public static String getASCIIOfLetterAndNumber(String str) {
        char a = str.charAt(0);
        return ('/' >= a || a >= ':') && ('@' >= a || a >= '[') && ('`' >= a || a >= '{') ? "-1" : String.valueOf(a);
    }

    public static String filterDangerString(String value) {
        if (value == null) {
            return null;
        } else {
            value = value.replaceAll("\\|", "");
            value = value.replaceAll("&", "&amp;");
            value = value.replaceAll(";", "");
            value = value.replaceAll("@", "");
            value = value.replaceAll("'", "");
            value = value.replaceAll("\"", "");
            value = value.replaceAll("\\'", "");
            value = value.replaceAll("\\\"", "");
            value = value.replaceAll("<", "&lt;");
            value = value.replaceAll(">", "&gt;");
            value = value.replaceAll("\\(", "");
            value = value.replaceAll("\\)", "");
            value = value.replaceAll("\\+", "");
            value = value.replaceAll("\r", "");
            value = value.replaceAll("\n", "");
            value = value.replaceAll("script", "");
            value = value.replaceAll("%27", "");
            value = value.replaceAll("%22", "");
            value = value.replaceAll("%3E", "");
            value = value.replaceAll("%3C", "");
            value = value.replaceAll("%3D", "");
            value = value.replaceAll("%2F", "");
            return value;
        }
    }
}