package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.Sales.converters.SalesConverter;
import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.SalesModel;
import br.edu.ufop.web.ticket.Sales.repositories.ISalesRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SalesService {
    
    private final ISalesRepository salesRepository = null;

    // GET all sales
    public List<SimpleSalesRecordDTO> getAllSales() {
        List<SalesModel> salesList = salesRepository.findAll();

        return salesList.stream().map(SalesConverter::toStiSimpleSalesRecordDTO).toList();
    }

    // CREATE (POST) new sale
    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO) {
        SalesDomain domain = SalesConverter.toSalesDomain(createSaleDTO);

        SalesModel model = SalesConverter.toSalesModel(domain);

        return SalesConverter.toStiSimpleSalesRecordDTO(salesRepository.save(model));
    }
}
