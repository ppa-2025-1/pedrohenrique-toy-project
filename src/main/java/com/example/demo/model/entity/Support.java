package main.java.com.example.demo.model.entity;

import com.example.demo.model.entity.BaseEntity;
import com.example.demo.model.entity.Profile.AccountType;
import com.example.demo.model.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "supports")
public class Support extends BaseEntity {

    public enum Supportype {
        NOVO,
        ANDAMENTO,
        CANCELADO,
        RESOLVIDO
    }

    private String action;
    private String object;
    private String details;


    @Enumerated(EnumType.STRING)
    private AccountType type;

    @OneToOne
    private Support support;

    @ManyToMany
     @JoinTable(
        name = "users", 
        joinColumns = @JoinColumn(eam = "users_id"), 
        inverseJoinColumns = @JoinColumn(name = "users_email")
    )

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getDetails(String details) {
        this.details = details;
    }

    public setDetails(String details) {
        this.details = details;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
    
}
