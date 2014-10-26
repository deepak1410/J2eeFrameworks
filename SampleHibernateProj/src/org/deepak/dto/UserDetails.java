package org.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {

	private int userId;
	private String userName;
	private Date joinedDate;
	private String description;
	@Embedded
	private Address homeAddress;

	// private Set<Address> address = new HashSet<Address>();
	private Collection<Address> address = new ArrayList<Address>();

	
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="JOINED_DATE")
	@Temporal(TemporalType.DATE)
	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	@Column(name="DESCRIPTION")
	@Transient
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="HOME_STREET")),
		@AttributeOverride(name="city", column=@Column(name="HOME_CITY")),
		@AttributeOverride(name="state", column=@Column(name="HOME_STATE")),
		@AttributeOverride(name="zipcode", column=@Column(name="HOME_ZIP_CODE"))
	})
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address address) {
		this.homeAddress = address;
	}
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
// 	@CollectionId(columns = { @Column }, generator = "", type = @Type)
	public Collection<Address> getOfficeAddress() {
		return address;
	}

	public void setOfficeAddress(Collection<Address> officeAddress) {
		this.address = officeAddress;
	}


}
