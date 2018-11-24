package co.review.HotelLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import co.gc.MyCoffeeShop.dao.MenuItemDao;
import co.review.HotelLab.Dao.HotelDao;
import co.review.HotelLab.model.Hotel;

@Controller
public class HotelController {
	
	@Autowired
	private HotelDao hotelDao;
	
	@RequestMapping("/")
	public ModelAndView index() {
		Set<String> cities = hotelDao.findAllCities();
		return new ModelAndView("index", "cities", cities );
	}
	
	@RequestMapping("/results")
	public ModelAndView showResults(@RequestParam("city") String city, @RequestParam("maxPrice") Double price) {
		ArrayList<Hotel> hotelList = (ArrayList<Hotel>) hotelDao.findByCity(city);
		ModelAndView mv = new ModelAndView("results");
		Collections.sort(hotelList, (h1, h2) -> h1.getPricePerNight().compareTo(h2.getPricePerNight()));
		mv.addObject("city", city);
		mv.addObject("price", price);
		
		if (price!=null) {
			Stream<Hotel> hotelsUnderBudget = hotelList.stream().filter(h -> h.getPricePerNight() <= price);
			 ArrayList<Hotel> hotelList2 = (ArrayList<Hotel>) hotelsUnderBudget.collect(Collectors.toList());
			 mv.addObject("hotels", hotelList2);
		}
		else {
		mv.addObject("hotels", hotelList );
		}
		
		return mv;
	}
}
