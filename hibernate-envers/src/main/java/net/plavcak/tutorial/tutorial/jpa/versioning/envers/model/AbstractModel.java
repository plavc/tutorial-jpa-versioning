package net.plavcak.tutorial.tutorial.jpa.versioning.envers.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Audited
@MappedSuperclass
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractModel {

    @Version
    @Column(name = "m_version", nullable = false)
    protected Long version;

    @NotAudited
    @CreatedDate
    @Column(name = "m_created_at", nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @NotAudited
    @LastModifiedDate
    @Column(name = "m_updated_at")
    protected LocalDateTime updatedAt;
}
