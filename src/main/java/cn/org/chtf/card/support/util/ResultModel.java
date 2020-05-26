package cn.org.chtf.card.support.util;

/**
 * 返回对象
 * @author wushixing
 *
 */
public class ResultModel {
	/**
	 * 执行状态
	 */
	private int status;
	/**
	 * 返回的提示消息
	 */
	private String msg;
	/**
	 * 如果为多条记录则返回数据数量
	 */
	private int count;
	/**
	 * 返回的结果
	 */
	private Object result;
	
	public ResultModel(int status,String msg,Object result) {
		this.status = status;
		this.msg = msg;
		this.result = result;
	}
	public ResultModel() {
		
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return this.msg;
	}
	public void setMsg(String msg) {
		this.msg = msg == null ? null : msg.trim();
	}
	public Object getResult() {
		return this.result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
