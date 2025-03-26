/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.adapters.medicalOrders;

import app.adapters.medicalOrders.entity.MedicalOrderEntity;
import app.adapters.medicalOrders.repository.MedicalOrderRepository;
import app.domain.models.MedicalOrder;
import app.ports.MedicalOrderPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viviana
 */
@Service
public class MedicalOrderAdapter implements MedicalOrderPort{
    
    @Autowired
    private MedicalOrderRepository medicalOrderRepository;
    @Override
    public void save(MedicalOrder medicalOrder){
        MedicalOrderEntity medicalOrderEntity = medicalOrderEntityAdapter(medicalOrder);
        medicalOrderRepository.save(medicalOrderEntity);
        medicalOrder.setMedicalOrderId(medicalOrderEntity.getMedicalOrderId());
    }
    @Override
    public MedicalOrder findById(long medicalOrderId){
        MedicalOrderEntity entity = medicalOrderRepository.findById(medicalOrderId).orElse(null);
        if (entity!=null){
            return toDomain(entity);
        }else{
            return null;
        }
    }
    @Override
    public void cancel(MedicalOrder medicalOrder){
        MedicalOrderEntity entity = medicalOrderRepository.findById(medicalOrderId).orElse(null);
        if (entity!=null){
            entity.setCanceled(true);
            medicalOrderRepoditory.save(entity);
        }
    }
            
    
}
