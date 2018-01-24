package com.pengx.test.espresso;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.web.assertion.WebViewAssertions;
import android.support.test.espresso.web.webdriver.DriverAtoms;
import android.support.test.espresso.web.webdriver.Locator;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.web.sugar.Web.onWebView;
import static android.support.test.espresso.web.webdriver.DriverAtoms.findElement;
import static android.support.test.espresso.web.webdriver.DriverAtoms.webClick;

/**
 * @author PengXin
 */
@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule mActivityTestRule = new ActivityTestRule<>
            (MainActivity.class);

    @Test
    public void testEditText() {
        String typedAccount = "1234567890";
        onView(withId(R.id.et_account))
                .perform(typeText(typedAccount), closeSoftKeyboard());
        onView(withId(R.id.et_account))
                .check(matches(withText(typedAccount)));

        String typedPassword = "0987654321";
        onView(withId(R.id.et_password))
                .perform(typeText(typedPassword), closeSoftKeyboard());
        onView(withId(R.id.et_password))
                .check(matches(withText(typedPassword)));
    }

    @Test
    public void testRecyclerView() {
        onView(withId(R.id.btn_recyclerview)).perform(click());

        onView(withId(R.id.rv)).perform(RecyclerViewActions.scrollToPosition(20));
        onView(withText("item 20")).check(matches(isDisplayed())).perform(click());

        onView(withText("确定")).perform(click());

        pressBack();
    }

    @Test
    public void testWebView() {
        onView(withText("WebView")).perform(click());

        onWebView().withElement(findElement(Locator.NAME, "word"))
                .perform(DriverAtoms.webKeys("android"))
                .withElement(findElement(Locator.ID, "index-bn"))
                .perform(webClick())
                .withElement(findElement(Locator.ID, "results"))
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(), Matchers.containsString("android")));
        pressBack();
    }
}
