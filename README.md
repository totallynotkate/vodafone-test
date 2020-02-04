This test suite comes with a bundled chromedriver instance for Mac. To run the test in another system you could do 
one of the following:
- replace the driver in src/main/resources
- edit the pom file so that the webdriver.chrome.driver property 
points to the location where your driver file is
- launch tests via console and specify webdriver.chrome.driver property as a system property