#!/usr/bin/env python3
from ev3dev.ev3 import *
import time

def write_data(voltage):
	motorA = LargeMotor('outA')
	timeStart = time.time()
	motorA.position = 0
	timeNow = time.time() - timeStart

	data = open('data_for_voltage_' + str(voltage) + '_.txt', 'w')

	try:
		while (timeNow < 1):
		motorA.run_direct(duty_cycle_sp = voltage)
		timeNow = time.time() - timeStart
		data.write(str(motorA.position))
		data.write(' '*10 + str(roud(timeNow,3)) + '\n')

	finally:
		data.close()
		motorA.stop(stop_action = 'brake')
		time.sleep(1)
for volt in range(10,101,10):
	write_data(volt)