package minions.flyway.core.dao.base;

import javax.persistence.Embeddable;

@Embeddable
public class Operator {
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public interface Field {
		String ID = "id";
		String NAME = "name";
	}
}
