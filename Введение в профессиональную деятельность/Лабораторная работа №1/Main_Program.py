#!/usr/bin/env python3
from ev3dev.ev3 import *
import math
import time


def OnFwd(voltage):
    # Создаем файл с заголовком '<n>.txt', где название <n> соответствует заданной "скорости"
    data = open(str(voltage) + '.txt', 'w')
    timeStart = time.time()
    motorA.position = 0

    while time.time() - timeStart < 1:
        # Задаем "скорость" - она соответствует полученному значению переменной x
        motorA.run_direct(duty_cycle_sp=voltage)

        # Записываем в файл новую строку, содержащую значение угла поворота в градусах и время в секундах,
        # разделитель между столбцами - табуляция
        data.write(str(motorA.position) + ' ' + str(time.time() - timeStart) + '\n')

    # Завершаем вращение и закрываем файл
    motorA.run_direct(duty_cycle_sp=0)
    motorA.stop(stop_action='brake')
    data.close()
    time.sleep(2)


motorA = LargeMotor('outA')
for i in [-100, -80, -60, -40, -20, 20, 40, 60, 80, 100]:
    OnFwd(i)
