package org.bunny.skyfire.model.websocket.level2;

import java.util.List;

public class Level2 {

	private String type;
	private String product_id;
	private List<Changes> changes;
	
	public Level2() {}
	
	public Level2(String type, String product_id, List<Changes> changes) {
		super();
		this.type = type;
		this.product_id = product_id;
		this.changes = changes;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public List<Changes> getChanges() {
		return changes;
	}
	public void setChanges(List<Changes> changes) {
		this.changes = changes;
	}
	
	
	
}
