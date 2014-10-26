package org.deepak.dto.inheritance;

import javax.persistence.*;
@Entity
/*@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
name="Animal_type",
discriminatorType=DiscriminatorType.STRING
)*/
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy=InheritanceType.JOINED)
public class Pet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
