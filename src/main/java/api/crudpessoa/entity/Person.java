package api.crudpessoa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@SQLDelete(sql = "UPDATE person SET was_deleted = true WHERE id = ?")
public class Person {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, length = 1)
    private String sex;
    @Column(nullable = false, length = 15, unique = true)
    private String cpf;
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false, length = 50)
    private String email;

    @OneToMany(
        targetEntity = Address.class,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "person_id")
    private List<Address> addresses;

    @OneToMany(
        targetEntity = Phone.class,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    @JoinColumn(name = "person_id")
    private List<Phone> phones;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    private boolean wasDeleted = false;

}
