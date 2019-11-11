package com.pegs.StudentManagementApp.Service;

import com.pegs.StudentManagementApp.Dao.StudentDaoImpl;
import com.pegs.StudentManagementApp.Model.Student;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.sf.jasperreports.engine.JasperCompileManager.compileReport;

@Service
public class ReportService {

    @Autowired
    private StudentDaoImpl studentDao;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {

        List<Student> students = studentDao.findAll();
        File file = ResourceUtils.getFile("classpath:AcList.jrxml");
        JasperReport jasperReport = compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("Created By" , "Srikanth Mergu");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\Users\\TT124\\Desktop\\jasperReports\\Student.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\TT124\\Desktop\\jasperReports\\Student.pdf");
        }

        return "report generated successfully.";
    }
}
