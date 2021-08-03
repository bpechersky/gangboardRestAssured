package org.example.org.example.base.dataProvider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class PetData {

    @DataProvider(name = "pet_data")
    public Object[][] petData()  { // array of object array
        String name = "abc";
        String name1 = "abc1";

        String status = "status";
        String status1 = "status1";

        String tagName = "tag";
        String tagName1 = "tag1";

        String categoryName = "cata";
        String categoryName1 = "cata1";

        List photos = new ArrayList();
        photos.add("url1");

        List photos1 = new ArrayList();
        photos1.add("url2");


        return new Object[][]{
                {name, status,tagName, categoryName, photos}, // even if this got failed the next will run
                {name1, status1,tagName1, categoryName1, photos1}
        };

    }

}
