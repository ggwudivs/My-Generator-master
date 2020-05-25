package generator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hou
 */
public class StringUtil {
    public static final long INVALID_LONG_VALUE = -9223372036854775808L;
    public static final String RAW_STRING = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public StringUtil() {
    }

    public static String deleteTail(String content, String str) {
        if (content != null && str != null) {
            int minSize = str.length();
            if (content.length() >= minSize) {
                content = content.substring(0, content.length() - minSize);
            }

            return content;
        } else {
            return content;
        }
    }

    public static String escapePattern(String content) {
        if (content == null) {
            return null;
        } else {
            content = content.replaceAll("\\\\", "\\\\\\\\");
            content = content.replaceAll("\\?", "\\\\?");
            content = content.replaceAll("\\+", "\\\\+");
            content = content.replaceAll("\\*", "\\\\*");
            content = content.replaceAll("\\[", "\\\\[");
            content = content.replaceAll("\\]", "\\\\]");
            content = content.replaceAll("\\{", "\\\\{");
            content = content.replaceAll("\\}", "\\\\}");
            content = content.replaceAll("\\(", "\\\\(");
            content = content.replaceAll("\\)", "\\\\)");
            content = content.replaceAll("\\-", "\\\\-");
            content = content.replaceAll("\\$", "\\\\\\$");
            return content;
        }
    }

    public static String fixed(int number, int minlen) {
        String result;
        for (result = String.valueOf(number); result.length() < minlen; result = "0" + result) {
            ;
        }

        return result;
    }

    public static final int find(String str, String s1) {
        int count = 0;

        for (int fromindex = -1; (fromindex = str.indexOf(s1, fromindex + 1)) > -1; ++count) {
            ;
        }

        return count;
    }

    public static String getDefault(String str, String defaultValue) {
        return isNotEmpty(str) ? str : defaultValue;
    }

    public static String getSimpleString(String string) {
        if (string == null) {
            return "";
        } else {
            String regex = "[a-zA-Z0-9]+";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(string);
            return m.find() ? m.group() : "";
        }
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isTrimEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static Map getUrlParam(String str) {
        Map result = new HashMap();
        if (isNotEmpty(str)) {
            String[] strArr = str.split("&");
            for (String item : strArr) {
                String[] itemArr = item.split("=");
                result.put(itemArr[0], itemArr[1]);
            }
        }
        return result;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public static boolean isFine(String str) {
        return isNotEmpty(str);
    }

    public static String join(String[] strs, String split) {
        if (strs != null && strs.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(strs[0]);

            for (int i = 1; i < strs.length; ++i) {
                sb.append(split + strs[i]);
            }

            return sb.toString();
        } else {
            return null;
        }
    }

    public static String getNotNull(String str) {
        if (str == null) {
            str = "";
        }

        return str;
    }

    public static double parseDouble(String str) {
        double v = 0.0D;

        try {
            v = Double.parseDouble(str);
        } catch (Exception var4) {
            v = -9.223372036854776E18D;
        }

        return v;
    }

    public static int parseInt(double num) {
        return (new Double(num)).intValue();
    }

    public static int parseInt(String str) {
        return parseInt(str, -2147483648);
    }

    public static int parseInt(String str, int custom) {
        return parseInt(str, -2147483648, custom);
    }

    public static int parseInt(String str, int min, int custom) {
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (Exception var5) {
            result = custom;
        }

        if (result < min) {
            result = min;
        }

        return result;
    }

    public static long parseLong(String str) {
        long v = 0L;

        try {
            v = Long.parseLong(str);
        } catch (Exception var4) {
            v = -9223372036854775808L;
        }

        return v;
    }

    public static String subString(String str, int len) {
        return subString(str, 0, len);
    }

    private static String subString(String str, int start, int len) {
        if (str == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            int counter = 0;

            for (int i = start; i < str.length(); ++i) {
                char c = str.charAt(i);
                if (c < 255) {
                    ++counter;
                } else {
                    counter += 2;
                }

                if (counter > len) {
                    break;
                }

                sb.append(c);
            }

            return sb.toString();
        }
    }

    public static final String replace(String s, String s1, String s2) {
        if (s == null) {
            return null;
        } else {
            byte i = 0;
            int i1;
            if ((i1 = s.indexOf(s1, i)) < 0) {
                return s;
            } else {
                char[] ac = s.toCharArray();
                char[] ac1 = s2.toCharArray();
                int j = s1.length();
                StringBuffer sb = new StringBuffer(ac.length);
                sb.append(ac, 0, i1).append(ac1);
                i1 += j;

                int k;
                for (k = i1; (i1 = s.indexOf(s1, i1)) > 0; k = i1) {
                    sb.append(ac, k, i1 - k).append(ac1);
                    i1 += j;
                }

                sb.append(ac, k, ac.length - k);
                return sb.toString();
            }
        }
    }

    public static String joinString(String[] strs) {
        if (strs == null) {
            return null;
        } else {
            StringBuilder buf = new StringBuilder();

            for (int i = 0; i < strs.length; ++i) {
                if (i > 0) {
                    buf.append(',');
                }

                buf.append('\'');
                buf.append(strs[i]);
                buf.append('\'');
            }

            return buf.toString();
        }
    }

    public static int[] toInts(String content) {
        return toInts(content, ",");
    }

    public static int[] toInts(String content, String split) {
        if (!isEmpty(content) && split != null) {
            String[] strs = content.split(split);
            if (strs.length == 0) {
                return null;
            } else {
                int[] re = new int[strs.length];

                for (int i = 0; i < re.length; ++i) {
                    re[i] = parseInt(strs[i]);
                }

                return re;
            }
        } else {
            return null;
        }
    }

    public static String[] split(String str) {
        if (isEmpty(str)) {
            return null;
        } else {
            byte SIZE = 125;
            int pages = (str.length() + SIZE - 1) / SIZE;
            String[] contents = new String[pages];
            int start = 0;

            for (int i = 0; i < pages; ++i) {
                if (i == pages - 1) {
                    contents[i] = str.substring(start);
                } else {
                    contents[i] = str.substring(start, start + SIZE);
                }

                start += SIZE;
            }

            return contents;
        }
    }

    public static String[] patchMa(String content, String coptem) {
        StringBuffer contentBatch = new StringBuffer();
        Pattern pa = Pattern.compile(coptem);
        Matcher ma = pa.matcher(content);
        int pos = 0;

        for (int ii = 0; ma.find(pos); pos = ma.end()) {
            contentBatch.append(ma.group(1));
            contentBatch.append("#!#");
            ++ii;
        }

        return contentBatch.toString().split("#!#");
    }

    public static String addzero(int num, int length) {
        String str = "";
        if ((double) num < Math.pow(10.0D, (double) (length - 1))) {
            for (int i = 0; i < length - (num + "").length(); ++i) {
                str = str + "0";
            }
        }

        str = str + num;
        return str;
    }

    public static boolean isEmail(String email) {
        if (isTrimEmpty(email)) {
            return false;
        } else {
            String pattern = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})+$";
            return email.matches(pattern);
        }
    }

