package api.crudpessoa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table
@SQLDelete(sql = "UPDATE phone SET was_deleted = true WHERE id = ?")
public class Phone {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 3)
    private String ddd;
    @Column(nullable = false, length = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name="id")
    private Person person;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private boolean wasDeleted = false;

}
