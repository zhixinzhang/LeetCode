package Company.Karat;

/**
 * @author Luke Zhang
 * @Date 2021-06-20 23:12
 *
 * https://www.1point3acres.com/bbs/thread-770003-1-1.html
 *
 * 第二题给String, 和key, 要求把String根据key来encrypt。大概思路就是先把key变成unique chars，然后遍历String，
 * 把每一个char都用key的index来map
 *
 * 第二题 encryptMessage
 * 给你一个String Message 和一个String key
 * key 是一个很长的string，把这个字母a-z 按照key 出现的顺序字母做mapping，已经出现过的key 直接skip 掉
 * map 做出来了之后把 Message map 到encryptMessage，要保证原本Message 的大小写和其他非字母的character 一样，只换字母
 */
public class EncryptMessage {



}
