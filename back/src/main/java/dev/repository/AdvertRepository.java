package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.entities.Advert;
import dev.entities.User;
import dev.entities.UserAdvert;

public interface AdvertRepository extends JpaRepository<Advert, String> {
	
	List<Advert> findAllByDriver(User user);

	Advert findOneById(Integer id);

	List<Advert> findAllByPassengersIn(List<UserAdvert> userAdvert);
}
