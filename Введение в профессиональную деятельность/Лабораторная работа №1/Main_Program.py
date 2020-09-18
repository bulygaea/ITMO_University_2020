#!/usr/bin/env python3
from ev3dev.ev3 import *
import time


def processing(x):
    # Создаем файл с заголовком '<n>.txt', где название <n> соответствует заданной "скорости"
    data = open(str(x)+'.txt', 'w')
    timeStart = time.time()
    motorA.position = 0

    while time.time() - timeStart < 1:
        # Задаем "скорость" - она соответствует полученному значению переменной x
        motorA.run_direct(duty_cycle_sp=x)

        # Записываем в файл новую строку, содержащую значение угла поворота в градусах (max=360) и время в секундах,
        # разделитель между столбцами - табуляция
        data.write(str(abs(motorA.position)%360) + '\t' + str(time.time() - timeStart) + '\n')

    # Завершаем вращение и закрываем файл
    motorA.run_direct(duty_cycle_sp=0)
    motorA.stop(stop_action='brake')
    data.close()


motorA = LargeMotor('outA')
for i in [-100, -80, -60, -40, -20, 20, 40, 60, 80]:
    processing(i)
