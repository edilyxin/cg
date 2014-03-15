package com.rc.util;

import org.apache.commons.digester.Digester;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: GK
 * Date: 2012-3-28
 * Time: 17:49:23
 * To change this template use File | Settings | File Templates.
 */
public class ReadConfig {
    
   
    private List<ResourcesConfig> propertys = new ArrayList<ResourcesConfig>();

    public List getPropertys() {
        return propertys;
    }

    public void addPropertys(ResourcesConfig property){
           propertys.add(property);
    }

    /**
     * 获取参数值
     * @param configName
     * @return
     */
    public static String getConfig(String configName){
        String configValue = null;// 参数值
        Digester digester = new Digester();//新建Digester实例
        digester.setValidating(false);
        //生成本类实例
        digester.addObjectCreate("config", ReadConfig.class);
        //生成property实例
        digester.addObjectCreate("config/property",ResourcesConfig.class);
        //获取属性值，并将其存入property实例
        digester.addCallMethod("config/property","setValue",0);
        digester.addSetProperties("config/property","name","name");
        digester.addSetNext("config/property","addPropertys");
        try{
            String filePath =ReadConfig.class.getResource("").getPath();
           //查找“WEB-INF/”在该字符串的位置
            int num = filePath.indexOf("WEB-INF");
            //取得“WEB-INF/”路径
            String realPath = filePath.substring(0, num+"WEB-INF".length()); 
            //System.out.println("file:"+realPath+"/resourcesConfig.xml");
            ReadConfig readConfig = (ReadConfig) digester.parse("file:"+realPath+"/resourcesConfig.xml");
            for(Object property:readConfig.getPropertys()){//循环匹配参数名称以便取值
                if(configName.equals(((ResourcesConfig)property).getName())){
                    configValue =  ((ResourcesConfig) property).getValue();
                    break;
                }
            }
        }catch(Exception e){
              e.printStackTrace();
        }
            return  configValue; 
        

    }

    /**
     * 获取完整路径
     * @param configName
     * @return
     */
    public static String getRealPath(String configName){
    		String filePathD =ReadConfig.class.getResource("").getPath();
	        filePathD = filePathD.replaceAll("%20", " ");
	        //查找“WEB-INF/”在该字符串的位置
	        int num = filePathD.indexOf("/WEB-INF");
	        //取得“项目WEB-INF/”路径
	        String realPath = filePathD.substring(0, num);
	        String filePath =  realPath+ReadConfig.getConfig(configName);
	        return filePath;
    }
    public static void main(String[] args){
         //System.out.println("aaaaaaD:\\myWork\\smwork\\workspace\\whepaysite\\epay\\WEB-INF\\aaaaaaaaa"+ReadConfig.class.getResource("").getPath());
         System.out.println(ReadConfig.getRealPath("download"));//示例
    }
}
