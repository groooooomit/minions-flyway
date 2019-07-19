package minions.flyway.core.dao.entity;

import minions.flyway.core.dao.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(catalog = "flyway_demo")
public class Person extends BaseEntity {

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

	///////////////////////////////////////////////////////////////////////////
	// field
	///////////////////////////////////////////////////////////////////////////

	public interface Field extends BaseEntity.Field {
		String NAME = "name";
		String AGE = "age";
	}

	///////////////////////////////////////////////////////////////////////////
	// getter & setter
	///////////////////////////////////////////////////////////////////////////

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	///////////////////////////////////////////////////////////////////////////
	// toString
	///////////////////////////////////////////////////////////////////////////


	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
