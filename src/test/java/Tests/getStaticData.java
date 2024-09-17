package Tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.RequestBuilder.*;
import static Common.StatusCodes.*;

@Test
@Feature("Tests")
@Story("Getting Static Data")
public class getStaticData{

    @Description("As an api user i want to create a token")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void createToken() {
        generateToken().
                then().
                assertThat().
                statusCode(Success_Status_Code);
    }
    @Test(dependsOnMethods = {"createToken"})
    public void getVehicleStaticData() {
        VehicleStaticData().
                then().
                assertThat().
                statusCode(Success_Status_Code);
    }
    @Test
    public void testPostRequestWithFormParams() {

    }

}
