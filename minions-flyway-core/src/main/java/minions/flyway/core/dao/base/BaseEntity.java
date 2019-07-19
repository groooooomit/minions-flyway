package minions.flyway.core.dao.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.PreDestroy;
import javax.persistence.*;

@MappedSuperclass /* Entity 的父类. */
@JsonInclude(JsonInclude.Include.NON_NULL) /* 属性值为 null 的不参与序列化. */
@EntityListeners(AuditingEntityListener.class) /* 监听 Entity 生命周期. */
public class BaseEntity {

	/**
	 * 属性名称常量
	 */
	public interface Field {
		String ID = "id";
		String CREATE_BY = "createBy";
		String CREATE_TIME = "createTime";
		String LAST_MODIFIED_BY = "lastModifiedBy";
		String LAST_MODIFIED_TIME = "lastModifiedTime";
		String OPTIMISTIC = "optimistic";

		/**
		 * 这些属性不可手动修改，都由框架进行维护
		 */
		String[] PROTECTED_FIELDS = {ID, CREATE_BY, CREATE_TIME, LAST_MODIFIED_BY, LAST_MODIFIED_TIME, OPTIMISTIC};
	}

	///////////////////////////////////////////////////////////////////////////
	// property
	///////////////////////////////////////////////////////////////////////////

	/**
	 * ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 创建人
	 * <p>
	 * 使用嵌入对象，配合 JPA 的审计功能使用.
	 * <p>
	 * 为了防止字段名称冲突，对其字段进行重命名
	 */
	@CreatedBy
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = Operator.Field.ID, column = @Column(name = "creator_id", updatable = false)),
			@AttributeOverride(name = Operator.Field.NAME, column = @Column(name = "creator_name", updatable = false))
	})
	private Operator createBy;

	/**
	 * 创建时间
	 */
	@CreatedDate
	@Column(updatable = false)
	private Long createTime;

	/**
	 * 最后一次的修改者
	 * <p>
	 * 使用嵌入对象，配合 JPA 的审计功能使用.
	 * <p>
	 * 为了防止字段名称冲突，对其字段进行重命名
	 */
	@LastModifiedBy
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = Operator.Field.ID, column = @Column(name = "last_editor_id")),
			@AttributeOverride(name = Operator.Field.NAME, column = @Column(name = "last_editor_name"))
	})
	private Operator lastModifiedBy;

	/**
	 * 最后一次修改时间
	 */
	@LastModifiedDate
	private Long lastModifiedTime;

	/**
	 * 乐观锁一致性验证
	 * <p>
	 * 又乐观锁导致的 Modify 失败，提示数据已过期，请重新操作
	 */
	@Version
	@JsonIgnore
	private Long optimistic;

	///////////////////////////////////////////////////////////////////////////
	// getter & setter
	///////////////////////////////////////////////////////////////////////////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Operator getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Operator createBy) {
		this.createBy = createBy;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Operator getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Operator lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Long getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Long lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Long getOptimistic() {
		return optimistic;
	}

	public void setOptimistic(Long optimistic) {
		this.optimistic = optimistic;
	}

	///////////////////////////////////////////////////////////////////////////
	// 生命周期
	///////////////////////////////////////////////////////////////////////////

	/**
	 * 实体被查询出后调用
	 */
	@PostLoad
	public void postLoad() {

	}

	/**
	 * save 之前调用
	 */
	@PrePersist
	public void prePersist() {

	}

	/**
	 * save 之后调用
	 */
	@PostPersist
	public void postPersist() {

	}

	/**
	 * update 之前调用
	 */
	@PreUpdate
	public void preUpdate() {

	}

	/**
	 * update 之后调用
	 */
	@PostUpdate
	public void postUpdate() {

	}

	/**
	 * 删除之前调用
	 */
	@PreRemove
	public void preRemove() {

	}

	/**
	 * 删除之后调用
	 */
	@PostRemove
	public void postRemove() {

	}

	/**
	 * 销毁前调用
	 */
	@PreDestroy
	public void preDestroy() {

	}
}
