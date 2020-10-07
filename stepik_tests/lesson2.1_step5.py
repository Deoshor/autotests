from selenium import webdriver
import time
import math

try: 
    link = "http://suninjuly.github.io/math.html"
    browser = webdriver.Chrome()
    browser.get(link)

    def calc(x):
        return str(math.log(abs(12*math.sin(int(x)))))

    # находим х и подставляем его в функцию
    x_element = browser.find_element_by_id('input_value')
    x = x_element.text
    y = calc(x)

    # полученное значение подставляем в поле ввода
    answer = browser.find_element_by_id('answer')
    answer.send_keys(y)

    # выбираем элемент чекбокс
    option1 = browser.find_element_by_css_selector("[for='robotCheckbox']")
    option1.click()

    # выбираем элемент радиобаттон
    option2 = browser.find_element_by_css_selector("[id='robotsRule']")
    option2.click()

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