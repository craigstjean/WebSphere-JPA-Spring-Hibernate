package com.craigstjean.jpaexample.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.craigstjean.jpaexample.model.Item;

@Repository
public class ItemDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Item save(Item item) {
		if (item.getId() == null) {
			entityManager.persist(item);
		} else {
			item = entityManager.merge(item);
		}

		return item;
	}

	public List<Item> getItems() {
		return entityManager.createNamedQuery("item.allSortedByName",
				Item.class).getResultList();
	}
}
