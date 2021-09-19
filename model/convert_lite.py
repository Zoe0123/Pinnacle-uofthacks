import tensorflow as tf 

SAVED_MODEL_PATH = "saved_model.pb"

# Convert the model using TFLiteConverter
converter = tf.lite.TFLiteConverter.from_saved_model(SAVED_MODEL_PATH)
tflite_model = converter.convert()

with open('model.tflite', 'wb') as f:
    f.write(tflite_model)