package com.api.sentimentanalysis.externalapi;

public class EmotionAnalysisAPIFactory
{
    public static EmotionAnalysisAPI getEmotionAnalysisAPI(String api, String apiKey)
    {
        if ("ParallelDots".equalsIgnoreCase(api)) return new ParallelDots(apiKey);
        return null;
    }
}
