﻿# Sleuth


## What is it ? 🤔

This project is a POC of fraud detection on Minecraft using anomaly detections. The project contains a client with a click recorder, an API, a streamlit application and a jupyter notebook

### Client

The client is coded in Java and can record your clicks and also send requests to the Flask API enabling your to predict anomalies on your click data.


### Server (API)

The API is coded in Flask, and contains a route for IsolationTree as well as well as a route for heuristics. The API also integrates a SVM (support vector machine) which is WIP and just for tests.

### Notebook

The notebook goes in depth about why I did this and how I tested multiple algorithms and used ITree to detect autoclicking behaviours.

### Streamlit

The streamlit app is a data visualization app where you can upload click data as a csv file. Once uploaded you can see the proportion of anomalies in your dataset, as well as plot it.

![streamlit_showcase](https://github.com/nelpats/Sleuth/assets/47573987/25b14819-28d7-4ef3-aa5a-f6196be5ef3d)




