package api.crudpessoa.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@SQLDelete(sql = "UPDATE user SET was_deleted = true WHERE id = ?")
public class Person {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "person")
    private List<Address> adresses;
    @OneToMany(mappedBy = "person")
    private List<Phone> phones;

    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Column(nullable = false)
    private boolean wasDeleted = false;

}
