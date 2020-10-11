from selenium import webdriver
import time
import math

browser = webdriver.Chrome()
link = "http://suninjuly.github.io/redirect_accept.html"
browser.get(link)

try:
    def calc(x):
        return str(math.log(abs(12*math.sin(int(x)))))

    #задание: нажать на кнопку и перейти в новую вкладку
    button1 = browser.find_element_by_xpath("//*[@type='submit']")
    button1.click()

    new_window = browser.window_handles[1]
    browser.switch_to.window(new_window)


    #решаем капчу
    element_x = browser.find_element_by_xpath("//*[@id='input_value']")
    value_x = element_x.text
    answer = calc(value_x)

    input1 = browser.find_element_by_xpath("//*[@id='answer']")
    input1.send_keys(answer)

    button2 = browser.find_element_by_xpath("//*[@type='submit']")
    button2.click()

    time.sleep(1)

finally:
    time.sleep(10)
    browser.quit()