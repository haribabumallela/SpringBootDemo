package com.capgemini.ocp.springbootdemo.service;

import java.util.List;

public interface SpringBootService {
	public List<String> getDuplicates(List<String> duplicates);

	public List<String> getDuplicateElements(List<String> duplicates);

	public List<String> createDuplicates(List<String> inputList);

	public List<String> getAllDuplicateElements();
}
