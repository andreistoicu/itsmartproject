package com.smart;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.directory.api.ldap.model.entry.Attribute;
import org.apache.directory.api.ldap.model.ldif.LdapLdifException;
import org.apache.directory.api.ldap.model.ldif.LdifEntry;
import org.apache.directory.api.ldap.model.ldif.LdifReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.smart.entity.LogsData;
import com.smart.entity.User;
import com.smart.repository.LogDataRepository;
import com.smart.repository.UserRepository;


@Configuration
public class LoadDataBase {
	
    Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

	@Autowired
    private Environment env;

	@Bean
	CommandLineRunner initCsvDatabase(UserRepository userRepository, LogDataRepository logDataRepository) {

		return args -> {
			
			//user path
			String line = "";
			String fileCsv = env.getProperty("app.csvFileLocation");
			
			//log data path
			String fileLdif = env.getProperty("app.ldifFileLocation");
			File file =  new File(fileLdif);
			
			logger.warn("=======================================================================");
			logger.error("CSV and Ldif files are LOADING , PLEASE WAIT THE SUCCCESS MESSAGE ");
			logger.warn("=======================================================================");

			// read the .csv file
			BufferedReader brCsv = new BufferedReader(new FileReader(fileCsv));
			
			//read without first line (header) - use a count for this configurable in the application.properties
			int counter = Integer.parseInt(env.getProperty("app.csv.header"));
			
			while ((line = brCsv.readLine()) != null) {
				if(counter>1){
					String[] data = line.split(",");
	
					String customerId = data[0];
					String userRole = data[1];
					String vfssoUserName = data[2];
					String vfssoStatus = data[3];
					String contactId = data[4];
	
					//save in SQL DB - not mandatory
					userRepository.save(new User(customerId, userRole, vfssoUserName, vfssoStatus, contactId));
				}
				counter++;
			};
			brCsv.close();
			
			logger.warn("======================================================================");
			logger.warn("-----SUCCESSFULLY LOADED THE CSV FILE -----");
			logger.warn("======================================================================");
			
			//read .ldif file
			logger.warn("=======================================================================");
			logger.error("CSV and Ldif files are LOADING , PLEASE WAIT THE SUCCCESS MESSAGE ");
			logger.warn("=======================================================================");
			
			
			try {
				@SuppressWarnings("resource")
				LdifReader ldifReader = new LdifReader(file);
				
				while(ldifReader.hasNext()) {
					LdifEntry ldifEntry = ldifReader.next();
					Attribute attrUsername = ldifEntry.get("username");
					Attribute attrLastLogin = ldifEntry.get("lastLogin");
					Attribute attrLastLogout = ldifEntry.get("lastLogout");
					
					String username = attrUsername.toString().substring(10);
					String lastLogin = attrLastLogin.toString().substring(11);
					String lastLogout = attrLastLogout.toString().substring(12);
					
					//save in SQL DB - not mandatory
					logDataRepository.save(new LogsData(username, lastLogin, lastLogout ));
					//System.out.println("\"" + username + "\",\"" + lastLogin + "\",\"" + lastLogout + "\"");
				}
				
			} catch (LdapLdifException e) {
				e.printStackTrace();
			}
			
			logger.warn("======================================================================");
			logger.warn("-----SUCCESSFULLY LOADED THE LDIF FILE -----");
			logger.warn("======================================================================");
			

		};
	}

}








