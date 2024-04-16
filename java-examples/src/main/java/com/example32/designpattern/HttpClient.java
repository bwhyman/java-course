package com.example32.designpattern;

public class HttpClient {
    // 必选项
    private String host;
    private String port;
    // 可选项
    private boolean mainThread;
    private String cacheDir;
    private Interceptor interceptor;
    private HttpClient(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.mainThread = builder.mainThread;
        this.cacheDir = builder.cacheDir;
        this.interceptor = builder.interceptor;
    }
    public static Builder builder(String host, String port) {
        return new Builder(host, port);
    }

    public static class Builder {
        // 必选项
        private String host;
        private String port;
        // 可选项
        private boolean mainThread;
        private String cacheDir;
        private Interceptor interceptor;
        public Builder(String host, String port) {
            this.host = host;
            this.port = port;
        }
        public Builder mainThread(boolean mainThread) {
            this.mainThread = mainThread;
            return this;
        }
        public Builder cacheDir(String dir) {
            this.cacheDir = dir;
            return this;
        }
        public Builder interceptor(Interceptor interceptor) {
            this.interceptor = interceptor;
            return this;
        }
        public HttpClient build() {
            return new HttpClient(this);
        }
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public boolean isMainThread() {
        return mainThread;
    }

    public String getCacheDir() {
        return cacheDir;
    }

    public Interceptor getInterceptor() {
        return interceptor;
    }

    public interface Interceptor {
        void doInterceptor();
    }

}
