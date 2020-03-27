package configMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import configMVC.model.StoricoCasi;

public interface StoricoRepositoryJPA extends JpaRepository<StoricoCasi,Integer> {

	List<StoricoCasi> findByData(Date data);
	
	
}
