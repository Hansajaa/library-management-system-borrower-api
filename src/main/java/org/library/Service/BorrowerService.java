package org.library.Service;

import org.library.Dto.BorrowerDto;
import org.library.Entity.BorrowerEntity;

import java.util.List;

public interface BorrowerService {

    boolean addBorrower(BorrowerDto dto);

    List<BorrowerEntity> getBorrowers();

    boolean deleteBorrower(Long id);
}
