package com.prestashop.tests.utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.Select;

public class RegisterInfo extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName =faker.name().lastName();
    String passwrd = faker.internet().password();
    String street =faker.address().streetAddress()+ " "+ faker.address().buildingNumber();
    String city =faker.address().cityName();
    int stateNo = 5;
    String zipCode = faker.address().zipCode().substring(0,5);
    String cellphone = faker.phoneNumber().cellPhone();

}
