
package org.example.pojos.herokuapp;

import javax.annotation.Generated;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Root {

    private String mOrigin;

    public String getOrigin() {
        return mOrigin;
    }

    public static class Builder {

        private String mOrigin;

        public Root.Builder withOrigin(String origin) {
            mOrigin = origin;
            return this;
        }

        public Root build() {
            Root root = new Root();
            root.mOrigin = mOrigin;
            return root;
        }

    }

}
