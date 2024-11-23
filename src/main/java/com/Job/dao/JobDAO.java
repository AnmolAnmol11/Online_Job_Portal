package com.Job.dao;



import com.Job.model.Job;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {
    private Connection connection;

    public JobDAO(Connection connection) {
        this.connection = connection;
    }

    // Create a new job
    public boolean createJob(Job job) throws SQLException {
        String query = "INSERT INTO jobs (title, description, company_name, location, salary, employment_type, posted_by, posted_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, job.getTitle());
        ps.setString(2, job.getDescription());
        ps.setString(3, job.getCompanyName());
        ps.setString(4, job.getLocation());
        ps.setDouble(5, job.getSalary());
        ps.setString(6, job.getEmploymentType());
        ps.setInt(7, job.getPostedBy());
        ps.setString(8, job.getPostedDate());
        return ps.executeUpdate() > 0;
    }

    // Get job by ID
    public Job getJobById(int jobId) throws SQLException {
        String query = "SELECT * FROM jobs WHERE job_id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, jobId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Job(
                rs.getInt("job_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("company_name"),
                rs.getString("location"),
                rs.getDouble("salary"),
                rs.getString("employment_type"),
                rs.getInt("posted_by"),
                rs.getString("posted_date")
            );
        }
        return null;
    }

    // Get all jobs
    public List<Job> getAllJobs() throws SQLException {
        String query = "SELECT * FROM jobs";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(
                rs.getInt("job_id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("company_name"),
                rs.getString("location"),
                rs.getDouble("salary"),
                rs.getString("employment_type"),
                rs.getInt("posted_by"),
                rs.getString("posted_date")
            ));
        }
        return jobs;
    }
}
