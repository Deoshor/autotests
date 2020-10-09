from selenium import webdriver
import math
import time

browser = webdriver.Chrome()
link = "http://suninjuly.github.io/execute_script.html"
browser.get(link)

try:
    #необходимая функция
    def func(x):
        return str(math.log(abs(12*math.sin(int(x)))))

    #получение переменной х
    find_x = browser.find_element_by_css_selector("[id='input_value']")
    x_value = find_x.text

    #поиск поля ввода и ввод значения
    input1 = browser.find_element_by_css_selector("[id='answer']")
    input1.send_keys(func(x_value))

    #поиск кнопки и прокрутка страницы
    button = browser.find_element_by_css_selector("[type='submit']")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)

    #поиск и выбор чекбокса "I'm the robot"
    checkbox = browser.find_element_by_css_selector("[for='robotCheckbox']")
    checkbox.click()

    #поиск и переключение радиобаттона на "Robots rule!"
    radio = browser.find_element_by_css_selector("[for='robotsRule']")
    radio.click()

    #поиск и нажатие кнопки для отправки данных
    button.click()

    #ожидание загрузки страницы
    time.sleep(1)

finally:
    #ожидание для визуальной оценки результатов прохождения скрипта
    time.sleep(10)
    #команда для закрытия окна браузера
    browser.quit()