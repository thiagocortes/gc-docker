package br.com.cortes.codestate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class CodestateApplication {
    private static final String serverUrl1 = "State Json";
    private static final String serverUrl2 = "Title Case Json";

    public static void main(String[] args) {
        SpringApplication.run(CodestateApplication.class, args);
    }
    public static String requestProcessData(int urlId){
        String serverUrl = null;
        if(urlId == 1)
            serverUrl = serverUrl1;
        else if (urlId == 2)
            serverUrl = serverUrl2;
        else
            return "ERROR";

        return serverUrl;
    }

    @GetMapping("/")
    public static String hello(){
        return "HELLO IM DATA READER";
    }
    @GetMapping("/readDataForCode")
    public static String requestCodeData(){
        return requestProcessData(1);
    }
    @GetMapping("/readDataForState")
    public static String requestStateData(){
        return requestProcessData(2);
    }
}
