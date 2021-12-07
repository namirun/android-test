function fn() {
    var config = {}
    var android = {}
    android["desiredConfig"] = {
        "app" : "/Users/waresix/Downloads/transporter.apk",
        "newCommandTimeout" : 6000,
        "platformVersion" : "10.0",
        "platformName" : "Android",
        "connectHardwareKeyboard" : true,
//        "deviceName" : "emulator-5554",
//        "avd" : "Pixel2_PIE",
        "automationName" : "UiAutomator2"
    }
    config["android"] = android
    return config;
}