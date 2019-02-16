package com.prestashop.utilities;
import com.github.javafaker.Faker;

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

    protected String myEmail="mfeyyazcimen@gmail.com";
    protected String myPasswrd="mfc12345";
    protected String logingNameUp="Muhammed Cimen";
    protected String firstName="Muhammed";
    protected String lastName="Cimen";






}
