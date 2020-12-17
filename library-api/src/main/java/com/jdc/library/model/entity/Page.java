package com.jdc.library.model.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Page<T> {
	private List<T> content;
	private int totalPages;
}
