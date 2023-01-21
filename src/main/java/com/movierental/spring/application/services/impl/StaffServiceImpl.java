package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.dtos.StaffDto;
import com.movierental.spring.application.entities.Staff;
import com.movierental.spring.application.mappers.StaffMapper;
import com.movierental.spring.application.repositories.StaffRepository;
import com.movierental.spring.application.services.StaffService;
import com.movierental.spring.exceptions.ResourceNotFoundException;
import com.movierental.spring.validators.CustomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;
    private final CustomValidator customValidator;

    @Override
    public List<StaffDto> findAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                .map(staffMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto findStaffById(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Staff member with id: " + id + " does not exist."));
        return staffMapper.toDto(staff);
    }

    @Override
    public StaffDto createStaff(StaffDto dto) {
        Staff staff = staffMapper.toEntity(dto);
        staffRepository.save(staff);
        return staffMapper.toDto(staff);
    }

//    @Override
//    public MovieDto updateF(Long id, MovieTitleUpdateDto movieUpdateDto) {
//        Optional<Movie> movieOptional = staffRepository.findById(id);
//        if (movieOptional.isPresent() && movieUpdateDto != null) {
//            Movie movie = movieOptional.get();
//            customValidator.validateValueLength(movieUpdateDto.getTitle(), "Title");
//            staffMapper.toDto(movie);
//            movie.setTitle(movieUpdateDto.getTitle());
//            movie = staffRepository.save(movie);
//            return staffMapper.toDto(movie);
//        }
//        throw new ResourceNotFoundException("Movie with id: " + id + " not found.");
//    }

//    @Override
//    public MovieDto updateDescription(Long id, MovieDescriptionUpdateDto movieUpdateDto) {
//        Optional<Movie> movieOptional = staffRepository.findById(id);
//        if (movieOptional.isPresent() && movieUpdateDto != null) {
//            Movie movie = movieOptional.get();
//            customValidator.validateValueLength(movieUpdateDto.getDescription(), "Description");
//            staffMapper.toDto(movie);
//
//            movie.setDescription(movieUpdateDto.getDescription());
//            movie = staffRepository.save(movie);
//            return staffMapper.toDto(movie);
//        }
//        throw new ResourceNotFoundException("Movie with id: " + id + " not found.");
//    }

    @Override
    public void deleteStaffById(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Staff member with id: " + id + " not found."));
        staffRepository.delete(staff);
    }

    @Override
    public boolean deleteAllStaffMembers() {
        long countBefore = staffRepository.count();
        staffRepository.deleteAll();
        long countAfter = staffRepository.count();
        return countAfter < countBefore;
    }
}
