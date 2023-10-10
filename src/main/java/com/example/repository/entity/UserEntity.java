package com.example.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity  {

    private static final long serialVersionUID = -4988455421375043688L;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
    private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "user")
	private List<UserRoleEntity> userRoles = new ArrayList<>();
	
//	  @ManyToMany(fetch = FetchType.LAZY)
//	  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id",
//	  nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id",
//	  nullable = false)) 
//	  private List<RoleEntity> roles = new ArrayList<>();
	 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

//    public List<RoleEntity> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<RoleEntity> roles) {
//        this.roles = roles;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public List<UserRoleEntity> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleEntity> userRoles) {
		this.userRoles = userRoles;
	}
    
}
