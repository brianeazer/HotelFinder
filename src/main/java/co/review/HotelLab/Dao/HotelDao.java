package co.review.HotelLab.Dao;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.gc.MyCoffeeShop.MenuItem;
import co.grandcircus.foodsorm.entity.Food;
import co.review.HotelLab.model.Hotel;

@Repository
@Transactional
public class HotelDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Set<String> findAllCities() {
		// This query returns a list of Strings, so I give it String.class
		List<String> cityList = em.createQuery("SELECT DISTINCT city FROM Hotel", String.class)
				.getResultList();
		// Convert the List to a Set.
		return new TreeSet<>(cityList);
	}
	
	public List<Hotel> findByCity(String city) {
		try {
			return em.createQuery("FROM Hotel WHERE city = :city", Hotel.class)
					.setParameter("city", city)
					.getResultList();
		} catch (NoResultException ex) {
			// No user with that username found.
			return null;
		}
	}
}
