package com.pismo.ptt.controller;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.pismo.ptt.repository.AccountRepository;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountRepository accountRepository;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

//	DozerBeanMapper mapper;
//	
//	@Before
//	public void before() throws Exception {
//	    mapper = new DozerBeanMapper();
//	}
//	
//	@Test
//	public void givenAccountDTOAndAccountClass_whenMapsSameNameFieldsCorrectly_thenCorrect() {
//		AccountDTO accountDTO = new AccountDTO();
//		accountDTO.setDocumentNumber("12345678900");
//		Account account = mapper.map(accountDTO, Account.class);
//		
//		assertEquals(account.getDocumentNumber(), "12345678900");
//	}

//	@Test
//	public void givenAccountData_whenCreateAccount_thenGetCode201() throws Exception {
//		
//		RestAssuredMockMvc
//					.given()
//						.contentType("application/json")
//						.body("{\"documentNumber\": \"12345678900\" }")
//					.when()
//						.post("/api/v1.0.0/accounts")
//					.then()
//						.status(HttpStatus.CREATED);
//	}
//
//	@Test
//	public void givenAccountId_whenFindAccountByID_thenGetCode200() throws Exception {
//		
//		RestAssuredMockMvc
//					.given()
//						.contentType("application/json")
//					.when()
//						.get("/api/v1.0.0/accounts/{accountID}", 1L)
//					.then()
//						.status(HttpStatus.OK);
//	}
//
//	@Test
//	public void givenAccountId_whenFindAccountByIDNotExists_thenGetCode404() throws Exception {
//		when(accountRepository.findById(84L)).thenReturn(null);
//		
//		RestAssuredMockMvc
//					.when()
//						.get("/api/v1.0.0/accounts/{accountID}", 42L)
//					.then()
//						.status(HttpStatus.NOT_FOUND);
//	}

}