    public static boolean isNum(String sNum) {
        return isTrimEmpty(sNum) ? false : sNum.matches("[0-9]*");
    }

    public static int getByteLength(String s) {
        return s == null ? 0 : s.getBytes().length;
    }

    public static String dbc2sbc(String str, boolean flag) {
        if (str.length() <= 0) {
            return "";
        } else {
            char[] inputStr = str.toCharArray();

            for (int i = 0; i < inputStr.length; ++i) {
                int str1 = inputStr[i];
                if (!flag) {
                    if (str1 == 32 || str1 >= 33 && str1 <= 126) {
                        str1 += 'ﻠ';
                    }

                    if (str1 == 46) {
                        str1 = '．';
                    }
                } else {
                    if (str1 == 12288 || str1 >= '！' && str1 <= 'ｃ') {
                        str1 -= 'ﻠ';
                    }

                    if (str1 == 12290 || str1 == '．') {
                        str1 = 46;
                    }
                }

                inputStr[i] = (char) str1;
            }

            return new String(inputStr);
        }
    }

    public static String fullToHalf(String str) {
        return dbc2sbc(str, true);
    }

    public static String halfToFull(String str) {
        return dbc2sbc(str, false);
    }

    public static String addBlankWord(String input, int length) {
        if (input.length() >= length) {
            return input;
        } else {
            StringBuilder sb = new StringBuilder(input);

            for (int i = input.length(); i < length; ++i) {
                sb.append(" ");
            }

            return sb.toString();
        }
    }

    public static byte[] strToAscii(String str) {
        if (str != null && str.length() != 0) {
            char[] c = str.toCharArray();
            byte[] b = new byte[c.length];

            for (int i = 0; i < c.length; ++i) {
                b[i] = (byte) (c[i] & 127);
            }

            return b;
        } else {
            return null;
        }
    }

    public static String strToAscii(String str, String fix) {
        byte[] b = strToAscii(str);
        if (b == null) {
            return "";
        } else {
            String s = "";

            for (int i = 0; i < b.length; ++i) {
                s = s + b[i] + fix;
            }

            return s.substring(0, s.length() - 1);
        }
    }

