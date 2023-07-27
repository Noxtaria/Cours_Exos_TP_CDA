package org.example.service;

import org.example.entity.Report;
import org.example.port.ReportRepository;
import org.example.port.ReportService;

import java.time.LocalDateTime;
import java.util.List;

public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @Override
    public Report createReport(double latitude, double longitude, int level, String comment) {
        //Validation des champs
        Report report = new Report(latitude, longitude, LocalDateTime.now(), level, comment);
        return reportRepository.save(report);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<Report> getReportsByDate(LocalDateTime dateTime) {
        return reportRepository.findAllByDate(dateTime);
    }

    @Override
    public List<Report> getReportsByLocation(double latitude, double longitude) {
        return reportRepository.findAllByLocation(latitude, longitude);
    }

    @Override
    public Report getReportById(int id) {
        return reportRepository.findById(id);
    }

    @Override
    public Report updateReport(int id, Report report) {
        try {
            Report oldReport= getReportById(id);
            oldReport.setComment(report.getComment());
            oldReport.setLevel(report.getLevel());
            oldReport.setLatitude(report.getLatitude());
            oldReport.setLongitude(report.getLongitude());
            return reportRepository.save(oldReport);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public void deleteReport(int id) {
        try {
            Report report = getReportById(id);
            reportRepository.delete(report);
        }catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
