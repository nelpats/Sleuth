package fr.nelpats.model.detection.methods.response;

import com.google.gson.annotations.SerializedName;

public class IsolationForestResponse {
    @SerializedName("sample_size")
    public int sampleSize;

    @SerializedName("number_of_anomalies")
    public int numberOfAnomalies;

    @SerializedName("anomalies_percent")
    public double anomaliesPercent;

}