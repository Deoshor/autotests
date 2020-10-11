from selenium import webdriver
import time

browser = webdriver.Chrome()
link = "http://suninjuly.github.io/cats.html"
browser.get(link)

try:
    browser.find_element_by_id("button")
finally:
    time.sleep(10)
    browser.quit()