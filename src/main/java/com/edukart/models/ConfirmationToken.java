//package com.edukart.models;
//
//import java.util.Date;
//import java.util.UUID;
//
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//
//public class ConfirmationToken {
//	
//	@Transient
//    public static final String SEQUENCE_NAME = "tiken_sequence";
//	
//	@Id
//	private long id;
//  
//    private String confirmationToken;
//
//    private Date createdDate;
//
//    @OneToOne(targetEntity = UserDetails.class)
//    @JoinColumn(nullable = false, name = "user_id")
//    UserDetails userDetails;
//
//    public ConfirmationToken() {}
//
//    public ConfirmationToken(UserDetails userDetails) {
//        this.userDetails = userDetails;
//        createdDate = new Date();
//        confirmationToken = UUID.randomUUID().toString();
//    }
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public String getConfirmationToken() {
//		return confirmationToken;
//	}
//
//	public void setConfirmationToken(String confirmationToken) {
//		this.confirmationToken = confirmationToken;
//	}
//
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public UserDetails getUserDetails() {
//		return userDetails;
//	}
//
//	public void setUserDetails(UserDetails userDetails) {
//		this.userDetails = userDetails;
//	}    
//
//}
