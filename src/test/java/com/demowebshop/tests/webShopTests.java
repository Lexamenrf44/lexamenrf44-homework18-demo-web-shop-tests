package com.demowebshop.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class webShopTests {

    @Test
    void addProductToCartWithCookiesTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=5deec30d-08d1-4581-8663-de9fc037eddb;")
                .body("product_attribute_74_5_26=81" +
                        "&product_attribute_74_6_27=83" +
                        "&product_attribute_74_3_28=86" +
                        "&addtocart_74.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/74/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                        "<a href=\"/cart\">shopping cart</a>"));

    }

    @Test
    void addProductToCartWithoutCookiesTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_74_5_26=81" +
                        "&product_attribute_74_6_27=83" +
                        "&product_attribute_74_3_28=86" +
                        "&addtocart_74.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/74/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                        "<a href=\"/cart\">shopping cart</a>"))
                .body("updatetopcartsectionhtml", is("(1)"));

    }

    @Test
    void addProductToWishlistWithCookiesTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("Nop.customer=5deec30d-08d1-4581-8663-de9fc037eddb;")
                .body("product_attribute_71_9_15=45" +
                        "&product_attribute_71_10_16=10" +
                        "&product_attribute_71_11_17=51" +
                        "&addtocart_71.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/71/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                        "<a href=\"/wishlist\">wishlist</a>"));

    }

    @Test
    void addProductToWishlistWithoutCookiesTest() {
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("product_attribute_71_9_15=45" +
                        "&product_attribute_71_10_16=10" +
                        "&product_attribute_71_11_17=51" +
                        "&addtocart_71.EnteredQuantity=1")
                .when()
                .post("http://demowebshop.tricentis.com/addproducttocart/details/71/2")
                .then()
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your " +
                        "<a href=\"/wishlist\">wishlist</a>"))
                .body("updatetopwishlistsectionhtml", is("(1)"));

    }

}
