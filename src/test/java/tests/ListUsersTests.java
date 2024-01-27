package tests;

import io.qameta.allure.restassured.AllureRestAssured;
import models.ResponseListModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("Rest")
public class ListUsersTests extends BaseTest {
    @Test
    void listUsers() {

        ResponseListModel responseListModel = step("Отправка запроса и его маппинг на модель", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("page", 1)
                        .formParam("per_page", 2)
                        .when()
                        .get("/users")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(ResponseListModel.class));

        step("Сравнение ", () -> {
            assertThat(responseListModel.getData()[0].getId()).isEqualTo(1);
            assertThat(responseListModel.getData()[0].getEmail()).isEqualTo("george.bluth@reqres.in");
            assertThat(responseListModel.getData()[0].getFirst_name()).isEqualTo("George");
            assertThat(responseListModel.getData()[0].getLast_name()).isEqualTo("Bluth");
            assertThat(responseListModel.getData()[0].getAvatar()).isEqualTo("https://reqres.in/img/faces/1-image.jpg");

        });
    }

    @Test
    void listUsers2() {

        ResponseListModel responseListModel = step("Отправка запроса и его маппинг на модель", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("page", 1)
                        .formParam("per_page", 2)
                        .when()
                        .get("/users")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(ResponseListModel.class));

        step("Сравнение ", () -> {
            assertThat(responseListModel.getData()[0].getId()).isEqualTo(1);
            assertThat(responseListModel.getData()[0].getEmail()).isEqualTo("_________george.bluth@reqres.in");
            assertThat(responseListModel.getData()[0].getFirst_name()).isEqualTo("George");
            assertThat(responseListModel.getData()[0].getLast_name()).isEqualTo("Bluth");
            assertThat(responseListModel.getData()[0].getAvatar()).isEqualTo("https://reqres.in/img/faces/1-image.jpg");

        });
    }

    @Disabled("Дубль первого")
    @Test
    void itsDouble() {

        ResponseListModel responseListModel = step("Отправка запроса и его маппинг на модель", () ->
                given()
                        .filter(new AllureRestAssured())
                        .formParam("page", 1)
                        .formParam("per_page", 2)
                        .when()
                        .get("/users")
                        .then()
                        .log().status()
                        .log().body()
                        .statusCode(200)
                        .extract().as(ResponseListModel.class));

        step("Сравнение ", () -> {
            assertThat(responseListModel.getData()[0].getId()).isEqualTo(1);
            assertThat(responseListModel.getData()[0].getEmail()).isEqualTo("george.bluth@reqres.in");
            assertThat(responseListModel.getData()[0].getFirst_name()).isEqualTo("George");
            assertThat(responseListModel.getData()[0].getLast_name()).isEqualTo("Bluth");
            assertThat(responseListModel.getData()[0].getAvatar()).isEqualTo("https://reqres.in/img/faces/1-image.jpg");
        });
    }
}
