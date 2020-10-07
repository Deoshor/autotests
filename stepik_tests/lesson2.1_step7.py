from selenium import webdriver
import time
import math

try: 
    link = "http://suninjuly.github.io/get_attribute.html"
    browser = webdriver.Chrome()
    browser.get(link)

    def calc(x):
        return str(math.log(abs(12*math.sin(int(x)))))

    # находим х в элементе-картинке и подставляем в функцию

    x_element = browser.find_element_by_id('treasure')
    x_value = x_element.get_attribute("valuex")
    #x = x_value.text
    y = calc(x_value)

    # полученное значение подставляем в поле ввода
    answer = browser.find_element_by_id('answer')
    answer.send_keys(y)

    # выбираем элемент чекбокс
    checkbox = browser.find_element_by_css_selector("[id='robotCheckbox']")
    checkbox.click()

    # выбираем элемент радиобаттон
    radio = browser.find_element_by_css_selector("[id='robotsRule']")
    radio.click()

    # отправляем данные
    button = browser.find_element_by_css_selector("[type='submit']")
    button.click()

    # ждем загрузки страницы
    time.sleep(1)


finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(15)
    # закрываем браузер после всех манипуляций
    browser.quit()