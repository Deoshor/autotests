from selenium import webdriver
import time
import os

browser = webdriver.Chrome()
link = "http://suninjuly.github.io/file_input.html"
browser.get(link)

try:
    #поиск и заполнение полей
    input1 = browser.find_element_by_xpath("//*[@name='firstname']")
    input1.send_keys("Noname")
    input2 = browser.find_element_by_xpath("//*[@name='lastname']")
    input2.send_keys("Nosurname")
    input3 = browser.find_element_by_xpath("//*[@name='email']")
    input3.send_keys("Noemail")

    #поиск кнопки загрузки файла
    file1 = browser.find_element_by_xpath("//*[@type='file']")
    #получение пути к директории текущего исполняемого файла 
    current_dir = os.path.abspath(os.path.dirname(__file__))
    #добавление к этому пути имя файла
    file_path = os.path.join(current_dir, 'file.txt')
    #прикрепление файла
    file1.send_keys(file_path)

    #поиск и нажатие кнопки для отправки данных
    button = browser.find_element_by_xpath("//*[@type='submit']")
    button.click()

finally:
    # ожидание чтобы визуально оценить результаты прохождения скрипта
    time.sleep(10)
    # закрываем браузер после всех манипуляций
    browser.quit()
