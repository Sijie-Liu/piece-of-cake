package handlers;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class GetProductInfoRequestHandler implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();

        JSONObject headerJson = new JSONObject();
        headerJson.put("Access-Control-Allow-Origin", "*");

        JSONObject responseBody = new JSONObject();
        responseBody.put("message", "Hello Jay Liu");

        JSONObject response = new JSONObject();
        response.put("statusCode", "201");
        response.put("headers", headerJson);
        response.put("body", responseBody.toString());

        logger.log("Response: " + response.toJSONString());

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(response.toJSONString());
        writer.close();
    }
}
