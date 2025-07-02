package br.edu.ufop.web.ticket.Sales.converters;

import br.edu.ufop.web.ticket.Sales.domain.SalesDomain;
import br.edu.ufop.web.ticket.Sales.dtos.CreateSaleDTO;
import br.edu.ufop.web.ticket.Sales.dtos.SimpleSalesRecordDTO;
import br.edu.ufop.web.ticket.Sales.models.SalesModel;

public class SalesConverter {

    public static SimpleSalesRecordDTO toStiSimpleSalesRecordDTO(SalesModel salesModel){
        return new SimpleSalesRecordDTO(salesModel.getId(), salesModel.getUserId(), salesModel.getEventId(), salesModel.getPurchaseStatus());
    }

    public static SalesDomain toSalesDomain(SimpleSalesRecordDTO simpleSalesRecordDTO) {
        return SalesDomain.builder().id(simpleSalesRecordDTO.id()).userId(simpleSalesRecordDTO.userId()).eventId(simpleSalesRecordDTO.eventId()).purchaseStatus(simpleSalesRecordDTO.purchaseStatus()).build();
    }

    public static SalesModel toSalesModel(SalesDomain salesDomain) {
        return SalesModel.builder().id(salesDomain.getId()).userId(salesDomain.getUserId()).eventId(salesDomain.getEventId()).purchaseDate(salesDomain.getPurchaseDate()).purchaseStatus(salesDomain.getPurchaseStatus()).createdAt(salesDomain.getCreatedAt()).updatedAt(salesDomain.getUpdatedAt()).build();
    }

    public static SalesDomain toSalesDomain(CreateSaleDTO createSaleDTO) {
        return CreateSaleDTO.builder().eventId(createSaleDTO.eventId()).userId(createSaleDTO.userId()).purchaseStatus(createSaleDTO.purchaseStatus()).build();
    }
}
