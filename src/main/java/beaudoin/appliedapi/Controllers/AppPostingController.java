package beaudoin.appliedapi.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import beaudoin.appliedapi.Models.Posting;
import beaudoin.appliedapi.Services.PostingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AppPostingController {
    private PostingService postingService;

    public AppPostingController(PostingService postingService) {
        this.postingService = postingService;
    }

    @PostMapping("/postings")
    public ResponseEntity<Integer> addPosting(@RequestBody Posting posting) {
        postingService.addPost(posting);
        return new ResponseEntity<>(posting.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/postings/{id}")
    public ResponseEntity<Posting> getPosting(@PathVariable Integer id) {
        Posting posting = postingService.findPostingById(id);
        if(posting.getTitle() != null) {
            return new ResponseEntity<>(posting, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/postings")
    public ResponseEntity<List<Posting>> getPostings() {
        List postings = postingService.findAllPostings();
        if(postings.size() > 0)
            return new ResponseEntity<List<Posting>>(postings, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/postings/{id}")
    public ResponseEntity<Integer> deletePosting(@PathVariable Integer id) {
        if(postingService.deletePosting(id)) {
            return new ResponseEntity<Integer>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/postings/{id}")
    public ResponseEntity<Void> updatePosting(@PathVariable Integer id, @RequestBody Posting newPosting) {
        if(postingService.updatePosting(newPosting, id) != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
