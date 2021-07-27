package org.example.pojos.herokuapp;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AvailablePetsResponse{
        @JsonProperty("id")
        public Object getId() {
            return this.id; }
        public void setId(Object id) {
            this.id = id; }
        Object id;
        @JsonProperty("category")
        public Category getCategory() {
            return this.category; }
        public void setCategory(Category category) {
            this.category = category; }
        Category category;
        @JsonProperty("name")
        public String getName() {
            return this.name; }
        public void setName(String name) {
            this.name = name; }
        String name;
        @JsonProperty("photoUrls")
        public List<String> getPhotoUrls() {
            return this.photoUrls; }
        public void setPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls; }
        List<String> photoUrls;
        @JsonProperty("tags")
        public List<Tag> getTags() {
            return this.tags; }
        public void setTags(List<Tag> tags) {
            this.tags = tags; }
        List<Tag> tags;
        @JsonProperty("status")
        public String getStatus() {
            return this.status; }
        public void setStatus(String status) {
            this.status = status; }
        String status;
    }



