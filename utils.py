import requests
from bs4 import BeautifulSoup
import tensorflow as tf
import numpy as np

WEATHER_URL = "https://weather.com/en-CA/weather/today/l/d8ccf908e3c4c748e232720575df7cdbca6e0f1b412bca8595d8a28d0c28e8bc"
COVID_URL = "https://www.toronto.ca/home/covid-19/covid-19-financial-social-support-for-people/covid-19-guide-for-toronto-residents/"

def get_weather():
    htmldata = requests.get(WEATHER_URL).text
    soup = BeautifulSoup(htmldata, 'html.parser')

    current_temp = str(soup.find_all("span",
							class_="CurrentConditions--tempValue--3a50n"))[-11:-9]
    chances_rain = str(soup.find_all("div",
							class_="CurrentConditions--precipValue--3nxCj"))[-45:-44]

    result = "current_temp " + current_temp + " Centidegree in toronto, and " + chances_rain + "% chance of rain"

    print(f"weather_broadcast: {result}")

    if current_temp > 15 and chances_rain < 30: 
        weather_cond = '0'
    elif current_temp > 0 and chances_rain < 50:
        weather_cond = '1'
    else:
        weather_cond = '2'
    
    return weather_cond

def get_covid_cond():
    htmldata = requests.get(COVID_URL).text

    soup = BeautifulSoup(htmldata, 'html.parser')

    open_stage = str(soup.find_all("div",
							class_="highlightedcontent"))[51:57]
    if "One" in open_stage:
        covid_cond = 2
    elif "Two" in open_stage:
        covid_cond = 1
    else:
        covid_cond = 0

    return covid_cond

# # TFLite inference in python 
# def __main__(user_input):

#     input = user_input + get_weather()+ get_covid_cond()
    # # Load the TFLite model and allocate tensors.
    # interpreter = tf.lite.Interpreter("/content/model.tflite")
    # interpreter.allocate_tensors()

    # # Get input and output tensors.
    # input_details = interpreter.get_input_details()
    # output_details = interpreter.get_output_details()

    # # Test the model on random input data.
    # input_shape = input_details[0]['shape']
    # input_data = np.array(np.random.random_sample(input_shape), dtype=np.float32)
    # interpreter.set_tensor(input_details[0]['index'], input_data)

    # interpreter.invoke()

    # # The function `get_tensor()` returns a copy of the tensor data.
    # # Use `tensor()` in order to get a pointer to the tensor.
    # output_data = interpreter.get_tensor(output_details[0]['index'])
    # print(output_data)
    
def __main__():
    str = get_weather() + "" + get_covid_cond()
    # print str 
    print(str)
