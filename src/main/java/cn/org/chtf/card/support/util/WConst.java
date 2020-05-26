package cn.org.chtf.card.support.util;

/**
 * 系统常量
 * @author wushixing
 *
 */
public class WConst{
	/**
	 * 返回实体内状态
	 */
	public static final int SUCCESS = 1;
	public static final int ERROR = 2;
	public static final int REDIRECT = 3;
	public static final int NOPERMISSION = 4;
	public static final int LOGINOVERTIME = 5;
	public static final int EMPTY = 6;

	/**
	 * 返回消息
	 */
	public static final String CERTIFICATED = "登陆成功";
	public static final String LOGINERROR = "用户名密码错误";
	
	public static final String LOCKED = "登陆失败次数过多，请稍后再试";
	public static final String LOGINOVERTIMEMSG = "登陆超时，请重新登陆";
	public static final String NOPERMISSIONMSG = "您没有权限进行此操作";
	
	public static final String SETED = "设置成功";
	public static final String SETEDERROR = "设置失败";
	
	public static final String SAVED = "保存成功";
	public static final String SAVEDERROR = "保存失败";
	
	public static final String DELETED = "删除成功";
	public static final String DELETEDERROR = "删除失败";

	public static final String QUERYSUCCESS = "查询成功";
	public static final String QUERYFAILD = "查询失败";
	public static final String HAVECHILDERROR = "删除失败，请先删除此几点下的所有子节点";

	/**
	 * 常用静态返回实体
	 */
	public static final ResultModel RELOGINJSON = new ResultModel(LOGINOVERTIME,LOGINOVERTIMEMSG,null);
	public static final ResultModel NOPERMISSIONJSON = new ResultModel(NOPERMISSION,NOPERMISSIONMSG,null);

	/**
	 * 路径相关
	 */
	public static final String HEADROOT = "/static/upload/head/";
	public static final String CKEDITORROOT = "/static/upload/CKEDITOR/";
	public static final String PICTUREROOT = "/static/upload/picture/";
	public static final String FILEROOT = "/static/upload/file/";
	public static final String BROWSERROOT = "/virtualhost/exhibition/static/upload/";

}
