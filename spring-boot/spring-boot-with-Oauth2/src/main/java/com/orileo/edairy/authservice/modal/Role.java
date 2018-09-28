/**
 * 
 */
package com.orileo.edairy.authservice.modal;
/**
 * @author H Kapil Kumar
 *
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name="role")
public class Role {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long id;
	
	@Column
	private String name;
	
	public Role(){}

	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}