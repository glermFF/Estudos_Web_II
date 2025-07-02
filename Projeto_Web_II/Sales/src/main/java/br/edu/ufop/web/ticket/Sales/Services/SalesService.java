package br.edu.ufop.web.ticket.Sales.Services;


import br.edu.ufop.web.ticket.Sales.converters.SalesConverter;
import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.SalesModel;
import br.edu.ufop.web.ticket.Sales.repositories.ISalesRepository;

public class SalesService {
    
    private ISalesRepository salesRepository;

    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO) {
        SalesDomain domain = SalesConverter.toSalesDomain(createSaleDTO);

        SalesModel model = SalesConverter.toSalesModel(domain);

        return SalesConverter.toStiSimpleSalesRecordDTO(salesRepository.save(model));
    }
}
