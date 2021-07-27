package org.example.pojos.herokuapp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpBinGetOringIPAddress {

        @JsonProperty("origin")
        public String getOrigin() {
            return this.origin; }
        public void setOrigin(String origin) {
            this.origin = origin; }
        String origin;

}
