#!/usr/bin/env python3
from ev3dev.ev3 import *
import time


def OnFwd(voltage):
    # Создаем файл с заголовком '<n>.txt', где название <n> соответствует заданной "скорости"
    data = open(str(voltage) + '.txt', 'w')
    timeStart = time.time()
    motorA.position = 0
    timeNow = time.time() - timeStart

    while timeNow < 6:
        # Задаем "скорость" - она соответствует полученному значению переменной x
        motorA.run_direct(duty_cycle_sp=voltage)

        # Записываем в файл новую строку, содержащую значение угла поворота в градусах и время в секундах,
        # разделитель между столбцами - табуляция
        data.write(str(motorA.position) + ' ' + str(timeNow) + '\n')

        timeNow = time.time() - timeStart

    # Завершаем вращение и закрываем файл
    motorA.run_direct(duty_cycle_sp=0)
    motorA.stop(stop_action='brake')
    data.close()
    time.sleep(3)


motorA = LargeMotor('outA')
for i in range(10, 101, 10):
    OnFwd(i)
