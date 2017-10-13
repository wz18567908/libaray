package com.libaray.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

    private Logger logger = Logger.getLogger(PropertyConfigurer.class);

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        DesEncrypter desEncrypter;
        try {
            desEncrypter = DesEncrypter.getInstance();
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            props.setProperty("jdbc.username", desEncrypter.decrypt(username));
            props.setProperty("jdbc.password", desEncrypter.decrypt(password));
            super.processProperties(beanFactoryToProcess, props);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException
                | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
            logger.error(StringUtil.formatErrorLogger(e, "processProperties"));
        }
    }
    
}
