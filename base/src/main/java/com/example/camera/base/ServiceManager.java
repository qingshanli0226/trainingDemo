package com.example.camera.base;

public class ServiceManager {
    private static ServiceManager instance = new ServiceManager();
    private ILoginService iLoginService;
    private IPayCallback  iPayCallback;
    private IPayService iPayService;

    private ServiceManager() {
    }

    public static ServiceManager getInstance() {
        return instance;
    }

    public static void setInstance(ServiceManager instance) {
        ServiceManager.instance = instance;
    }

    public ILoginService getiLoginService() {
        return iLoginService;
    }

    public void setiLoginService(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    public IPayCallback getiPayCallback() {
        return iPayCallback;
    }

    public void setiPayCallback(IPayCallback iPayCallback) {
        this.iPayCallback = iPayCallback;
    }

    public IPayService getiPayService() {
        return iPayService;
    }

    public void setiPayService(IPayService iPayService) {
        this.iPayService = iPayService;
    }
}
