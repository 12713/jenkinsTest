package freemarker;

/**
 * @author tingxiu.zhou@hand-china.com
 * @version 1.0
 * @name Monitor
 * @description
 * @date 2017/12/20 11:31
 */
public class Monitor {
	private String frontEndSystemCode;
	private Boolean status;

	public String getFrontEndSystemCode() {
		return frontEndSystemCode;
	}

	public void setFrontEndSystemCode(String frontEndSystemCode) {
		this.frontEndSystemCode = frontEndSystemCode;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}
