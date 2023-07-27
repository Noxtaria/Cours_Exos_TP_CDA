package com.example.infrastructurespringdata.repository.impl;

import com.example.infrastructurespringdata.entity.ReportEntity;
import com.example.infrastructurespringdata.exception.NotFoundException;
import com.example.infrastructurespringdata.repository.ReportEntityRepository;
import org.example.entity.Report;
import org.example.port.ReportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    private final ReportEntityRepository reportEntityRepository;
    private final ModelMapper modelMapper;

    public ReportRepositoryImpl(ReportEntityRepository reportEntityRepository, ModelMapper modelMapper) {
        this.reportEntityRepository = reportEntityRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Report save(Report report) {
        ReportEntity reportEntity = modelMapper.map(report, ReportEntity.class);
        return modelMapper.map(reportEntityRepository.save(reportEntity), Report.class);
    }

    @Override
    public Report findById(int id) {
        Optional<ReportEntity> optionalReportEntity = reportEntityRepository.findById(id);
        if(optionalReportEntity.isPresent()){
            return modelMapper.map(optionalReportEntity.get(), Report.class);
        }
        throw new NotFoundException();
    }

    @Override
    public List<Report> findAll() {
       return convertToListReports((List<ReportEntity>) reportEntityRepository.findAll());
    }

    @Override
    public List<Report> findAllByDate(LocalDateTime date) {
        return convertToListReports(reportEntityRepository.findAllByDate(date));
    }

    @Override
    public List<Report> findAllByLocation(double latitude, double longitude) {
        return convertToListReports(reportEntityRepository.findAllByLatitudeAndLongitude(latitude,longitude));
    }

    @Override
    public void delete(Report report) {
        reportEntityRepository.delete(modelMapper.map(report, ReportEntity.class));
    }

    //Convertir une liste de ReportEntity en Liste de Report
    private List<Report> convertToListReports(List<ReportEntity> reportEntities) {
        List<Report> reports = new ArrayList<>();
        reportEntities.forEach(r ->reports.add(modelMapper.map(r, Report.class)));
        return reports;
    }
}
