package org.library.Service.Impl;

import lombok.Data;
import org.library.Dto.BorrowerDto;
import org.library.Entity.BorrowerEntity;
import org.library.Repository.BorrowerRepository;
import org.library.Service.BorrowerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowerServiceImpl implements BorrowerService {

    @Autowired
    BorrowerRepository borrowerRepository;


    @Autowired
    ModelMapper modelMapper;

    public boolean addBorrower(BorrowerDto dto){
        BorrowerEntity borrower = modelMapper.map(dto, BorrowerEntity.class);
        borrowerRepository.save(borrower);
        return true;
    }

    public List<BorrowerEntity> getBorrowers(){
        return borrowerRepository.findAll();
    }
}
