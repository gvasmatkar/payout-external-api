package com.paymaya.payout.daoImpl;



import java.util.HashMap;

import org.json.Cookie;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paymaya.payout.dao.PayoutExternalAPILoginDao;
import com.paymaya.payout.model.CookieObj;
import com.paymaya.payout.model.UserJsonResponse;  

@Repository
public class PayoutExternalAPILoginDaoImpl implements PayoutExternalAPILoginDao{
	
	@Autowired
    private RestTemplateBuilder restTemplateBuilder;
	
	@Autowired
	UserJsonResponse userJsonResponse;
	
//	public User saveData(User requestUser) {
//
//        String url = "https://sandbox-payout.paymaya.com";
//
//        ResponseEntity<String> result = restTemplateBuilder.build().postForEntity(url, requestUser, String.class);
//
//        return user;
//    }

	@Override
	public UserJsonResponse generateCSRFToken() {

        String url = "https://sandbox-payout.paymaya.com/csrfToken";

        ResponseEntity<String> result = restTemplateBuilder.build().
                exchange(url,
                        HttpMethod.GET, null, String.class);
        String userJson ="";
        final ObjectMapper objectMapper = new ObjectMapper();
          
        JSONObject csrfJsonObject = new JSONObject(result.getBody());
        JSONObject sessionCookieObj = new JSONObject(result.getHeaders().toSingleValueMap());
        
        	 try {
				userJson  = objectMapper.writeValueAsString(result.getBody().toString());
				
			      String jsonStr = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(sessionCookieObj.get("set-cookie"));
			      JSONObject cookieJsonObj = Cookie.toJSONObject(jsonStr);

			      System.out.println("Deserializing JSON to Object:");
			      CookieObj cookieObj = objectMapper.readValue(cookieJsonObj.toString(), CookieObj.class);

			      userJsonResponse.setCookieObj(cookieObj);
			      userJsonResponse.setCsrfToken(csrfJsonObject.get("_csrf").toString());
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        return userJsonResponse;
    }

	@Override
	public Boolean initiateSession(HashMap<String, Object> userDetails) {
		// TODO Auto-generated method stub
		return null;
	}

}
