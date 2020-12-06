package whz.pti.eva.pizzaService.config;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity<PK extends Serializable> {
	
	@Id	@GeneratedValue
	private PK id;

	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}
	
	@Version
	@Column(name = "version")
    private Long version;
	
	@CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private OffsetDateTime createdDate;
    
    @LastModifiedDate
    @Column(name = "last_modified_date")
    private OffsetDateTime lastModifiedDate;

	@Override
	public int hashCode() {
		if (getId() != null) {
			return getId().hashCode();
		}
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseEntity))
			return false;
		BaseEntity other = (BaseEntity) obj;
		return this.getId() != null && this.getId().equals(other.getId());
	}
}
