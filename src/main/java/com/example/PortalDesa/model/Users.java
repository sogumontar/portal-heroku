package com.example.PortalDesa.model;

import com.example.PortalDesa.model.constant.TablesConstant;
import com.example.PortalDesa.model.timestamp.Timestamp;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sogumontar Hendra Simangunsong on 07/04/2020.
 */

@NoArgsConstructor
@Entity
//@Table(name = TablesConstant.TABEL_USER, uniqueConstraints = {
//        @UniqueConstraint(columnNames = {
//                "username"
//        }),
//        @UniqueConstraint(columnNames = {
//                "email"
//        })
//})
@Table(name = TablesConstant.TABEL_USER)
public class Users extends Timestamp {
    @Id
    public String sku;

    @Column(name = "name")
    public String  name;

    @Column(name = "alamat")
    public String alamat;

    @Column(name = "username")
    public String username;

    @Email
    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "sku_user"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();

    @Column(name = "status")
    public int status;

    public Users(String sku, String name, String alamat, String username, @Email String email, String password, int status) {
        this.sku = sku;
        this.name = name;
        this.alamat = alamat;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
