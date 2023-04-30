package beaudoin.appliedapi.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import beaudoin.appliedapi.Models.Posting;
import beaudoin.appliedapi.Repositories.PostingRepository;

@Service
public class PostingService {
    private PostingRepository postingRepo;

    public PostingService(PostingRepository postingRepository) {
        this.postingRepo = postingRepository;
    }

    public void addPost(Posting posting) {
        postingRepo.save(posting);
    }

    public Posting findPostingById(Integer id) {
        Optional<Posting> opt = postingRepo.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        return new Posting();
    }

    public boolean deletePosting(Integer id) {
        if(!postingRepo.findById(id).isEmpty()) {
            postingRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List findAllPostings() {
        List<Posting> postings = (List<Posting>) postingRepo.findAll();
        return postings;
    }

    public Posting updatePosting(Posting newPosting, Integer id) {
        Posting oldPosting = postingRepo.findById(id).get();
        if(oldPosting != null) {
            oldPosting.setTitle(newPosting.getTitle());
            oldPosting.setisChecked(newPosting.getIsChecked());
            postingRepo.save(oldPosting);
            return oldPosting;
        }
        return null;
    }
}
