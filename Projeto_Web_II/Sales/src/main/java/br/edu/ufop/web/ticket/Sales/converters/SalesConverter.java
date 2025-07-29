package br.edu.ufop.web.ticket.Sales.converters;

import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.EventsModel;
import br.edu.ufop.web.ticket.Sales.models.SalesModel;

public class SalesConverter {

    public static SimpleSalesRecordDTO toSimpleSalesRecordDTO(SalesModel salesModel){
        return new SimpleSalesRecordDTO(salesModel.getId(), salesModel.getUserId(), salesModel.getEventModel().getId(), salesModel.getPurchaseStatus());
    }

    public static SalesDomain toSalesDomain(SimpleSalesRecordDTO simpleSalesRecordDTO) {
        return SalesDomain.builder().id(simpleSalesRecordDTO.id()).userId(simpleSalesRecordDTO.userId()).eventId(simpleSalesRecordDTO.eventId()).purchaseStatus(simpleSalesRecordDTO.purchaseStatus()).build();
    }

    public static SalesModel toSalesModel(SalesDomain salesDomain, EventsModel event) {
        return SalesModel.builder().id(salesDomain.getId()).userId(salesDomain.getUserId()).eventModel(event).purchaseDate(salesDomain.getPurchaseDate()).purchaseStatus(salesDomain.getPurchaseStatus()).build(); //? REVIEW THIS LINE
    }

    public static SalesDomain toSalesDomain(CreateSaleDTO createSaleDTO) {
        return SalesDomain.builder().eventId(createSaleDTO.eventId()).userId(createSaleDTO.userId()).purchaseStatus(createSaleDTO.purchaseStatus()).build();
    }
}
