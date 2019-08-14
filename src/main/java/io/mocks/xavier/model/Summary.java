package io.mocks.xavier.model;

public class Summary {

    private String provider;
    private String product;
    private String version;
    private Long hosts;
    private Long sockets;
    private Long clusters;
    private Long vms;

    public Summary() {
    }

    public Summary(String provider, String product, String version, Long hosts, Long sockets, Long clusters, Long vms) {
        this.provider = provider;
        this.product = product;
        this.version = version;
        this.hosts = hosts;
        this.sockets = sockets;
        this.clusters = clusters;
        this.vms = vms;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getHosts() {
        return hosts;
    }

    public void setHosts(Long hosts) {
        this.hosts = hosts;
    }

    public Long getSockets() {
        return sockets;
    }

    public void setSockets(Long sockets) {
        this.sockets = sockets;
    }

    public Long getClusters() {
        return clusters;
    }

    public void setClusters(Long clusters) {
        this.clusters = clusters;
    }

    public Long getVms() {
        return vms;
    }

    public void setVms(Long vms) {
        this.vms = vms;
    }
}
