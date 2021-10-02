package com.wzh.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A loadbalacing strategy that randomly distributes traffic amongst existing
 * servers.
 *
 * @author stonse
 *
 */
public class DemoRandomRule extends AbstractLoadBalancerRule {

    private int total = 0; // 被使用的次数
    private int currentIndex = 0; // 当前是谁在提供服务


    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);

            if (total < 5) {
                server = upList.get(currentIndex);
                total += 1;
            } else {
                total = 0;
                currentIndex ++;
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
                server = upList.get(currentIndex);
            }

            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }

        return server;

    }

    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}
