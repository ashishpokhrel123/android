package com.example.foodorderingapp.Activity;

import androidx.test.rule.ActivityTestRule;

import com.example.foodorderingapp.R;

import org.junit.Before;
import org.junit.Test;

import org.hamcrest.Matchers;

import org.junit.Rule;


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

import static org.junit.Assert.*;

public class RegisterActivityTest {
    @Rule
    public ActivityTestRule<RegisterActivity> testRule = new ActivityTestRule<>(RegisterActivity.class);

    RegisterActivity registerActivity = null;

    @Before
    public void setUp() throws Exception {
        registerActivity =  testRule.getActivity();
    }
    @Test
    public void ComponentsTest(){
        assertNotNull(registerActivity.etname);
        assertNotNull(registerActivity.etemail);
        assertNotNull(registerActivity.etphone);
        assertNotNull(registerActivity.etusername);
        assertNotNull(registerActivity.etpassword);
        assertNotNull(registerActivity.imagepath);
    }

    @Test
    public void RegisterUItest(){

        onView(withId(R.id.name))
                .perform(typeText("Kumar Poudel"));
        onView(withId(R.id.email))
                .perform(typeText("jumarpoudel146@ggmail"));
        onView(withId(R.id.phone))
                .perform(typeText("9860409629"));

        onView(withId(R.id.username))
                .perform(typeText("kumar"));

        onView(withId(R.id.password))
                .perform(typeText("kumar"));
        onView(withId(R.id.userprofile))
                .perform(typeText("R.drawable.ashish"));

        closeSoftKeyboard();

        onView(withId(R.id.login))
                .perform(click());

        onView(withText("Username or password doesnot match")).
                inRoot(withDecorView(Matchers.not(is(registerActivity.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

}