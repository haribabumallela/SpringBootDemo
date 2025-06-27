package com.capgemini.ocp.springbootdemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SpringBootServiceImpl implements SpringBootService {

	private final Set<String> storedDuplicates = new LinkedHashSet<>();

	public List<String> getDuplicates(List<String> duplicates) {

		// duplicates = List.of(10,15,8,49,25,98,98,32,15);

		// return
		// list.stream().filter(i->Collections.frequency(list,i)>1).collect(Collectors.toSet());

		Set<String> set = new HashSet<>();
		return duplicates.stream().map(String::valueOf).filter(a -> !set.add(a)).collect(Collectors.toList());

	}

	@Override
	public List<String> getDuplicateElements(List<String> inputList) {
		Map<String, Integer> countMap = new HashMap<>();
		List<String> duplicates = new ArrayList<>();

		for (String item : inputList) {
			countMap.put(item, countMap.getOrDefault(item, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1) {
				duplicates.add(entry.getKey());
			}
		}

		return duplicates;
	}

	@Override
	public List<String> createDuplicates(List<String> inputList) {
		Map<String, Integer> countMap = new HashMap<>();
		List<String> duplicates = new ArrayList<String>();

		// Arrays.asList("apple", "banana", "mango", "apple", "guva", "mango");

		for (String item : inputList) {
			countMap.put(item, countMap.getOrDefault(item, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > 1) {
				duplicates.add(entry.getKey());
				storedDuplicates.add(entry.getKey());
			}
		}

		return duplicates;
	}

	@Override
	public List<String> getAllDuplicateElements() {
		return new ArrayList<>(storedDuplicates);
	}

}
