package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.Sales.converters.SalesConverter;
import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;
import br.edu.ufop.web.ticket.Sales.models.SalesModel;
import br.edu.ufop.web.ticket.Sales.repositories.IEventsRepository;
import br.edu.ufop.web.ticket.Sales.repositories.ISalesRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SalesService {
    
    private final ISalesRepository salesRepository;
    private final IEventsRepository eventRepository;

    // GET all sales
    public List<SimpleSalesRecordDTO> getAllSales() {
        List<SalesModel> salesList = salesRepository.findAll();

        return salesList.stream().map(SalesConverter::toSimpleSalesRecordDTO).toList();
    }

    // CREATE (POST) new sale
    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO) {
        EventsModel event = eventRepository.findById(createSaleDTO.eventId()).orElseThrow(() -> new RuntimeException("Event not found"));

        SalesDomain domain = SalesConverter.toSalesDomain(createSaleDTO);

        SalesModel model = SalesConverter.toSalesModel(domain, event);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(model));
    }
}
