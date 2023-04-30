package beaudoin.appliedapi.Services;


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
}
