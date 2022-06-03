package pageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {

    private static final Logger LOG = LogManager.getLogger(HomePage.class);
    private static int entryAppOccurence = 0;
    @AndroidFindBy(id = "com.kikuu:id/country_txt")
    List<MobileElement> countries;
    @AndroidFindBy(id = "com.kikuu:id/product_name_txt")
    List<MobileElement> nomProduits;
    @AndroidFindBy(accessibility = "Se connecter")
    private MobileElement loginLink;
    @AndroidFindBy(id = "com.kikuu:id/tab_cart_img")
    private MobileElement cartIcon;
    @AndroidFindBy(id = "com.kikuu:id/login_submit_btn")
    private MobileElement loginBtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    private MobileElement permissionAllowBtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    private MobileElement positionAllowBtn;
    @AndroidFindBy(id = "com.kikuu:id/hot_keys_flipper")
    private MobileElement searchBarAcces;
    @AndroidFindBy(id = "com.kikuu:id/search_input_et")
    private MobileElement searchBar;
    @AndroidFindBy(id = "com.kikuu:id/tv_skip")
    private MobileElement skipBtn;
    @AndroidFindBy(id = "com.kikuu:id/search_txt")
    private MobileElement searchBtn;
    @AndroidFindBy(id = "com.kikuu:id/et_password")
    private MobileElement passwordField;
    @AndroidFindBy(id = "com.kikuu:id/et_account")
    private MobileElement accountField;
    @AndroidFindBy(id = "com.kikuu:id/tab_kikuu_img")
    private MobileElement accountLogo;
    @AndroidFindBy(id = "com.kikuu:id/m3_profile_user_avatar_parent_layout")
    private MobileElement loggedHeader;
    @AndroidFindBy(id = "com.kikuu:id/hot_keys_flipper")
    private MobileElement productOccurences;

    public void reject(MobileElement element) {
        try {
            shortWaitUntil(visibilityOf(element));
            click(element);
        } catch (Exception ex) {
        }
    }


//    public void getOnCategory(){
//        click(categoryView);
//    }

    public void waitForAppLoading() {
        if (entryAppOccurence == 0) {
            reject(permissionAllowBtn);
            reject(permissionAllowBtn);
            reject(skipBtn);
            String text = "";
            String country = "";
            int i = 0;
            while ((!country.equals("Cameroon")) && (i != countries.size())) {
                country = countries.get(i).getText();
                if (country.equals("Cameroon"))
                    countries.get(i).click();
                else
                    i++;
            }

            reject(positionAllowBtn);
        }
//        entryAppOccurence++;
    }

    public void clickOnSearchBar() {
        click(searchBarAcces);
    }

    public void clickOnSearchBtn() {
        click(searchBtn);
    }

    public void clickOnLoginBtn() {
        click(loginBtn);
    }


    public void makeSearch(String element) {
        searchBar.sendKeys(element);
    }

    public void login(String cellphone, String password) {
        accountField.sendKeys(cellphone);
        passwordField.sendKeys(password);
    }


    public boolean verifyFoundResult(String S) {
        S = S.toUpperCase();
        System.out.println(nomProduits.size());
        int i = 0;
        do {
            System.out.println(nomProduits.get(i).getText());
            shortWaitUntil(visibilityOf(nomProduits.get(i)));
            System.out.println(nomProduits.get(i).getText().toUpperCase().contains(S));
            if (!nomProduits.get(i).getText().contains(S))
                return false;
            i++;
        } while (i <= nomProduits.size() - 1);


        return true;
    }
    public boolean verifyLoggedIn() {
        reject(accountLogo);
if(shortWaitUntil(visibilityOf(loggedHeader)))
        return true;
else
    return false;
    }
//
//    public boolean verifyNotFoundResult(){
//        shortWaitUntil(visibilityOf(notFoundInfo));
//        return notFoundInfo.isDisplayed();
//    }
//
//    public boolean verifySuggestions(){
//        shortWaitUntil(visibilityOf(categorySuggestionButton));
//        return categorySuggestionButton.isDisplayed();
//    }
//
//    public boolean verifyViewTitle(String element){
//        shortWaitUntil(visibilityOf(productOccurences));
//        return getTitle(element)!=0;
//    }

    public void selectCategory(String category) {
        scrollClick(category);
    }

    public void selectSubcategory(String subcategory) {
        scrollClick(subcategory);
    }

    public void accesToLoginPage() {
        click(cartIcon);
        click(loginLink);
    }


//    public int getTitle(String element){
//        int found = 0;
//        for (int i = 0; i < textView.size(); i++) {
//            if (textView.get(i).getText().equals(element)) {
//                textView.get(i).click();
//                found++;
//                break;
//            }
//        }
//        return found;
//    }


}
