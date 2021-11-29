import io.restassured.http.ContentType;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.meta.When;
import javax.xml.ws.Response;
import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


public class CreateUser {
        private String userList;

        //https://petstore.swagger.io/v2/user
        @Test
        public void createSingleUser() {
            //create single user
            //https://petstore.swagger.io/v2/user
            UserDataClass userDataDetails = new UserDataClass();
            UserResponse userCreationResponseDetails = new UserResponse();
            userDataDetails.setId(1);
            userDataDetails.setUsername("Ganga1");
            userDataDetails.setFirstName("Neel");
            userDataDetails.setLastName("Ganga");
            userDataDetails.setEmail("neel@gmail.com");
            userDataDetails.setPassword("123456");
            userDataDetails.setPhone("444-00-444");
            userDataDetails.setUserStatus(0);

          userCreationResponseDetails =
                    given().
                            contentType(ContentType.JSON).
                            body(userDataDetails).
                            log().body().
                            when().
                            post("https://petstore.swagger.io/v2/user").
                            as(UserResponse.class);

            //Checking for Success code=200
            Assert.assertEquals(200,userCreationResponseDetails.getCode());
            System.out.println(userCreationResponseDetails.getCode());

        }

        @Test
        public void createMultipleUsers() {
            //create multiple users
            //https://petstore.swagger.io/v2/user/createWithArray
            ArrayList<UserDataClass> userList=new ArrayList<UserDataClass>();//Creating arraylist
            UserDataClass userOneDataDetails = new UserDataClass();
            UserDataClass userTwoDataDetails = new UserDataClass();
            UserResponse userCreationResponseDetails  ;
            //first user object data

            userOneDataDetails.setId(0);
            userOneDataDetails.setUsername("tester1");
            userOneDataDetails.setFirstName("vapasi");
            userOneDataDetails.setLastName("tester");
            userOneDataDetails.setEmail("tester1@gmail.com");
            userOneDataDetails.setPassword("123456");
            userOneDataDetails.setPhone("444-00-444");
            userOneDataDetails.setUserStatus(0);
            userList.add(userOneDataDetails);

            //second user object data
            userTwoDataDetails.setId(1);
            userTwoDataDetails.setUsername("tester2");
            userTwoDataDetails.setFirstName("Sam");
            userTwoDataDetails.setLastName("Sid");
            userTwoDataDetails.setEmail("side@gmail.com");
            userTwoDataDetails.setPassword("123456");
            userTwoDataDetails.setPhone("444-060-444");
            userTwoDataDetails.setUserStatus(0);
            userList.add(userTwoDataDetails);

            userCreationResponseDetails=
                    given().
                            contentType(ContentType.JSON).
                            body(userList).
                            log().body().
                            when().
                            post("https://petstore.swagger.io/v2/user/createWithArray").
                            as(UserResponse.class);

            Assert.assertEquals(200,userCreationResponseDetails.getCode());

        }

    }

