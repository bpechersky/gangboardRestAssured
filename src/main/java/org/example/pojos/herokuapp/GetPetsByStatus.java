package org.example.pojos.herokuapp;

import java.util.List;
import lombok.Data;

public @Data class GetPetsByStatus{
	private List<String> photoUrls;
	private String name;
	private long id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}