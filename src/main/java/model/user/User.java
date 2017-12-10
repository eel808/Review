package model.user;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @author zuan
 *
 */

@Entity
@Table(name = "USER")
@DynamicInsert(true)
@DynamicUpdate(true)
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;
	
	@Column(name = "NAME", nullable =false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_INFO_ID")
	private AccountInfo accountInfo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MAPPING_USER_ROLE", 
	           joinColumns = {@JoinColumn(name = "USER_ID", nullable = false,updatable = false)},
	           inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", nullable = false, updatable = false)}
	          )
	private Set<Role> roles=new HashSet<Role>(0);
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_INFO_ID")
	private UserInfo userInfo;
	
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	

}
