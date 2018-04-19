
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Sahil Sharma
 * <p>
 * Retrofit 2 Interceptor to check for API Failure and Log these events.
 */

public class ApiFailureInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Response response = chain.proceed(request);

        if (isApiSuccess(response.code())) {
            logApiFailure(response.request().url().toString(), response.code());
        }

        return response;
    }

    private boolean isApiSuccess(int httpStatusCode) {
        return httpStatusCode >= 200 && httpStatusCode < 300;
    }

    private void logApiFailure(String url, int httpStatusCode) {
        Log.e("TAG", "API FAILED : URL = " + url + " ; HttpStatusCode = " + httpStatusCode);
    }

}
