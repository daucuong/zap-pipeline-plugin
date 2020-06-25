package com.vrondakis.zap;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.vrondakis.zap.workflow.RunZapAttackStepParameters;
import hudson.FilePath;
import hudson.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class ZapDriverStub implements ZapDriver {
    private int port;
    private int timeout;
    private String host;
    private String loadedSessionPath = "";
    private List<String> allowedHosts;
    private HashMap<Integer, Integer> failBuild = new HashMap<>();
    private String zapDir;
    private String apiKey;

    public ZapDriverStub() {
        super();
    }

    public String getLoadedSessionPath() {
        return loadedSessionPath;
    }

    @Override
    public boolean shutdownZap() {
        return false;
    }

    @Override
    public boolean setZapMode(String zapMode) {
        return false;
    }

    @Override
    public boolean startZapCrawler(String host) {
        return true;
    }

    @Override
    public int zapCrawlerStatus() {
        return 100;
    }

    @Override
    public boolean importUrls(String path) {
        return true;
    }

    @Override
    public boolean loadSession(String sessionPath) {
        loadedSessionPath = sessionPath;
        return true;
    }

    @Override
    public boolean loadPolicy(String policy) {
        return true;
    }

    @Override
    public boolean zapAttack(RunZapAttackStepParameters zsp) {
        return false;
    }

    @Override
    public boolean zapCrawlerSuccess() {
        return true;
    }

    @Override
    public int zapAttackStatus() {
        return 0;
    }

    @Override
    public boolean startZapProcess(String zapHome, FilePath ws, Launcher launcher) {
        return true;
    }

    @Override
    public void setZapHost(String zapHost) {
        host = zapHost;
    }

    @Override
    public void setZapPort(int zapPort) {
        port = zapPort;
    }

    @Override
    public void setFailBuild(int all, int high, int med, int low) {
        failBuild.put(ZapArchive.ALL_ALERT, all);
        failBuild.put(ZapArchive.HIGH_ALERT, high);
        failBuild.put(ZapArchive.MEDIUM_ALERT, med);
        failBuild.put(ZapArchive.LOW_ALERT, low);
    }

    @Override
    public void setZapTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void setAllowedHosts(List<String> allowedHosts) {
        this.allowedHosts = allowedHosts;
    }

    @Override
    public int getZapTimeout() {
        return timeout;
    }

    @Override
    public int getZapPort() {
        return port;
    }

    @Override
    public HashMap<Integer, Integer> getFailBuild() {
        return failBuild;
    }

    @Override
    public String getZapHost() {
        return host;
    }

    @Override
    public List<String> getAllowedHosts() {
        return this.allowedHosts;
    }

    @Override
    public String getZapReport() throws IOException {
        URL url = Resources.getResource("zap-raw.json");
        return Resources.toString(url, Charsets.UTF_8);
    }

    @Override
    public String getZapReportXML() throws IOException {
        URL url = Resources.getResource("zap-raw.xml");
        return Resources.toString(url, Charsets.UTF_8);
    }

    @Override
    public boolean zapAliveCheck() {
        return true;
    }

    @Override
    public void setZapDir(String zapDir) {
        this.zapDir = zapDir;
    }

    @Override
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
