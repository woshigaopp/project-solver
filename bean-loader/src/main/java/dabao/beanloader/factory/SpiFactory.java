package dabao.beanloader.factory;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public final class SpiFactory<T> {

    private final Map<String,T> spiMap = new ConcurrentHashMap<>(1024);

    public List<T> listServices(Class<T> clz){
        return listServicesAndPutMapIfNecessary(clz,false);
    }

    public Map<String,T> getSpiMap(Class<T> clz){
        listServicesAndPutMapIfNecessary(clz,true);
        return spiMap;
    }

    private List<T> listServicesAndPutMapIfNecessary(Class<T> clz,boolean isNeedPutMap){
        List<T> serviceList = new ArrayList();
        ServiceLoader<T> services = ServiceLoader.load(clz);
        Iterator<T> iterator = services.iterator();
        while(iterator.hasNext()){
            T service = iterator.next();
            serviceList.add(service);
            setServiceMap(isNeedPutMap, service);
        }
        return serviceList;
    }

    private void setServiceMap(boolean isNeedPutMap, T service) {
        if(isNeedPutMap){
            String serviceName = StringUtils.uncapitalize(service.getClass().getSimpleName());
            spiMap.put(serviceName,service);
        }
    }
}
