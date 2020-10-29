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
@SQLDelete(sql = "UPDATE address SET was_deleted = true where id = ?")
public class Address {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String street;
    @Column(nullable = false, length = 4)
    private String number;
    @Column(nullable = false, length = 25)
    private String district;
    @Column(nullable = false, length = 25)
    private String city;
    @Column(nullable = false, length = 2)
    private String state;

    @ManyToOne
    @JoinColumn(name="id")
    private Person person;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private boolean wasDeleted = false;

}
