package Company.Micorsoft;

import java.util.*;


/**
 * @author Luke(New Man) Zhang
 * @Date 4/13/2021 10:21 PM
 * <p>
 * Description: https://leetcode.com/problems/validate-ip-address/discuss/1157636/Luke's-solution-beats-99.9-in-java
 * Similar task :
 * Key Point:
 */

public class _468_ValidateIPAddress_Character {
    public static void main(String[] args){
//        validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        validIPAddress("12..33.4");
        validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        validIPAddress("172.16.254.1");
    }

    static String res = "Neither";
    public static String validIPAddress(String IP) {
        if (IP == null || IP.length() <= 4) {
            return res;
        }


        if (IP.charAt(IP.length() - 1) == '.' || IP.charAt(IP.length() - 1) == ':') {
            return res;
        }
        String[] IP4s = IP.split("\\.");
        String[] IP6s = IP.split(":");
        if (IP4s.length == 1) {
            return isIP6(IP6s);
        } else {
            return isIP4(IP4s);
        }
    }

    private static String isIP4(String[] IP4s){
        if (IP4s.length != 4) {
            return res;
        }

        for (String ip : IP4s){
            if (ip == null || ip.length() > 3 || ip.length() == 0) {
                return res;
            }
            for (int i = 0; i < ip.length(); i++){
                char c = ip.charAt(i);
                if (c == '0' && i == 0) {
                    return res;
                } else if (!Character.isDigit(c)){
                    return res;
                }
            }
            if (Integer.parseInt(ip) > 255){
                return res;
            }
        }

        return "IPv4";
    }


    private static String isIP6(String[] IP6s){
        if (IP6s.length != 8) {
            return res;
        }

        for (String ip : IP6s){
            if (ip == null || ip.length() > 4 || ip.length() == 0) {
                return res;
            }
            for (int i = 0; i < ip.length(); i++){
                char c = ip.charAt(i);
                if (Character.isDigit(c) || (c >= 'a' || c <= 'f') && (c >= 'A' || c <= 'F')){
                    continue;
                } else {
                    return res;
                }
            }
        }

        return "IPv6";
    }
}
