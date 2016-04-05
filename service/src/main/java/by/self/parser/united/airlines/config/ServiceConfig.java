package by.self.parser.united.airlines.config;

import by.self.parser.united.airlines.parser.interf.Parser;
import by.self.parser.united.airlines.service.impl.*;
import by.self.parser.united.airlines.service.interf.*;
import by.self.parser.united.airlines.parser.impl.*;
import by.self.parser.united.airlines.utils.Helper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"by.self.parser.united.airlines"})
public class ServiceConfig {

    @Bean
    public Driver phantomDriver() {
        return new PhantomDriver();
    }

    @Bean
    public JsonConverter jsonConverter() {
        return new JsonConverterImpl();
    }

    @Bean
    public Parser parserUnited() {
        return new ParserUnited();
    }

    @Bean
    public LocatorWrapper locatorWrapper() {
        return new LocatorWrapperImpl();
    }

    @Bean
    public ClassParser classParser() {
        return new ClassParser();
    }

    @Bean
    public FlightParser flightParser() {
        return new FlightParser();
    }

    @Bean
    public InfoParser infoParser() {
        return new InfoParser();
    }

    @Bean
    public ExtraDataParser extraDataParser() {
        return new ExtraDataParser();
    }

    @Bean
    public Converter converter() {
        return new ConverterImpl();
    }

    @Bean
    public Helper helper() {
        return new Helper();
    }
}
