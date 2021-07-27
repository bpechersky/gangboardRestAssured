package org.example.pojos.herokuapp;

import lombok.Data;

import java.util.List;

public @Data class ResponseItem{
	private List<String> photoUrls;
	private String name;
	private long id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}