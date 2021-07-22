package org.example.pojos.herokuapp;

import lombok.Data;

import java.util.List;

public @Data class PojoLombok {
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}