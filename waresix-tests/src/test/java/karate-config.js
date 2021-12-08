function fn() {
    var config = {}

    config.mobileDriver= {
        webDriverSession: {
            desiredCapabilities: {
                app: "/Users/waresix/Downloads/transporter.apk",
                platformName: "Android",
                platformVersion: "10.0",
                appPackage: "com.waresix.freight.transporter",
                appActivity: "com.waresix.freight.transporter.activity.SplashScreenActivity",
//                avd: "Pixel_3_API_29_1",
                autoGrantPermissions: true,
                automationName: "UiAutomator2"
            }
        }
    }

    driverConfig = {
        type: 'android',
        showDriverLog: true,
        webDriverPath: '/wd/hub'
    }

    karate.configure('driver', driverConfig);

    return config;
}