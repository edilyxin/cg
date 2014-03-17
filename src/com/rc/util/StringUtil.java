package com.rc.util;

import java.security.MessageDigest; 

import javax.servlet.http.HttpServletRequest;
/** 
 * <p>Title: </p> 
 * <p>Description: </p> 
 * <p>Copyright: Copyright (c) 2003</p> 
 * <p>Company: </p> 
 * @author unascribed 
 * @version 1.0 
 */ 
public class StringUtil { 
  private final static String[] hexDigits = { 
      "0", "1", "2", "3", "4", "5", "6", "7", 
      "8", "9", "a", "b", "c", "d", "e", "f"}; 
  /** 
   * 转换字节数组为16进制字串 
   * @param b 字节数组 
  * @return 16进制字串 
   */ 
  public static String byteArrayToHexString(byte[] b) { 
    StringBuffer resultSb = new StringBuffer(); 
    for (int i = 0; i < b.length; i++) { 
      resultSb.append(byteToHexString(b[i])); 
    } 
    return resultSb.toString(); 
  } 
  private static String byteToHexString(byte b) { 
    int n = b; 
    if (n < 0) 
      n = 256 + n; 
   int d1 = n / 16; 
    int d2 = n % 16; 
    return hexDigits[d1] + hexDigits[d2]; 
  } 
  public static String MD5Encode(String origin) { 
    String resultString = null;
   try { 
     resultString=new String(origin); 
      MessageDigest md = MessageDigest.getInstance("MD5"); 
      resultString=byteArrayToHexString(md.digest(resultString.getBytes())); 
    } 
    catch (Exception ex) { 
    } 
    return resultString; 
  } 
  

  
 public static void main(String[] args){ 
    System.err.println(MD5Encode("123456")); 
  } 
 

 public static String getIpAddr(HttpServletRequest request) {
     String ip = request.getHeader("x-forwarded-for");
     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("Proxy-Client-IP");
     }
     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("WL-Proxy-Client-IP");
     }
     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getRemoteAddr();
     }
     return ip;
 }

}  