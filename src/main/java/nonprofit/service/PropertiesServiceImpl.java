package nonprofit.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PropertiesServiceImpl implements PropertiesService {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesServiceImpl.class);
	
	private Properties props;
	private static final String PROPERTIES_PATH = "/app/latax/properties/nonprofit.properties";	

	public PropertiesServiceImpl() {
		this.props = loadProps();
	}
	
	@Override
	public Properties getProperties() {
		return props;
	}
	
	private Properties loadProps() {
		Properties newProps = new Properties();
		try {
			//InputStream input = new FileInputStream(PROPERTIES_PATH);
			InputStream input = getClass().getResourceAsStream("/app.properties");
			newProps.load(input);
			return newProps;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Could not load properties file");
		}
		return null;		
	}
}
