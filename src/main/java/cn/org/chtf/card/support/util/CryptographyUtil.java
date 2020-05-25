package cn.org.chtf.card.support.util;

import javax.servlet.http.HttpServletRequest;

public class CryptographyUtil {
    
    public static String GeCurrenttUrl(HttpServletRequest request){
    	String url= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    	return url;
    }
    
}
