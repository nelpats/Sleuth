package fr.nelpats.model.detection.methods;

public abstract class DetectionMethod {

    protected String name;


    public DetectionMethod() {

    }
    public DetectionMethod(String name) {
        this.name = name;
    }


    public abstract boolean getDetection() throws Exception;

    public abstract void setData(double[] inputData);


}
