# sliide-initial-interview

Tech stack:
- Appium Server 1.21.0
- Java
- IntelliJ
- Maven

Dependencies:
- java-client
- selenium-java
- testng

## Why Appium over Espresso:
1. Support for multiple languages and tools

Because Appium uses JSON Wire Protocol for client/server communication, it allows writing clients in many different languages. Appium Web Driver’s clients are more “automation libraries” than simply sending HTTP requests to the server. Remarkably, you can even use Ruby, Python, PHP or C# for writing test scripts. Basically, with Appium, you are not limited in choosing your technology stack.

2. Cross-platform test cases

If you also need to test your iOS app, Appium has you covered: the test automation framework is cross-platform. This means that it allows running tests against multiple mobile platforms. What’s more important, you can reuse code across your Android and iOS test suites.

3. Similarity with Selenium

Appium’s functionality resembles the one of Selenium, a popular test automation framework for web applications. This makes it familiar and easy to use for everyone who has experience with Selenium, so if your team is working with it, adopting Appium for automated Android UI testing will come naturally.

## How to run tests
1. Setup Appium on your MacOS: https://www.techaheadcorp.com/blog/how-to-install-appium-on-mac/
2. Setup Android Studio and Android SDK: https://developer.android.com/studio
3. Setup Maven: https://maven.apache.org/install.html
4. Open up a project and run the following commands to run the tests: mvn test -Dtest=LoginTests -DplatformVersion="11.0" -DdeviceName="Pixel 4 XL API 30". Be aware that -DplatformVersion and -DdeviceName parameters must be defined and set through local Android SDK, meaning that you need to have this specific simulator name with this specific OS version install and up and running on your local. 
