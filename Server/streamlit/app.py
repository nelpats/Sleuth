from sklearn.ensemble import IsolationForest
import scipy.stats as stats
import numpy as np
import streamlit as st
from io import StringIO
import pandas as pd



def predict(data) -> float:
        input_data = np.array(data).reshape(-1, 1)

        model = IsolationForest() # Contamination set to auto

        model.fit(input_data)

        predictions = model.predict(input_data)

        anomalies = input_data[predictions == -1]

        return round((len(anomalies) / len(data)) * 100, 2)


st.title("Slauth")

st.markdown("Check the anomaly score of a click sample !")

uploaded_file = st.file_uploader("Upload your file")

st.info("The file should be a CSV with one column called 'clicks'")
st.warning("Warning: the results may vary each time")

if uploaded_file is not None:
    info_section = st.empty()
    stringio = StringIO(uploaded_file.getvalue().decode("utf-8"))
    df = pd.read_csv(stringio)
    
    info_section.markdown("Here are some facts about your data:")
    anomaly_score = predict(df["clicks"])
    
    if anomaly_score < 45.00:
            info_section.success(f"This sample is likely human ! (**{anomaly_score} %**)")     
    elif anomaly_score > 45.00 and anomaly_score < 65.00:
            info_section.warning(f"This sample is suspicious, it might be fake 🤔 (**{anomaly_score} %**)")
    elif anomaly_score > 65.00:
            info_section.error(f"This sample is fake ! (**{anomaly_score} %**)")
                
    analytics = st.empty()
    
    analytics_checkbox = st.checkbox("Show analytics")   
    
    if analytics_checkbox:
        info_section.scatter_chart(
                df,
                x=None,
                y='clicks',
        )
    
    

