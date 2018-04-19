package com.faqapp.dao;

import java.util.List;

import com.faqapp.models.Faq;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Faq> allFaqs = DatabaseOperations.getAllFaqRecords();
		System.out.println(allFaqs);
	}

}
