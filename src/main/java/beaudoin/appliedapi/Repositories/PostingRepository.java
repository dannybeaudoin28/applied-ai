package beaudoin.appliedapi.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import beaudoin.appliedapi.Models.Posting;

@Repository
public interface PostingRepository extends CrudRepository<Posting, Integer>{
        
}
