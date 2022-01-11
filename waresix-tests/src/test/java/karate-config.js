function fn() {
    var config = {}

    config.mobileDriver= {
        webDriverSession: {
            desiredCapabilities: {
                app: "/Users/waresix/Downloads/app-debug.apk",
                platformName: "Android",
                platformVersion: "10.0",
                appPackage: "com.waresix.freight.driver",
                appActivity: "com.waresix.freight.driver.view.activity.SplashScreenActivity",
                autoGrantPermissions: true,
//                noReset: true,
                fullReset: true,
                automationName: "UiAutomator2"
            }
        }
    }

    driverConfig = {
        type: 'android',
        showDriverLog: true,
        webDriverPath: '/wd/hub',
    }

    config.baseUrl = 'https://sit-gql.waresix.com';
    karate.configure('driver', driverConfig);

    return config;
}