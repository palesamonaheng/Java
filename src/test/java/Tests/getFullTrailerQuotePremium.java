package Tests;

import io.qameta.allure.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import static Common.RequestBuilder.*;
import static Common.StatusCodes.Success_Status_Code;

@Test
@Feature("Tests")
@Story("Getting Full Trailer Quote Premium")
public class getFullTrailerQuotePremium {
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
    public void getTrailerQuotePremium() throws Exception {
        TrailerQuote().
                then().
                assertThat().
                statusCode(Success_Status_Code);
    }
}
