package com.prestashop.tests.utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class RegisterInfo extends TestBase {

    Faker faker = new Faker();
    protected String firstname = faker.name().firstName();
    protected String lastname =faker.name().lastName();
    protected String email = faker.internet().emailAddress();
    protected String passwrd = faker.internet().password();
    protected String street =faker.address().streetAddress()+ " "+ faker.address().buildingNumber();
    protected String city =faker.address().cityName();
    protected String stateNo = "Texas";
    protected String zipCode = faker.address().zipCode().substring(0,5);
    protected String cellphone = faker.phoneNumber().cellPhone();
    protected String first_Last_Names= firstname+ " "+ lastname;




}
