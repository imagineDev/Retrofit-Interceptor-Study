import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
* 
* Created by Sahil Sharma
* Simple Logging Interceptor for Logging HTTP Requests and Response
*
**/
public class SimpleLoggingInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        long t1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append("\n-----> Sending " + request.method() + " request on : " + request.url());
        sb.append("\n" + request.headers().toString());
        sb.append("\n");
        logger(sb.toString());


        Response response = chain.proceed(request);


        long t2 = System.currentTimeMillis();
        sb = new StringBuilder();
        sb.append(".\n\n<----- Received " + request.method() + " response from : " + response.request().url() + " (" + response.code() + ")" + "  in  "+ (t2 - t1) + " millis");
        sb.append("\n\n" + response.headers().toString());
        sb.append("\n\n" + (response.body() == null ? "-EMPTY BODY-" : response.body().string()));
        logger(sb.toString());


        return response;
    }

    public void logger(String str) {
        //TODO: Print this log
        // Log.d("TAG", str);
    }

}