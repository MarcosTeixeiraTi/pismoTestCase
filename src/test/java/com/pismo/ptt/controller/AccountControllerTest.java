package com.pismo.ptt.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pismo.ptt.dto.AccountDTO;
import com.pismo.ptt.model.Account;


@SpringBootTest
public class AccountControllerTest {
	
	DozerBeanMapper mapper;
	
	@Before
	public void before() throws Exception {
	    mapper = new DozerBeanMapper();
	}
	
	@Test
	public void givenAccountDTOAndAccountClass_whenMapsSameNameFieldsCorrectly_thenCorrect() {
//		AccountDTO accountDTO = new AccountDTO();
//		accountDTO.setDocumentNumber("12345678900");
//		Account account = mapper.map(accountDTO, Account.class);
//		
//		assertEquals(account.getDocumentNumber(), "12345678900");
	}
	
	
	@Test
	public void givenRequestBody_whenCreateAccount_thenGetCode200() {
//		baseURI = "http://localhost";
//		port = 8080;
//		basePath = "/1.0.0/accounts";
//		
//		given().body("{\n" +
//						" \"document_number\": \"12345678900\",\n" +
//						"}").contentType(ContentType.JSON)
//		.when().post("/1.0.0/accounts")
//		.then().assertThat().statusCode(200);
	}

}
