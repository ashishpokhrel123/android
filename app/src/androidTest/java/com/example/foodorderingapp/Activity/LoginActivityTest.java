package com.example.foodorderingapp.Activity;

import androidx.test.rule.ActivityTestRule;

import com.example.foodorderingapp.R;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;

public class LoginActivityTest {
    @Rule
    public ActivityTestRule<LoginActivity> testRule = new ActivityTestRule<>(LoginActivity.class);

    LoginActivity loginActivity = null;
    @Before
    public void setUp() throws Exception {
        loginActivity = testRule.getActivity();
    }

    @Test
    public void ComponentsTest(){
        assertNotNull(loginActivity.etpassword);
        assertNotNull(loginActivity.etusername);
    }

    @Test
    public void LoginUItest(){

        onView(withId(R.id.username))
                .perform(typeText("ashish"));
        onView(withId(R.id.password))
                .perform(typeText("ashish"));

        closeSoftKeyboard();

        onView(withId(R.id.login))
                .perform(click());

        onView(withText("Username or password doesnot match")).
                inRoot(withDecorView(Matchers.not(is(loginActivity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }
}