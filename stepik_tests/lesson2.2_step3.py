from selenium import webdriver
from selenium.webdriver.support.ui import Select
import time

try: 
    link = "http://suninjuly.github.io/selects1.html"
    browser = webdriver.Chrome()
    browser.get(link)

    def sum(x, y):
        return str(int(x) + int(y))

    #находим на странице переменные
    num1 = browser.find_element_by_css_selector("[id='num1']")
    x = num1.text
    num2 = browser.find_element_by_css_selector("[id='num2']") 
    y = num2.text
    
    #выбираем из списка нужную сумму
    select = Select(browser.find_element_by_tag_name("select"))
    select.select_by_visible_text(sum(x, y))
    

    #нажимаем кнопку для отправки данных
    button = browser.find_element_by_xpath("//*[contains(@type, 'submit')]")
    button.click()

    # ждем загрузки страницы
    time.sleep(1)


finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
