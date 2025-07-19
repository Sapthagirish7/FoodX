package com.sapthagirish.foodx.service.impl;

import com.sapthagirish.foodx.dto.request.DeliveryPartnerRequest;
import com.sapthagirish.foodx.model.DeliveryPartner;
import com.sapthagirish.foodx.repository.DeliverPartnerRepository;
import com.sapthagirish.foodx.service.DeliveryPartnerService;
import com.sapthagirish.foodx.transformer.DeliveryPartnerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {
    final DeliverPartnerRepository deliverPartnerRepository;

    @Autowired
    public DeliveryPartnerServiceImpl(DeliverPartnerRepository deliverPartnerRepository) {
        this.deliverPartnerRepository = deliverPartnerRepository;
    }
    @Override
    public String addPartner(DeliveryPartnerRequest deliveryPartnerRequest) {
        //dto -> entity
        DeliveryPartner deliveryPartner = DeliveryPartnerTransformer.PartnerRequestToDeliveryPartner(deliveryPartnerRequest);

        // save
        DeliveryPartner savedPartner = deliverPartnerRepository.save(deliveryPartner);

        return "You have been successfully regsitered!!!";
    }
}
