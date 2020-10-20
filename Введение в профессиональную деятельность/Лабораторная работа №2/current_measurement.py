#!/usr/bin/env python3
from ev3dev.ev3 import *
import time

def OnFwd(volt):
	motorA = LargeMotor('outA')
	timeStart = time.time()
	timeNow = time.time() - timeStart
	try:
		while timeNow < 6:
		motorA.run_direct(duty_cycle_sp = volt)
		timeNow = time.time() - timeStart

	finally:
		motorA.stop(stop_action = 'brake')
		time.sleep(3)

for volt in range(10,101,10):
	OnFwd(volt)