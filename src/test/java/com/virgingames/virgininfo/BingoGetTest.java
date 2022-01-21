package com.virgingames.virgininfo;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import com.virgingames.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;

/**
 * By Dimple Patel
 **/
//@RunWith(SerenityRunner.class)
public class BingoGetTest extends TestBase
{

    @Test
    public void getAllBingoRecords()
    {
        RestAssured.registerParser("text/plain", Parser.JSON);
        Response response=given()
                .when()
                .basePath(Path.BINGO)
                .get(EndPoints.GET_ALL_RECORDS);
              response.then().statusCode(200);
              RestAssured.registerParser("text/plain", Parser.JSON);
              response.prettyPrint();
        //System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(response));
    }
    //Verify that defaultGameFrequency has 300000 value

}
