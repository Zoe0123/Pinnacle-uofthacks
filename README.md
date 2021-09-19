# Catch - APP to make recommendation about plan B

## Inspiration
It goes without saying, 2020 was extremely challenging for us to get together and connect with other people. Dates fell through due to the difficulty to foresee things that would cancel a plan.

We were literally inspired by our frustrations and wanted to create something that would gently remind people of planning mishaps and also propose alternative ideas!

## What it does
Catch is a mobile app that helps users plan dates better by checking logistical problems. We’re only human, and sometimes life gets so busy we don’t check everything. Catch has got you covered, by checking your date for you.

It also suggests related date ideas, giving you plan b if things fall through.

## languages and Platforms
Java, Python, Tensorflow, Tensorflow Lite

Android Studio (build the mobile app), Google Colab (train the neural network)

## Credits

https://www.tensorflow.org/lite/guide/android

https://www.tensorflow.org/lite/examples/recommendation/overview

https://www.journaldev.com/9231/android-spinner-drop-down-list

https://www.journaldev.com/1050/java-timer-timertask-example

## Authors
Eunice Yan, Zoe Zhou

## Complete project link

https://devpost.com/software/catch-wqyn5j

## Prototype

https://www.figma.com/file/5cvatXbYAXvHnlGlC1fzyX/Pinnacle-2021?node-id=0%3A1

## Installation

```
conda create -n tf tensorflow
conda install pandas
conda install -c anaconda requests 
conda install -c anaconda beautifulsoup4
```
## To play with the app

1. Git clone this repository.
2. Open Android Studio (download if you haven't).
3. Open the Catch directory from the cloned folder in Android Studio) and then run module app with an emulator (make sure your gradle version is up to date).

## Retrain the recommendation system

```
python model/train.py
```


