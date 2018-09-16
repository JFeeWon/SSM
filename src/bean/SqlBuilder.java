package bean;

public class SqlBuilder {
	private String where;

	public SqlBuilder() {
		super();
	}

	public SqlBuilder(String where) {
		super();
		this.where = where;
	}

	public String getWhere() {
		return where;
	}

	public void setWhere(String where) {
		this.where = where;
	}
	
}
