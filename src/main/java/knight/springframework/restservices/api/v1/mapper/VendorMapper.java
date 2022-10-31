package knight.springframework.restservices.api.v1.mapper;

import knight.springframework.restservices.api.v1.mod.VendorDTO;
import knight.springframework.restservices.model.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);
    VendorDTO vendorToVendorDTO(Vendor vendor);
    Vendor vendorDTOToVendor(VendorDTO vendorDTO);

}
