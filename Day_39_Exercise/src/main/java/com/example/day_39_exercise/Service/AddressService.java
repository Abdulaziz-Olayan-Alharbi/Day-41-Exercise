package com.example.day_39_exercise.Service;


import com.example.day_39_exercise.Api.ApiException;
import com.example.day_39_exercise.DTO.AddressDTO;
import com.example.day_39_exercise.Model.Address;
import com.example.day_39_exercise.Model.Teacher;
import com.example.day_39_exercise.Repository.AddressRepository;
import com.example.day_39_exercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher t = teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if (t == null) {
            throw new ApiException("Teacher Not Found");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), t);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacherId());
        if (address == null) {
            throw new ApiException("Address Not Found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address Not Found");
        }
        addressRepository.delete(address);
    }
}
