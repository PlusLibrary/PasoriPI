import RPi.GPIO as GPIO
import time

def main():
    pin = 18
    GPIO.setmode(GPIO.BCM)
    GPIO.setup(pin, GPIO.OUT)
    GPIO.output(pin, GPIO.HIGH)
    time.sleep(.1)
    GPIO.output(pin, GPIO.LOW)
    GPIO.cleanup()
main()
