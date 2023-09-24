from flask import Flask, request, jsonify
import numpy as np
from sklearn.ensemble import IsolationForest
import csv

app = Flask(__name__)

@app.route('/predict', methods=['POST'])
def predict():
    try:
        input_data = request.json['data']

        input_data = np.array(input_data).reshape(-1, 1)

        model = IsolationForest() # Contamination set to auto

        model.fit(input_data)

        predictions = model.predict(input_data)

        anomalies = input_data[predictions == -1]

        response_data = {
            "sample_size": len(input_data),
            "number_of_anomalies": len(anomalies),
            "anomalies_percent": (len(anomalies) / len(input_data)) * 100
        }

        return jsonify(response_data)

    except Exception as e:
        return jsonify({"error": str(e)})

if __name__ == '__main__':
    app.run(debug=True)
