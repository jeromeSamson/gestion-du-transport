package dev.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entities.Advert;
import dev.entities.AdvertStatut;
import dev.repository.AdvertRepository;

@RestController
public class AdvertController {

	@Autowired
	private AdvertRepository advertRepo;

	@RequestMapping(value = "/addNew", method = RequestMethod.POST)
	public ResponseEntity<Advert> saveNewAdvert(@RequestBody Advert advert) {
		Advert advertLocal = new Advert();
		advertLocal = advert;
		advertLocal.setDateFirst(LocalDateTime.of(advert.getDateFirst().getYear(), advert.getDateFirst().getMonth(),
				advert.getDateFirst().getDayOfMonth(), advert.getDateFirst().getHour(),
				advert.getDateFirst().getMinute(), advert.getDateFirst().getSecond()));
		System.out.println(advertLocal.getDateFirst());
		advert.setPassengers(null);
		advert.setStatut(AdvertStatut.INPROGRESS);
		advertRepo.save(advertLocal);
		return new ResponseEntity<Advert>(advert, HttpStatus.CREATED);

	}

}
