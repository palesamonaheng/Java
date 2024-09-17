package Common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static Common.BasePaths.*;
import static Common.Headers.*;
import static Common.PayloadBuilder.*;
import static Common.QueryParameters.*;
import static Common.StatusCodes.*;
import static io.restassured.RestAssured.given;

public class RequestBuilder {
    static Response response;
    public static String token;
    public static RequestSpecification requestSpecification;

    public static Response generateToken() {
        RestAssured.baseURI = token_baseURL;

                 response=given()
                .urlEncodingEnabled(true) // Enable URL encoding of form parameters
                .when().
                formParam(grant_type, grant_type_value).
                formParam(client_id, client_id_value).
                formParam(client_secret, client_secret_value).
                formParam(scope, scope_value)
                .post("/token")
                .then().
                extract().response();
                token= response.jsonPath().getString("access_token");
        System.out.println(token);
        return response;
    }
    public static RequestSpecification setRequestSpecification()
    {
         requestSpecification=given()
                .baseUri(TIH_baseURL)
                 .header(authorization, authorization_value + token)
                 .header(correlationId, correlationId_value)
                 .header(envType,envType_Value,envType_Description)
                 .header(envOperator,envOperator_Value)
                 .header(envIdentity,envIdentity_Value);
         return requestSpecification;
    }

    public static Response VehicleStaticData() {

        response= given().spec(setRequestSpecification())
                .when()
                .get("/api/v1/quickquotes/static/motors")
                .then()
                .statusCode(Success_Status_Code)
                .log().all().extract().response();
        return response;
    }
    public static Response TrailerQuote() throws Exception {

        response= given().spec(setRequestSpecification())
                .when()
                .body(createTrailerPayload())
                .post("/api/v1/quickquotes/motors/trailers")
                .then()
                .statusCode(Success_Status_Code)
                .log().all().extract().response();
        return response;
    }

}
