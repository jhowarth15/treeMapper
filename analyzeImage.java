package treeMap;

//Need to add commonslogging, httpclient and httpcore jar files to build path for this to run

//// This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class analyzeImage 
{
 public static void main(String[] args) 
 {
     HttpClient httpclient = HttpClients.createDefault();

     String imageURL = "http://www.internationaltimber.com/media/image/uploads/8bd0b80694b1cfbea690ca9ae5447ee3472dab5b.jpg";
     
     try
     {
         URIBuilder builder = new URIBuilder("https://api.projectoxford.ai/vision/v1/analyses");

         builder.setParameter("visualFeatures", "All");

         URI uri = builder.build();
         HttpPost request = new HttpPost(uri);
         request.setHeader("Content-Type", "application/json");
         request.setHeader("Ocp-Apim-Subscription-Key", "e9213e3c0ac2413db66929ec4104d3bf");


         // Request body
         StringEntity reqEntity = new StringEntity("{ \"url\": \"" + imageURL + "\" }");
         request.setEntity(reqEntity);

         HttpResponse response = httpclient.execute(request);
         HttpEntity entity = response.getEntity();

         if (entity != null) 
         {
             System.out.println(EntityUtils.toString(entity));
         }
     }
     catch (Exception e)
     {
         System.out.println(e.getMessage());
     }
 }
}
