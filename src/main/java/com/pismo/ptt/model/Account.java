package com.pismo.ptt.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
//@Table(name = "TB_ACCOUNT")
public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Account(String documentNumber, LocalDateTime createDate) {
		this.documentNumber = documentNumber;
		this.createDate = createDate;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long accountId;
	
	@NotNull
	@Size(min = 0, max = 11)
	private String documentNumber;

	@NotNull
	private LocalDateTime createDate;

}
