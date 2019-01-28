package com.example.campaigns;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/campaign")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    private double yourAcound;

    CampaignController(){
        setYourAcound(100000.23);
    }



    @RequestMapping(value="/campaign", method = RequestMethod.GET)
    public ModelAndView campaign(){
    Campaign campaign= new Campaign();
    campaign.setStatus("on");
    ModelAndView modelAndView=new ModelAndView("campaign","command",campaign);
    return modelAndView;
    }


    @RequestMapping(value="/savecampaign", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("campaign_list") Campaign campaign) {
        campaignService.save(campaign);

        return new ModelAndView("campaign_list");
    }

    @GetMapping("/list")
    public List<Campaign> getAllCampaigns(){
        return campaignService.findAll();
    }


    @GetMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable("id") Long id){
        Campaign campaign=campaignService.findOneCampaign(id);

        return ResponseEntity.ok().body(campaign);
    }

    @PutMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable("id") Long id,@Valid @RequestBody Campaign campaignDetails){
        Campaign campaign= campaignService.findOneCampaign(id);

        campaign.setNameOfCampaign(campaignDetails.getNameOfCampaign());
        campaign.setKeywords(campaignDetails.getKeywords());
        if(yourAcound>campaignDetails.getCampaignFund()) {
            if (campaignDetails.getBidAmount() != 0 && campaignDetails.getCampaignFund() != 0) {
                if (campaignDetails.getBidAmount() < 0) {
                    double value = campaignDetails.getBidAmount() * -1;
                    campaign.setBidAmount(value);
                    double operationValue=yourAcound-value;
                    setYourAcound(operationValue);
                } else if (campaignDetails.getCampaignFund() < 0) {
                    double value = campaignDetails.getCampaignFund() * -1;
                    double operationValue=yourAcound-value;
                    setYourAcound(operationValue);
                    campaign.setCampaignFund(value);
                }
            }
        }
        campaign.setTown(campaignDetails.getTown());
        campaign.setRadius(campaignDetails.getRadius());
        Campaign updateCampaign = campaignService.save(campaign);

        return ResponseEntity.ok().body(updateCampaign);
    }

    @ModelAttribute("townList")
    public List<String> getTownList(){
        ArrayList<String> townList= new ArrayList<String>();
        townList.add("London");
        townList.add("New York");
        townList.add("Paris");
        townList.add("Berlin");
        return townList;
    }




    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Campaign> deleteCampaign (@PathVariable("id") Long id){
        Campaign campaign=campaignService.findOneCampaign(id);
        campaignService.deleteCampaign(campaign);
        return ResponseEntity.ok().build();
    }

    private void setYourAcound(double yourAcound){
        this.yourAcound=yourAcound;
    }
    public double getYourAcound(){
        return yourAcound;
    }
}
