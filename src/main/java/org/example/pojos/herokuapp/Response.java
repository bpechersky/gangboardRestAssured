package org.example.pojos.herokuapp;

import lombok.Data;

import java.util.List;

public @Data class Response{
	private List<ResponseItem> response;
}