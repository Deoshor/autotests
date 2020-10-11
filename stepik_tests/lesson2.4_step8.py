from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium import webdriver
import time
import math

browser = webdriver.Chrome()
link = "http://suninjuly.github.io/explicit_wait2.html"
browser.get(link)

try:
    def calc(x):
            return str(math.log(abs(12*math.sin(int(x)))))

    #задание - Selenium проверяет price в течение 12 секунд, пока цена не опустится до 100$
    price = WebDriverWait(browser, 12).until(
            EC.text_to_be_present_in_element((By.ID, "price"), "100")
        )

    #поиск и нажатие кнопки для отправки данных
    book = browser.find_element_by_id("book")
    book.click()

    #доп.задание с math
    button = browser.find_element_by_xpath("//*[@id='solve']")
    browser.execute_script("return arguments[0].scrollIntoView(true);", button)

    element_x = browser.find_element_by_xpath("//*[@id='input_value']")
    value_x = element_x.text
    answer = calc(value_x)

    input1 = browser.find_element_by_xpath("//*[@id='answer']")
    input1.send_keys(answer)

    button.click()

    time.sleep(1)

finally:
    time.sleep(10)
    browser.quit()