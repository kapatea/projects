package com.orileo.edairy.authservice.modal;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class Address {

	@NotNull
	private String locality;
	
	@NotNull
	private String pincode;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
}