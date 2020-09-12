package com.edukart.course.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.edukart.models.UserDetails;

@Document(collection="UserDetails")
public class UserDetailsDto extends UserDetails{

}
