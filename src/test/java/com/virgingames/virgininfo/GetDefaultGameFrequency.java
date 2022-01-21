package com.virgingames.virgininfo;

import com.virgingames.constants.EndPoints;
import com.virgingames.constants.Path;
import io.restassured.RestAssured;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.runner.RunWith;


import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * By Dimple Patel
 **/
@RunWith(SerenityRunner.class)
public class GetDefaultGameFrequency
{
    static ValidatableResponse response;
    static String defaultGameFrequency;
    @BeforeClass
    public static void inIt()
    {
        RestAssured.baseURI="https://www.virgingames.com";
        RestAssured.registerParser("text/plain", Parser.JSON);
        response=given()
                .header("Content-Type", "application/json")
                .when()
                .basePath(Path.BINGO)
                .get(EndPoints.GET_ALL_RECORDS)
                .then().statusCode(200);
    }
    @Test
    public void getDefaultGameFrequency()
    {
        //$..bingoLobbyInfoResource.streams[0].defaultGameFrequency//
        response.body("bingoLobbyInfoResource.streams[0]",hasEntry("defaultGameFrequency",300000));
    }
    @Test
    public void getGameFeq()
    {
        defaultGameFrequency = response.extract().path("bingoLobbyInfoResource.streams.findAll{it.defaultGameFrequency='300000'}.defaultGameFrequency").toString();
        System.out.println("The Default Game Frequency values in the list are : " + defaultGameFrequency);
    }
}
