package beaudoin.appliedapi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/addPosting")
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
}
