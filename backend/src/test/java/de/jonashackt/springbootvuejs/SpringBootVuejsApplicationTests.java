package de.jonashackt.springbootvuejs;

import de.jonashackt.springbootvuejs.controller.BackendController;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(
		classes = SpringBootVuejsApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
		properties = "server.port = 8089"
)
public class SpringBootVuejsApplicationTests {

	private static final String BASE_URL = "http://localhost:8088";

	@Test
	public void backendServiceSaysHello() {
		given()
		.when()
			.get(BASE_URL + "/api/hello")
		.then()
			.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body(is(equalTo(BackendController.HELLO_TEXT)));
	}

}
