package br.edu.ufop.web.ticket.Sales.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.ufop.web.ticket.Sales.converters.SalesConverter;
import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.DeleteSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.dtos.UpdatePurchaseStatusDTO;
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

    // GET 
    public List<SimpleSalesRecordDTO> getAllSales() {
        List<SalesModel> salesList = salesRepository.findAll();

        return salesList.stream().map(SalesConverter::toSimpleSalesRecordDTO).toList();
    }

    // POST
    public SimpleSalesRecordDTO createSale(CreateSaleDTO createSaleDTO) {
        EventsModel event = eventRepository.findById(createSaleDTO.eventId()).orElseThrow(() -> new RuntimeException("Event not found"));

        SalesDomain domain = SalesConverter.toSalesDomain(createSaleDTO);
        SalesModel model = SalesConverter.toSalesModel(domain, event);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(model));
    }

    // PUT
    public SimpleSalesRecordDTO updatePurchaseType(UpdatePurchaseStatusDTO updatePurchaseStatusDTO){
        EventsModel event = eventRepository.findById(updatePurchaseStatusDTO.eventId()).orElseThrow(() -> new RuntimeException("Oops... Something went wrong"));

        SalesDomain domain = SalesConverter.toSalesDomain(updatePurchaseStatusDTO);
        SalesModel model = SalesConverter.toSalesModel(domain, event);

        return SalesConverter.toSimpleSalesRecordDTO(salesRepository.save(model));
    } 

    // DELETEA
    public void deleteSale(DeleteSaleDTO deleteSaleDTO){
        Optional<SalesModel> optional = salesRepository.findById(deleteSaleDTO.id());
        salesRepository.delete(optional.get());
    }
}
