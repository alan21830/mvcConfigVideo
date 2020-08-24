package configMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import configMVC.model.StoricoCasi;

public interface StoricoRepositoryJPA extends JpaRepository<StoricoCasi,Integer> {

	List<StoricoCasi> findByData(Date data);
	
	@Query("SELECT DISTINCT s FROM StoricoCasi s ")
	List<StoricoCasi> findDistinctAll();
	
	
	
}
