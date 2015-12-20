package com.khai.training.util;

import com.khai.training.entity.Proverb;
import com.khai.training.repository.ProverbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Дубинин on 01.11.2015.
 */
@Component
public class ProverbUtil {
    @Autowired
    private ProverbRepository proverbRepository;
    private List<String> proverbs;
    private Random random = new Random();

    public String getProverbs(){
        if(proverbs == null){
            init();
        }
        return proverbs.get(random.nextInt(proverbs.size()));
    }

    private void init(){
        proverbs = new ArrayList<String>();
        for (Proverb proverb : proverbRepository.listAll()){
            proverbs.add(proverb.getProverb());
        }
    }
}
