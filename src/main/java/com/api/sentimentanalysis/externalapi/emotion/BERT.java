package com.api.sentimentanalysis.externalapi.emotion;

import com.api.sentimentanalysis.config.PropertiesConfig;
import okhttp3.*;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/** This class contains a method to execute the sentiment analysis with BERT model.
 *
 * @author Ariadna de Arriba
 */
public class BERT implements EmotionAnalysisAPI
{
    private String apiKey;
    private Boolean bert;
    private final Properties properties = PropertiesConfig.readProperties();
    private final String baseUrl = properties.getProperty("host") + ":6231/bert/v1/";

    /**
     * Constructor.
     * @param apiKey Api-key to authorize the method.
     * @param bert Boolean to indicate using bert multilingual or beto model.
     */
    public BERT(String apiKey, Boolean bert)
    {
        this.apiKey = apiKey;
        this.bert = bert;
    }

    /** Make a request to BERT for sentiment analysis.
     *
     * @param text Text to analyze.
     * @return Returns a string that contains a json with each of six emotions weighted.
     * @throws NullPointerException {@link NullPointerException caused by an error during a call to the API and returns nothing.}
     * @throws IOException {@link IOException caused by an error in the API call. }
     */
    public String getEmotion(String text) throws NullPointerException, IOException
    {
        if (this.apiKey != null)
        {
            String url = baseUrl + "emotion";
            OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("text", text);
            jsonObject.put("bert", bert);
            String json = jsonObject.toString();

            RequestBody requestBody = RequestBody.create(
                    json,
                    MediaType.parse("application/json"));

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("x-api-key", apiKey)
                    .post(requestBody)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        } else
        {
            throw new NullPointerException("No api-key provided");
        }
    }
}