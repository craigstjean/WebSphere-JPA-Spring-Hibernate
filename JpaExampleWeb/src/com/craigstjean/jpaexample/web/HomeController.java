package com.craigstjean.jpaexample.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.craigstjean.jpaexample.dao.ItemDao;
import com.craigstjean.jpaexample.model.Item;

@Controller
public class HomeController {
	@Autowired
	private ItemDao itemDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String display(final Model model) {
		Item item = new Item();
		item.setName("Random item, added " + (new Date()).getTime());
		itemDao.save(item);

		model.addAttribute("items", itemDao.getItems());
		return "index";
	}
}
