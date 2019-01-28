package com.example.campaigns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    @Autowired
    CampaignRepository campaignRepository;

    public Campaign save(Campaign campaign){
        return campaignRepository.save(campaign);
    }

    public List<Campaign> findAll(){
        return campaignRepository.findAll();
    }

    public Campaign findOneCampaign(long id){
        return campaignRepository.findById(id).orElseThrow(()->new CampaignNotFoundException(id));

    }

    public void deleteCampaign(Campaign campaign){
        campaignRepository.delete(campaign);
    }
}
