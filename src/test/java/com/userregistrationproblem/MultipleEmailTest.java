package com.userregistrationproblem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultipleEmailTest {

    private String emailId;
    private boolean expectedResult;
    static UserRegistration userRegistration;

    public MultipleEmailTest(String emailId, boolean expectedResult) {
        this.emailId = emailId;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize() {
        userRegistration = new UserRegistration();
    }

    @Parameterized.Parameters
    public static Collection input() {
        return Arrays.asList(new Object[][]{{"abc@yahoo.com",true},{"abc-100@yahoo.com",true},{"abc.100@yahoo.com",true},{"abc111@abc.com",true},{"abc-100@abc.net",true},{"abc.100@abc.com.au",true},{"abc@1.com",true},{"abc@gmail.com.com",true},{"abc+100@gmail.com",true}});
    }

    @Test
    public void givenEmailHappyTest() {
        boolean actualEmail = userRegistration.validEmail(emailId);
        Assert.assertEquals(expectedResult,actualEmail);
        System.out.println("Email Successfully Validate.");
    }
}
