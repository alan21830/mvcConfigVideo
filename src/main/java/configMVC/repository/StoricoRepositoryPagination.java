package configMVC.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import configMVC.model.StoricoCasi;

public interface StoricoRepositoryPagination extends PagingAndSortingRepository<StoricoCasi, Integer>{
	

}
