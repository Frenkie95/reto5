package com.example.reto3.service;




import com.example.reto3.entities.Score;
import com.example.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return  scoreRepository.getAll();

    }
    public Optional<Score>getScore(int id){
        return scoreRepository.getScore(id);

    }

    public Score update(Score c) {
        if (c.getId() != null) {
            Optional<Score> q = scoreRepository.getScore(c.getId());
            if (q.isPresent()) {
                if (c.getMessageText() != null) {
                    q.get().setMessageText(c.getMessageText());
                }
            }

            if (c.getStars() != null) {
                q.get().setStars(c.getStars());
            }
             scoreRepository.save(q.get());
            return q.get();
        }else{
            return c;
        }

    }


    public Score save(Score c) {
        if (c.getId() == null) {
            return scoreRepository.save(c);
        } else {
            Optional<Score> e =  scoreRepository.getScore(c.getId());
            if (e.isPresent()){
                return c;
            }else {
                return scoreRepository.save(c);
            }

        }


    }

    public boolean delete (int id ){
        boolean d = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return d;


    }

}