    public static String asciiToStr(String ascii, String fix) {
        String[] asciiArr = ascii.split(fix);
        int length = asciiArr.length;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; ++i) {
            sb.append((char) Integer.parseInt(asciiArr[i]));
        }

        return sb.toString();
    }

    public static String toAsciiString(String str) {
        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        char[] var3 = chars;
        int var4 = chars.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            char ch = var3[var5];
            String tmp = ch + "";
            if (tmp.length() == tmp.getBytes().length) {
                sb.append(tmp);
            } else {
                String hex = "\\u" + Integer.toHexString(ch);
                sb.append(hex);
            }
        }

        return sb.toString();
    }

    public static String toNormalString(String str) {
        StringBuffer sb = new StringBuffer();
        boolean begin = true;
        String[] ss = str.split("\\\\\\\\u");
        if (ss.length == 1) {
            ss = str.split("\\\\u");
        }

        String[] var4 = ss;
        int var5 = ss.length;

        for (int var6 = 0; var6 < var5; ++var6) {
            String s = var4[var6];
            if (begin) {
                begin = false;
                sb.append(s);
            } else if (s.length() >= 4) {
                String ascii = s.substring(0, 4);
                String tmp = s.substring(4);
                sb.append((char) Integer.valueOf(ascii, 16).intValue()).append(tmp);
            }
        }

        return sb.toString();
    }

    public static String escapeCmd(String content) {
        if (content != null && !"".equals(content)) {
            content = StringUtils.replace(content, "\"", "\\\\\\\"");
            content = StringUtils.replace(content, "\'", "\\\'");
            content = StringUtils.replace(content, " ", "\\ ");
            return content;
        } else {
            return "";
        }
    }

    public static String toString(String[] str, String seperator) {
        if (str != null && str.length != 0) {
            StringBuffer buf = new StringBuffer();
            int i = 0;

            for (int n = str.length; i < n; ++i) {
                if (i != 0) {
                    buf.append(seperator);
                }

                buf.append(str[i]);
            }

            return buf.toString();
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(isIpAddr("111.222.222.111"));
    }

    public static boolean check() {
        boolean versionType = true;
        String version = "2.2.2";
        ArrayList versionList = new ArrayList();
        versionList.add("2.2.3");
        versionList.add("2.2.4");
        versionList.add("2.2.5");
        versionList.add("2.2.1");
        versionList.add("2.2.7");
        Iterator var3 = versionList.iterator();

        while (var3.hasNext()) {
            String v = (String) var3.next();
            if (!versionType) {
                if (Integer.parseInt(v) < Integer.parseInt(version)) {
                    return true;
                }
            } else {
                String[] versions = version.split("\\.");
                String[] preVersions = v.split("\\.");
                System.out.println(versions.length);
                if (Integer.parseInt(preVersions[0]) < Integer.parseInt(versions[0])) {
                    return true;
                }

                if (Integer.parseInt(preVersions[1]) < Integer.parseInt(versions[1])) {
                    return true;
                }

                if (Integer.parseInt(preVersions[2]) < Integer.parseInt(versions[2])) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isInt(String str) {
        return str.matches("\\d+");
    }

    public static Map jsonStrToMap(String str) {
        return JSON.parseObject(str, new TypeReference<Map<String, Object>>() {
        });
    }

    public static int getInt(String str, int defaultValue) {
        return str == null ? defaultValue : (isInt(str) ? Integer.parseInt(str) : defaultValue);
    }

    public static String sqlIds(List<Integer> ids) {
        StringBuilder sbStr = new StringBuilder("");
        Iterator var2 = ids.iterator();

        while (var2.hasNext()) {
            Integer id = (Integer) var2.next();
            sbStr.append(id).append(",");
        }

        if (sbStr.length() > 1) {
            sbStr.delete(sbStr.length() - 1, sbStr.length());
            return sbStr.toString();
        } else {
            return null;
        }
    }

    public static String trans(String str) {
        return str != null && str.length() != 0 ? str : "无";
    }

    public static final boolean commonCharCheck(String in) {
        if (StringUtils.isBlank(in)) {
            return true;
        } else {
            Pattern pattern = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\\-,，+\\s一-龥]+$");
            Matcher matcher = pattern.matcher(in);
            return matcher.matches();
        }
    }

    public static final boolean isChineseCharacters(String str) {
        return str.matches("^[\\u4e00-\\u9fa5]+$");
    }

    public static final boolean isNumber(String str) {
        return str.matches("^[0-9]+$");
    }

    public static final boolean isCharacters(String str) {
        return str.matches("^[a-zA-Z]+$");
    }

    public static String[] split(String str, String splitsign) {
        if (str != null && splitsign != null) {
            int index;
            ArrayList al;
            for (al = new ArrayList(); (index = str.indexOf(splitsign)) != -1; str = str.substring(index + splitsign.length())) {
                al.add(str.substring(0, index));
            }

            al.add(str);
            return (String[]) al.toArray(new String[0]);
        } else {
            return null;
        }
    }

    public static boolean checkEffectTel(String tel) {
        boolean effectTel = false;
        StringBuffer sb = new StringBuffer();
        if (tel != null && tel.trim() != "") {
            if (tel.contains("+86")) {
                sb.append("^(\\+861)\\d{10}$");
            } else if (tel.contains("+852")) {
                sb.append("^(\\+852)\\d{8}$");
            }

            Pattern p = Pattern.compile(sb.toString());
            Matcher mobilePhone = p.matcher(tel.trim());
            effectTel = mobilePhone.matches();
            return effectTel;
        } else {
            return effectTel;
        }
    }

    public static final String getRandomString(int length) {
        if (length < 1) {
            return "";
        } else {
            Random random = new Random();
            int str_len = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".length();
            StringBuilder b = new StringBuilder();

            for (int i = 0; i < length; ++i) {
                b.append("1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(str_len)));
            }

            return b.toString();
        }
    }

    public static final String getRandomStr(int length) {
        if (length < 1) {
            return "";
        } else {
            Random random = new Random();
            int str_len = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".length();
            StringBuilder b = new StringBuilder();

            for (int i = 0; i < length; ++i) {
                b.append("1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(random.nextInt(str_len)));
            }

            return b.toString();
        }
    }

    public static final boolean isIpAddr(String ipStr) {
        return ipStr.matches("^((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)$");
    }

    public static final String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static final String getUUID(String prefix, String suffix, boolean rmvUnderline) {
        String uuid = UUID.randomUUID().toString();
        if (rmvUnderline) {
            uuid = uuid.replaceAll("\\-", "");
        }

        if (isNotEmpty(prefix)) {
            uuid = prefix + "_" + uuid;
        }

        if (isNotEmpty(suffix)) {
            uuid = uuid + "_" + suffix;
        }

        return uuid;
    }

    public static final List<Integer> toIntList(String strSerial) {
        ArrayList intList = new ArrayList();
        if (isNotEmpty(strSerial) && strSerial.matches("^\\d+(,\\d+)*$")) {
            String[] var2 = strSerial.split(",");
            int var3 = var2.length;

            for (int var4 = 0; var4 < var3; ++var4) {
                String str = var2[var4];
                int i = Integer.parseInt(str);
                intList.add(Integer.valueOf(i));
            }
        }

        return intList;
    }

    public static final String getNumCode(int length) {
        String src = "1234567890";
        int src_len = src.length();
        StringBuilder result = new StringBuilder();
        Random r = null;

        for (int i = 0; i < length; ++i) {
            r = new Random();
            int index = r.nextInt(src_len);
            result.append(src.indexOf(String.valueOf(index)));
        }

        return result.toString();
    }

    /**
     * 获取支付流水号
     *
     * @param appUserId
     * @return
     */
    public static final String getTradeNo(Long appUserId) {
        // 小于等于32位长度的支付流水号 = 平台订单号 + 13位时间戳取后面九位
        return getOrderNum(appUserId) + String.valueOf(System.currentTimeMillis()).substring(4);
    }

    /**
     * 获取订单编号
     *
     * @param appUserId
     * @return
     */
    public static final String getOrderNum(Long appUserId) {
        Date today = new Date();
        String orderNum = CalendarUtil.dateToStr(today, CalendarUtil.TimeFormat.yyyyMMddHHmmss) + String.valueOf(5678 + appUserId);//订单号
        return orderNum;
    }

    /**
     * 获取邀请码
     */
    public static String generateReferralCode(String fullName, Long id) {
        StringBuilder random = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int intVal = (int) (Math.random() * 26 + 97);
            random.append((char) intVal);
        }
        String name = fullName + random;
        if (name.length() > 6) {
            name = name.substring(0, 6);
        }
        StringBuilder $id = new StringBuilder(id + "");
        if ($id.length() < 4) {
            for (int i = $id.length(); i < 4; i++) {
                $id.insert(0, "0");
            }
        }
        return name + $id;
    }

    public static String snakeToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String snakeToCapHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return org.apache.commons.lang.StringUtils.capitalize(sb.toString());
    }
}
