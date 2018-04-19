# Retrofit-Interceptor-Study
Retrofit Interceptor Study - Experiments and Ready to use retrofit interceptors


References:
--------------------

https://github.com/square/okhttp/wiki/Interceptors

https://futurestud.io/tutorials/retrofit-2-manage-request-headers-in-okhttp-interceptor

https://medium.com/@kanishksinha/easily-retrying-network-requests-on-android-with-retrofit2-and-okhttp3-interceptor-ab289e35e342




How to add interceptor:
-------------------------

1. OkHttp Client Builder
   
   OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
   
2. Attach interceptor to the client's builder 

  httpClientBuilder.addInterceptor(new YourInterceptorClass());
  
3. Build OkHttpCLient

  OkHttpClient httpClient = httpClientBuilder.build();
  
4. Initialize Retrofit

  Retrofit retrofit = getRetrofitBuilder().client(httpClient).build();
  
  
Note: 
getRetrofitBuilder() is your class which returns Retrofit.Builder.
