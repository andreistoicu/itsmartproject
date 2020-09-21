package com.smart.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.smart.entity.JoinResponse;

@Service
public class MergeServiceImpl implements UserLogDataService{

	Logger logger = LoggerFactory.getLogger(MergeServiceImpl.class);
	
	@Autowired
    private Environment env;
	
	@Autowired
	EntityManagerFactory emf;

	@Override
	public String mergeTables() {
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select u.customerId, u.userRole,u.vfssoUserName, u.vfssoStatus, u.contactId, ld.userName,"
				+ " ld.lastLogin, ld.lastLogout "
				+ "from User u "
				+ "left join LogsData ld "
				+ "on ld.userName = u.vfssoUserName");
		
		//map the result to result
		@SuppressWarnings("unchecked")
		List<Object[]> rows = query.getResultList();
		List<JoinResponse> result = new ArrayList<>(rows.size());
		for (Object[] row : rows) {
		    result.add(new JoinResponse((String) row[0], (String) row[1], (String) row[2],(String) row[3],
		                            	(String) row[4], (String) row[5], (String) row[6]));
		}
		
		em.close();
		
		String COMMA_DELIMITER = ",";
		String NEW_LINE_SEPARATOR = "\r\n";
		String FILE_HEADER = "CUSTOMER_ID, USSERROLE, VFSSOUSERNAME, VFSSOSTATUS, CONTACT_ID, LAST_LOGIN, LAST_LOGOUT";
		 
		try {
			PrintWriter pw = new PrintWriter(new File(env.getProperty("app.csvOutputFileLocation")));
			StringBuilder sb = new StringBuilder();
			sb.append(FILE_HEADER);
			sb.append(NEW_LINE_SEPARATOR);
			 
			//map each line with separator and delimiter for a csv format
			for(JoinResponse line: result) {
				sb.append(line.getCustomerId());
				sb.append(COMMA_DELIMITER);
				sb.append(line.getUserRole()); 
				sb.append(COMMA_DELIMITER);
				sb.append(line.getVfssoUserName());
				sb.append(COMMA_DELIMITER);
				sb.append(line.getVfssoStatus());
				sb.append(COMMA_DELIMITER);
				sb.append(line.getContactId());
				sb.append(COMMA_DELIMITER);
				sb.append(line.getLastLogin());
				sb.append(COMMA_DELIMITER);
				sb.append(line.getLastLogout());
				sb.append(NEW_LINE_SEPARATOR);
			 }
			 
			 pw.write(sb.toString());
			 pw.close();
			 logger.warn("=======================================================================");
			 logger.error("DONE MERGING FILES ");
			 logger.warn("=======================================================================");
			 
		} catch(Exception e) {
			 e.printStackTrace();
		}
		 
		return "Please check the output location of the mergedFiles.csv on resource folder";
		
	}

}
