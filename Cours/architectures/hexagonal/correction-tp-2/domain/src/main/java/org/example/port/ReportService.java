package org.example.port;

import org.example.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportService {
    Report createReport(double latitude, double longitude, int level, String comment);
    List<Report> getAllReports();
    List<Report> getReportsByDate(LocalDateTime dateTime);
    List<Report> getReportsByLocation(double latitude, double longitude);
    Report getReportById(int id);
    Report updateReport(int id, Report report);
    void deleteReport(int id);
}
